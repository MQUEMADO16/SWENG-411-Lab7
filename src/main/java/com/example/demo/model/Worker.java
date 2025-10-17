package com.example.demo.model;

import java.io.Serializable;

public class Worker implements Serializable {

    // Attributes
    private String name;
    private int age;
    private String gender;
    private int yearsWorkExp;

    // Constructor
    public Worker(String name, int age, String gender, int yearsWorkExp) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.yearsWorkExp = yearsWorkExp;
    }

    // Methods

    // Get/Set
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getYearsWorkExp() {
        return this.yearsWorkExp;
    }

    public void setYearsWorkExp(int years) {
        this.yearsWorkExp = years;
    }

    public String printWorker() {
        return "Worker: " + name + " | Age: " + age + " | Gender: " + gender + " | Years of Work Experience: " + yearsWorkExp;
    }
}
