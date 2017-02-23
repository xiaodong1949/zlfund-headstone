
package com.zlfund.headstone.core.mapper;

import org.apache.ibatis.annotations.Param;

import com.zlfund.headstone.core.common.mybatis.BaseSqlMapper;
import com.zlfund.headstone.core.dao.po.CustInfoPO;

/**
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public interface CustInfoMapper extends BaseSqlMapper {

    /** 
     * 查看客户是否已经注册
     * @param mobileno
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    boolean queryAlreadyRegistered(@Param("mobileno") String mobileno);

    /** 
     * 是否在渠道已经绑卡
     * @param mobileno
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    boolean queryMctRegistered(@Param("mobileno") String mobileno);

    /** 
     * 返回身份证后四位
     * @param mobileno
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @param count 
     * @history: 
     */
    String getlastDigitsIdno(@Param("mobileno") String mobileno, @Param("i") int count);

    /** 
     * 生成客户号
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    String generateCustno();

    /** 
     * 生成虚拟身份证号
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    String generateVirtualIdno();

    /** 
     * 写入用户信息
     * @param custInfoPO
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    void saveCustInfo(@Param("custInfoPO") CustInfoPO custInfoPO);

}
