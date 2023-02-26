package org.bafeimao.thinking.in.spring.dependency.injection;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.injection
 * @className: QualifierAnnotationDependencyInjectionDemo
 * @author: ycd20
 * @description: {@link org.springframework.beans.factory.ObjectProvider} 实现延迟注入
 * @date: 2023/2/21 20:08
 * @version: 1.0
 */
@Configuration
public class LazyAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    private ObjectProvider<User> objectProvider;

    @Autowired
    private ObjectFactory<Set<User>> setObjectFactory;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(LazyAnnotationDependencyInjectionDemo.class);

        //注册UserHolder的BeanDefinition
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        //load xml resource
        beanDefinitionReader.loadBeanDefinitions(location);
        applicationContext.refresh();

        //依赖查找
        LazyAnnotationDependencyInjectionDemo demo = applicationContext.getBean(LazyAnnotationDependencyInjectionDemo.class);
        System.out.println("demo.User" + demo.user);
        System.out.println("demo.userObjectProvider" + demo.objectProvider.getObject());
        System.out.println("demo.userObjectFactory" + demo.setObjectFactory.getObject());

        demo.objectProvider.forEach(System.out::println);

        applicationContext.close();
    }
}
