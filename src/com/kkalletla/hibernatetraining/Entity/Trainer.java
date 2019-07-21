package com.kkalletla.hibernatetraining.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*This class is used to map Trainer table in the database.
* id column is used as reference to a foreign key column in Course class and course table.
* Therefore a OneToMany mapping is created by creating a field od List<Course> type. The parameter
* mapping should be equated to the field of type Trainer in Course class.
*
* addCourse method is used to link trainer and course objects by populating the respective fields.
* This class uses @Access(AccessType.PROPERTY).*/
@Entity
@Table(name = "trainer")
public class Trainer {

    private int id;
    private String firstName;
    private String lastName;
    private String address;

    private List<Course> courses;

    public Trainer() {

    }

    public Trainer(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @OneToMany(mappedBy = "trainer", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", courses=" + courses +
                '}';
    }

    public void addCourse(Course course){
        if(courses == null)
            courses = new ArrayList<>();

        course.setTrainer(this);
        courses.add(course);
    }
}
