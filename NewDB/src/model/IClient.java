package model;

import java.io.IOException;
import java.sql.SQLException;

public interface IClient {
    public  void queryAlbums();
    public void queryArtists();
    public void querySongs();
    public void queryAlbumsWithArtist() throws IOException;
    public void queryMetaData(String tableName);
    public void getCount(String tableName);
    public void createArtistView();
    public void queryArtistList();
    public void querySongInfo() throws IOException;
    public void insertArtist() throws SQLException, IOException ;
    public void insertAlbum() throws SQLException, IOException;
    public void insertSong() throws SQLException, IOException;
    public void querySongsWithArtist() throws IOException ;

}
