/**
 * @Title CustAbnStatusDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月26日 下午5:59:13 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.dao.po.CustAbnStatusPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月26日 下午5:59:13 
 * @history:
 */
public interface CustAbnStatusDAO {

    CustAbnStatusPO getCustAbnStatusByIdNo(String idNo, String counterpart);

}
