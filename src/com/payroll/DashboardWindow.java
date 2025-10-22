package com.payroll;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

/*
 * Main dashboard GUI
 * Allows adding, viewing, and deleting employees
 */
public class DashboardWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Payroll System - Dashboard");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton addBtn = new JButton("Add Employee");
        addBtn.setBounds(50, 50, 200, 40);
        frame.add(addBtn);

        JButton viewBtn = new JButton("View Employees");
        viewBtn.setBounds(50, 120, 200, 40);
        frame.add(viewBtn);

        JButton deleteBtn = new JButton("Delete Employee");
        deleteBtn.setBounds(50, 190, 200, 40);
        frame.add(deleteBtn);

        // Add Employee
        addBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField idField = new JTextField();
                JTextField nameField = new JTextField();
                JTextField deptField = new JTextField();
                JTextField salaryField = new JTextField();

                Object[] message = {
                    "ID:", idField,
                    "Name:", nameField,
                    "Department:", deptField,
                    "Salary:", salaryField
                };

                int option = JOptionPane.showConfirmDialog(frame, message, "Add Employee", JOptionPane.OK_CANCEL_OPTION);
                if(option == JOptionPane.OK_OPTION) {
                    try {
                        int id = Integer.parseInt(idField.getText());
                        String name = nameField.getText();
                        String dept = deptField.getText();
                        double salary = Double.parseDouble(salaryField.getText());

                        Employee emp = new Employee(id, name, dept, salary);

                        Connection con = DBConnection.getConnection();
                        PreparedStatement ps = con.prepareStatement(
                            "INSERT INTO employees(id, name, department, salary, hra, da, ta, deductions, net_salary) VALUES(?,?,?,?,?,?,?,?,?)");
                        ps.setInt(1, emp.getId());
                        ps.setString(2, emp.getName());
                        ps.setString(3, emp.getDepartment());
                        ps.setDouble(4, emp.getSalary());
                        ps.setDouble(5, emp.getHra());
                        ps.setDouble(6, emp.getDa());
                        ps.setDouble(7, emp.getTa());
                        ps.setDouble(8, emp.getDeductions());
                        ps.setDouble(9, emp.getNetSalary());
                        ps.executeUpdate();

                        JOptionPane.showMessageDialog(frame, "Employee Added Successfully!\nNet Salary: " + emp.getNetSalary());
                        con.close();
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                    }
                }
            }
        });

        // View Employees
        viewBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DBConnection.getConnection();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("SELECT * FROM employees");
                    StringBuilder sb = new StringBuilder();
                    while(rs.next()) {
                        sb.append("ID: ").append(rs.getInt("id"))
                          .append(", Name: ").append(rs.getString("name"))
                          .append(", Dept: ").append(rs.getString("department"))
                          .append(", Salary: ").append(rs.getDouble("salary"))
                          .append(", Net Salary: ").append(rs.getDouble("net_salary"))
                          .append("\n");
                    }
                    JOptionPane.showMessageDialog(frame, sb.length() > 0 ? sb.toString() : "No records found.");
                    con.close();
                } catch(Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                }
            }
        });

        // Delete Employee
        deleteBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idStr = JOptionPane.showInputDialog(frame, "Enter Employee ID to Delete:");
                if(idStr != null && !idStr.isEmpty()) {
                    try {
                        int id = Integer.parseInt(idStr);
                        Connection con = DBConnection.getConnection();
                        PreparedStatement ps = con.prepareStatement("DELETE FROM employees WHERE id=?");
                        ps.setInt(1, id);
                        int rows = ps.executeUpdate();
                        JOptionPane.showMessageDialog(frame, rows > 0 ? "Employee Deleted!" : "Employee ID not found!");
                        con.close();
                    } catch(Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}
