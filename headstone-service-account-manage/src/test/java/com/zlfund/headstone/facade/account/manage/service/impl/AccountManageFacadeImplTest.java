package com.zlfund.headstone.facade.account.manage.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.zlfund.headstone.JUnitServiceBase;
import com.zlfund.headstone.common.security.DESEncHelper;
import com.zlfund.headstone.core.biz.RegisterBiz;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoRequestDTO;
import com.zlfund.headstone.facade.account.manage.dto.RegisterMobilenoResultDTO;

public class AccountManageFacadeImplTest extends JUnitServiceBase {
    @Autowired
    private RegisterBiz registerBiz;
    @Test
    public void testRegisterByMobileno() {
        RegisterMobilenoRequestDTO requestDTO = new RegisterMobilenoRequestDTO();

        DESEncHelper des = DESEncHelper.getInstance();
        requestDTO.setMobileNo("12364345576");
        requestDTO.setMctcode("1000");
        try {
            requestDTO.setPassword(des.encrypt("Admin@123"));
        } catch(Exception e) {
            e.printStackTrace();
        }

        registerBiz.checkRequestDTO(requestDTO);
        RegisterMobilenoResultDTO obj = registerBiz.doBiz(requestDTO);
        System.out.println("--------" + obj + "------------");
    }

}
