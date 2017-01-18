package com.zlfund.headstone.consumer;

import com.zlfund.headstone.common.exceptions.BizException;
import com.zlfund.headstone.facade.account.entity.CustInfo;
import com.zlfund.headstone.facade.account.service.AccountManageFacade;
import com.zlfund.headstone.facade.account.service.AccountQueryFacade;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class HeadstoneConsumer4Dubbo {
    public static void main(String[] args) {
        Logger log = Logger.getLogger(HeadstoneConsumer4Dubbo.class);
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "consumer.xml");
        ctx.start();
        AccountManageFacade accountManageFacade = (AccountManageFacade) ctx.getBean("accountManageFacade");
        AccountQueryFacade accountQueryFacade = (AccountQueryFacade) ctx.getBean("accountQueryFacade");

        try {
            CustInfo custInfo1 = accountManageFacade.reg("18611111111", "1qaz2wsx", "111111");
            System.out.println(custInfo1);
        } catch (BizException e) {
            System.out.println(e.getCode() + "--" + e.getMsg());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            CustInfo custInfo2 = accountQueryFacade.getCustinfo("18611111111");
            System.out.println(custInfo2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
