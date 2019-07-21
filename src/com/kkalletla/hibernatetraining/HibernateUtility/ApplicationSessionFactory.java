package com.kkalletla.hibernatetraining.HibernateUtility;

import com.kkalletla.hibernatetraining.Entity.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class ApplicationSessionFactory {

    /*Class Name for Printing Purpose*/
    private final static String CLASS_NAME_STATIC = "ApplicationSessionFactory: ";

    /*Configuration is used to read database configuration details and the used to create SessionFactory*/
    public static Configuration configuration;

    /*Initialize Session Factory.
    * Thread safe immutable object. Only one object is created per application.
    * sessionFactory.openSession() is used to create a single threaded session.
    * sessionFactory.getCurrentSession() is used to return session bases on Current Session Context Class.*/
    private static SessionFactory sessionFactory;

    /*Service is used to register hibernate session in case of JNDI.*/
    private static StandardServiceRegistryBuilder standardServiceRegistryBuilder;

    private static Properties properties;

    static{
        try{

            /*Initialize configuration properties and set all the parameters.*/
            ConfigurationProperties configurationProperties = new ConfigurationProperties();

            configurationProperties.setDriverClass("com.mysql.jdbc.Driver");
            configurationProperties.setUrl("jdbc:mysql://localhost:3306/training_db?useSSL=false");
            configurationProperties.setUserName("training");
            configurationProperties.setPassword("training");
            configurationProperties.setShowSQL("true");
            configurationProperties.setPoolSize("1");
            configurationProperties.setDialect("org.hibernate.dialect.MySQLDialect");
            configurationProperties.setCurrentSessionContextClass("thread");

            System.out.println(CLASS_NAME_STATIC +"Configuration Properties created.");

            /*Create Properties object and load all the properties in it*/
            properties = new Properties();
            properties.setProperty("hibernate.connection.driver_class",configurationProperties.getDriverClass());
            properties.setProperty("hibernate.connection.url",configurationProperties.getUrl());
            properties.setProperty("hibernate.connection.username",configurationProperties.getUserName());
            properties.setProperty("hibernate.connection.password",configurationProperties.getPassword());
            properties.setProperty("hibernate.connection.pool_size",configurationProperties.getPoolSize());
            properties.setProperty("hibernate.dialect", configurationProperties.getDialect());
            properties.setProperty("hibernate.show_sql",configurationProperties.getShowSQL());
            properties.setProperty("hibernate.current_session_context_class", configurationProperties.getCurrentSessionContextClass());

            System.out.println(CLASS_NAME_STATIC +"Properties created.");

            /*Configures hibernate using ConfigurationProperties class(Where DB details are stored for this project*/
            configuration = new Configuration().setProperties(properties)
                                               .addAnnotatedClass(Trainer.class)
                                               .addAnnotatedClass(Trainee.class)
                                               .addAnnotatedClass(Course.class)
                                               .addAnnotatedClass(TraineeCourses.class)
                                               .addAnnotatedClass(Test.class)
                                               .configure();

            standardServiceRegistryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

            System.out.println(CLASS_NAME_STATIC +"Configuration done");

        }catch(Exception e){
            System.out.println(CLASS_NAME_STATIC +"Exception while building properties");
            e.printStackTrace();
        }
    }

    /*In case user decides to reconfigure hibernate, SessionFactory also must be recreated.
    * User changes the configuration and calls this method to recreate every thing.
    * This helps used to dynamically add entities and change database properties etc. */
    public static SessionFactory configure(Configuration config){
        configuration = config;
        resetSessionFactory();
        return getSessionFactory();
    }

    public static Configuration getConfiguration(){
        return configuration;
    }

    /*Build SessionFactory by making use of Configuration object.
    * If it is already created the same is returned, else a new object is created and returned.*/
    public static SessionFactory getSessionFactory(){

        try {
            if (sessionFactory == null) {

                sessionFactory = configuration.buildSessionFactory(standardServiceRegistryBuilder.build());
                System.out.println(CLASS_NAME_STATIC + "Session Factory created");
                return sessionFactory;
            } else {
                System.out.println(CLASS_NAME_STATIC + "Returning session factory");
                return sessionFactory;
            }
        }catch (HibernateException e){
            System.out.println(CLASS_NAME_STATIC +"Exception while building SessionFactory");
            e.printStackTrace();
            return null;
        }
    }

    /*Reset session factory to null*/
    private static void resetSessionFactory(){
        System.out.println(CLASS_NAME_STATIC +"Session factory set to null. Call getSessionFactory().");
        sessionFactory = null;
    }

    /*Close the created session factory*/
    public static void closeSessionFactory(){
        sessionFactory.close();
        System.out.println(CLASS_NAME_STATIC +"SessionFactory closed.");
    }


}
