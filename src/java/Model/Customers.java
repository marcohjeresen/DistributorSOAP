/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author markh
 */
public class Customers {
    
    private int cvrNumber;
    private String name;
    private String storeChain;
    private String street;
    private int phone;
    private String mail;
    private String Password;

    public Customers(int cvrNumber, String name, String storeChain, String street, int phone, String mail, String Password) {
        this.cvrNumber = cvrNumber;
        this.name = name;
        this.storeChain = storeChain;
        this.street = street;
        this.phone = phone;
        this.mail = mail;
        this.Password = Password;
    }

    public int getCvrNumber() {
        return cvrNumber;
    }

    public void setCvrNumber(int cvrNumber) {
        this.cvrNumber = cvrNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStoreChain() {
        return storeChain;
    }

    public void setStoreChain(String storeChain) {
        this.storeChain = storeChain;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Customers{" + "cvrNumber=" + cvrNumber + ", name=" + name + ", storeChain=" + storeChain + ", street=" + street + ", phone=" + phone + '}';
    }
    
    
    
}
