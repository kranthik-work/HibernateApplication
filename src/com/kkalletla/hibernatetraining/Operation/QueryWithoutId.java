package com.kkalletla.hibernatetraining.Operation;

import com.kkalletla.hibernatetraining.Entity.TraineeCourses;
import com.kkalletla.hibernatetraining.HibernateUtility.ApplicationSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.List;

public class QueryWithoutId {

    public static void main(String[] args) {

        Session session = null;

        try{
            session = ApplicationSessionFactory.getSessionFactory().openSession();

            session.beginTransaction();
            List<TraineeCourses> traineeCourses = session.createQuery("from TraineeCourses").getResultList();

            for(TraineeCourses traineeCourse: traineeCourses)
                System.out.println(traineeCourse);

            session.getTransaction().commit();

        }catch (HibernateException e){
            System.out.println("Hibernate Exception");
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("Exception");
            e.printStackTrace();
        }finally {
            session.close();
            ApplicationSessionFactory.closeSessionFactory();
        }
    }
}
