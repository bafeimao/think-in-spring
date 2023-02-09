package org.bafeimao.thinking.in.spring.bean.defination;

import org.bafeimao.thinking.in.spring.bean.factory.DefaultUserFactory;
import org.bafeimao.thinking.in.spring.bean.factory.UserFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

import static java.util.ServiceLoader.load;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.defination
 * @className: BeanInstantinationDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/9 7:47
 * @version: 1.0
 */
public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/special-bean-instantiation-context.xml");

        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();

        ServiceLoader serviceLoader = beanFactory.getBean("userFactoryServiceLoader", ServiceLoader.class);

        displayServiceLoader(serviceLoader);
//        demoServiceLoader();
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
    }

    public static void demoServiceLoader() {
        ServiceLoader<UserFactory> serviceLoader = load(UserFactory.class, Thread.currentThread().getContextClassLoader());
        displayServiceLoader(serviceLoader);
    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        Iterator<UserFactory> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            UserFactory userFactory = iterator.next();
            System.out.println(userFactory.createUser());
        }
    }

}
