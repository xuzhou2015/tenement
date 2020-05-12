package com.tenement.domain.common;

import com.tenement.domain.util.LoggerUtils;
import com.tenement.domain.util.ResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：徐周
 * @date ：Created in 2019/12/20 20:24
 * @description：通用异常处理
 */
@ControllerAdvice
public class BussinessExceptionHandler {

    private static final Logger log= LoggerFactory.getLogger(BussinessExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Response handler(Exception e, HandlerMethod method, HttpServletResponse resp) throws
            IOException {

        try{
            String str=e.getMessage();
            BusinessException businessException=new BusinessException();
            return ResponseUtils.create(businessException.getStatusCode(),str);

//            BusinessException businessException=(BusinessException)e;
//            return ResponseUtils.create(businessException.getStatusCode(),businessException.getRsMsg());

        }catch (Exception x){
            log.error(x.toString());
        }

        return ResponseUtils.create(CommonResultCode.FAILURE);


    }
}
