package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inroom extends Container {
    public Inroom() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Вы заказали еду в вашем номере за 12000тг");
        label.setBounds(140, 50, 350, 20);
        add(label);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,100,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.inroom.setVisible(false);
                Main.frame.vipMenu.setVisible(true);
            }
        });

    }
}
