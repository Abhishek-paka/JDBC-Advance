# JDBC-Advance
JDBC - Advance Queries

Database - Music
Tables - albums, artist, songs, artist_list
+--------------------+
| Tables_in_Music |
+--------------------+
| albums             |
| artists            |
| songs              |
| artist_list        |
+--------------------+

albums -
+--------+------+------+-----+---------+----------------+
| Field  | Type | Null | Key | Default | Extra          |
+--------+------+------+-----+---------+----------------+
| _id    | int  | NO   | PRI | NULL    | auto_increment |
| name   | text | NO   |     | NULL    |                |
| artist | int  | YES  |     | NULL    |                |
+--------+------+------+-----+---------+----------------+

artists - 
+-------+------+------+-----+---------+----------------+
| Field | Type | Null | Key | Default | Extra          |
+-------+------+------+-----+---------+----------------+
| _id   | int  | NO   | PRI | NULL    | auto_increment |
| name  | text | NO   |     | NULL    |                |
+-------+------+------+-----+---------+----------------+

songs - 
+-------+------+------+-----+---------+----------------+
| Field | Type | Null | Key | Default | Extra          |
+-------+------+------+-----+---------+----------------+
| _id   | int  | NO   | PRI | NULL    | auto_increment |
| track | int  | YES  |     | NULL    |                |
| title | text | NO   |     | NULL    |                |
| album | int  | YES  |     | NULL    |                |
+-------+------+------+-----+---------+----------------+

artist_list - 
+--------+------+------+-----+---------+-------+
| Field  | Type | Null | Key | Default | Extra |
+--------+------+------+-----+---------+-------+
| artist | text | NO   |     | NULL    |       |
| album  | text | NO   |     | NULL    |       |
| track  | int  | YES  |     | NULL    |       |
| title  | text | NO   |     | NULL    |       |
+--------+------+------+-----+---------+-------+


Performed queries 
---------------------
JDBC Format :
1. "select * from "+TABLE_ALBUMS
2. "select * from "+TABLE_ARTISTS
3. "select * from "+TABLE_SONGS
4. "SELECT "+TABLE_ALBUMS+"."+ALBUM_NAME+
            " FROM "+TABLE_ALBUMS+" INNER JOIN "+TABLE_ARTISTS+" ON " +TABLE_ALBUMS+"."+ALBUM_ARTIST+" = " +TABLE_ARTISTS+"."+ARTIST_ID +
            " WHERE "+TABLE_ARTISTS+"."+ARTIST_NAME+" = "
5. "select * from "+tableName --> Quering MetaData
6. select count(*) from "+tableName --> Total Count of Records
7. "create view " +
            TABLE_ARTIST_VIEW+" as select "+TABLE_ARTISTS+"."+ARTIST_NAME+" AS artist, "+
            TABLE_ALBUMS+"."+ALBUM_NAME+" as album, "+TABLE_SONGS+"."+SONG_TRACK+", "+
            TABLE_SONGS+"."+SONG_TITLE+" from "+TABLE_SONGS+
            " inner join "+TABLE_ALBUMS+" ON "+TABLE_SONGS+"."+SONG_ALBUM+" = "+TABLE_ALBUMS+"."+ALBUM_ID+
            " inner join "+TABLE_ARTISTS+" ON "+TABLE_ALBUMS+"."+ALBUM_ARTIST+" = "+TABLE_ARTISTS+"."+ARTIST_ID+
            " ORDER BY "+TABLE_ARTISTS+"."+ALBUM_NAME+", "+TABLE_ALBUMS+"."+ALBUM_NAME+", "+TABLE_SONGS+"."+SONG_TRACK
8. "select * from "+TABLE_ARTIST_VIEW
9. "select artist, album,"+SONG_TRACK+" from "+TABLE_ARTIST_VIEW+" WHERE " +
            SONG_TITLE+" = ?"
10. "insert into "+TABLE_ARTISTS+"("+ARTIST_NAME+") values(?)"
11. "insert into "+TABLE_ALBUMS+"("+ALBUM_NAME+", "+ALBUM_ARTIST+") values(?, ?)"
12.  "insert into "+TABLE_SONGS+" ("+SONG_TRACK+", "+SONG_TITLE+", "+SONG_ALBUM+") values(?, ?, ?)"
13.  "select "+TABLE_SONGS+"."+SONG_ID+", "+ TABLE_SONGS+"."+SONG_TRACK+", "+TABLE_SONGS+"."+SONG_TITLE+", "+TABLE_SONGS+"."+SONG_ALBUM+
            " from "+TABLE_SONGS+" INNER JOIN "+TABLE_ALBUMS+" ON "+TABLE_SONGS+"."+SONG_ALBUM+" = "+TABLE_ALBUMS+"."+ALBUM_ID+
            " INNER JOIN "+TABLE_ARTISTS+" ON "+TABLE_ALBUMS+"."+ALBUM_ARTIST+" = "+TABLE_ARTISTS+"."+ARTIST_ID+
            " WHERE "+TABLE_ARTISTS+"."+ARTIST_NAME+" = ?"


MySQL Format : 
1. select * from albums;
2. select * from artists;
3. select * from songs;
4. SELECT albums.name
            FROM albums INNER JOIN artists ON albums.artist = artists._id
            WHERE artists.name = ?
5. select * from +tableName --> Quering MetaData
6. select count(*) from "+tableName --> Total Count of Records
7. create view 
            artist_view as select artists.name AS artist,
            albums.name as album, songs.track,
            songs.title from songs
            inner join albums ON songs.album = albums._id
            inner join artists ON albums.artist = artists._id
            ORDER BY artists.name, albums.name, songs.track;
8. select * from artist_view;
9. select artist, album, track from artist_view WHERE title = ?;
10. insert into artists(name) values(?);
11. insert into albums(name,artist) values(?, ?);
12. insert into songs (track, title, album) values(?, ?, ?);
13. select songs._id, songs.track, songs.title, songs.album
            from songs INNER JOIN artists ON songs.album = albums._id
            INNER JOIN artists ON albums.artist = artists._id
            WHERE artists.name = ?;
