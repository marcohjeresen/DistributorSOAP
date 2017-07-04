/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.AlbumToOrder;
import Model.Customers;
import Model.OrderLine;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author markh
 */
public class OrderControl {
    
    private static OrderControl oc;
    private Customers customers;
    private AlbumToOrder albumToOrder;
    private OrderLine orderLine;
    private ResultSet rs;
    private Connection con;
    private PreparedStatement stmt;
    
    private DataSource getDBCon() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/DBCon");
    }
    
    private OrderControl() {
    }
    
    public static OrderControl getInstance() {
        if (oc == null) {
            oc = new OrderControl();
        }
        return oc;
    }
    
    public void setResult(String sql) throws NamingException, SQLException {
        con = getDBCon().getConnection();
        stmt = con.prepareStatement(sql);
        rs = stmt.executeQuery();
    }
    
    public void closeCon() throws SQLException {
        rs.close();
        con.close();
    }
    
    public String createNewOrder(OrderLine order) {
        int orderId = 0;
        try {
            setResult("call createneworder('" + order.getDate() + "'," + order.getCustomers().getCvrNumber() + "," + order.getTotalPrice() + ");");
            while (rs.next()) {
                orderId = rs.getInt("nextid");
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return addAlbumToOrder(orderId, order.getAlbumList());
    }
    
    public String addAlbumToOrder(int orderid, ArrayList<AlbumToOrder> toOrdersList) {
        String conformation = "New order createt";
        for (AlbumToOrder toOrd : toOrdersList) {
            try {
                setResult("call addalbumtoorder(" + toOrd.getAlbum().getId() + ","+orderid+","+toOrd.getAmount()+","+toOrd.getPrice()+");");
            } catch (Exception e) {
                conformation = "something went roung";
                System.err.println(e.getLocalizedMessage());
            }
        }
        return conformation;
    }
    
}
