package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicMenu extends Container{
    public BasicMenu(){
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Вы открыли меню клиента Basic");
        label.setBounds(140, 50, 220, 20);
        add(label);

        JButton basicCleaningButton = new JButton("[1] Cleaning (2000)");
        basicCleaningButton.setBounds(100,100,250,20);
        add(basicCleaningButton);

        JButton basicFoodButton = new JButton("[2] Food (5000)");
        basicFoodButton.setBounds(100,140,250,20);
        add(basicFoodButton);

        JButton basicCheckBalanceButton = new JButton("[3] Check balance");
        basicCheckBalanceButton.setBounds(100,180,250,20);
        add(basicCheckBalanceButton);

        JButton exitButton = new JButton("[4] Exit");
        exitButton.setBounds(100,220,250,20);
        add(exitButton);

        basicCleaningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Client Cl : Main.listClients()) {
                    if (Cl.getLogin().equals(Main.frame.orderClient.log)) {
                        if (Cl.getBalance() >= 2000) {
                            Main.reduceMoney(Cl, 2000);
                            Main.frame.basicMenu.setVisible(false);
                            Main.frame.basicCleaning.setVisible(true);
                            break;
                        }
                    }
                }
            }
        });

        basicFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Client Cl : Main.listClients()) {
                    if (Cl.getLogin().equals(Main.frame.orderClient.log)) {
                        if (Cl.getBalance() >= 5000) {
                            Main.reduceMoney(Cl, 5000);
                            Main.frame.basicMenu.setVisible(false);
                            Main.frame.basicFood.setVisible(true);
                            break;
                        }
                    }
                }
            }
        });

        basicCheckBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.basicCheckBalance.update();
                    Main.frame.basicMenu.setVisible(false);
                    Main.frame.basicCheckBalance.setVisible(true);
            }
        });



        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.basicMenu.setVisible(false);
                Main.frame.orderClient.setVisible(true);
            }
        });
    }
}
