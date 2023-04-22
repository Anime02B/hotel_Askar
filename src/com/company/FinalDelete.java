package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinalDelete extends Container {
    public FinalDelete() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Этот клиент только что, покинул наш отель");
        label.setBounds(50, 50, 350, 20);
        add(label);


        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(50,90,220,20);
        add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.finalDelete.setVisible(false);
                Main.frame.managerMenu.setVisible(true);
            }
        });


    }
}
