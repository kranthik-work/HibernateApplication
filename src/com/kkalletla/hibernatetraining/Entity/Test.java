package com.kkalletla.hibernatetraining.Entity;

import javax.persistence.*;

    /*Hibernate doesn't use getter/setter methods to get or assign values to the fields.
    * To let that happen the annotations should be given on top of the getters instead of fields
    * and set @Access(AccessType.PROPERTY) at class level.*/
@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Test() {

    }

    public Test(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
