package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalAddMoneyClient extends Container {
    public FinalAddMoneyClient() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Деньги успешно переведены на счет этого пользователя:");
        label.setBounds(140, 50, 350, 20);
        add(label);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,90,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.finalAddMoneyClient.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
            }
        });

        }
}
