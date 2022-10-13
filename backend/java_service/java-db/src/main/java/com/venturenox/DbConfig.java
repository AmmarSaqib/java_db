package com.venturenox;

import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DbConfig {
    String PERSISTENCE_UNIT;
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
        this.ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(this.PERSISTENCE_UNIT);
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
