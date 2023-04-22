package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrderClient extends Container {
    public static String log;
    public OrderClient() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("WRITE THE CLIENT'S LOGIN");
        label.setBounds(140, 50, 350, 20);
        add(label);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(140, 90, 70, 20);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(230, 90, 70, 20);
        add(loginField);

        JButton EnterOrderClientButton = new JButton("ENTER");
        EnterOrderClientButton.setBounds(140, 130, 220, 20);
        add(EnterOrderClientButton);

        EnterOrderClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                log = loginField.getText();

                for (Client Cl : Main.listClients()) {
                    if (Cl.getLogin().equals(log)) {
                        if (Cl instanceof BasicClient && Cl.getInHotel()) {
                            Main.frame.orderClient.setVisible(false);
                            Main.frame.basicMenu.setVisible(true);
                            loginField.setText("");
                        }
                        if (Cl instanceof VipClient && Cl.getInHotel()) {
                            Main.frame.orderClient.setVisible(false);
                            Main.frame.vipMenu.setVisible(true);
                            loginField.setText("");
                        }
                    }
                }

            }
        });


        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,170,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // НУЖНО ДОРАБОТАТЬ
                        Main.frame.orderClient.setVisible(false);
                        Main.frame.managerMenu.setVisible(true);
                loginField.setText("");
            }
        });

    }
}
