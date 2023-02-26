package org.bafeimao.thinking.in.spring.dependency.source;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.source
 * @className: ResourceDependencySourceDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/22 22:35
 * @version: 1.0
 */
@Configuration
@PropertySource(value = "META-INF/default.properties",encoding = "UTF-8")
public class ExternalConfigurationDependencySourceDemo {

    @Value("${user.id:-1}")
    private Long id;

    @Value("${user.resource:classpath://default.properties}")
    private Resource resource;

    @Value("${usr.name}")
    private String name;


    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(ExternalConfigurationDependencySourceDemo.class);

        applicationContext.refresh();

        ExternalConfigurationDependencySourceDemo demo = applicationContext.getBean(ExternalConfigurationDependencySourceDemo.class);
        System.out.println("id" + demo.id);
        System.out.println("demo.name" + demo.name);
        System.out.println("demo.resource" + demo.resource);

        applicationContext.close();
    }
}
