package org.bafeimao.thinking.in.spring.bean.lifecycle;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.lifecycle
 * @className: BeanMetadataConfigurationDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/25 9:25
 * @version: 1.0
 */
public class AnnotatedBeanDefinitionParsingDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader beanDefinitionReader = new AnnotatedBeanDefinitionReader(beanFactory);
        int beanDefinitionCountBefore = beanFactory.getBeanDefinitionCount();
        beanDefinitionReader.register(AnnotatedBeanDefinitionParsingDemo.class);

        int beanDefinitaionCountAfter = beanFactory.getBeanDefinitionCount();
        int result = beanDefinitaionCountAfter - beanDefinitionCountBefore;
        System.out.println("已经加载数量：" + result);

        AnnotatedBeanDefinitionParsingDemo definitionParsingDemo = beanFactory
                .getBean("annotatedBeanDefinitionParsingDemo", AnnotatedBeanDefinitionParsingDemo.class);
        System.out.println(definitionParsingDemo);


    }
}
