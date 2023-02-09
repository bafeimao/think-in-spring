package org.bafeimao.thinking.in.spring.bean.defination;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.defination
 * @className: BeanInstantinationDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/9 7:47
 * @version: 1.0
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        BeanFactory  beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User userByInstance = beanFactory.getBean("user-by-instance-method", User.class);
        User userByFactory = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user);
        System.out.println(userByInstance);
        System.out.println(userByFactory);
        System.out.println(user==userByInstance);
        System.out.println(user==userByFactory);
    }
}
