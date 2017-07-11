/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import Handler.AlbumHandler;
import MailService.SendMail;
import Model.Album;
import Model.Lyric;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.naming.NamingException;

/**
 *
 * @author markh
 */
@WebService(serviceName = "GetInfo")
@Stateless()
public class GetInfo {
    private AlbumHandler ah = AlbumHandler.getInstance();


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAlbum")
    public String getAlbum(@WebParam(name = "parameter") int parameter) {
        Album album = null;
        album = ah.getAlbum(parameter);
        return album.toString();
        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAlbumById")
    public Album getAlbumById(@WebParam(name = "parameter") int parameter) {
        Album album = null;
        album = ah.getAlbum(parameter);
        return album;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllAlbum")
    public Album[] getAllAlbum() {
        return ah.getAllAlbum();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAlbumContain")
    public Album[] getAlbumContain(@WebParam(name = "contain") String contain) {
        return ah.getAlbumContain(contain);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLyricToAlbum")
    public Lyric[] getLyricToAlbum(@WebParam(name = "albumId") int albumId) {
        //TODO write your implementation code here:
        return ah.getLyricToAlbum(albumId);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "sendMail")
    public String sendMail(@WebParam(name = "Mailaddres") String Mailaddres) {
        String response = "Mail sent to"+Mailaddres;
        try{
            SendMail mail = new SendMail(Mailaddres,"prøve");
        } catch (MessagingException ex) {
            response = "mail fail";
            Logger.getLogger(GetInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return response;
    }


}
