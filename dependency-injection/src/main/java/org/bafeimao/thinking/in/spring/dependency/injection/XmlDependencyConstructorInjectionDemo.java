package org.bafeimao.thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.injection
 * @className: XmlDependencySetterInjectionDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/19 15:59
 * @version: 1.0
 */
public class XmlDependencyConstructorInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-constructor-injection.xml";
        //load xml resource
        beanDefinitionReader.loadBeanDefinitions(location);
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
