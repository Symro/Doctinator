package com.doctinator.doctinator.models;

public class CallList {
    public String name, description;
    public int phone;

    public CallList(String name, String description, int phone){

        this.name = name;
        this.description = description;
        this.phone = phone;

    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public int getPhone(){
        return phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
}
