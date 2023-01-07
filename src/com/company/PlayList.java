package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class PlayList {
    private ArrayList<com.company.Album>albums;
    private LinkedList<com.company.Song>playlist;
    public PlayList() {
        this.albums = new ArrayList<com.company.Album>();
        this.playlist = new LinkedList<com.company.Song>();
    }
    public ArrayList<com.company.Album> getAlbums() {
        return albums;
    }
    public LinkedList<com.company.Song> getPlaylist() {
        return playlist;
    }
    public void addAlbum(String albumName){
        com.company.Album foundAlbum=findAlbum(albumName);
        if(foundAlbum==null){
            this.albums.add(new com.company.Album(albumName));
        }
        else{
            System.out.println("Album "+foundAlbum.getName()+" is already on file!");
        }
    }
    private com.company.Album findAlbum(String albumName){
        for(int i=0;i<this.albums.size();i++){
            com.company.Album checkedAlbums=this.albums.get(i);
            if(checkedAlbums.getName().equals(albumName)){
                return checkedAlbums;
            }
        }
        return null;
    }
    public void addSong(String albumName, String songName){
        com.company.Album checkedAlbum=findAlbum(albumName);
        if(checkedAlbum!=null){
            com.company.Song checkedSong=findSong(albumName,songName);
            if(checkedSong!=null){
                playlist.add(checkedSong);

            }else{
                System.out.println("Song is not in the album!");
            }

        }else if(checkedAlbum==null){
            System.out.println("Album is not on the file!");
        }
    }
    private com.company.Song findSong(String albumName, String songName){
        com.company.Album checkedAlbum=findAlbum(albumName);
        if(checkedAlbum!=null){
            for(int i=0;i<checkedAlbum.getSongs().size();i++){
                com.company.Song checkedSongs=checkedAlbum.getSongs().get(i);
                if(checkedSongs.getTitle().equals(songName)){
                    return checkedSongs;
                }
            }
        }
        return null;
    }
    public void addSongToAlbum(String albumName,String songName,double duration){
        com.company.Album checkedAlbum=findAlbum(albumName);
        if(checkedAlbum!=null){
            com.company.Song checkedSong=findSong(albumName,songName);
            if(checkedSong==null){
                checkedAlbum.addSongs(songName,duration);
            }
            else{
                System.out.println("Song is already in album");
            }
        }
        else if(checkedAlbum==null){
            System.out.println("Album is not on file");
        }

    }
}