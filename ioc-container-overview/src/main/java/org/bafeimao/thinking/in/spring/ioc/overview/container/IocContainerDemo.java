package org.bafeimao.thinking.in.spring.ioc.overview.container;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.ioc.overview.container
 * @className: IocContainerDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/7 22:03
 * @version: 1.0
 */
public class IocContainerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beandefinationsCount = reader.loadBeanDefinitions(location);
        System.out.println("Bean definaton" + beandefinationsCount);
        lookupByCollectionType(beanFactory);

    }

    private static void lookupByCollectionType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有 User 集合对象" + users);
        }
    }
}
