package com.wsy.java.juc.learn.annotationDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnoDemo {
    public static void main (String[] args) {
        Person person = new Person("无注解","无注解","无注解");
        deAnnoTest(person);
        System.out.println(person.toString());
    }
    private static void deAnnoTest(Object obj) {
        Class clazz = obj.getClass();
        Field[] declareFields = clazz.getDeclaredFields();
        for (Field field:declareFields) {
            //检查该类是否使用了某个注解
            if(field.isAnnotationPresent(MyAnno.class)){
                MyAnno anno = field.getAnnotation(MyAnno.class);
                if(anno!=null){
                    String fieldName = field.getName();
                    try {
                        Method setMethod = clazz.getDeclaredMethod("set" + fieldName.substring(0, 1).toUpperCase() +
                                fieldName.substring(1),String.class);
                    //获取注解的属性
                        String annoValue = anno.value();
                    //将注解的属性值赋给对应的属性
                        setMethod.invoke(obj,annoValue);
                   }catch (Exception e){

                   }
               }
            }
        }
    }
}
