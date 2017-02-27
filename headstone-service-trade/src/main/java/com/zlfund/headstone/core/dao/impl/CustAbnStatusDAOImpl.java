/**
 * @Title CustAbnStatusDAOImpl.java 
 * @Package com.zlfund.headstone.core.dao.impl 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月26日 下午5:59:35 
 * @version V1.0   
 */
package com.zlfund.headstone.core.dao.impl;

import org.springframework.stereotype.Repository;

import com.zlfund.headstone.core.dao.CustAbnStatusDAO;
import com.zlfund.headstone.core.dao.po.CustAbnStatusPO;

/** 
 * @author: 徐文凡 
 * @since: 2017年2月26日 下午5:59:35 
 * @history:
 */
@Repository("custAbnStatusDAO")
public class CustAbnStatusDAOImpl implements CustAbnStatusDAO {

    @Override
    public CustAbnStatusPO getCustAbnStatusByIdNo(String idNo, String counterpart) {

        return null;
    }

}
