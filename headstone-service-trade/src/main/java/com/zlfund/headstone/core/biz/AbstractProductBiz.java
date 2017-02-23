/**
 * @Title AbstractProductBiz.java 
 * @Package com.zlfund.headstone.core.biz 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月22日 下午3:37:46 
 * @version V1.0   
 */
package com.zlfund.headstone.core.biz;

import com.zlfund.headstone.common.exceptions.BizException;
import com.zlfund.headstone.facade.trade.dto.BuyRequestDTO;

/** 
 * 产品业务抽象类
 * @author: 徐文凡 
 * @since: 2017年2月22日 下午3:37:46 
 * @history:
 */
public abstract class AbstractProductBiz {

    /**
     * 产品购买
     * @param buyRequestDTO 
     * @create: 2017年2月22日 下午5:41:41 
     * @author: 徐文凡
     * @history:
     */
    public void buy(BuyRequestDTO buyRequestDTO) {
        // 上层实现不开启事务
        checkBeforeBuy(buyRequestDTO);

        // 上层实现开启事务
        submitBuy(buyRequestDTO);
    }

    /**
     * 购买参数校验和业务检查，不开启事务
     * @param buyRequestDTO 
     * @create: 2017年2月22日 下午5:42:02 
     * @author: 徐文凡
     * @history:
     */
    protected void checkBeforeBuy(BuyRequestDTO buyRequestDTO) {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    /**
     * 下单购买
     * @param buyRequestDTO 
     * @create: 2017年2月22日 下午5:42:11 
     * @author: 徐文凡
     * @history:
     */
    protected void submitBuy(BuyRequestDTO buyRequestDTO) {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    protected void redeem() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    protected void cancel() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    protected void quickRedeem() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    // 036
    protected void convert() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    // 956
    protected void fastConvert() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    // 955
    protected void spanConvert() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    // 322 320
    protected void t0Convert() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    protected void reserveBuy() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    protected void reserveRedeem() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    protected void setDividend() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    protected void addMipPlan() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

    protected void updMipPlan() {
        throw BizException.FUNCTION_NOT_SUPPORT;
    }

}
