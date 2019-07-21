package com.kkalletla.hibernatetraining.Operation;

import com.kkalletla.hibernatetraining.Entity.Test;
import com.kkalletla.hibernatetraining.HibernateUtility.ApplicationSessionFactory;
import org.hibernate.Session;

import java.util.List;

public class UsingContextSession {

    public static void main(String[] args) {

        Session session = ApplicationSessionFactory.getSessionFactory().getCurrentSession();

        session.beginTransaction();
        List<Test> tests = session.createQuery("from Test").getResultList();

        session.getTransaction().commit();
        for(Test test: tests)
            System.out.println(test);
        ApplicationSessionFactory.closeSessionFactory();
    }
}
