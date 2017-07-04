/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author markh
 */
public class OrderLine {
    
    private int id;
    private Date date;
    private Customers customers;
    private int totalPrice;
    private boolean orderEnd;
    private ArrayList<AlbumToOrder> albumToOrdersList;

    public OrderLine(int id, Date date, Customers customers, int totalPrice, boolean orderEnd) {
        this.id = id;
        this.date = date;
        this.customers = customers;
        this.totalPrice = totalPrice;
        this.orderEnd = orderEnd;
        albumToOrdersList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isOrderEnd() {
        return orderEnd;
    }

    public void setOrderEnd(boolean orderEnd) {
        this.orderEnd = orderEnd;
    }

    public ArrayList<AlbumToOrder> getAlbumList() {
        return albumToOrdersList;
    }

    public void setAlbumList(ArrayList<AlbumToOrder> albumList) {
        this.albumToOrdersList = albumList;
    }
    
    public int getAlbumAmount(){
        int amount = 0;
        for (AlbumToOrder albumList1 : albumToOrdersList) {
            amount = amount + albumList1.getAmount();
        }
        return amount;
    }
    
    
    
}
