package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMenu extends Container {
    public ManagerMenu(){
        setSize(500,500);
        setLayout(null);

        JButton addClientButton = new JButton("[1] Add client!");
        addClientButton.setBounds(100,100,250,20);
        add(addClientButton);

        JButton changeClientButton = new JButton("[2] Change client!");
        changeClientButton.setBounds(100,140,250,20);
        add(changeClientButton);

        JButton deleteClientButton = new JButton("[3] Delete client!");
        deleteClientButton.setBounds(100,180,250,20);
        add(deleteClientButton);

        JButton orderClientButton = new JButton("[4] Order for client!");
        orderClientButton.setBounds(100,220,250,20);
        add(orderClientButton);

        JButton infoClientButton = new JButton("[5] Info about client");
        infoClientButton.setBounds(100,260,250,20);
        add(infoClientButton);

        JButton addMoneyClientButton = new JButton("[6] Add money for client");
        addMoneyClientButton.setBounds(100,300,250,20);
        add(addMoneyClientButton);

        JButton bankMoneyButton = new JButton("[7] Show All Bank Money");
        bankMoneyButton.setBounds(100,340,250,20);
        add(bankMoneyButton);

        JButton exitButton = new JButton("[8] Exit");
        exitButton.setBounds(100,380,250,20);
        add(exitButton);


        addClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.managerMenu.setVisible(false);
                Main.frame.addClient.setVisible(true);
            }
        });

        changeClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.managerMenu.setVisible(false);
                Main.frame.changeClient.setVisible(true);
            }
        });

        deleteClientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.managerMenu.setVisible(false);
                Main.frame.deleteClient.setVisible(true);
            }
        });

       orderClientButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Main.frame.managerMenu.setVisible(false);
               Main.frame.orderClient.setVisible(true);

           }
       });

       infoClientButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Main.frame.managerMenu.setVisible(false);
               Main.frame.infoClient.setVisible(true);
           }
       });

       addMoneyClientButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Main.frame.managerMenu.setVisible(false);
               Main.frame.addMoneyClient.setVisible(true);
           }
       });

       bankMoneyButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               Main.frame.bankMoney.update();
               Main.frame.managerMenu.setVisible(false);
               Main.frame.bankMoney.setVisible(true);
           }
       });


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.managerMenu.setVisible(false);
                Main.frame.mainMenu.setVisible(true);
            }
        });




    }
}
