/**
 * @Title TradeAccoInfoDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午2:07:58 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.dao.po.CustInfoPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午2:07:58 
 * @history:
 */
public interface CustInfoDAO {

    public CustInfoPO getCustInfoByCustNo(String custNo);

    int countCustInfoByCustNo(String custNo);
}
