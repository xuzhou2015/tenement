package com.tenement.api.config;

import com.tenement.domain.common.BusinessException;
import com.tenement.domain.common.CommonResultCode;
import com.tenement.domain.po.VisitLog;
import com.tenement.domain.vo.SysUserVo;
import com.tenement.service.api.VisitLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * @author 徐周
 * @date ：Created in 2020-04-19 15:40
 * @description：1
 * @version: 1
 */
@Aspect
@Component
public class AspectController {

    @Autowired
    private VisitLogService visitLogService;



    @Pointcut("execution(public * com.tenement.api.controller..*.*(..))")
    public void pointCut(){}

    /**
     * 在切点方法之前执行
     * @param joinPoint
     */
    @Before(value="pointCut()")
    public void doBefore(JoinPoint joinPoint){

//        Object[] args = joinPoint.getArgs();
//        if(args.length>0){
//            HttpServletRequest request=(HttpServletRequest)args[0];
//
//            Signature sig = joinPoint.getSignature();
//            MethodSignature msig = (MethodSignature) sig;
//            Method method=msig.getMethod();
//            HttpSession session = request.getSession();
//            SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
//            if (sysUserVo == null) {
//                throw new BusinessException(CommonResultCode.LONING);
//            }

//            NoNeedToLogin noNeedToLogin = method.getAnnotation(NoNeedToLogin.class);
//            if (noNeedToLogin != null) {
//                HttpSession session = request.getSession();
//                SysUserVo sysUserVo = (SysUserVo) session.getAttribute("user");
//                if (sysUserVo == null) {
//                    throw new BusinessException(CommonResultCode.LONING);
//                }
//            }
    //    }



  //      System.out.println("@Before：切点方法之前执行.....");
    }



    /**
     * 在切点方法之后执行
     * @param joinPoint
     */
    @After(value="pointCut()")
    public void doAfter(JoinPoint joinPoint) throws  Exception{
//        Object[] args = joinPoint.getArgs(); // 参数值
//        if(args.length>0){
//            HttpServletRequest request=(HttpServletRequest)args[0];
//
//            String ip=getIp(request);
//            // AddressUtils addressUtils = new AddressUtils();
//            //  String city=addressUtils.getAddresses("ip="+ip, "utf-8");
//
//          //  VisitLog visitLog=new VisitLog();
//          //  visitLog.setIp(ip);
//            // visitLog.setCity(city);
//          //  visitLogService.insertSelective(visitLog);
//        }


    }
    private String getIp(HttpServletRequest request){

        String ip = request.getHeader("x-forwarded-for");//squid 服务代理
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");//apache服务代理
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");//weblogic 代理
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");//有些代理
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP"); //nginx代理
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        if (ip != null) {
            //对于通过多个代理的情况，最后IP为客户端真实IP,多个IP按照','分割
            int position = ip.indexOf(",");
            if (position > 0) {
                ip = ip.substring(0, position);
            }
        }
        return ip;
    }
}
