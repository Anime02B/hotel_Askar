package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VipCheckBalance extends Container {
    JTextArea area = new JTextArea();
    public VipCheckBalance() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Информация про ваш баланс:");
        label.setBounds(100, 50, 350, 20);
        add(label);

        area.setSize(100,20);
        area.setLocation(300, 50);
        add(area);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(100,100,300,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipCheckBalance.setVisible(false);
                Main.frame.vipMenu.setVisible(true);
                area.setText("");
            }
        });
    }
    public void update(){
        for (Client Cl : Main.listClients()) {
            if (Cl.getLogin().equals(Main.frame.orderClient.log)) {
                area.setText(String.valueOf(Cl.getBalance() + " тенге"));
                break;
            }
        }
    }
}