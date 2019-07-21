package com.kkalletla.hibernatetraining.Entity;

import javax.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/*This class is used to map Trainee table in the database.
* id column is used as reference to a foreign key column in TraineeCourses class and trainee_courses table.
* Therefore a OneToMany mapping is created by creating a field od List<TraineeCourses> type. The parameter
* mapping should be equated to the field of type Trainee in TraineeCourses class.
*
* A method addCourse is used to link or map Trainee, course and TraineeCourses.
* This class uses @Access(AccessType.PROPERTY).*/
@Entity
@Table(name = "trainee")
public class Trainee {

    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private List<TraineeCourses> traineeCourses;

    public Trainee() {

    }

    public Trainee(String firstName, String lastName, String address) {
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

    @OneToMany(mappedBy = "trainee", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    public List<TraineeCourses> getTraineeCourses() {
        return traineeCourses;
    }

    public void setTraineeCourses(List<TraineeCourses> traineeCourses) {
        this.traineeCourses = traineeCourses;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void addCourse(Course course){
        if(traineeCourses == null)
            traineeCourses = new ArrayList<>();
        if(course.getTraineeCourses() == null)
            course.setTraineeCourses(traineeCourses);

        Date now = Calendar.getInstance().getTime();
        TraineeCourses newTraineeCourses = new TraineeCourses(this,course,now);
        traineeCourses.add(newTraineeCourses);
    }
}
