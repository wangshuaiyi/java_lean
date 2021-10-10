package com.wsy.java.juc.learn.ReflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo {

    public static void main (String[] args) throws Exception {
        ReflectPerson person = new ReflectPerson();
        //第一种方式，通过实例对象获取class
        Class pclass1 = person.getClass();
        ReflectPerson person1 = (ReflectPerson) pclass1.newInstance();
        System.out.println(person == person1);
        //第二种方式，直接获取
        Class pclass2 = ReflectPerson.class;
        ReflectPerson person2 = (ReflectPerson) pclass2.newInstance();
        System.out.println(person2);

        //第三种方式，通过全路径类名获取
        Class pclass3 = Class.forName("com.wsy.java.juc.learn.ReflectDemo.ReflectPerson");
        ReflectPerson person3 = (ReflectPerson)pclass3.newInstance();
        System.out.println(person3);

        //执行有参构造函数
        Constructor<?> constructor = pclass1.getConstructor(String.class);
        ReflectPerson person4 = (ReflectPerson)constructor.newInstance("test");
        System.out.println(person4);
        //获取所有public属性，protected也不能获取
        Field[] fields = pclass1.getFields();
        for(Field field : fields){
            System.out.println(field.getName());
        }
        Field pr = pclass1.getDeclaredField("pr_name");
        pr.setAccessible(true);//设置允许访问
        pr.set(person1,"demo");
        System.out.println(person1);
        //Field pu = pclass1.getField("pro_name");

        Method[] methods = pclass1.getDeclaredMethods();
        for(Method method : methods){
            System.out.println(method.getName());
        }
        Method pu_method = pclass1.getMethod("getPr_name");
        String str = (String) pu_method.invoke(person1);
        System.out.println("return: " + str);
        Method pr_method = pclass1.getDeclaredMethod("getPu_name");
        pr_method.setAccessible(true);
        String pr_return = (String)pr_method.invoke(person);
        System.out.println("pr_return: " + pr_return);

        Method avg_method = pclass1.getDeclaredMethod("sum",Integer.class,int.class);
        avg_method.setAccessible(true);
        int sum = (int) avg_method.invoke(person1,1,3);
        System.out.println("sum: " + sum);

    }
}
