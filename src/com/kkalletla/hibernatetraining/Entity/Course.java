package com.kkalletla.hibernatetraining.Entity;

import javax.persistence.*;
import java.util.List;

/*This class is used to map Course table in the database.
* id column is used as reference to a foreign key column in TraineeCourses class and trainee_courses table.
* Therefore a OneToMany mapping is created by creating a field od List<TraineeCourses> type. The parameter
* mapping should be equated to the field of type Courses in TraineeCourses class.
*
* traineeId field is a foreign key mapped to id of Trainer Class or trainer table.
* Therefore a ManyToOne mapping is created with joinColumn as the foreign key column. This field should be used as mapping in Trainer class.
* This class uses @Access(AccessType.PROPERTY).*/
@Entity
@Table(name = "course")
public class Course {

    private int id;
    private String courseName;
    private String description;
    private Trainer trainer;
    private List<TraineeCourses> traineeCourses;

    public Course() {

    }

    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
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

    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name = "trainer_id")
    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @OneToMany(mappedBy = "course", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    public List<TraineeCourses> getTraineeCourses() {
        return traineeCourses;
    }

    public void setTraineeCourses(List<TraineeCourses> traineeCourses) {
        this.traineeCourses = traineeCourses;
    }


    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
