/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Handler.CustomersHandler;
import Model.Customers;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author markh
 */
@WebService(serviceName = "Logon")
@Stateless
public class Logon {
    private CustomersHandler ch = CustomersHandler.getInstance();


    /**
     * Web service operation
     */
    @WebMethod(operationName = "CheckLogon")
    public Customers CheckLogon(@WebParam(name = "Username") String Username, @WebParam(name = "Password") String Password) {
        return ch.logon(Username, Password);
    }

}
