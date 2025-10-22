package com.payroll;

/*
 * Represents an Employee object and calculates payroll automatically
 */
public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private double hra, da, ta, deductions, netSalary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;

        // Payroll calculation
        this.hra = salary * 0.1;        // House Rent Allowance 10%
        this.da = salary * 0.08;        // Dearness Allowance 8%
        this.ta = salary * 0.05;        // Travel Allowance 5%
        this.deductions = salary * 0.02; // Deductions 2%
        this.netSalary = salary + hra + da + ta - deductions;
    }

    // Getters
    public int getId() { return id; }
    public String getName() {   return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public double getHra() { return hra; }
    public double getDa() { return da; }
    public double getTa() { return ta; }
    public double getDeductions() { return deductions; }
    public double getNetSalary() { return netSalary; }
}
