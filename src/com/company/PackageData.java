package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    public String operationType;
    public Client cl;
    public ArrayList<Client> clients;
    public int money;


    public void setCl(Client cl) {
        this.cl = cl;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public PackageData(Client cli) {
        cl = cli;
    }

    public PackageData(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public PackageData() {

    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String message) {
        this.operationType = message;
    }

    public Client getCl() {
        return cl;
    }

    public void setClient(Client client) {
        cl = client;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
}
