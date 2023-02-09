package org.bafeimao.thinking.in.spring.ioc.overview.dependency.injection;

import org.bafeimao.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.ioc.overview.dependency.lookup
 * @className: DependencyLookUpDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/6 6:48
 * @version: 1.0
 */
public class DependencyInjection {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
//        System.out.println(userRepository.getUsers());

//        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory objectFactory = userRepository.getUserObjectFactory();
        System.out.println(objectFactory.getObject() == beanFactory);
//        System.out.println(beanFactory.getBean(BeanFactory.class));
    }


}
