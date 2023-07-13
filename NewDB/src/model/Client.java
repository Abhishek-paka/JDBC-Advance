package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

class Client {

    public static DataSource dataSource = new DataSource();
    public static Scanner sc = new Scanner(System.in);
    public final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Client client = new Client();
    public static final String options = """
            1. Query Albums Table
            2. Query Artists Table
            3. Query 
            4. Enter Artist Name to find this albums
            5. To Query MetaData enter Table Name 
            6. Count of Records 
            7. Create Artist View
            8. Query ArtistList View
            9. Query Song Info
            10. Insert Artist 
            11. Insert Album
            12. insert Song
            13. Query Songs with Artist Name 
            0. Exit
            Enter your choice to perform query : 
            """;

    public static void main(String[] args) throws SQLException, IOException {
        boolean flag = true;
        dataSource.open();
        while (flag) {
            System.out.print(options);
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    client.queryAlbums();
                    break;
                case 2:
                    client.queryArtists();
                    break;
                case 3:
                    client.querySongs();
                    break;
                case 4:
                    client.queryAlbumsWithArtist();
                    break;
                case 5:
                    System.out.print("Enter Table Name : ");
                    String tableName = sc.next();
                    client.queryMetaData(tableName);
                    break;
                case 6:
                    System.out.print("Enter Table Name :");
                    String tableName1 = sc.next();
                    client.getCount(tableName1);
                    break;
                case 7:
                    client.createArtistView();
                    break;
                case 8:
                    client.queryArtistList();
                    break;
                case 9:
                    client.querySongInfo();
                    break;
                case 10:
                    client.insertArtist();
                    break;
                case 11:
                    client.insertAlbum();
                    break;
                case 12:
                    client.insertSong();
                    break;
                case 13:
                    client.querySongsWithArtist();
                    break;
                case 0:
                    flag = false;
                    break;

                default:
                    System.out.println("Enter a Valid Choice...");
            }
        }
        dataSource.close();


    }

    public void queryAlbums(){
        //query albums table ---> select * from albums
        List<Album> albums = dataSource.queryAlbums();
        if(albums != null){
            for(Album album : albums){
                System.out.format("Album id : %d\t Album Name : %s\t Album artist_id : %d\n",album.getId(),album.getName(),album.getArtist());
            }
        }else{
            System.out.println("No Records Found in Albums Table");
        }
    }

    public void queryArtists(){
        //query artists table --> select * from artists
        List<Artist> artists = dataSource.queryArtists();
        if(artists != null){
            for(Artist artist : artists){
                System.out.format("Artist id : %d\t Artist Name: %s\n",artist.getId(),artist.getName());

            }
        }else{
            System.out.println("No Records Found in Artists Table");
        }
    }

    public void querySongs(){
        List<Song> songs = dataSource.querySongs();
        if(songs != null){
            for(Song song : songs){
                System.out.format("Song id : %d\t Song Track : %d\t Song Title : %s\t Song Album : %d\n",song.getId(),song.getTrack(),song.getTitle(),song.getAlbum());
            }
        }else {
            System.out.println("No Records Found in Songs Table");
        }
    }

    public void queryAlbumsWithArtist() throws IOException{
        System.out.print("Enter Artist Name : ");
        String artistName = br.readLine();
        List<String> albums = dataSource.queryAlbumsWithArtist(artistName);
        if(albums != null){
            System.out.println("Albums by "+artistName+" are : ");
            for(String album : albums){
                System.out.println("\t\t\t"+album);
            }
        }else{
            System.out.println("No Records Found with name of "+artistName);
        }
    }

    public void queryMetaData(String tableName){
        dataSource.queryMetaData(tableName);
    }

    public void getCount(String tableName){
        dataSource.getCount(tableName);
    }

    public void createArtistView(){
        dataSource.create_view_artistList();
    }

    public void queryArtistList(){
        List<ArtistList> artistlists = dataSource.queryArtistList();
        if(artistlists != null){
            for(ArtistList artistList : artistlists){
                System.out.format("Artist Name : %s\tAlbum Name : %s\tTrack Number : %d\tTitle : %s\n",artistList.getArtist(),artistList.getAlbum(),artistList.getTrack(),artistList.getTitle());
            }
        }else {
            System.out.println("No Records Found in "+DataSource.TABLE_ARTIST_VIEW);
        }
    }

    public void querySongInfo() throws IOException{
        System.out.print("Enter the Song Name :");
        String songName = br.readLine();
        List<ArtistList> artistLists = dataSource.querySongInfo(songName);
        if(artistLists != null){
            for(ArtistList artistList : artistLists){
                System.out.format("Artist Name : %s\t Album Name : %s\t Track Number : %d\n",artistList.getArtist(),artistList.getAlbum(),artistList.getTrack());
            }
        }else{
            System.out.println("No Record Found with the Song Name : "+songName);
        }
        sc.close();
    }

    public void insertArtist() throws SQLException, IOException {
        System.out.println("Enter Artist Name : ");
        String artistName = br.readLine();
        int id = dataSource.insertArtist(artistName);
        System.out.println("Generated _id for Artist : "+artistName+" is :"+id);
    }

    public void insertAlbum() throws SQLException, IOException{
        System.out.println("Enter Album Name : ");
        String albumName = br.readLine();
        System.out.println("Enter Artist Id : ");
        int artistId = Integer.parseInt(br.readLine());

        int id = dataSource.insertAlbum(albumName,artistId);
        System.out.println("Generated _id for Album : "+albumName+" is :"+id);

    }

    public void insertSong() throws SQLException, IOException{
        System.out.print("Enter Track Number : ");
        int track = Integer.parseInt(br.readLine());
        System.out.print("Enter Song Title : ");
        String title = br.readLine();
        System.out.print("Enter Album Id : ");
        int album = Integer.parseInt(br.readLine());

        int id = dataSource.insertSong(track,title,album);
        System.out.println("Generated _id for Song : "+title+" is : "+id);
    }

    public void querySongsWithArtist() throws IOException {
        System.out.print("Enter Artist Name : ");
        String artistName = br.readLine();
        List<Song> songs = dataSource.querySongWithArtist(artistName);
        if(songs != null){
            for(Song song : songs){
                System.out.format("Song Id : %d\t Track Number : %d\t Song Title : %s\t Album id :%d\n",song.getId(),song.getTrack(),song.getTitle(),song.getAlbum());
            }
        }else{
            System.out.println("No Records Found with the Artist Name : "+artistName);
        }
    }

}