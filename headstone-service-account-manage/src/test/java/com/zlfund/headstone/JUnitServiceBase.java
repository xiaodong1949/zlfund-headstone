/**
 * @Title JUnitServiceBase.java 
 * @Package com.zlfund.headstone 
 * @Description 
 * @author 徐文凡
 * @date 2017年2月26日 下午3:53:37 
 * @version V1.0   
 */
package com.zlfund.headstone;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zlfund.headstone.common.security.DESEncHelper;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoRequestDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoResultDTO;
import com.zlfund.headstone.facade.account.manage.service.AccountManageFacade;

/**
 * 测试超类
 * @author Yang Xiaodong
 * @since: 2017年3月1日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/spring-context-test.xml", "classpath*:spring/spring-mongo-test.xml",
        "classpath*:spring/spring-mybatis-test.xml" })
public class JUnitServiceBase extends AbstractJUnit4SpringContextTests {
    @Autowired
    private AccountManageFacade accountManageFacade;

    @Test
    public void testService() {
        RegisterMobilenoRequestDTO requestDTO = new RegisterMobilenoRequestDTO();

        DESEncHelper des = DESEncHelper.getInstance();
        requestDTO.setMobileNo("12364345598");
        requestDTO.setMctcode("1000");
        try {
            requestDTO.setPassword(des.encrypt("Admin@123"));
        } catch(Exception e) {
            e.printStackTrace();
        }

        RegisterMobilenoResultDTO obj = accountManageFacade.registerByMobileno(requestDTO);
        System.out.println("--------" + obj + "------------");
        Assert.assertEquals("00000000", obj.getErrCode());
    }
}
