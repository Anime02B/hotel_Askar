package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChangeClient extends Container {
    public ChangeClient() {
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

        JButton EnterChangeClientButton = new JButton("ENTER");
        EnterChangeClientButton.setBounds(140, 130, 220, 20);
        add(EnterChangeClientButton);

        EnterChangeClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String log = loginField.getText();
                Client c = null;
                ArrayList<Client> clients=Main.listClients();
                for (Client cl : clients) {
                    if (cl.getLogin().equals(log)) {
                        c = cl;
                        Main.changeStatus(c);
                        //ServerThread.writeClients(clients);
                        Main.frame.changeClient.setVisible(false);
                        Main.frame.finalChange.setVisible(true);
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
                Main.frame.changeClient.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
                loginField.setText("");
            }
        });

    }
}
