package org.bafeimao.thinking.in.spring.bean.defination;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.defination
 * @className: BeanAliasDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/8 22:20
 * @version: 1.0
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");

        User user = beanFactory.getBean("user", User.class);
        User bafeimao = beanFactory.getBean("bafeimao-user", User.class);

        System.out.println(user==bafeimao);
    }
}
