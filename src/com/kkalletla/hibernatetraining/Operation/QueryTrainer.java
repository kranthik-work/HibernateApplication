package com.kkalletla.hibernatetraining.Operation;

import com.kkalletla.hibernatetraining.Entity.Trainer;
import com.kkalletla.hibernatetraining.HibernateUtility.ApplicationSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class QueryTrainer {

    private static void print(Object object){
        System.out.println("CreateTrainer: "+object);
    }

    public static void main(String[] args) {

        Session session = null;
        try{
            session = ApplicationSessionFactory.getSessionFactory().openSession();
            print("Session Created");

            session.beginTransaction();
            print("Transaction Started");

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Trainer> criteriaQuery = criteriaBuilder.createQuery(Trainer.class);

            Root<Trainer> root = criteriaQuery.from(Trainer.class);
            criteriaQuery.select(root);
            List<Trainer> trainers = session.createQuery(criteriaQuery).getResultList();

            for(Trainer trainer: trainers){
                print(trainer);
            }

        }catch (HibernateException e){
            print("Hibernate Exception");
            e.printStackTrace();
        }catch (Exception e){
            print("Exception");
            e.printStackTrace();
        }finally {
            session.close();
            ApplicationSessionFactory.closeSessionFactory();
        }
    }
}
