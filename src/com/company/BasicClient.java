package com.company;

import java.io.Serializable;

public class BasicClient implements Client, Serializable {
    private String login;
    private String name;
    private int age;
    private int balance;
    private int countOfVisits;
    private boolean InHotel;

    public boolean isInHotel() {
        return InHotel;
    }

    public void setInHotel(boolean inHotel) {
        InHotel = inHotel;
    }
    public String getLogin() {
        return login;
    }

    @Override
    public void ChefFood(boolean a) {
        System.out.println("BASIC CAN NOT ORDER CHEF'S FOOD" );
    }

    @Override
    public String toString() {
        return "BasicClient{" + '\n' +
                "login= " + login + '\n' +
                "name= " + name + '\n' +
                "age= " + age + '\n' +
                "balance= " + balance + '\n' +
                "countOfVisits= " + countOfVisits +
                '}';
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public BasicClient(String login, String name, int age, int balance, int countOfVisits) {
        this.login=login;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.countOfVisits = countOfVisits;
        InHotel=true;
    }
    public BasicClient(String login, String name, int age, int balance, int countOfVisits,boolean inHotel) {
        this.login=login;
        this.name = name;
        this.age = age;
        this.balance = balance;
        this.countOfVisits = countOfVisits;
        InHotel=inHotel;
    }

    public int getCountOfVisits() {
        return countOfVisits;
    }


    public void setCountOfVisits(int countOfVisits) {
        this.countOfVisits = countOfVisits;
    }

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
        return isInHotel();
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void OrderFood() {
        System.out.println("Ordering food for 5000tg for basic");
        balance=balance-5000;
    }

    @Override
    public void OrderClean() {
        System.out.println("Ordering cleaning for 2000tg for basic");
        balance=balance-2000;
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
    public String Info() {
        return "BasicClient{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", balance=" + balance +
                ", countOfVisits=" + countOfVisits +
                ",inhotel= "+InHotel +'}';
    }
    @Override
    public void changeCountOfVisits() {
        this.countOfVisits+=1;
    }
}
