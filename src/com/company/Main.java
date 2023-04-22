package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class Main {
    public static Socket socket;
    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static MainFrame frame;
    public static int bank = ServerThread.readBank();


    public static void connectToServer(){
        try {

             socket = new Socket("127.0.0.1", 2003);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        }catch (Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        connectToServer();
        MainFrame frame = new MainFrame();
        frame.setVisible(true);




        frame.managerMenu.setVisible(false);
        Main.frame.addClient.setVisible(false);
        Main.frame.changeClient.setVisible(false);
        Main.frame.deleteClient.setVisible(false);
        Main.frame.orderClient.setVisible(false);
        Main.frame.infoClient.setVisible(false);
        Main.frame.addMoneyClient.setVisible(false);
        Main.frame.bankMoney.setVisible(false);

        Main.frame.addOldClient.setVisible(false);
        Main.frame.addNewClient.setVisible(false);

        Main.frame.addBasicClient.setVisible(false);
        Main.frame.addVipClient.setVisible(false);

        Main.frame.finalChange.setVisible(false);
        Main.frame.finalDelete.setVisible(false);
        Main.frame.finalInfoClient.setVisible(false);
        Main.frame.finalAddMoneyClient.setVisible(false);

        Main.frame.basicMenu.setVisible(false);
        Main.frame.basicCleaning.setVisible(false);
        Main.frame.basicFood.setVisible(false);
        Main.frame.basicCheckBalance.setVisible(false);

        Main.frame.vipMenu.setVisible(false);
        Main.frame.vipCleaning.setVisible(false);
        Main.frame.vipFood.setVisible(false);
        Main.frame.vipChef.setVisible(false);
        Main.frame.vipCheckBalance.setVisible(false);

        Main.frame.inkafe.setVisible(false);
        Main.frame.inroom.setVisible(false);


        // System.out.println(Main.clients.size());







/*
   //    ArrayList<Client> clients =ServerThread.readClients();


        int bank=0;
        ServerThread.writeBank(bank);

        clients.add(new BasicClient("Askar1k","Askar",25,120000,1));

        clients.add(new BasicClient("BEKAZAVR","Bekzat",19,70000,0));

        clients.add(new BasicClient("Aldanysheva","Aruzhan",22,100000,1));
        ServerThread.writeClients(clients);
*/


// /*
       
    }
    public static void addClient(Client client){
        PackageData pd=new PackageData(client);
        pd.setOperationType("Add client");
        try {
            outputStream.writeObject(pd);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public static ArrayList<Client> listClients(){
        ArrayList<Client> clients=new ArrayList<>();
        PackageData pd=new PackageData();
        pd.setOperationType("List client");

        pd.setClients(clients);
        try {
            outputStream.writeObject(pd);
            if((pd = (PackageData) inputStream.readObject())!=null){
                clients=pd.getClients();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return clients;
    }


    public static void deleteClient(Client client) {
        PackageData pd=new PackageData();
        pd.setClient(client);
        pd.setOperationType("Delete client");
        try {
            outputStream.writeObject(pd);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void changeHotel(Client cl) {
        PackageData pd=new PackageData();
        pd.setClient(cl);
        pd.setOperationType("Change hotel");
        try {
            outputStream.writeObject(pd);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static void changeStatus(Client c) {
        PackageData pd=new PackageData();
        pd.setClient(c);
        pd.setOperationType("Change status");
        try {
            outputStream.writeObject(pd);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void addMoney(Client cl,int mon) {
        PackageData pd=new PackageData();
        pd.setClient(cl);
        pd.setMoney(mon);
        pd.setOperationType("Add money");
        try {
            outputStream.writeObject(pd);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static void reduceMoney(Client cl,int mon) {
        PackageData pd=new PackageData();
        pd.setClient(cl);
        pd.setMoney(mon);
        pd.setOperationType("Reduce money");
        try {
            outputStream.writeObject(pd);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
