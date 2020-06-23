package com.rumenz;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class RumenzB {
    public  RumenzB() {
        System.out.println("RumenzB 无参构造方法");
    }

    @PostConstruct
    public void init(){
        System.out.println("RumenzB PostConstruct init方法执行");
    }

    public void test(){
        System.out.println("test func---->>>>");
    }
}
