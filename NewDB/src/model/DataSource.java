package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSetMetaData;

public class DataSource {
    private static final String DB_NAME = "practice";
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/"+DB_NAME;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "ROOT";
    private Connection conn;


    public static final String TABLE_ALBUMS = "albums";
    public static final String ALBUM_ID = "_id";
    public static final String ALBUM_NAME = "name";
    public static final String ALBUM_ARTIST = "artist";
    public static final String QUERY_ALBUMS_TABLE = "select * from "+TABLE_ALBUMS;

    public static final String TABLE_ARTISTS = "artists";
    public static final String ARTIST_ID = "_id";
    public static final String ARTIST_NAME = "name";
    public static final String QUERY_ARTISTS_TABLE = "select * from "+TABLE_ARTISTS;

    public static final String TABLE_SONGS = "songs";
    public static final String SONG_ID = "_id";
    public static final String SONG_TRACK = "track";
    public static final String SONG_TITLE = "title";
    public static final String SONG_ALBUM = "album";
    public static final String QUERY_SONGS_TABLE = "select * from "+TABLE_SONGS;

    //QURIES
    public static final String QUERY_ALBUMS_WITH_ARTISTNAME = "SELECT "+TABLE_ALBUMS+"."+ALBUM_NAME+
            " FROM "+TABLE_ALBUMS+" INNER JOIN "+TABLE_ARTISTS+" ON " +TABLE_ALBUMS+"."+ALBUM_ARTIST+" = " +TABLE_ARTISTS+"."+ARTIST_ID +
            " WHERE "+TABLE_ARTISTS+"."+ARTIST_NAME+" = ";
    // create artist_list as view
    public static final String TABLE_ARTIST_VIEW = "artist_list";
    public static final String CREATE_TABLE_FOR_SONG_VIEW = "create view " +
            TABLE_ARTIST_VIEW+" as select "+TABLE_ARTISTS+"."+ARTIST_NAME+" AS artist, "+
            TABLE_ALBUMS+"."+ALBUM_NAME+" as album, "+TABLE_SONGS+"."+SONG_TRACK+", "+
            TABLE_SONGS+"."+SONG_TITLE+" from "+TABLE_SONGS+
            " inner join "+TABLE_ALBUMS+" ON "+TABLE_SONGS+"."+SONG_ALBUM+" = "+TABLE_ALBUMS+"."+ALBUM_ID+
            " inner join "+TABLE_ARTISTS+" ON "+TABLE_ALBUMS+"."+ALBUM_ARTIST+" = "+TABLE_ARTISTS+"."+ARTIST_ID+
            " ORDER BY "+TABLE_ARTISTS+"."+ALBUM_NAME+", "+TABLE_ALBUMS+"."+ALBUM_NAME+", "+TABLE_SONGS+"."+SONG_TRACK;
    // query ArtistList View
    public static final String QUERY_ARTISTLIST_VIEW = "select * from "+TABLE_ARTIST_VIEW;
    // query song info
    public static final String QUERY_SONG_INFO = "select artist, album,"+SONG_TRACK+" from "+TABLE_ARTIST_VIEW+" WHERE " +
            SONG_TITLE+" = ?";
    // query artist
    public static final String QUERY_ARTIST = "select "+ARTIST_ID+" FROM "+TABLE_ARTISTS+" where "+ARTIST_NAME+" = ?";
    public static final String INSERT_ARTIST = "insert into "+TABLE_ARTISTS+"("+ARTIST_NAME+") values(?)";
    // query album
    public static final String QUERY_ALBUM = "select "+ALBUM_ID+" from "+TABLE_ALBUMS+" where "+ALBUM_NAME+" = ?";
    public static final String INSERT_ALBUM = "insert into "+TABLE_ALBUMS+"("+ALBUM_NAME+", "+ALBUM_ARTIST+") values(?, ?)";
    // query song
    public static final String QUERY_SONG = "select "+SONG_ID+" from "+TABLE_SONGS+" where "+SONG_TITLE+" = ?";
    public static final String INSERT_SONG = "insert into "+TABLE_SONGS+" ("+SONG_TRACK+", "+SONG_TITLE+", "+SONG_ALBUM+") values(?, ?, ?)";
    // query songs with artist name
    //SELECT songs._id, songs.track, songs.title,songs.album FROM practice.songs inner join albums on songs.album = albums._id inner join artists on albums.artist = artists._id where artists.name = 'Yo Yo Honey Singh';
    public static final String QUERY_SONGS_WITH_ARTIST = "select "+TABLE_SONGS+"."+SONG_ID+", "+ TABLE_SONGS+"."+SONG_TRACK+", "+TABLE_SONGS+"."+SONG_TITLE+", "+TABLE_SONGS+"."+SONG_ALBUM+
            " from "+TABLE_SONGS+" INNER JOIN "+TABLE_ALBUMS+" ON "+TABLE_SONGS+"."+SONG_ALBUM+" = "+TABLE_ALBUMS+"."+ALBUM_ID+
            " INNER JOIN "+TABLE_ARTISTS+" ON "+TABLE_ALBUMS+"."+ALBUM_ARTIST+" = "+TABLE_ARTISTS+"."+ARTIST_ID+
            " WHERE "+TABLE_ARTISTS+"."+ARTIST_NAME+" = ?";

//
    private PreparedStatement querySongInfo;

