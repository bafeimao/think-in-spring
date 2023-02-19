package org.bafeimao.thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.injection
 * @className: AutoWiringByNameDependencySetterInjectionDemo
 * @author: ycd20
 * @description: AwtoWiring 依赖 constructor方法注入示例
 * @date: 2023/2/19 16:29
 * @version: 1.0
 */
public class AutoWiringConstructorDependencySetterInjectionDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/autowiring-dependency-constructor-injection.xml";
        //load xml resource
        beanDefinitionReader.loadBeanDefinitions(location);
        UserHolder userHolder = beanFactory.getBean(UserHolder.class);
        System.out.println(userHolder);
    }
}
