package com.company;

import java.io.Serializable;

public class VipClient implements  Serializable, Client {
    private String login;
    private String name;
    private int age;
    private int balance;
    private int countOfVisits;
    private boolean InHotel;

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean getInHotel() {
        return InHotel;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCountOfVisits(int countOfVisits) {
        this.countOfVisits = countOfVisits;
    }

    public boolean isInHotel() {
        return InHotel;
    }

    public void setInHotel(boolean inHotel) {
        InHotel = inHotel;
    }

    @Override
    public void OrderFood() {
        System.out.println("Ordering food for 4000tg for VIPs");
        balance=balance-4000;
    }

    @Override
    public void OrderClean() {
        System.out.println("Ordering cleaning for free for VIPs");
    }

    @Override
    public int getBalance() {
        return balance;
    }

    @Override
    public void setBalance(int money) {
        balance=money;
    }

    @Override
    public String toString() {
        return "VipClient{" + '\n' +
                "login= " + login + '\n' +
                "name= " + name + '\n' +
                "age= " + age + '\n' +
                "balance= " + balance + '\n' +
                "countOfVisits= " + countOfVisits +
                '}';
    }

    public VipClient(String login, String name, int age, int balance, int countOfVisits) {
        this.login=login;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.countOfVisits = countOfVisits;
        InHotel=true;
    }
    public VipClient(String login, String name, int age, int balance, int countOfVisits,boolean inHotel) {
        this.login=login;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.countOfVisits = countOfVisits;
        InHotel=inHotel;
    }
    @Override
    public String Info() {
        return "VipClient{" + '\n' +
                "login= " + login + '\n' +
                "name= " + name + '\n' +
                "age= " + age + '\n' +
                "balance= " + balance + '\n' +
                "countOfVisits=" + countOfVisits +
                '}';
    }

    @Override
    public int getCountOfVisits() {
        return countOfVisits;
    }

    @Override
    public void changeCountOfVisits() {
        this.countOfVisits+=1;
    }

    @Override
    public String getLogin() {
        return login;
    }

    public void ChefFood(boolean InRoom){
        if(InRoom && balance>=12000) {
            System.out.println("In room - 12000 tg");
            balance = balance - 12000;
        }

        else if(!InRoom && balance>=7000)
        {
            System.out.println("Chef's food - 7000 tg");
            balance=balance-7000;
        }
        else {
            System.out.println("Yod don't have money");
        }
    }
}
