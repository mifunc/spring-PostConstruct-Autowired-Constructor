package com.rumenz;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac=new AnnotationConfigApplicationContext();
        ac.register(RumenzA.class);
        ac.register(RumenzB.class);
        ac.refresh();

    }
}
