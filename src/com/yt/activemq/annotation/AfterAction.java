package com.yt.activemq.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2016/1/13 0013.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AfterAction {
    String value() default "";
}
