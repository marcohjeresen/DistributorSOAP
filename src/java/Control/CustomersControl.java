/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author markh
 */
public class CustomersControl {

    private static CustomersControl cc;
    private ResultSet rs;
    private Connection con;
    private PreparedStatement stmt;

    private DataSource getDBCon() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/DBCon");
    }

    private CustomersControl() {
    }

    public static CustomersControl getInstance() {
        if (cc == null) {
            cc = new CustomersControl();
        }
        return cc;
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

    public Customers logon(String mail, String password) {
        Customers c = null;
        try {
            setResult("call logon('" + mail + "','" + password + "');");
            while (rs.next()) {
                c = new Customers(rs.getInt("cu_cvrnumber"), rs.getString("cu_name"), rs.getString("cu_storechain"), rs.getString("cu_street"), rs.getInt("cu_tlf"), rs.getString("cu_mail"), rs.getString("cu_password"));
            }
            closeCon();
        } catch (Exception e) {
            c = null;
        }
        return c;
    }
}
