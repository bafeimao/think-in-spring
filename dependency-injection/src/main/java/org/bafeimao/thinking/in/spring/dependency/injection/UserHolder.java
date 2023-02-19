package org.bafeimao.thinking.in.spring.dependency.injection;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.injection
 * @className: UserHolder
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/19 16:04
 * @version: 1.0
 */
public class UserHolder {
    private User user;

    public UserHolder() {
    }

    public UserHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public UserHolder setUser(User user) {
        this.user = user;
        return this;
    }

    @Override
    public String toString() {
        return "UserHolder{" +
                "user=" + user +
                '}';
    }
}
