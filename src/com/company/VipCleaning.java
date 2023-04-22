package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VipCleaning extends Container {
    public VipCleaning() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Вы заказали бесплатный Cleaning,");
        label.setBounds(140, 50, 220, 20);
        add(label);

        JLabel label1 = new JLabel(" так как вы наш Vip клиент");
        label1.setBounds(140, 80, 220, 20);
        add(label1);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,130,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.vipCleaning.setVisible(false);
                Main.frame.vipMenu.setVisible(true);
            }
        });
    }
}
