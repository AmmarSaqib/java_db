package com.venturenox.app;

import java.util.Date;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import com.venturenox.app.model.dtos.Employee;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    public static void main(String[] args) {
        // Configuring log4j via properties file
        Properties props_log = new Properties();
        try {
            props_log.load(new FileInputStream("/usr/app/log4j.properties"));
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println(e.toString());
        }
        PropertyConfigurator.configure(props_log);

        System.out.println(System.getenv("POSTGRES_USERNAME"));
        System.out.println(System.getenv("POSTGRES_PASSWORD"));
        System.out.println(System.getenv("POSTGRES_HOST"));
        System.out.println(System.getenv("DB_NAME"));

        EntityManagerFactory entityManagerFactory;
        entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Employee("ammar", "lahore"));
        entityManager.persist(new Employee("ammar", "lahore"));
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
