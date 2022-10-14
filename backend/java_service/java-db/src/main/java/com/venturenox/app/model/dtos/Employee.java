package com.venturenox.app.model.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;

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
    @Id
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
