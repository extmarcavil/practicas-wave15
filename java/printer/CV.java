package com.company;

import java.util.Arrays;

public class CV extends Document{
    private String name;
    private String last_name;
    private int age;
    private String[] skills;

    public CV(String name, String last_name, int age, String[] skills) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "CV{" +
                "name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", age=" + age +
                ", habilities=" + Arrays.toString(skills) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }
}
