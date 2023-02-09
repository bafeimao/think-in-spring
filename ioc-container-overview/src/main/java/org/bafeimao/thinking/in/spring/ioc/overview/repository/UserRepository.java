package org.bafeimao.thinking.in.spring.ioc.overview.repository;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;

import java.util.Collection;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.ioc.overview.repository
 * @className: UserRepository
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/7 21:00
 * @version: 1.0
 */
public class UserRepository {

    private Collection<User> users;

    private BeanFactory beanFactory;

    private ObjectFactory<ApplicationContext> userObjectFactory;


    public ObjectFactory<ApplicationContext> getUserObjectFactory() {
        return userObjectFactory;
    }

    public UserRepository setUserObjectFactory(ObjectFactory<ApplicationContext> userObjectFactory) {
        this.userObjectFactory = userObjectFactory;
        return this;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public UserRepository setUsers(Collection<User> users) {
        this.users = users;
        return this;
    }

    public UserRepository setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
        return this;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