    private PreparedStatement queryArtist;
    private PreparedStatement insertIntoArtist;

    private PreparedStatement queryAlbum;
    private PreparedStatement insertIntoAlbum;

    private PreparedStatement querySong;
    private PreparedStatement insertIntoSong;

    private PreparedStatement querySongWithArtist;

    public boolean open(){
        try{
            conn = DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
            System.out.println("Connected to Database");

            querySongInfo = conn.prepareStatement(QUERY_SONG_INFO);

            queryArtist = conn.prepareStatement(QUERY_ARTIST);
            insertIntoArtist = conn.prepareStatement(INSERT_ARTIST,Statement.RETURN_GENERATED_KEYS);

            queryAlbum = conn.prepareStatement(QUERY_ALBUM);
            insertIntoAlbum = conn.prepareStatement(INSERT_ALBUM,Statement.RETURN_GENERATED_KEYS);

            querySong = conn.prepareStatement(QUERY_SONG);
            insertIntoSong = conn.prepareStatement(INSERT_SONG,Statement.RETURN_GENERATED_KEYS);

            querySongWithArtist = conn.prepareStatement(QUERY_SONGS_WITH_ARTIST);
            return true;
        }catch (SQLException e){
            System.out.println("Couldn't Connect to DataBase : "+e.getMessage());
            return false;
        }
    }

    public void close(){
        try{
            if(querySongInfo != null){
                querySongInfo.close();
            }
            if(queryArtist != null){
                queryArtist.close();
            }
            if(insertIntoArtist != null){
                insertIntoArtist.close();
            }
            if(queryAlbum != null){
                queryArtist.close();
            }
            if(insertIntoAlbum != null){
                insertIntoAlbum.close();
            }
            if(querySong != null){
                querySong.close();
            }
            if(insertIntoSong != null){
                insertIntoSong.close();
            }
            if(conn != null){
                conn.close();
                System.out.println("Closed Database");
            }
        }catch (SQLException e){
            System.out.println("Couldn't Close DataBase "+e.getMessage());
        }
    }

