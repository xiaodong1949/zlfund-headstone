
package com.zlfund.headstone.core.mapper;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.MerchantPO;

/**
 * @author Yang Xiaodong
 * @since: 2017年2月22日
 */
public interface MerchantMapper extends BaseSqlMapper {

    /** 
     * 是否为渠道请求
     * @param merchantPO
     * @return
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    boolean queryFromMerchant(MerchantPO merchantPO);

}
