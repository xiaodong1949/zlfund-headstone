/**
 * @Title TAInfoDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月23日 下午1:19:06 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.dao.po.TAInfoPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月23日 下午1:19:06 
 * @history:
 */
public interface TAInfoDAO {

    TAInfoPO getTaInfoByFundId(String fundId);

}
