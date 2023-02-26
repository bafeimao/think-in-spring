package org.bafeimao.thinking.in.spring.ioc.overview.domain;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.emun.City;
import org.springframework.core.io.Resource;

import java.util.Arrays;
import java.util.List;

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

    private City city;

    private City[] workCities;

    private List<City> lifeCities;

    private Resource configFileLocation;

    public City[] getWorkCities() {
        return workCities;
    }

    public User setWorkCities(City[] workCities) {
        this.workCities = workCities;
        return this;
    }

    public Resource getConfigFileLocation() {
        return configFileLocation;
    }

    public User setConfigFileLocation(Resource configFileLocation) {
        this.configFileLocation = configFileLocation;
        return this;
    }

    public City getCity() {
        return city;
    }

    public User setCity(City city) {
        this.city = city;
        return this;
    }

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

    public List<City> getLifeCities() {
        return lifeCities;
    }

    public User setLifeCities(List<City> lifeCities) {
        this.lifeCities = lifeCities;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city=" + city +
                ", workCities=" + Arrays.toString(workCities) +
                ", lifeCities=" + lifeCities +
                ", configFileLocation=" + configFileLocation +
                '}';
    }

    public static User createUser() {
        User user = new User();
        user.setId(1L);
        user.setName("芭菲猫");
        return user;
    }
}
