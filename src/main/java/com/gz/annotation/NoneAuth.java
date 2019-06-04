package com.gz.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 使用此注解表示不需要鉴权
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface NoneAuth {

}
