> 如果想在生成对象时候完成某些初始化操作，而偏偏这些初始化操作又依赖于依赖注入，那么就无法在构造函数中实现。为此，可以使用@PostConstruct注解一个方法来完成初始化，@PostConstruct注解的方法将会在依赖注入完成后被自动调用。

## 代码演示

** RumenzA **
```java

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

```

** RumenzB **

```java

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

```

** 调用 **

```java
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
```

```
23:35:35.460 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'rumenzA'
RumenzA 无参构造方法
23:35:35.479 [main] DEBUG org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'rumenzB'
RumenzB 无参构造方法
RumenzB PostConstruct init方法执行
RumenzA PostConstruct init方法
test func---->>>>
```

Constructor >> @Autowired >> @PostConstruct

源码:https://github.com/mifunc/spring-PostConstruct-Autowired-Constructor
