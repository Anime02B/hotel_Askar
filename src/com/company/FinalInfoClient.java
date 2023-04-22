package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FinalInfoClient extends Container { // ЕЩЕ НУЖНО ПОРАБОТАТЬ
    JTextArea area = new JTextArea();

    public FinalInfoClient() {
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel("Информация про клиента:");
        label.setBounds(140, 50, 350, 20);
        add(label);


        area.setSize(200,150);
        area.setLocation(120, 90);
        add(area);

            JButton exitButton = new JButton("EXIT");
            exitButton.setBounds(140, 330, 220, 20);
            add(exitButton);

            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Main.frame.finalInfoClient.setVisible(false);
                    Main.frame.managerMenu.setVisible(true);
                    area.setText("");
                }
            });



    }

    public void update() {
        ArrayList<Client> clients=Main.listClients();
        for (Client cl: clients){
            if(cl.getLogin().equals(InfoClient.login)){
                area.setText(cl.toString());
                break;
            }
        }
    }


}
