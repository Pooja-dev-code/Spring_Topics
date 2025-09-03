package com.spring.AOP.model;

public class Employee {

    private int id;
    private int age;
    private String job;

    public Employee(int age, String job) {
        this.age = age;
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
