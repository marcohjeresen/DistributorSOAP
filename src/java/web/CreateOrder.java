/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Handler.OrderHandler;
import Model.AlbumToOrder;
import Model.OrderLine;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author markh
 */
@WebService(serviceName = "CreateOrder")
public class CreateOrder {
    private OrderHandler oh = OrderHandler.getInstance();



    /**
     * Web service operation
     */
    @WebMethod(operationName = "createNewOrder")
    public String createNewOrder(@WebParam(name = "orderLine") OrderLine orderLine, @WebParam(name = "albumToOrder") Model.AlbumToOrder[] albumToOrder) {
        OrderLine ol = orderLine;
        ArrayList<AlbumToOrder> alList = new ArrayList<>();
        for (int i = 0; i < albumToOrder.length; i++) {
            AlbumToOrder albumToOrder1 = albumToOrder[i];
            alList.add(albumToOrder1);
        }
        ol.setAlbumList(alList);
        
        return oh.createNewOrder(orderLine);
    }

}
