package org.bafeimao.thinking.in.spring.bean.lifecycle;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.lifecycle
 * @className: BeanMetadataConfigurationDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/25 9:25
 * @version: 1.0
 */
public class BeanMetadataConfigurationDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertiesBeanDefinitionReader propertiesBeanDefinitionReader = new PropertiesBeanDefinitionReader(beanFactory);
        String location = "META-INF/user.properties";
        Resource resource = new ClassPathResource(location);
        EncodedResource encodedResource = new EncodedResource(resource, "UTF-8");
        int beanNumbers = propertiesBeanDefinitionReader.loadBeanDefinitions(encodedResource);
        System.out.println("加载beandefinitions 数量" + beanNumbers);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user);

    }
}
