/**
 * @Title BankBnkBaseDAO.java 
 * @Package com.zlfund.headstone.core.dao 
 * @Description 
 * @author 徐文凡
 * @date 2017年3月1日 上午10:22:18 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.dao.po.BankBnkBasePO;

/** 
 * @author: 徐文凡 
 * @since: 2017年3月1日 上午10:22:18 
 * @history:
 */
public interface BankBnkBaseDAO {

    BankBnkBasePO getBankBnkBaseByBankNo(String bankNo);

}
