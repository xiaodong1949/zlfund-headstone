package com.zlfund.headstone.core.mapper;

import java.util.List;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.CustInfoPO;

/**
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public interface CustInfoExMapper extends BaseSqlMapper {

    /** 
     * 获取单个用户
     * @return
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    CustInfoPO getCustInfo(String custno);

    /** 
     * 获取用户集合
     * @return
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    List<CustInfoPO> listCustInfo();

    /** 
     * 获取用户个数
     * @return
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    int countCustInfo();

    /** 
     * 保存用户
     * @param custInfoPO
     * @return
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    int saveCustInfo(CustInfoPO custInfoPO);

    /** 
     * 更新用户
     * @param custInfoPO
     * @return
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    int updateCustInfo(CustInfoPO custInfoPO);
}
