package org.bafeimao.thinking.in.spring.dependency.injection;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;
import java.util.Map;
import java.util.Optional;

/**
 * 注解驱动的依赖注入过程
 *
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.injection
 * @className: QualifierAnnotationDependencyInjectionDemo
 * @author: ycd20
 * @description: {@link ObjectProvider} 实现延迟注入
 * @date: 2023/2/21 20:08
 * @version: 1.0
 */
@Configuration
public class AnnotationDependencyInjectionResolutionDemo {

    @Autowired
    private User user;

    @Autowired
    private Map<String, User> users;

    @Autowired
    private Optional<User> userOptional;

    @Inject
    private User injectUser;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationDependencyInjectionResolutionDemo.class);

        //注册UserHolder的BeanDefinition
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        //load xml resource
        beanDefinitionReader.loadBeanDefinitions(location);
        applicationContext.refresh();

        //依赖查找
        AnnotationDependencyInjectionResolutionDemo demo = applicationContext.getBean(AnnotationDependencyInjectionResolutionDemo.class);
        System.out.println("demo.injectUser=" + demo.injectUser);
        System.out.println("demo.User=" + demo.userOptional);


        applicationContext.close();
    }
}
