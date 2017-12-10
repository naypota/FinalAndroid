package com.example.user.finalandroid;

public class Money {
    public final int id;
    public final String type;
    public final int money;
    public String picture;


    public Money(int id, String picture,String type, int money ) {
        this.id = id;
        this.type = type;
        this.money = money;
    }

    public int getId() {
        return id;
    }
}

