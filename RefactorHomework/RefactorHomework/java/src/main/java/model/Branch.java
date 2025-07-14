package model;

import java.util.List;

public class Branch {
    private String branchName;
    private Department specialty;
    private List<Employee> employees;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Department getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Department specialty) {
        this.specialty = specialty;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
