package com.kkalletla.hibernatetraining.HibernateUtility;

import com.kkalletla.hibernatetraining.Entity.Test;
import org.hibernate.Session;

public class TestAccess {

    /*Hibernate doesn't use getter/setter methods to get or assign values to the fields.
    * To let that happen the annotations should be given on top of the getters instead of fields
    * and set @Access(AccessType.PROPERTY) at class level.*/
    public static void main(String[] args) {

        Session session = ApplicationSessionFactory.getSessionFactory().openSession();

        Test test = new Test("First");

        session.beginTransaction();
        session.persist(test);
        session.getTransaction().commit();

        session.beginTransaction();
        Test newTest = session.get(Test.class, 1);
        System.out.println(newTest);
        session.close();
        ApplicationSessionFactory.closeSessionFactory();
    }
}
