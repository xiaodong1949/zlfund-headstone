package com.zlfund.headstone.core.dao;

import com.zlfund.headstone.core.dao.po.CustInfoPO;
import com.zlfund.headstone.core.dao.po.CustInfoExPO;

/**
 * 用户信息表操作
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public interface AccountManageDao {

    /** 
     * 是否来自渠道平台
     * @param mctCode
     * @param partnerno
     * @return
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    public boolean queryFromMerchant(String mctCode);

    /** 
     * @param mobileno
     * @return
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    public boolean queryAlreadyRegistered(String mobileno);

    /** 
     * 手机号码未验证已绑卡，且在众禄渠道绑卡
     * 异常情况返回身份证件后四位
     * @param mobileno
     * @return
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    public String queryMctRegistered(String mobileno);

    /** 
     * 生成客户id
     * @return
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    public String getNewCustno();

    /** 
     * 生成客户虚拟身份证号码
     * @return
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    public String getNewVIdno();

    /** 
     * 写入custinfo表
     * @param custInfoPO
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    public void saveCustInfo(CustInfoPO custInfoPO);

    /** 
     * 写入custsinfoex表
     * @param custInfoExPO
     * @return 
     * @create: 2017年2月22日
     * @author: Yang Xiaodong
     * @history: 
     */
    public void saveCustInfoEx(CustInfoExPO custInfoExPO);

    /** 
     * 设置风险等级
     * @param custno
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    public void saveCustRiskLevel(String custno);

}
