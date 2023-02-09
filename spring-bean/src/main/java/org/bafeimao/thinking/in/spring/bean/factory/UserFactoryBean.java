package org.bafeimao.thinking.in.spring.bean.factory;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.factory
 * @className: UserFactoryBean
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/9 7:59
 * @version: 1.0
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
