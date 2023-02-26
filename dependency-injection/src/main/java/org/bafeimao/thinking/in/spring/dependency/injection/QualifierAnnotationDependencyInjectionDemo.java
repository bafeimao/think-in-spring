package org.bafeimao.thinking.in.spring.dependency.injection;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.injection
 * @className: QualifierAnnotationDependencyInjectionDemo
 * @author: ycd20
 * @description: {@link org.springframework.beans.factory.annotation.Qualifier}
 * @date: 2023/2/21 20:08
 * @version: 1.0
 */
@Configuration
public class QualifierAnnotationDependencyInjectionDemo {

    @Autowired
    private User user;

    @Autowired
    @Qualifier("user")
    private User namedUser;

    @Autowired
    private Collection<User>allusers;

    @Autowired
    @Qualifier
    private Collection<User> qualifiedUsers;

    @Autowired
    @UserGroup
    private Collection<User> groupedUsers;

    @Bean
    @Qualifier
    public User user2() {
        User user1 = new User();
        user1.setId(8L);
        return user1;    }

    @Bean
    @Qualifier
    public User user1() {
        User user1 = new User();
        user1.setId(1L);
        return user1;
    }

    @Bean
    @UserGroup
    public User user3(){
        return createUser(9L);
    }

    @Bean
    @UserGroup
    public User user4(){
        return createUser(10L);
    }

    private static User createUser(Long id){
        User user = new User();
        user.setId(id);
        return user;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(QualifierAnnotationDependencyInjectionDemo.class);

        //注册UserHolder的BeanDefinition
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(applicationContext);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        //load xml resource
        beanDefinitionReader.loadBeanDefinitions(location);
        applicationContext.refresh();

        //依赖查找
        QualifierAnnotationDependencyInjectionDemo demo = applicationContext.getBean(QualifierAnnotationDependencyInjectionDemo.class);

        System.out.println("demo.user=" + demo.user);
        System.out.println("demo.namedUser" + demo.namedUser);
        System.out.println("all.namedUser" + demo.allusers);
        System.out.println("quali.namedUser" + demo.qualifiedUsers);
        System.out.println("groupUsers.namedUser" + demo.groupedUsers);
        applicationContext.close();
    }
}
