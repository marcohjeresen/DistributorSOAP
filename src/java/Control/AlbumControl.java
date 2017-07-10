/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Album;
import Model.Lyric;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author markh
 */
public class AlbumControl {

    private static AlbumControl ac;
    private ResultSet rs;
    private Connection con;
    private PreparedStatement stmt;

    private DataSource getDBCon() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/DBCon");

    }

    private AlbumControl() {
    }

    public static AlbumControl getInstance() {
        if (ac == null) {
            ac = new AlbumControl();
        }
        return ac;
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

    public Album getAlbum(int albumid) {
        Album album = null;
        try {
            setResult("call getalbum(" + albumid + ");");
            while (rs.next()) {
                album = new Album(rs.getString("al_title"), rs.getInt("al_id"));
            }
            closeCon();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        return album;
    }

    public Album[] getAllAlbum() {
        Album album = null;
        ArrayList<Album> albumList = new ArrayList<>();
        try {
            setResult("call getallalbum()");
            while (rs.next()) {
                album = new Album(rs.getString("al_title"), rs.getInt("al_id"));
                albumList.add(album);
            }
            closeCon();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        Album[] allAlbum = new Album[albumList.size()];

        for (int i = 0; i < allAlbum.length; i++) {
            allAlbum[i] = albumList.get(i);
        }
        return allAlbum;
    }

    public Album[] getAlbumcontain(String contain) {
        Album album = null;
        ArrayList<Album> albumList = new ArrayList<>();
        try {
            setResult("call getalbumcontains('%" + contain + "%')");
            while (rs.next()) {
                album = new Album(rs.getString("al_title"), rs.getInt("al_id"));
                albumList.add(album);
            }
            closeCon();
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        Album[] allAlbum = new Album[albumList.size()];

        for (int i = 0; i < allAlbum.length; i++) {
            allAlbum[i] = albumList.get(i);
        }
        return allAlbum;
    }

    public Lyric[] getLyricToAlbum(int id) {
        Lyric l = null;
        ArrayList<Lyric> lyricList = new ArrayList<>();
        try {
            setResult("call getlyrictoalbum(" + id + ")");
            while (rs.next()){
                l = new Lyric(rs.getInt("ly_id"), rs.getString("ly_title"), rs.getString("ly_text"));
                lyricList.add(l);
            }
        } catch (Exception e) {
            System.err.println(e.getLocalizedMessage());
        }
        Lyric[] lyricMatch = new Lyric[lyricList.size()];
        
        for (int i = 0; i < lyricMatch.length; i++) {
            lyricMatch[i] = lyricList.get(i);
            
        }
        return lyricMatch;
    }

}
