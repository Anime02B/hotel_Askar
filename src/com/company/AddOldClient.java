package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddOldClient extends Container {
    public AddOldClient() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Ваши данные у нас в базе есть. Ваш номер отеля успешно");
        label.setBounds(50, 150, 400, 20);
        add(label);

        JLabel label1 = new JLabel("оформлен на ваше имя и с вашего счета сняли 5000 тг");
        label1.setBounds(50, 175, 400, 20);
        add(label1);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,215,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addOldClient.setVisible(false);
                Main.frame.addClient.setVisible(true);
            }
        });

    }
}
