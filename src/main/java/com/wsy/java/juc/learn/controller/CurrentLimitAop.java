package com.wsy.java.juc.learn.controller;

import com.google.common.util.concurrent.RateLimiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class CurrentLimitAop {

    private ConcurrentHashMap<String, RateLimiter> rateLimiters = new ConcurrentHashMap();

    @Around(value = "@annotation(com.wsy.java.juc.learn.controller.CurrentLimit)")
    public Object around(ProceedingJoinPoint joinPoint){

       try{
           //获取拦截的方法名字
           Signature signature = joinPoint.getSignature();
           //获取拦截的方法名字
           MethodSignature methodSignature = (MethodSignature) signature;
           CurrentLimit currentLimit = methodSignature.getMethod().getDeclaredAnnotation(CurrentLimit.class);
           if(currentLimit == null){
               //执行目标方法
               return joinPoint.proceed();
           }

           //获取注解上name
           String name = currentLimit.name();
           //获取token
           double token = currentLimit.token();

           RateLimiter rateLimiter = rateLimiters.get(name);
           if(rateLimiter == null){
               rateLimiter = RateLimiter.create(token);
               rateLimiters.put(name,rateLimiter);
           }
           //限流
           boolean result = rateLimiter.tryAcquire();
           if(!result){
               return "访问人数过多";
           }
           return joinPoint.proceed();
       }catch (Throwable throwable) {
           throwable.printStackTrace();
           return "系统出错";
       }


    }

}
