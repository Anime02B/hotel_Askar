package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddClient extends Container {
    public AddClient(){
        setSize(500,500);
        setLayout(null);

        JLabel label = new JLabel("WRITE THE CLIENT'S LOGIN");
        label.setBounds(140, 50, 220, 20);
        add(label);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(140, 90, 70, 20);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(230, 90, 70, 20);
        add(loginField);

        JButton EnterAddClientButton = new JButton("ENTER");
        EnterAddClientButton.setBounds(140, 130, 220, 20);
        add(EnterAddClientButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,170,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addClient.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
                loginField.setText("");
            }
        });

        EnterAddClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String log = loginField.getText();
                boolean firstTime = true;
                int number_client = -1;
                ArrayList<Client> clients=Main.listClients();
                for (int i=0;i<clients.size();i++) {

                    if (clients.get(i).getLogin().equals(log)) {
                        number_client = i;
                        firstTime = false;
                        break;
                    }
                }

                    if (firstTime && !log.isEmpty()) {
                        Main.frame.addClient.setVisible(false);
                        Main.frame.addNewClient.setVisible(true);
                    }


                    else if (!firstTime && !clients.get(number_client).getInHotel() && clients.get(number_client).getBalance() >= 5000) {
                        Main.changeHotel(clients.get(number_client));
                        Main.frame.addClient.setVisible(false);
                        Main.frame.addOldClient.setVisible(true);
                    }

                loginField.setText("");

            }





        });

    }

}
