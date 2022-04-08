package com.example.damiansshop;

public class User {

    public String name, email, address, card, password;

    public User(String mname, String memail, String maddress, String mcard, String mpassword)
    {
        this.name = mname;
        this.email = memail;
        this.address = maddress;
        this.card = mcard;
        this.password = mpassword;
    }
}
