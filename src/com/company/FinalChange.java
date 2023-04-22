package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalChange extends Container {
    public FinalChange() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Отлично. Теперь у этого пользователя статус изменен");
        label.setBounds(50, 50, 350, 20);
        add(label);

        JLabel label1 = new JLabel("с Basic на VIP");
        label1.setBounds(50, 75, 350, 20);
        add(label1);


        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(50,115,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.finalChange.setVisible(false);
                Main.frame.changeClient.setVisible(true);
            }
        });

    }
}
