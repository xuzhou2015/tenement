package com.tenement.api.config;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.common.Response;
import com.tenement.domain.common.StringUtils;
import com.tenement.domain.util.ResponseUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;


/**
 * @author 徐周
 * @date ：Created in 2020-04-14 15:18
 * @description：2
 * @version: 1
 */
@ControllerAdvice
public class AgbweappControllerAdvice implements RequestBodyAdvice {


    /**
     * 请求参数json解析全局异常捕捉处理
     *
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = {JsonMappingException.class, JsonParseException.class})
    public Response errorHandler(Exception e) {

        return ResponseUtils.create(CommonResultCode.ILLEGAL_REQ_PARAMETER);

    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        Method method = methodParameter.getMethod();
        String methodName = StringUtils.join(method.getDeclaringClass().getName(), ".", method.getName());
        return httpInputMessage;
    }

    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }
}
