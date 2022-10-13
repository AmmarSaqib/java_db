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

    public EmployeesDBMan(EntityManager entity_manager) {
        this.entity_manager = entity_manager;
        this.criteria_builder = this.entity_manager.getCriteriaBuilder();
    }

    public List<Employee> get_all() {
        // using HQL
        this.entity_manager.getTransaction().begin();

        List<Employee> result = this.entity_manager.createQuery("from Employee",
                Employee.class).getResultList();

        this.entity_manager.getTransaction().commit();
        this.entity_manager.close();

        return result;
    }

    public List<Employee> get_by_id(int id) {
        // using Criteria Builder
        CriteriaQuery<Employee> query = this.criteria_builder.createQuery(Employee.class);
        Root<Employee> root = query.from(Employee.class);

        query.where(this.criteria_builder.equal(root.get("id"), id));

        return this.entity_manager.createQuery(query).getResultList();

    }
}
