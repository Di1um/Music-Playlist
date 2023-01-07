package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PlayList playList=new PlayList();

        playList.addAlbum("Best of the Best");
        playList.addSongToAlbum("Best of the Best", "Stolen Dance", 2.30);
        playList.addAlbum("A Summer 2022");
        playList.addSongToAlbum("A Summer 2022", "Counting Stars", 3.30);
        playList.addAlbum("Best of Eminem");
        playList.addSongToAlbum("Best of Eminem", "Mockingbird", 2.45);
        playList.addAlbum("YMCMB");
        playList.addSongToAlbum("YMCMB", "If I Can't", 2.10);
        playList.addSongToAlbum("YMCMB", "In Da Club", 2.20);
        playList.addSong("YMCMB", "If I Can't");
        playList.addSong("YMCMB", "In Da Club");
        playList.addSong("A Summer 2022", "Counting Stars");
        playList.addSong("Best of the Best", "Stolen Dance");

        menu(playList);
    }
    public static void menu(PlayList playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        LinkedList<Song> songsInPlaylist = playList.getPlaylist();
        ListIterator<Song> listIterator = songsInPlaylist.listIterator();

        if (songsInPlaylist.isEmpty()) {
            System.out.println("No songs in Playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());
            printOptions();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Closing playlist");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Skipping to next song " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing previous song " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (goingForward) {
                        System.out.println("now playing " + listIterator.previous().getTitle());
                        goingForward = false;
                    } else {
                        System.out.println("now playing " +listIterator.next().getTitle());
                        goingForward = true;
                    }
                    break;
                case 4:
                    printOptions();
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void printOptions() {
        System.out.println("Available operations:\npress any of the actions below: ");
        System.out.println("0 - Quit the program\n" +
                "1 - Play the next song\n" +
                "2 - play the previous song\n" +
                "3 - repeat the current song\n" +
                "4 - Go to the menu");
    }
}
