package com.venturenox.app;

import com.venturenox.app.model.dtos.Employee;
import com.venturenox.app.utils.dbmanagers.EmployeesDBMan;

import java.util.List;
import java.util.Properties;

import java.io.FileInputStream;

import org.apache.log4j.PropertyConfigurator;

public class Main {

    public static void main(String[] args) {
        // Configuring log4j via properties file
        Properties props_log = new Properties();
        try {
            props_log.load(new FileInputStream("/usr/app/log4j.properties"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        PropertyConfigurator.configure(props_log);

        // intitializing the Database configuration and getting the entity manager
        // factory.
        DbConfig db = new DbConfig("my-persistence-unit");

        List<Employee> result = new EmployeesDBMan(db.get_manager()).get_all();
        List<Employee> result_id = new EmployeesDBMan(db.get_manager()).get_by_id(27);

        System.out.println("------Printing Query Data------");
        if (result.isEmpty()) {
            System.out.println("No data in the table");
        } else {
            for (Employee employee : result) {
                System.out.println(employee.getName());
            }
        }

        if (result_id.isEmpty()) {
            System.out.println("No data in the table");
        } else {
            for (Employee employee : result_id) {
                System.out.println(employee.getName());
            }
        }
    }
}
