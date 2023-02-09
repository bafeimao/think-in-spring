package org.bafeimao.thinking.in.spring.ioc.overview.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.ioc.overview.annotation
 * @className: Super
 * @author: ycd20
 * @description: TODO
 * @date: 2023/2/7 20:47
 * @version: 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Super {
}
