package org.bafeimao.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * {@link org.springframework.beans.BeanInstantiationException} 示例代码
 *
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.lookup
 * @className: BeanInstantiationExceptionDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/19 9:51
 * @version: 1.0
 */
public class BeanInstantiationExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(CharSequence.class);
        applicationContext.registerBeanDefinition("errorBean",beanDefinitionBuilder.getBeanDefinition());


        applicationContext.refresh();

        applicationContext.close();
    }
}
