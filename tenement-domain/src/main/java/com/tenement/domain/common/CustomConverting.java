package com.tenement.domain.common;

import org.dozer.CustomConverter;

import java.lang.annotation.*;

/**
 * @author lingzhen on 17/9/4.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomConverting {

    /**
     * 自定义转换器
     * @return
     */
    Class<? extends CustomConverter> value();

    /**
     * 转换器参数
     * @return
     */
    String parameter() default "";
}
