package com.hu.springboot.test.service.imp;

import org.springframework.stereotype.Service;

@Service
public class testReflexService {

    public void testReflex() {
        try{
            Class class1 = Class.forName("com.hu.springboot.test.VO.Student");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
