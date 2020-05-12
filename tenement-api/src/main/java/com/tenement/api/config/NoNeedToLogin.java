package com.tenement.api.config;

import java.lang.annotation.*;

/**
 * @author 徐周
 * @date ：Created in 2020-04-26 16:28
 * @description：1
 * @version: 1
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoNeedToLogin {
}
