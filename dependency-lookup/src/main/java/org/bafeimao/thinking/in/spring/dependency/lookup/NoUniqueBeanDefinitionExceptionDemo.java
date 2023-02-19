package org.bafeimao.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * {@link org.springframework.beans.factory.NoUniqueBeanDefinitionException} 示例代码
 *
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.lookup
 * @className: NoUniqueBeanDefinitionExceptionDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/19 9:33
 * @version: 1.0
 */
public class NoUniqueBeanDefinitionExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(NoUniqueBeanDefinitionExceptionDemo.class);


        applicationContext.refresh();
        try {
            applicationContext.getBean(String.class);
        } catch (NoUniqueBeanDefinitionException e) {
            System.err.println("Spring 应用上下文存在 " + e.getNumberOfBeansFound() + " 个 " + String.class.getName() + " 类型的 Bean，具体原因：" + e.getMessage());
        }

        applicationContext.close();
    }

    @Bean
    public String bean1() {
        return "";
    }

    @Bean
    public String bean2() {
        return "2";
    }
    @Bean
    public String bean3() {
        return "3";
    }
}
