package com.kkalletla.hibernatetraining.Operation;

import com.kkalletla.hibernatetraining.Entity.Course;
import com.kkalletla.hibernatetraining.Entity.Trainer;
import com.kkalletla.hibernatetraining.HibernateUtility.ApplicationSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class CreateTrainer {

    private static void print(Object object){
        System.out.println("CreateTrainer: "+object);
    }

    public static void main(String[] args) {

        print("In CreateTrainer main method.");

        print("Creating Trainer object.");
        Trainer trainer = new Trainer("Kranthi Kiran", "Kaletla","Des Moines");
        print("Trainer object created");

        print("Creating Trainer object.");
        Course course = new Course("Java", "Concepts in core Java");
        print("Trainer object created");
        trainer.addCourse(course);

        Session session = null;
        try {
            session = ApplicationSessionFactory.getSessionFactory().openSession();
            print("Session Created");

            session.beginTransaction();
            print("Transaction Started");

            /*Persisting only the parent object will also persist the dependent objects based on the cascading type described in the classes.
            * But when save() is used, dependent objects are not saved.9*/
            session.persist(trainer);
            //session.persist(course);


            print("Trainer object persisted");
            print(trainer);
            print(course);
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
