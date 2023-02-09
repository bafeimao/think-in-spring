package org.bafeimao.thinking.in.spring.ioc.overview.domain;

import org.bafeimao.thinking.in.spring.ioc.overview.annotation.Super;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.ioc.overview.domain
 * @className: SuperUser
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/7 20:46
 * @version: 1.0
 */
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public SuperUser setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
