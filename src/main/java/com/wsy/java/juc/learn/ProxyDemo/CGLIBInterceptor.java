package com.wsy.java.juc.learn.ProxyDemo;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLIBInterceptor implements MethodInterceptor {
    public Object intercept (Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("begin cglib");
        Object o1 = methodProxy.invokeSuper(o,objects);
        System.out.println("end cglib");
        return o1;
    }
}