    public List<Album> queryAlbums(){

        try(PreparedStatement preparedStatement = conn.prepareStatement(QUERY_ALBUMS_TABLE);
            ResultSet resultSet = preparedStatement.executeQuery()){
//        try(Statement statement = conn.createStatement();
//            ResultSet resultSet = statement.executeQuery(QUERY_ALBUMS_TABLE)){

            List<Album> albums = new ArrayList<>();
            while (resultSet.next()){
                Album album = new Album();
                album.setId(resultSet.getInt(ALBUM_ID));
                album.setName(resultSet.getString(ALBUM_NAME));
                album.setArtist(resultSet.getInt(ALBUM_ARTIST));
                albums.add(album);
            }
            return albums;

        }catch (SQLException e){
            System.out.println("Query Failed : "+e.getMessage());
            return null;
        }

    }
    public List<Artist> queryArtists(){
        try(PreparedStatement preparedStatement = conn.prepareStatement(QUERY_ARTISTS_TABLE);
            ResultSet resultSet = preparedStatement.executeQuery()){
            List<Artist> artists = new ArrayList<>();
            while(resultSet.next()){
                Artist artist = new Artist();
                artist.setId(resultSet.getInt(ARTIST_ID));
                artist.setName(resultSet.getString(ARTIST_NAME));
                artists.add(artist);
            }
            return artists;

        }catch (SQLException e){
            System.out.println("Query Failed : "+e.getMessage());
            return null;
        }
    }

    public List<Song> querySongs(){
        try(PreparedStatement preparedStatement = conn.prepareStatement(QUERY_SONGS_TABLE);
            ResultSet resultSet = preparedStatement.executeQuery()){
            List<Song> songs = new ArrayList<>();
            while(resultSet.next()){
                Song song = new Song();
                song.setId(resultSet.getInt(1));
                song.setTrack(resultSet.getInt(2));
                song.setTitle(resultSet.getString(3));
                song.setAlbum(resultSet.getInt(4));
                songs.add(song);
            }
            return songs;

        }catch (SQLException e){
            System.out.println("Query Failed : "+e.getMessage());
            return null;
        }
    }

    public List<String> queryAlbumsWithArtist(String artistName){
        StringBuilder sb = new StringBuilder(QUERY_ALBUMS_WITH_ARTISTNAME);
        sb.append("\"");
        sb.append(artistName);
        sb.append("\"");
//        System.out.println("SQL Statement : "+sb.toString());
        try(PreparedStatement preparedStatement = conn.prepareStatement(sb.toString());
            ResultSet resultSet = preparedStatement.executeQuery()){
            List<String> albums = new ArrayList<>();
            while(resultSet.next()){
                albums.add(resultSet.getString(ALBUM_NAME));
            }
            return albums;

        }catch (SQLException e){
            System.out.println("Query Failed : "+e.getMessage());
            return null;
        }
    }

