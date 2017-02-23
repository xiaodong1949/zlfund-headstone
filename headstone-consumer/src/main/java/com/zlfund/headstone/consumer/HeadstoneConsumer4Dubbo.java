package com.zlfund.headstone.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zlfund.headstone.common.exceptions.BizException;
import com.zlfund.headstone.facade.account.manage.dto.RegisterRequestDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterResultDTO;
import com.zlfund.headstone.facade.account.manage.service.AccountManageFacade;

public class HeadstoneConsumer4Dubbo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("consumer.xml");
        ctx.start();
        AccountManageFacade accountManageFacade = (AccountManageFacade)ctx.getBean("accountManageFacade");
        RegisterRequestDTO registerRequestDTO = new RegisterRequestDTO();
        registerRequestDTO.setMobileNo("11111111111");
        registerRequestDTO.setMctCode("1000");
        registerRequestDTO.setPassword("123456");

        try {
            RegisterResultDTO custInfo1 = accountManageFacade.registerByMobileno(registerRequestDTO);
            System.out.println(custInfo1);
        } catch(BizException e) {
            System.out.println(e.getCode() + "--" + e.getMsg());
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            ctx.close();
        }
    }
}
