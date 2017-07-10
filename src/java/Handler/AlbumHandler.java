/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handler;

import Control.AlbumControl;
import Model.Album;
import Model.Lyric;
import java.sql.SQLException;
import javax.naming.NamingException;

/**
 *
 * @author markh
 */
public class AlbumHandler {
    
    private static AlbumHandler ah;
    private AlbumControl ac;

    public AlbumHandler() {
        ac = AlbumControl.getInstance();
    }
    
    public static AlbumHandler getInstance(){
        if (ah == null) {
            ah = new AlbumHandler();
        }
        return ah;
    }
    
    public Album getAlbum(int albumid){
        return ac.getAlbum(albumid);
    }
    
    public Album[] getAllAlbum(){
        return ac.getAllAlbum();
    }
    
    public Album[] getAlbumContain(String contain){
        return ac.getAlbumcontain(contain);
    }
    
    public Lyric[] getLyricToAlbum(int id){
        return ac.getLyricToAlbum(id);
    }
    
}
