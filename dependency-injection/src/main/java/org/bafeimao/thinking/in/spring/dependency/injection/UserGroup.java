package org.bafeimao.thinking.in.spring.dependency.injection;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * @projectName: think-in-spring
 * @package: org.bafeimao.thinking.in.spring.dependency.injection
 * @className: UserGroup
 * @author: ycd20
 * @description: {@link org.springframework.beans.factory.annotation.Qualifier}
 * @date: 2023/2/21 21:20
 * @version: 1.0
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier
public @interface UserGroup {

}
