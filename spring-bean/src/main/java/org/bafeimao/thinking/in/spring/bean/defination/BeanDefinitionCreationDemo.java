package org.bafeimao.thinking.in.spring.bean.defination;

import org.bafeimao.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.definition
 * @className: BeanDefinitionCreationDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/8 17:39
 * @version: 1.0
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1)
                .addPropertyValue("name", "芭菲猫");
        BeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();

        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(User.class);

        MutablePropertyValues propertyValues = new MutablePropertyValues();
//        propertyValues.addPropertyValue("id", 1);
//        propertyValues.addPropertyValue("name", "芭菲猫");
        propertyValues
                .add("id", 1)
                .add("name", "芭菲猫");
        genericBeanDefinition.setPropertyValues(propertyValues);

    }
}
