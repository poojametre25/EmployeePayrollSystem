package com.payroll;

import javax.swing.*;
import java.awt.event.*;

/*
 * Simple login GUI for admin
 */
public class LoginWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Payroll System - Login");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 50, 100, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(150, 50, 150, 25);
        frame.add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 90, 100, 25);
        frame.add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(150, 90, 150, 25);
        frame.add(passText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 140, 100, 30);
        frame.add(loginButton);

        // Login button action
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = String.valueOf(passText.getPassword());

                if(username.equals("admin") && password.equals("admin")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                    frame.dispose();
                    DashboardWindow.main(null); // Open dashboard
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Username or Password");
                }
            }
        });

        frame.setVisible(true);
    }
}
