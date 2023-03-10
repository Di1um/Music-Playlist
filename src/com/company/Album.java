package com.company;
import java.util.ArrayList;
public class Album {
    private String name;
    private ArrayList<Song>songs;
    public Album(String name) {
        this.name = name;
        this.songs = new ArrayList<Song>();
    }
    public String getName() {
        return name;
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }
    public void addSongs(String songName, double duration){
        Song song=new Song(songName,duration);
        this.songs.add(song);
    }
}

