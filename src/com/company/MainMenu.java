package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    public MainMenu() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("HELLO MANAGER! WRITE YOUR INFO");
        label.setBounds(140, 50, 220, 20);
        add(label);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(140, 90, 70, 20);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(230, 90, 70, 20);
        add(loginField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(140, 130, 70, 20);
        add(passLabel);

        JTextField passField = new JTextField();
        passField.setBounds(230, 130, 70, 20);
        add(passField);

        JButton Enterbutton = new JButton("ENTER");
        Enterbutton.setBounds(140, 170, 220, 20);
        add(Enterbutton);


        Enterbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String login = loginField.getText();
                String pass = passField.getText();

                if (login.equals(Manager.getLogin()) && pass.equals(Manager.getPinCode())) {
                    Main.frame.mainMenu.setVisible(false);
                    Main.frame.managerMenu.setVisible(true);
                    loginField.setText("");
                    passField.setText("");
                }


            }
        });



    }
}
