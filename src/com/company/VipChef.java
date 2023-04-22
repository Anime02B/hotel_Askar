package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VipChef extends Container {
        public String[] type = {"In room (12000)", "In cafe (7000)"};

    public VipChef() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Выберите где вы будете кушать:");
        label.setBounds(100, 50, 350, 20);
        add(label);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(100, 100, 70, 20);
        add(typeLabel);

        JComboBox typeBox = new JComboBox(type);
        typeBox.setBounds(190,100,115,20);
        add(typeBox);

        JButton enterButton = new JButton("ENTER");
        enterButton.setBounds(100,150,300,20);
        add(enterButton);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = (String)typeBox.getSelectedItem();

                    for (Client Cl : Main.listClients()) {
                        if (Cl.getLogin().equals(Main.frame.orderClient.log)) {

                            if (b.equals("In room (12000)") && Cl.getBalance() >= 12000) {
                                Main.reduceMoney(Cl, 12000);
                                Main.frame.vipChef.setVisible(false);
                                Main.frame.inroom.setVisible(true);
                                break;
                            }
                            if (b.equals("In cafe (7000)") && Cl.getBalance() >= 7000) {
                                    Main.reduceMoney(Cl, 7000);
                                    Main.frame.vipChef.setVisible(false);
                                    Main.frame.inkafe.setVisible(true);
                                break;
                            }
                        }
                    }
                }
        });

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(100,200,300,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipChef.setVisible(false);
                Main.frame.vipMenu.setVisible(true);
            }
        });
    }
}