package com.autentia.tutoriales.dynamicjasper.datasource;

// Bean básico para almacenar los datos que mostrará el informe
public class Employee {

    private Long id;

    private String firstname;

    private String surname;

    private String startDate;

    private String salary;

    private String department;

    public Employee(Long id, String firstname, String surname, String startDate, String salary, String department) {
        this.id = id;
        this.firstname = firstname;
        this.surname = surname;
        this.startDate = startDate;
        this.salary = salary;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}
