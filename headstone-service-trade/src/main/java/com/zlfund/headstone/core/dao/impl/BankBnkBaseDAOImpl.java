/**
 * @Title BankBnkBaseDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年3月1日 上午10:22:33 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.BankBnkBaseDAO;
import com.zlfund.headstone.core.dao.po.BankBnkBasePO;
import com.zlfund.headstone.core.mapper.BankBnkBaseMapper;

/** 
 * @author: 徐文凡 
 * @since: 2017年3月1日 上午10:22:33 
 * @history:
 */
@Repository("bankBnkBaseDAO")
public class BankBnkBaseDAOImpl implements BankBnkBaseDAO {

    @Autowired
    BankBnkBaseMapper bankBnkBaseMapper;

    @Override
    public BankBnkBasePO getBankBnkBaseByBankNo(String bankNo) {
        return bankBnkBaseMapper.getBankBnkBaseByBankNo(bankNo);
    }

}
