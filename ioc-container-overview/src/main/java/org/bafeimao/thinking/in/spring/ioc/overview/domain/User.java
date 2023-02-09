package org.bafeimao.thinking.in.spring.ioc.overview.domain;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.ioc.overview.domain
 * @className: User
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/6 6:53
 * @version: 1.0
 */
public class User {
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("芭菲猫");
        return user;
    }
}