    public void queryMetaData(String tableName){
        String sql = "select * from "+tableName;

        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columnCount = resultSetMetaData.getColumnCount();
            for(int i=1;i<=columnCount;i++){
                System.out.format("Column %d in %s is named as %s\n",i,tableName,resultSetMetaData.getColumnName(i));
            }

        }
        catch (SQLException e){
            System.out.println("Query Faied : "+e.getMessage());
        }
    }

    public void getCount(String tableName){
        String sql = "select count(*) from "+tableName;
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()) {
            if(resultSet.next()){
                System.out.format("Count of Records in %s is %d\n",tableName,resultSet.getInt(1));
            }else{
                System.out.println("No Records Found in "+tableName);
            }

        }catch (SQLException e ){
            System.out.println("Query Failed : "+e.getMessage());

        }
    }

    public void create_view_artistList(){
        try{
            System.out.println("Sql Ststement : "+CREATE_TABLE_FOR_SONG_VIEW);
            PreparedStatement preparedStatement = conn.prepareStatement(CREATE_TABLE_FOR_SONG_VIEW);
            preparedStatement.execute();
            System.out.println(TABLE_ARTIST_VIEW+" Created... ");

        }catch (SQLException e){
            System.out.println("Creating View Failed : "+e.getMessage());
        }
    }
    public List<ArtistList> queryArtistList(){
        try(PreparedStatement preparedStatement = conn.prepareStatement(QUERY_ARTISTLIST_VIEW);
            ResultSet resultSet = preparedStatement.executeQuery()){
            List<ArtistList> artistLists = new ArrayList<>();
            while(resultSet.next()){
                ArtistList artistList = new ArtistList();
                artistList.setArtist(resultSet.getString(1));
                artistList.setAlbum(resultSet.getString(2));
                artistList.setTrack(resultSet.getInt(3));
                artistList.setTitle(resultSet.getString(4));
                artistLists.add(artistList);
            }
            return artistLists;

        }catch (SQLException e){
            System.out.println("Query Failed : "+e.getMessage());
            return null;
        }
    }

    public List<ArtistList> querySongInfo(String songName){
        try{
            querySongInfo.setString(1,songName);
            ResultSet resultSet = querySongInfo.executeQuery();
            List<ArtistList> artistLists = new ArrayList<>();
            while(resultSet.next()){
                ArtistList artistList = new ArtistList();
                artistList.setArtist(resultSet.getString(1));
                artistList.setAlbum(resultSet.getString(2));
                artistList.setTrack(resultSet.getInt(3));
                artistLists.add(artistList);
            }
            return artistLists;

        }catch (SQLException e) {
            System.out.println("Query Failed : "+e.getMessage());
            return null;
        }

    }

    public int insertArtist(String artistName) throws SQLException{
        queryArtist.setString(1,artistName);
        ResultSet resultSet = queryArtist.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        }else{
            insertIntoArtist.setString(1,artistName);
            int generatedKeys = insertIntoArtist.executeUpdate();

            if(generatedKeys != 1){
                throw new SQLException("Couldn't Insert Artist");
            }
            ResultSet resultSet1 = insertIntoArtist.getGeneratedKeys();
            if(resultSet1.next()){
                return resultSet1.getInt(1);
            }else{
                throw new SQLException("Couldn't get _id for artist");
            }

        }
    }

    public int insertAlbum(String albumName,int artistId) throws SQLException{
        queryAlbum.setString(1,albumName);
        ResultSet resultSet = queryAlbum.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        }else{
            insertIntoAlbum.setString(1,albumName);
            insertIntoAlbum.setInt(2,artistId);
            int affectedRows = insertIntoAlbum.executeUpdate();

            if(affectedRows != 1){
                throw new SQLException("Couldn't Insert Album");
            }
            ResultSet resultSet1 = insertIntoAlbum.getGeneratedKeys();
            if(resultSet1.next()){
                return resultSet1.getInt(1);
            }else{
                throw new SQLException("Couldn't get _id for album");
            }
        }
    }

    public int insertSong(int track, String title, int album) throws SQLException{
        querySong.setString(1,title);
        ResultSet resultSet = querySong.executeQuery();
        if(resultSet.next()){
            return resultSet.getInt(1);
        }else {
            insertIntoSong.setInt(1,track);
            insertIntoSong.setString(2,title);
            insertIntoSong.setInt(3,album);

            int affectedRows = insertIntoSong.executeUpdate();
            if(affectedRows != 1){
                throw new SQLException("Couldn't Insert Song");
            }
            ResultSet resultSet1 = insertIntoSong.getGeneratedKeys();
            if(resultSet1.next()){
                return resultSet1.getInt(1);
            }else{
                throw new SQLException("Couldn't get _id for Song");
            }
        }
    }

    public List<Song> querySongWithArtist(String artistName){
        try{
            querySongWithArtist.setString(1,artistName);
            ResultSet resultSet = querySongWithArtist.executeQuery();
            List<Song> songs = new ArrayList<>();
            while(resultSet.next()){
                Song song = new Song();
                song.setId(resultSet.getInt(1));
                song.setTrack(resultSet.getInt(2));
                song.setTitle(resultSet.getString(3));
                song.setAlbum(resultSet.getInt(4));
                songs.add(song);
            }
            return songs;
        }catch (SQLException e){
            System.out.println("Query Failed : "+e.getMessage());
            return null;
        }

    }



}
