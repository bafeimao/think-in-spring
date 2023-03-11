package org.bafeimao.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * {@link org.springframework.beans.factory.BeanCreationException} 示例代码
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.lookup
 * @className: BeanCreationExceptionDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/17 9:54
 * @version: 1.0
 */
public class BeanCreationExceptionDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(POJO.class);
        applicationContext.registerBeanDefinition("errorBean",beanDefinitionBuilder.getBeanDefinition());


        applicationContext.refresh();

        applicationContext.close();
    }

    static class POJO implements InitializingBean{

        public void init() throws Throwable{
            throw new Throwable("For purpose");
        }
        @Override
        public void afterPropertiesSet() throws Exception {
            throw new Exception("afterPropertiesSet() For purpose...");
        }
    }
}
