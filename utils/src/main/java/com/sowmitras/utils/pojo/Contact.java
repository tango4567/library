package com.sowmitras.utils.pojo;

public class Contact {
    private String name;
    private String number;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return "Contact [ Name = " + this.name + ", Number = " + this.number + " ]";
    }
}
