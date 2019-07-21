package com.kkalletla.hibernatetraining.Operation;

import com.kkalletla.hibernatetraining.Entity.Student;

import java.lang.reflect.Field;


/*
* Hibernate used reflection API to access Private fields in an Entity.
* An example can be demonstrated as follows.
* */
public class TestPrivateFieldAccess {

    public static void main(String[] args) {

        Student student = new Student();


        Field studentId = null;
        try {
            studentId = student.getClass().getDeclaredField("id");
            studentId.setAccessible(true);
            System.out.println(studentId.get(student));
            studentId.set(student, 100);
            System.out.println(studentId.get(student));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
