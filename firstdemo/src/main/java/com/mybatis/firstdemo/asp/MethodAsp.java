package com.mybatis.firstdemo.asp;

import com.mybatis.firstdemo.zhujie.MethodAnnotion;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;

@Aspect
@Component
public class MethodAsp {
    @Around("@annotation(methodAsp)")
    public Object getUser(ProceedingJoinPoint point, MethodAnnotion methodAsp) throws Throwable {
        System.out.println("--------------1------------");
        Object[] args = point.getArgs();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String id = request.getParameter("id");
        System.out.println(id);
        Object proceed = point.proceed();
        System.out.println("--------------2------------");
        return proceed;
    }
}
