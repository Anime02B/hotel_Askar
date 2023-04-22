package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBasicClient extends Container {
    public AddBasicClient() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Этот клиент зарегистрирован в нашем отеле как Basic клиент");
        label.setBounds(140, 50, 350, 20);
        add(label);

        JLabel label1 = new JLabel("Его номер отеля успешно оформлен на его имя и со счета сняли 5000 тг");
        label1.setBounds(140, 75, 350, 20);
        add(label1);

        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(140,115,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addBasicClient.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
            }
        });

    }
}
