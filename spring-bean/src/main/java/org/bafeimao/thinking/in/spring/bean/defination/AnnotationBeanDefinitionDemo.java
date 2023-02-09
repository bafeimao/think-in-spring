package org.bafeimao.thinking.in.spring.bean.defination;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.genericBeanDefinition;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.defination
 * @className: AnnotationBeanDefinitionDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/8 22:27
 * @version: 1.0
 */
@Import(AnnotationBeanDefinitionDemo.Config.class)
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        registerUserBeanDefinition(applicationContext,"mercyblitz-user");
        registerUserBeanDefinition(applicationContext);

        applicationContext.refresh();
        Map<String, Config> beans = applicationContext.getBeansOfType(Config.class);
        System.out.println(applicationContext.getBeansOfType(Config.class));
        System.out.println(applicationContext.getBeansOfType(User.class));

        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder builder = genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 1L)
                .addPropertyValue("name", "芭菲猫");
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    @Component
    public static class Config {
        @Bean(name = {"user", "bafeimao-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("芭菲猫");
            return user;
        }
    }
}
