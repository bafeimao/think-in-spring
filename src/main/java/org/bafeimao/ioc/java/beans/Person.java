package org.bafeimao.ioc.java.beans;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.ioc.java.beans
 * @className: Person
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/5 20:15
 * @version: 1.0
 */
public class Person {

    String name;

    Integer age;

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Person setAge(Integer age) {
        this.age = age;
        return this;
    }
}
