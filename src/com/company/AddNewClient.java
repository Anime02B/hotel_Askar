package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddNewClient extends Container {
    public String[] type = {"Basic", "VIP"};

    public AddNewClient() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Напишите данные про нового клиента:");
        label.setBounds(140, 50, 350, 20);
        add(label);

        JLabel loginLabel = new JLabel("Login:");
        loginLabel.setBounds(140, 90, 70, 20);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(230, 90, 70, 20);
        add(loginField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(140, 130, 70, 20);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(230, 130, 70, 20);
        add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(140, 170, 70, 20);
        add(ageLabel);

        JTextField ageField = new JTextField();
        ageField.setBounds(230, 170, 70, 20);
        add(ageField);

        JLabel balanceLabel = new JLabel("Balance:");
        balanceLabel.setBounds(140, 210, 70, 20);
        add(balanceLabel);

        JTextField balanceField = new JTextField();
        balanceField.setBounds(230, 210, 70, 20);
        add(balanceField);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(140, 250, 70, 20);
        add(typeLabel);

        JComboBox typeBox = new JComboBox(type);
        typeBox.setBounds(230,250,70,20);
        add(typeBox);

        JButton EnterInfoClientButton = new JButton("ENTER");
        EnterInfoClientButton.setBounds(140, 290, 220, 20);
        add(EnterInfoClientButton);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,330,220,20);
        add(exitButton);

        EnterInfoClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String log = loginField.getText();
                String name = nameField.getText();
                String sage = ageField.getText();
                String sbalance = balanceField.getText();
                String type = (String)typeBox.getSelectedItem();

                if (!log.isEmpty() && !name.isEmpty() && !sage.isEmpty() && !sbalance.isEmpty()) {

                    int age = Integer.parseInt(ageField.getText());
                    int balance = Integer.parseInt(balanceField.getText());

                    if (type.equals("Basic") && balance >= 5000) {
                        balance -= 5000;
                        BasicClient client = new BasicClient(log,name,age,balance,1);
                        Main.addClient(client);

                    }
                    else if (type.equals("VIP") && balance >= 8000) {
                        balance -= 8000;
                        VipClient client = new VipClient(log,name,age,balance,1);
                        Main.addClient(client);
                    }
                }

                loginField.setText("");
                nameField.setText("");
                ageField.setText("");
                balanceField.setText("");

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addNewClient.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
                loginField.setText("");
                nameField.setText("");
                ageField.setText("");
                balanceField.setText("");
            }
        });



    }
}
