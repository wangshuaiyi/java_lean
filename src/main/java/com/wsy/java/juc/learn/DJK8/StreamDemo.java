package com.wsy.java.juc.learn.DJK8;

import java.util.*;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main (String[] args) {
        ArrayList<PersonStream> arrayList = new ArrayList();
        arrayList.add(new PersonStream("test1",10));
        arrayList.add(new PersonStream("test2",20));
        arrayList.add(new PersonStream("3test1",25));
        arrayList.add(new PersonStream("4test1",29));
        arrayList.add(new PersonStream("5test1",35));
//        Map<String,PersonStream> collect = arrayList.stream().collect(Collectors.toMap(new Function<PersonStream, String>() {
//            @Override
//            public String apply(PersonStream userEntity) {
//                return userEntity.getName();
//            }
//        }, new Function<PersonStream, PersonStream>() {
//            @Override
//            public PersonStream apply(PersonStream userEntity) {
//                return userEntity;
//            }
//        }));
        Map<String,PersonStream> collect = arrayList.stream().collect(Collectors.toMap((person)->  person.getName(),
                (persopn)-> persopn));
//        collect.forEach(new BiConsumer<String,PersonStream>(){
//
//            @Override
//            public void accept (String s, PersonStream personStream) {
//                System.out.println("s: " + s + " ,: " + personStream);
//            }
//        });
        collect.forEach((s, personStream) -> System.out.println("s: " + s + " ,: " + personStream));

        Stream<Integer> integerStream = Stream.of(10, 30, 80, 60, 10, 70);

        Optional<Integer> reduce = integerStream.reduce((a1, a2) -> a1 + a2);
        System.out.println(reduce.get());

        Optional<PersonStream> reduce1 = arrayList.stream().reduce((p1,p2)->{p1.setAge(p1.getAge() + p2.getAge());
        return p1;});
        System.out.println(reduce1.toString());

        Optional<PersonStream> max = arrayList.stream().max((p1,p2)-> p1.getAge() - p2.getAge());
        System.out.println(max.get());

        Optional<PersonStream> min = arrayList.stream().min((p1,p2)-> p1.getAge() - p2.getAge());
        System.out.println(min.get());

//        anyMatch表示，判断的条件里，任意一个元素成功，返回true
//        allMatch表示，判断条件里的元素，所有的都是，返回true
//        noneMatch跟allMatch相反，判断条件里的元素，所有的都不是，返回true

        boolean result = arrayList.stream().noneMatch((p)->p.getAge() > 30);

        arrayList.stream().filter(p -> p.getAge() > 20).filter(p -> p.getName().contains("3"));
    }
}
