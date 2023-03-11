package org.bafeimao.thinking.in.spring.bean.lifecycle;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.lifecycle
 * @className: MergedBeanDefinitionDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/28 21:26
 * @version: 1.0
 */
public class MergedBeanDefinitionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "META-INF/dependency-lookup-context.xml";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNumbers = beanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("加载beandefinitions 数量" + beanNumbers);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);
        User superUser = beanFactory.getBean("superUser", User.class);
        System.out.println(superUser);
    }
}
