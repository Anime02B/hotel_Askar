package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMoneyClient extends Container {
    public AddMoneyClient() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("WRITE THE CLIENT'S LOGIN AND SUM OF DEPOSIT");
        label.setBounds(140, 50, 350, 20);
        add(label);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(140, 90, 70, 20);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(230, 90, 70, 20);
        add(loginField);

        JLabel passLabel = new JLabel("Money:");
        passLabel.setBounds(140, 130, 70, 20);
        add(passLabel);

        JTextField passField = new JTextField();
        passField.setBounds(230, 130, 70, 20);
        add(passField);

        JButton EnterAddMoneyClientButton = new JButton("ENTER");
        EnterAddMoneyClientButton.setBounds(140, 170, 220, 20);
        add(EnterAddMoneyClientButton);

        EnterAddMoneyClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Smoney = passField.getText();
                String log = loginField.getText();
                if (!Smoney.isEmpty() && !log.isEmpty()) {
                    int money = Integer.parseInt(passField.getText());
                    for (Client cl : Main.listClients()) {
                        if (cl.getLogin().equals(log)) {
                            Main.addMoney(cl,money);

                            Main.frame.addMoneyClient.setVisible(false);
                            Main.frame.finalAddMoneyClient.setVisible(true);

                            loginField.setText("");
                            passField.setText("");
                            break;
                        }
                    }
                }
            }
        });


        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,210,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addMoneyClient.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
                loginField.setText("");
                passField.setText("");
            }
        });




    }
}