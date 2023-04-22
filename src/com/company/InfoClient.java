package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InfoClient extends Container {
    public static String login;
    public InfoClient() {
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

        JButton EnterInfoClientButton = new JButton("ENTER");
        EnterInfoClientButton.setBounds(140, 130, 220, 20);
        add(EnterInfoClientButton);

        EnterInfoClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ArrayList<Client> clients=Main.listClients();
                login=loginField.getText();
                for (Client cl : clients) {
                    if (cl.getLogin().equals(login)) {

                        Main.frame.finalInfoClient.update();
                        Main.frame.infoClient.setVisible(false);
                        Main.frame.finalInfoClient.setVisible(true);
                        loginField.setText("");

                        break;
                    }
                }

            }
        });


        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,170,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.infoClient.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
                loginField.setText("");
            }
        });

    }
}