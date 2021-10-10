package com.wsy.java.juc.learn.ReflectDemo;

public class ReflectPerson {
    private String pr_name = "pr_name";
    public  String pu_name = "pu_name";
    protected String pro_name = "pro_name";

    public ReflectPerson(){}
    public ReflectPerson(String pr_name){
        this.pr_name = pr_name;
    }

    public String getPr_name(){
        return this.pr_name;
    }
    private String getPu_name(){
        return this.pu_name;
    }
    public void print_name(){
        System.out.println(this.pro_name);
    }

    private Integer sum(Integer a,int b){
        return a+b;
    }

    @Override
    public String toString () {
        return "ReflectPerson{" +
                "pr_name='" + pr_name + '\'' +
                ", pu_name='" + pu_name + '\'' +
                ", pro_name='" + pro_name + '\'' +
                '}';
    }
}
