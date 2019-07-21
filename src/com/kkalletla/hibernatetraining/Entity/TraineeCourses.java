package com.kkalletla.hibernatetraining.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/*TraineeCourses is made up of 2 foreign keys corresponding to id columns of trainee and course.
* Therefore 2 ManyToOne mappings ae created and joined th the respective table.
* There is no primary key in the database. But in this class both the foreign keys are used as ID's.*/
@Entity
@Table(name = "trainee_courses")
public class TraineeCourses implements Serializable{


    @Id
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="trainee_id")
    private Trainee trainee;

    @Id
    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="course_id")
    private Course course;

    @Column(name="start_date")
    private Date startDate;

    public TraineeCourses() {

    }

    public TraineeCourses(Trainee trainee, Course course, Date startDate) {
        this.trainee = trainee;
        this.course = course;
        this.startDate = startDate;
    }

    public Trainee getTrainee() {
        return trainee;
    }

    public void setTrainee(Trainee trainee) {
        this.trainee = trainee;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "TraineeCourses{" +
                "startDate=" + startDate +
                '}';
    }
}
