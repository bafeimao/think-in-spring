package org.bafeimao.thinking.in.spring.dependency.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.source
 * @className: ResourceDependencySourceDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/22 22:35
 * @version: 1.0
 */
public class ResourceDependencySourceDemo {

    @Autowired
    private String value;

    @PostConstruct
    public void init(){
        System.out.println(value);
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ResourceDependencySourceDemo.class);

        applicationContext.addBeanFactoryPostProcessor(beanFactory -> {
            beanFactory.registerResolvableDependency(String.class, "Hello World");

        });
        applicationContext.refresh();

        applicationContext.close();
    }
}
