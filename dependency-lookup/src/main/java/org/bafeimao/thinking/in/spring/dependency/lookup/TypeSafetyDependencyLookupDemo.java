package org.bafeimao.thinking.in.spring.dependency.lookup;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.lookup
 * @className: TypeSafetyDependencyLookupDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/17 8:31
 * @version: 1.0
 */
public class TypeSafetyDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(TypeSafetyDependencyLookupDemo.class);
        applicationContext.refresh();

        displayBeanFactoryGetBean(applicationContext);
        displayObjectFactoryGetObject(applicationContext);
        displayObjectProviderIfAvailable(applicationContext);
        displayListableBeanFactory(applicationContext);
        displayObjectProviderStreamOps(applicationContext);
        applicationContext.close();
    }

    private static void displayObjectProviderStreamOps(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectProviderStreamOps",()-> beanProvider.forEach(System.out::println));
    }

    private static void displayListableBeanFactory(ListableBeanFactory beanFactory) {
        printBeansException("displayListableBeanFactory",()-> beanFactory.getBeansOfType(User.class));
    }

    private static void displayObjectProviderIfAvailable(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject", beanProvider::getIfAvailable);
    }

    private static void displayObjectFactoryGetObject(AnnotationConfigApplicationContext applicationContext) {
        ObjectProvider<User> beanProvider = applicationContext.getBeanProvider(User.class);
        printBeansException("displayObjectFactoryGetObject", beanProvider::getObject);
    }

    public static void displayBeanFactoryGetBean(BeanFactory factory) {
        printBeansException("displayBeanFactoryGetBean",()-> factory.getBean(User.class));
    }

    private static void printBeansException(String source,Runnable runnable){
        System.err.println("SourceFrom: " + source);
        System.err.println("=====================================");
        try {
            runnable.run();
        }catch (BeansException e){
            e.printStackTrace();
        }
    }
}
