package com.zlfund.headstone.core.biz;

import com.zlfund.headstone.common.dto.BaseRequestDTO;
import com.zlfund.headstone.common.dto.BaseResultDTO;
import com.zlfund.headstone.facade.account.manage.exception.AccountManageBizException;

/**
 * Biz 父类
 * @author Yang Xiaodong
 * @since: 2017年2月21日
 */
public abstract class AccountManageCommonBiz {

    /** 
     * 执行业务
     * @param requestDTO
     * @return
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    public BaseResultDTO execute(BaseRequestDTO requestDTO) {
        // 参数检查，一般不配置事务
        checkRequestDTO(requestDTO);
        // 业务处理，一般配置事务
        BaseResultDTO result = doBiz(requestDTO);
        return result;
    }

    /** 
     * 参数校验（DB）
     * @param requestDTO
     * @return
     * @throws AccountManageBizException
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @return 
     * @history: 
     */
    protected abstract void checkRequestDTO(BaseRequestDTO requestDTO) throws AccountManageBizException;

    /** 
     * 执行业务
     * @param requestDTO
     * @return
     * @throws AccountManageBizException
     * @return 
     * @create: 2017年2月23日
     * @author: Yang Xiaodong
     * @history: 
     */
    protected abstract BaseResultDTO doBiz(BaseRequestDTO requestDTO) throws AccountManageBizException;

}
