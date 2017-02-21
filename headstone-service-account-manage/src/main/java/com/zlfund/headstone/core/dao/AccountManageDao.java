package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.common.dao.BaseDao;
import com.zlfund.headstone.core.dao.po.CustInfoPO;

/**
 * 用户信息表操作
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public interface AccountManageDao extends BaseDao<CustInfoPO> {
    /** 
     * 根据用户id获取用户信息
     * @param custNo
     * @return
     * @return 
     * @create: 2017年2月21日
     * @author: Yang Xiaodong
     * @history: 
     */
    public CustInfoPO getCustInfo(String custNo);

}
