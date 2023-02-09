package org.bafeimao.thinking.in.spring.ioc.overview.container;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.ioc.overview.container
 * @className: AnnotationAplicationContextAsIocContainerDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/8 7:45
 * @version: 1.0
 */
public class AnnotationAplicationContextAsIocContainerDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationAplicationContextAsIocContainerDemo.class);
        applicationContext.refresh();
        lookupByCollectionType(applicationContext);

        applicationContext.close();
    }

    @Bean
    public User user() {
        User user = new User();
        user.setId(1L);
        user.setName("芭菲猫");
        return user;
    }


    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有 User 集合对象" + users);
        }
    }
}
