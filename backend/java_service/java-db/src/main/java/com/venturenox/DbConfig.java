package com.venturenox;

import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DbConfig {
    String PERSISTENCE_UNIT;
    String CONNECTION_URL = "jdbc:postgresql://" + System.getenv("POSTGRES_HOST") + "/" + System.getenv("DB_NAME");
    String USERNAME = System.getenv("POSTGRES_USERNAME");
    String PASSWORD = System.getenv("POSTGRES_PASSWORD");
    EntityManagerFactory ENTITY_MANAGER_FACTORY;

    // Initializing the persistence unit and initializing the entity manager
    // factory.
    public DbConfig(String persistence_unit) {
        this.PERSISTENCE_UNIT = persistence_unit;

        this.init_entity_manager();
    }

    /**
     * > This function initializes the entity manager factory
     */
    private void init_entity_manager() {
        Map<String, String> persistenceMap = new HashMap<String, String>();

        persistenceMap.put("javax.persistence.jdbc.url", this.CONNECTION_URL);
        persistenceMap.put("javax.persistence.jdbc.user", this.USERNAME);
        persistenceMap.put("javax.persistence.jdbc.password", this.PASSWORD);

        this.ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(this.PERSISTENCE_UNIT, persistenceMap);
    }

    /**
     * > This function returns the EntityManagerFactory object
     * 
     * @return The EntityManagerFactory is being returned.
     */
    public EntityManagerFactory get_factory() {
        return this.ENTITY_MANAGER_FACTORY;
    }

    public EntityManager get_manager() {
        return this.ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
