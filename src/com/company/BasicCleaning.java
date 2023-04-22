package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicCleaning extends Container {
    public BasicCleaning() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Вы заказали Cleaning за 2000 тг");
        label.setBounds(140, 50, 220, 20);
        add(label);


        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,100,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.basicCleaning.setVisible(false);
                Main.frame.basicMenu.setVisible(true);
            }
        });
    }
}
