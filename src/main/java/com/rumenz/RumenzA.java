package com.rumenz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RumenzA {

    @Autowired
    RumenzB rumenzB;

    public  RumenzA() {
        System.out.println("RumenzA 无参构造方法");
    }

    @PostConstruct
    public void init(){
        System.out.println("RumenzA PostConstruct init方法");
        rumenzB.test();
    }



}
