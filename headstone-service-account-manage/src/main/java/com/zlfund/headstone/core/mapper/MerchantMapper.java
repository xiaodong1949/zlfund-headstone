
package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;

/**
 * @author Yang Xiaodong
 * @since: 2017年2月22日
 */
public interface MerchantMapper extends BaseSqlMapper {

    /** 
     * @param mctcode
     * @param partnerno
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    boolean queryFromMerchant(@Param("mctcode") String mctcode);

}
