package org.bafeimao.thinking.in.spring.bean.factory;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.bean.factory
 * @className: DefaultUserFactory
 * @author: ycd20
 * @description:
 * @date: 2023/2/9 7:56
 * @version: 1.0
 */
public class DefaultUserFactory implements UserFactory, InitializingBean, DisposableBean {


    public void init() {
        System.out.println("@PostConstruct UserFactory initlization...");
    }

    public void initUserFactory() {
        System.out.println("自定义初始化方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("自定义afterProperties初始化方法");
    }


    public void preDestroy() {
        System.out.println("@preDestroy User Factory 销毁中");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean User Factory 销毁中");
    }

    public void doDestroy() {
        System.out.println("自定义销毁方法 User Factory 销毁中");
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("当前 DefaultUserFactory 对象正在被垃圾回收");
    }
}
