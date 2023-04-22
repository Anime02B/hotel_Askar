package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VipMenu extends Container{
    public VipMenu(){
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Вы открыли меню клиента Vip");
        label.setBounds(140, 50, 220, 20);
        add(label);

        JButton vipCleaningButton = new JButton("[1] Cleaning (0)");
        vipCleaningButton.setBounds(100,100,250,20);
        add(vipCleaningButton);

        JButton vipFoodButton = new JButton("[2] Food (4000)");
        vipFoodButton.setBounds(100,140,250,20);
        add(vipFoodButton);

        JButton vipChefButton = new JButton("[3] Chef's food");
        vipChefButton.setBounds(100,180,250,20);
        add(vipChefButton);

        JButton vipCheckBalanceButton = new JButton("[4] Check balance");
        vipCheckBalanceButton.setBounds(100,220,250,20);
        add(vipCheckBalanceButton);

        JButton exitButton = new JButton("[5] Exit");
        exitButton.setBounds(100,260,250,20);
        add(exitButton);

        vipCleaningButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Main.frame.vipMenu.setVisible(false);
                    Main.frame.vipCleaning.setVisible(true);

            }
        });

        vipFoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Client Cl : Main.listClients()) {
                    if (Cl.getLogin().equals(Main.frame.orderClient.log)) {
                        if (Cl.getBalance() >= 4000) {
                            Main.reduceMoney(Cl, 4000);
                            Main.frame.vipMenu.setVisible(false);
                            Main.frame.vipFood.setVisible(true);
                            break;
                        }
                    }
                }
            }
        });

        vipChefButton.addActionListener(new ActionListener() {   /////
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.vipChef.setVisible(true);
            }
        });

        vipCheckBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipCheckBalance.update();
                Main.frame.vipMenu.setVisible(false);
                Main.frame.vipCheckBalance.setVisible(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipMenu.setVisible(false);
                Main.frame.orderClient.setVisible(true);
            }
        });
    }
}
