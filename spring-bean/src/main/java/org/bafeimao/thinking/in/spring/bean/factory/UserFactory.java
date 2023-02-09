package org.bafeimao.thinking.in.spring.bean.factory;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.factory
 * @className: UserFactory
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/9 7:52
 * @version: 1.0
 */
public interface UserFactory {
    default User createUser(){
        return User.createUser();
    }
}
