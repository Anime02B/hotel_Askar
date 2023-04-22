package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankMoney extends Container {
    JTextArea textAreaL = new JTextArea();
    public BankMoney() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Информация про бюджет банка");
        label.setBounds(140, 50, 350, 20);
        add(label);

        JLabel loginLabel = new JLabel("Bank:");
        loginLabel.setBounds(140, 90, 70, 20);
        add(loginLabel);


        textAreaL.setBounds(180, 92, 110, 20);
        textAreaL.setText(String.valueOf(Main.bank) + " тенге");
        add(textAreaL);
        textAreaL.setEditable(true);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,130,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.bankMoney.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
                textAreaL.setText("");
            }

        });


    }

    public void update() {
        int bank = ServerThread.readBank();
        textAreaL.setText(String.valueOf(bank) + " тенге");
    }
}