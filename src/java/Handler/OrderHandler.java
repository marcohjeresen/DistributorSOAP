/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.OrderControl;
import Model.OrderLine;

/**
 *
 * @author markh
 */
public class OrderHandler {
    
    private static OrderHandler oh;
    private OrderControl oc;
    
    
    private OrderHandler(){
        oc = OrderControl.getInstance();
    }
    
    public static OrderHandler getInstance(){
        if (oh == null) {
            oh = new OrderHandler();
        }
        return oh;
    }
    
    public String createNewOrder(OrderLine orderLine){
        return oc.createNewOrder(orderLine);
    }
    
}
