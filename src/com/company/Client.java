package com.company;

import java.io.Serializable;

public interface Client extends Serializable {
    void OrderFood();
    void OrderClean();
    int getBalance();
    void setBalance(int money);
    String Info();
    int getCountOfVisits();

    boolean isInHotel() ;

    void setInHotel(boolean inHotel);
    void changeCountOfVisits();

    String getLogin();

    void ChefFood(boolean a);

    String getName();

    int getAge();

    boolean getInHotel();
}
