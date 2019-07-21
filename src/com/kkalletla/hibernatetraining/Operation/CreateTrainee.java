package com.kkalletla.hibernatetraining.Operation;

import com.kkalletla.hibernatetraining.Entity.Course;
import com.kkalletla.hibernatetraining.Entity.Trainee;
import com.kkalletla.hibernatetraining.Entity.Trainer;
import com.kkalletla.hibernatetraining.HibernateUtility.ApplicationSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CreateTrainee {

    private static void print(Object object){
        System.out.println("CreateTrainee: "+object);
    }

    public static void main(String[] args) {

        print("In CreateTrainee main method.");

        print("Creating Trainee object.");
        Trainee trainee = new Trainee("Kranthi Kiran", "Kaletla","Des Moines");
        print("Trainee object created");

        Session session = null;
        try {
            session = ApplicationSessionFactory.getSessionFactory().openSession();
            print("Session Created");

            session.beginTransaction();
            print("Transaction Started");

            Course course = session.get(Course.class,2);
            /*Persisting only the parent object will also persist the dependent objects based on the cascading type described in the classes.
            * But when save() is used, dependent objects are not saved.9*/

            trainee.addCourse(course);
            session.persist(trainee);
            //session.createSQLQuery("CALL storedProcedure()");
            //session.persist(course);


            print("Trainer object persisted");
            print(trainee);
            print(course);
            print(trainee.getTraineeCourses());
            session.getTransaction().commit();
            print("Session Committed");
        }catch (HibernateException e){
            print("Hibernate Error while in transaction.");
            e.printStackTrace();
        }catch(Exception e){
            print("Error while in transaction.");
            e.printStackTrace();
        }
        finally {
            session.close();
            ApplicationSessionFactory.closeSessionFactory();
        }
    }
}
