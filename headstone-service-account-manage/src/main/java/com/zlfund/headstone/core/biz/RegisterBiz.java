package com.zlfund.headstone.core.biz;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.common.dto.BaseRequestDTO;
import com.zlfund.headstone.core.dao.AccountManageDao;
import com.zlfund.headstone.core.dao.po.CustInfoExPO;
import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.facade.account.manage.consts.AccountManageConsts;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoRequestDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoResultDTO;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;

/**
 * 注册业务类逻辑实现
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
@Component("registerBiz")
public class RegisterBiz extends AccountManageCommonBiz {

    @Autowired
    private AccountManageDao accountManagerDao;

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public RegisterMobilenoResultDTO doBiz(BaseRequestDTO requestDTO) throws AccountManageBizException {
        RegisterMobilenoRequestDTO bizRequestDTO = (RegisterMobilenoRequestDTO)requestDTO;
        RegisterMobilenoResultDTO resultDTO = new RegisterMobilenoResultDTO();
        // 生成客户号
        String custno = accountManagerDao.getNewCustno();
        // 生成虚拟身份证号码
        String vIdno = accountManagerDao.getNewVIdno();

        CustInfoPO custInfoPO = new CustInfoPO();
        custInfoPO.setCustno(custno);
        custInfoPO.setIdno(vIdno);
        custInfoPO.setInvtp("1");

        custInfoPO.setPasswd(bizRequestDTO.getPassword());
        custInfoPO.setMobileno(bizRequestDTO.getMobileNo());
        custInfoPO.setMobileverifist(AccountManageConsts.MOBILENO_VERIFIST);
        custInfoPO.setMctcode(bizRequestDTO.getMctcode());
        custInfoPO.setInvnm("");

        CustInfoExPO custInfoExPO = new CustInfoExPO();
        custInfoExPO.setCustno(custno);
        // 写入custinfo表
        accountManagerDao.saveCustInfo(custInfoPO);
        // 写如custinfoex表
        accountManagerDao.saveCustInfoEx(custInfoExPO);
        // TODO 写客户定制信息
        // TODO 如果不存在客户信息 写入风险等级
        accountManagerDao.saveCustRiskLevel(custno);
        resultDTO.setMctCustno(custno);
        return resultDTO;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.biz.AccountManageCommonBiz#checkRequestDTO(com.zlfund.headstone.common.dto.
     * BaseRequestDTO)
     */
    @Override
    public void checkRequestDTO(BaseRequestDTO requestDTO) throws AccountManageBizException {
        RegisterMobilenoRequestDTO registerRequestDTO = (RegisterMobilenoRequestDTO)requestDTO;
        // 非众禄渠道不能使用手机号码注册
        if (accountManagerDao.queryFromMerchant(registerRequestDTO.getMctcode())) {
            throw AccountManageBizException.ACCOUNT_NOT_FROM_ZLFUND;
        }
        // 验证手机号码是否注册
        if (accountManagerDao.queryAlreadyRegistered(registerRequestDTO.getMobileNo())) {
            throw AccountManageBizException.ACCOUNT_ALREADY_REGISTERED;
        }
        // 手机号码未验证已绑卡，且在众禄渠道绑卡
        String msg = accountManagerDao.queryMctRegistered(registerRequestDTO.getMobileNo());
        if (StringUtils.isNotBlank(msg)) {
            AccountManageBizException ame = AccountManageBizException.ACCOUNT_ALREADY_REGISTERED;
            throw ame.newInstance("该手机号码已被身份证尾号%s注册，请使用身份证登录后绑定该手机，如有疑问请联系客服4006-788-887", msg);
        }
        // 一个客户不能同时属于地推员和推广员
        if (StringUtils.isNotBlank(registerRequestDTO.getPromo_code()) && StringUtils.isBlank(registerRequestDTO.getSpread_code())) {
            registerRequestDTO.setSerialno("");
        }
    }

}
