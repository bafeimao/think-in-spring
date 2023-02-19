package org.bafeimao.thinking.in.spring.dependency.lookup;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.lookup
 * @className: HierarchicalDependencyLookupDemo
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/18 23:04
 * @version: 1.0
 */
public class HierarchicalDependencyLookupDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        applicationContext.register(ObjectProviderDemo.class);
        ConfigurableListableBeanFactory beanFactory = applicationContext.getBeanFactory();
        System.out.println("当前 BeanFactory 的 Parent BeanFactory: " + beanFactory.getParentBeanFactory());
        // 1.设置 Parent BeanFactory
        HierarchicalBeanFactory parentBeanFactory = createBeanFactory();
        beanFactory.setParentBeanFactory(parentBeanFactory);
        System.out.println("当前 BeanFactory 的 Parent BeanFactory: " + beanFactory.getParentBeanFactory());

        displayContainsLocalBean(beanFactory, "user");
        displayContainsLocalBean(parentBeanFactory, "user");
        displayContainsBean(beanFactory, "user");
        displayContainsBean(parentBeanFactory,"user");
        applicationContext.refresh();

        applicationContext.close();

    }

    private static void displayContainsBean(HierarchicalBeanFactory beanFactory,String beanName){
        containsBean(beanFactory,beanName);
        System.out.println("当前 BeanFactory 是否包含 Bean[name: "+beanName+"]: "+containsBean(beanFactory,beanName));
    }

    private static boolean containsBean(HierarchicalBeanFactory beanFactory, String beanName) {
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        if (parentBeanFactory instanceof HierarchicalBeanFactory) {
            HierarchicalBeanFactory parentHierarchicalBeanFactory = HierarchicalBeanFactory.class.cast(parentBeanFactory);
            if (beanFactory.containsLocalBean(beanName)) {
                return true;
            }
            return containsBean(parentHierarchicalBeanFactory, beanName);
        }
        return beanFactory.containsLocalBean(beanName);
    }

    private static void displayContainsLocalBean(HierarchicalBeanFactory beanFactory, String beanName) {
        System.out.printf("当前 BeanFactory[%s] 是否包含 Local Bean[name: %s]: %s\n", beanFactory, beanName, beanFactory.containsLocalBean(beanName));
    }

    private static ConfigurableListableBeanFactory createBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beandefinationsCount = reader.loadBeanDefinitions(location);
        return beanFactory;
    }

}
