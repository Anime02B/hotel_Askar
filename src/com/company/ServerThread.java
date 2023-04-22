package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServerThread extends Thread{
    public static Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;
   public static Connection connection;
    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection=connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void run() {
        try {

            PackageData pd=null;
            while ((pd= (PackageData) inputStream.readObject())!=null) {

                if(pd.getOperationType().equals("Add client")){
                        AddClient(pd.cl);
                        int bank = readBank();
                        if(pd.cl instanceof BasicClient) {
                            bank += pd.cl.getBalance() + 5000;
                        }
                        if(pd.cl instanceof VipClient) {
                            bank += pd.cl.getBalance() + 8000;
                        }
                        writeBank(bank);

                }
                else if(pd.getOperationType().equals("Delete client")){
                        DeleteClient(pd.cl);
                }
                else if(pd.getOperationType().equals("List client")){
                    ArrayList<Client> clients=getAllClients();
                    PackageData pd2=new PackageData();
                    pd2.setClients(clients);
                    outputStream.writeObject(pd2);
                }
                else if(pd.getOperationType().equals("Change hotel")){
                   ChangeHotel(pd.getCl());
                }
                else if(pd.getOperationType().equals("Change status")){
                    ChangeStatus(pd.getCl());
                }
                else if(pd.getOperationType().equals("Add money")){
                    AddMoney(pd.getCl(),pd.getMoney());
                    int bank = readBank();
                    writeBank(bank + pd.getMoney());
                }
                else if(pd.getOperationType().equals("Reduce money")){
                    ReduceMoney(pd.getCl(),pd.getMoney());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    public static int readBank() {
        int bank=0;
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("bank.data"));
            bank= (int)inputStream.readObject();
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return bank;

    }
    public static void writeBank(int bank) {
        try{
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("bank.data"));
            outStream.writeObject(bank);
            outStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void AddClient(Client client){
        PreparedStatement st = null;

        try {
            st = connection.prepareStatement("insert into hotel.clients(login,name,age,balance,countOfVisits,inHotel,isVip) values(?,?,?,?,?,?,?)");

            st.setString(1, client.getLogin());
            st.setString(2, client.getName());
            st.setInt(3, client.getAge());
            st.setInt(4, client.getBalance());
            st.setInt(5, client.getCountOfVisits());
            st.setBoolean(6, client.getInHotel());
            st.setBoolean(7,(client instanceof VipClient));

            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<Client> getAllClients() {
        ArrayList<Client> clients=new ArrayList<>();
        try{
            PreparedStatement st=connection.prepareStatement("select * from hotel.clients");
            ResultSet res=st.executeQuery();
            while(res.next()) {
                String login=res.getString("login");
                String name=res.getString("name");
                int age=res.getInt("age");
                int balance=res.getInt("balance");
                int count=res.getInt("countOfVisits");
                boolean inHotel=res.getBoolean("inHotel");
                boolean isVip=res.getBoolean("isVip");
                if(isVip){
                    clients.add(new VipClient(login,name,age,balance,count,inHotel));
                }
                else{
                    clients.add(new BasicClient(login,name,age,balance,count,inHotel));
                }
            }
            st.close();

        }catch(Exception e){
            e.printStackTrace();
        }
        return clients;
    }


    public static void DeleteClient(Client client) {
            try{

                PreparedStatement st = connection.prepareStatement("update hotel.clients set inHotel=false WHERE login = ?");
                st.setString(1, client.getLogin());

                st.executeUpdate();
                st.close();
            }catch (Exception e){
                e.printStackTrace();
            }

    }
    private void ChangeHotel(Client cl) {
        try{

            PreparedStatement st = connection.prepareStatement("update hotel.clients set inHotel=true, countOfVisits=countOfVisits+1, balance=balance-5000 WHERE login = ?");

            st.setString(1, cl.getLogin());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void ChangeStatus(Client cl) {
        try{

            PreparedStatement st = connection.prepareStatement("update hotel.clients set isVip=true WHERE login = ?");

            st.setString(1, cl.getLogin());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void AddMoney(Client cl, int money) {
        try{

            PreparedStatement st = connection.prepareStatement("update hotel.clients set balance=balance+? WHERE login = ?");
            st.setInt(1,money);
            st.setString(2, cl.getLogin());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void ReduceMoney(Client cl, int money) {
        try{

            PreparedStatement st = connection.prepareStatement("update hotel.clients set balance=balance-? WHERE login = ?");
            st.setInt(1,money);
            st.setString(2, cl.getLogin());
            st.executeUpdate();
            st.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
