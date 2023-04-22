package com.company;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {


    public static MainMenu mainMenu;
    public static ManagerMenu managerMenu;
    public static AddClient addClient;
    public static ChangeClient changeClient;
    public static DeleteClient deleteClient;
    public static OrderClient orderClient;
    public static InfoClient infoClient;
    public static AddMoneyClient addMoneyClient;
    public static BankMoney bankMoney;

    public static AddOldClient addOldClient;
    public static AddNewClient addNewClient;

    public static AddBasicClient addBasicClient;
    public static AddVipClient addVipClient;

    public static FinalChange finalChange;
    public static FinalDelete finalDelete;
    public static FinalInfoClient finalInfoClient;
    public static FinalAddMoneyClient finalAddMoneyClient;

    public static BasicMenu basicMenu;
    public static BasicCleaning basicCleaning;
    public static BasicFood basicFood;
    public static BasicCheckBalance basicCheckBalance;

    public static VipMenu vipMenu;
    public static VipCleaning vipCleaning;
    public static VipFood vipFood;
    public static VipChef vipChef;
    public static VipCheckBalance vipCheckBalance;

    public static Inkafe inkafe;
    public static Inroom inroom;


    public MainFrame() {


        setSize(500, 500);
        setTitle("Hotel Project");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon background=new ImageIcon("C:\\Users\\user\\Desktop\\2 курс ДЗ\\ООП\\2.png");
        Image img=background.getImage();
        Image temp=img.getScaledInstance(500,500,Image.SCALE_SMOOTH);
        background=new ImageIcon(temp);
        JLabel back=new JLabel(background);
        back.setLayout(null);
        back.setBounds(0,0,500,500);


//
        ImageIcon icon =new ImageIcon("C:\\Users\\user\\Desktop\\2 курс ДЗ\\ООП\\2.png");


       //  ImageIcon icon = new ImageIcon("C:\\Users\\user\\Desktop\\2 курс ДЗ\\ООП\\i.png");
        Image imag=background.getImage();

        // Image image=imag.getScaledInstance(500,500,Image.SCALE_SMOOTH);
        setIconImage(imag);
//




        mainMenu = new MainMenu();
        mainMenu.setLocation(0,0);
        add(mainMenu);

        managerMenu = new ManagerMenu();
        managerMenu.setLocation(0,0);
        add(managerMenu);

        addClient = new AddClient();
        addClient.setLocation(0,0);
        add(addClient);

        changeClient = new ChangeClient();
        changeClient.setLocation(0,0);
        add(changeClient);

        deleteClient = new DeleteClient();
        deleteClient.setLocation(0,0);
        add(deleteClient);

        orderClient = new OrderClient();
        orderClient.setLocation(0,0);
        add(orderClient);

        infoClient = new InfoClient();
        infoClient.setLocation(0,0);
        add(infoClient);

        addMoneyClient = new AddMoneyClient();
        addMoneyClient.setLocation(0,0);
        add(addMoneyClient);

        bankMoney = new BankMoney();
        bankMoney.setLocation(0,0);
        add(bankMoney);





        addOldClient = new AddOldClient();
        addOldClient.setLocation(0,0);
        add(addOldClient);

        addNewClient = new AddNewClient();
        addNewClient.setLocation(0,0);
        add(addNewClient);





        addBasicClient = new AddBasicClient();
        addBasicClient.setLocation(0,0);
        add(addBasicClient);

        addVipClient = new AddVipClient();
        addVipClient.setLocation(0,0);
        add(addVipClient);






        finalChange = new FinalChange();
        finalChange.setLocation(0,0);
        add(finalChange);

        finalDelete = new FinalDelete();
        finalDelete.setLocation(0,0);
        add(finalDelete);

        finalInfoClient = new FinalInfoClient();
        finalInfoClient.setLocation(0,0);
        add(finalInfoClient);

        finalAddMoneyClient = new FinalAddMoneyClient();
        finalAddMoneyClient.setLocation(0,0);
        add(finalAddMoneyClient);



        basicMenu = new BasicMenu();
        basicMenu.setLocation(0,0);
        add(basicMenu);

        basicCleaning = new BasicCleaning();
        basicCleaning.setLocation(0,0);
        add(basicCleaning);

        basicFood = new BasicFood();
        basicFood.setLocation(0,0);
        add(basicFood);

        basicCheckBalance = new BasicCheckBalance();
        basicCheckBalance.setLocation(0,0);
        add(basicCheckBalance);


        vipMenu = new VipMenu();
        vipMenu.setLocation(0,0);
        add(vipMenu);

        vipFood = new VipFood();
        vipFood.setLocation(0,0);
        add(vipFood);

        vipChef = new VipChef();
        vipChef.setLocation(0,0);
        add(vipChef);

        vipCleaning = new VipCleaning();
        vipCleaning.setLocation(0,0);
        add(vipCleaning);

        vipCheckBalance = new VipCheckBalance();
        vipCheckBalance.setLocation(0,0);
        add(vipCheckBalance);



        inkafe = new Inkafe();
        inkafe.setLocation(0,0);
        add(inkafe);

        inroom = new Inroom();
        inroom.setLocation(0,0);
        add(inroom);

        add(back);

    }
}