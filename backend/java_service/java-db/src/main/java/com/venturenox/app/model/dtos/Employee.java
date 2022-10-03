package com.venturenox.app.model.dtos;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.GenerationType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "employees")
@Audited
public class Employee {

    private int id;
    private String name;
    private String address;

    public Employee() {
    }

    public Employee(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter functions

    // @SequenceGenerator(name = "employee_sequence", sequenceName =
    // "employees_id_seq", allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "employees_id_seq")
    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
    // "employee_id_seq")
    // @SequenceGenerator(name = "employee_id_seq", sequenceName =
    // "employee_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    // Setter functions
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
