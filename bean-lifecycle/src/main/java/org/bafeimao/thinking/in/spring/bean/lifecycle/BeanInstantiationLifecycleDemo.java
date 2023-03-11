package org.bafeimao.thinking.in.spring.bean.lifecycle;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.SuperUser;
import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ObjectUtils;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.lifecycle
 * @className: BeanInstantiationLifecycleDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/3/1 21:52
 * @version: 1.0
 */
public class BeanInstantiationLifecycleDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.addBeanPostProcessor(new MyInstantiationAware());

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
    static class MyInstantiationAware implements InstantiationAwareBeanPostProcessor {
        @Override
        public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(beanClass)) {
                return new SuperUser();
            }
            return null;
        }

        @Override
        public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
            if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(bean.getClass())) {
                return false;
            }
            return true;
        }

//        @Override
//        public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
//            if (ObjectUtils.nullSafeEquals("user", beanName) && UserHolder.class.equals(bean.getClass())) {
//
//            }
    }
}
