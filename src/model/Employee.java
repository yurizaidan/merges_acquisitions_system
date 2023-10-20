package model;

public class Employee extends User {

    public Employee(String first_name, String last_name, int id, Department department) {
        super(first_name, last_name, id, department);
        this.employment_type="Employee";
    }
}
