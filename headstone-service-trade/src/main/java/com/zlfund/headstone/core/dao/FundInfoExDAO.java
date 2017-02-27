/**
 * @Title FundInfoExDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月24日 下午3:46:35 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.dao.po.FundInfoExPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月24日 下午3:46:35 
 * @history:
 */
public interface FundInfoExDAO {

    FundInfoExPO getFundInfoExByFundId(String fundId);

    int countFundInfoExIfFuse(String fundId);

}
