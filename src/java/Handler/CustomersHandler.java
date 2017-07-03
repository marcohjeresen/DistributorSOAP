/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.CustomersControl;
import Model.Customers;

/**
 *
 * @author markh
 */
public class CustomersHandler {
    
    private static CustomersHandler ch;
    private CustomersControl cc;
    
    private CustomersHandler(){
        cc = CustomersControl.getInstance();
    }
    
    public static CustomersHandler getInstance(){
        if (ch == null){
            ch = new CustomersHandler();
        }
        return ch;
    }
    
    public Customers logon(String mail, String password){
        return cc.logon(mail, password);
    }
    
}
