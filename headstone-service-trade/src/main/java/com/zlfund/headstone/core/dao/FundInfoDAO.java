/**
 * @Title FundInfoDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午1:22:52 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.dao.po.FundInfoPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午1:22:52 
 * @history:
 */
public interface FundInfoDAO {

    FundInfoPO getFundInfoByFundId(String fundId);

    int countFundInfoByFundId(String fundId);
}
