package org.bafeimao.thinking.in.spring.ioc.overview.dependency.lookup;

import org.bafeimao.thinking.in.spring.ioc.overview.annotation.Super;
import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.ioc.overview.dependency.lookup
 * @className: DependencyLookUpDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/6 6:48
 * @version: 1.0
 */
public class DependencyLookUpDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupByType(beanFactory);
        lookupByCollectionType(beanFactory);
        lookupByAnnotation(beanFactory);
//        lookupInRealTime(beanFactory);
//        lookupInLazy(beanFactory);
    }

    private static void lookupByAnnotation(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("查找到的所有标注 @Super User 集合对象" + users);
        }
    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有 User 集合对象" + users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("实时查找" + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延迟查找" + user);
    }

    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时查找" + user);
    }
}
