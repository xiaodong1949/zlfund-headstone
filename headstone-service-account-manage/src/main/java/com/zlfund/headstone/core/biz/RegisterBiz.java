package com.zlfund.headstone.core.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zlfund.headstone.common.dto.BaseRequestDTO;
import com.zlfund.headstone.common.utils.StringUtils;
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

    /** 
     * 注册客户信息校验
     * @param registerRequestDTO
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    public void validation(RegisterMobilenoRequestDTO registerRequestDTO) {
    }

    /** 
     * 手机号码注册
     * @param mobileNo
     * @param password
     * @return
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    @Transactional(rollbackFor = Exception.class)
    public RegisterMobilenoResultDTO registerByMobileno(RegisterMobilenoRequestDTO registerRequestDTO) throws AccountManageBizException {
        RegisterMobilenoResultDTO resultDTO = new RegisterMobilenoResultDTO();
        String custno = accountManagerDao.getNewCustno();
        String vIdno = accountManagerDao.getNewVIdno();
        CustInfoPO custInfoPO = new CustInfoPO();
        custInfoPO.setCustno(custno);
        custInfoPO.setIdno(vIdno);
        custInfoPO.setPasswd(registerRequestDTO.getPassword());
        custInfoPO.setMobileno(registerRequestDTO.getMobileNo());
        custInfoPO.setMobileverifist(AccountManageConsts.MOBILENO_VERIFIST);
        custInfoPO.setMctcode(registerRequestDTO.getMctcode());

        CustInfoExPO custInfoExPO = new CustInfoExPO();

        // 写入custinfo表
        accountManagerDao.saveCustInfo(custInfoPO);
        // 写如custinfoex表
        accountManagerDao.saveCustinfoex(custInfoExPO);
        // TODO 写客户定制信息
        // TODO 如果不存在客户信息 写入风险等级

        return resultDTO;
    }

    @Override
    protected RegisterMobilenoResultDTO doBiz(BaseRequestDTO requestDTO) throws AccountManageBizException {

        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.zlfund.headstone.core.biz.AccountManageCommonBiz#checkRequestDTO(com.zlfund.headstone.common.dto.
     * BaseRequestDTO)
     */
    @Override
    protected void checkRequestDTO(BaseRequestDTO requestDTO) throws AccountManageBizException {
        RegisterMobilenoRequestDTO registerRequestDTO = (RegisterMobilenoRequestDTO)requestDTO;
        // 非众禄渠道不能使用手机号码注册
        if (accountManagerDao.queryFromMerchant(registerRequestDTO.getMctCode(), AccountManageConsts.ZLFUND_PARTNERNO)) {
            throw AccountManageBizException.ACCOUNT_NOT_FROM_ZLFUND;
        }
        // 验证手机号码是否注册
        if (accountManagerDao.queryAlreadyRegistered(registerRequestDTO.getMobileNo(), AccountManageConsts.MOBILENO_VERIFIST)) {
            throw AccountManageBizException.ACCOUNT_ALREADY_REGISTERED;
        }
        // 手机号码未验证已绑卡，且在众禄渠道绑卡
        if (accountManagerDao.queryMctRegistered(registerRequestDTO.getMobileNo(), AccountManageConsts.MOBILENO_VERIFIST)) {
            AccountManageBizException ame = AccountManageBizException.ACCOUNT_ALREADY_REGISTERED;
            throw ame.newInstance("该手机号码已被身份证尾号%s注册，请使用身份证登录后绑定该手机，如有疑问请联系客服4006-788-887", "1234");
        }
        // 一个客户不能同时属于地推员和推广员
        if (!StringUtils.isBlank(registerRequestDTO.getPromo_code()) && StringUtils.isBlank(registerRequestDTO.getSpread_code())) {
            registerRequestDTO.setSerialno("");
        }
    }

}
