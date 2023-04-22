package com.company;


public class Manager {
    private static String login="0"; // "MyLogin";
    private static String pinCode= "0"; //"MyPinCode";
    public static String getLogin() {
        return login;
    }

    public static String getPinCode() {
        return pinCode;
    }


    public static Client ChangeClient(Client client){
        Client tmp=null;
        if (client instanceof BasicClient) {
            if(((BasicClient) client).getCountOfVisits()>3){
                String login= ((BasicClient) client).getLogin();
                String name= ((BasicClient) client).getName();
                int age=((BasicClient) client).getAge();
                int balance=client.getBalance();
                int count=((BasicClient) client).getCountOfVisits();
                tmp=new VipClient(login,name,age,balance,count);
                System.out.println("CONGRATS!!!! You have now acquired VIP status!!!!");
                return tmp;
            }
            else{
                System.out.println("no more than 3");
            }
        }
        return client;
    }
    public static void info(Client cl){
        System.out.println(cl.Info());
    }

}
