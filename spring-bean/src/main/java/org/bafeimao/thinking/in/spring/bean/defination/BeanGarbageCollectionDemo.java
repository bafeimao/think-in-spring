package org.bafeimao.thinking.in.spring.bean.defination;

import org.bafeimao.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.defination
 * @className: BeanGarbageCollectionDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/15 21:49
 * @version: 1.0
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        applicationContext.close();
        Thread.sleep(5000L);
        System.gc();
        Thread.sleep(5000L);

    }
}
