package org.bafeimao.thinking.in.spring.bean.defination;

import org.bafeimao.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.bafeimao.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.defination
 * @className: BeanInitializationDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/12 20:34
 * @version: 1.0
 */
@Configuration
public class BeanInitializationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        System.out.println("spring 上下文已启动");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println(userFactory);
        System.out.println("spring应用上下文准备关闭");
        applicationContext.close();
        System.out.println("spring 上下文已关闭");
    }

    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    @Lazy(value = false)
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }
}
