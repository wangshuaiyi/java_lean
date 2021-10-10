package com.wsy.java.juc.learn.ProxyDemo;

import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Demo {
    public static void main (String[] args) {
        Subject subject = new SubjectImpl();
        InvocationHandler proxy = new SubjectProxy(subject);
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),subject.getClass().getInterfaces(),proxy);
        proxyInstance.hello("test");

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGLIBSubject.class);
        enhancer.setCallback(new CGLIBInterceptor());
        CGLIBSubject cglibSubject = (CGLIBSubject) enhancer.create();
        cglibSubject.sayHello("cglib");
    }
}
