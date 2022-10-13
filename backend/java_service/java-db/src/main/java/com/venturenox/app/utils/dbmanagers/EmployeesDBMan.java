package com.venturenox.app.utils.dbmanagers;

import com.venturenox.app.model.dtos.Employee;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class EmployeesDBMan {

    EntityManager entity_manager;
    CriteriaBuilder criteria_builder;

    // A constructor that takes an EntityManager as a parameter.
    public EmployeesDBMan(EntityManager entity_manager) {
        this.entity_manager = entity_manager;
        this.criteria_builder = this.entity_manager.getCriteriaBuilder();
    }

    /**
     * Get all the employees from the database.
     * 
     * @return A list of all the employees in the database.
     */
    public List<Employee> get_all() {
        // using HQL
        this.entity_manager.getTransaction().begin();

        List<Employee> result = this.entity_manager.createQuery("from Employee",
                Employee.class).getResultList();

        this.entity_manager.getTransaction().commit();
        this.entity_manager.close();

        return result;
    }

    /**
     * "Get all employees with the given id."
     * 
     * The first line of the function is a declaration of the return type. In this case, it's a list of
     * employees
     * 
     * @param id The id of the employee you want to get.
     * @return A list of employees with the given id.
     */
    public List<Employee> get_by_id(int id) {
        // using Criteria Builder
        CriteriaQuery<Employee> query = this.criteria_builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        query.where(this.criteria_builder.equal(root.get("id"), id));

        return this.entity_manager.createQuery(query).getResultList();

    }
}
