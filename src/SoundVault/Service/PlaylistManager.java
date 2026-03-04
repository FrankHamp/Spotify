package SoundVault.Service;

import SoundVault.Model.Song;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlaylistManager {

    private List<Song> songs;

    public PlaylistManager() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public boolean removeSong(String title) {
        Song song = findSong(title);

        if (song != null) {
            songs.remove(song);
            return true;
        }
        return false;
    }

    public Song findSong(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }

    public boolean editSong(String oldTitle, String newTitle) {
        Song song = findSong(oldTitle);

        if (song != null) {
            song.setTitle(newTitle);
            return true;
        }

        return false;
    }

    public void sortSongs() {
        songs.sort(Comparator.comparing(Song::getTitle));
    }

    public void displaySongs() {
        if (songs.isEmpty()) {
            System.out.println("Playlisten er tom.");
            return;
        }

        for (Song song : songs) {
            System.out.println(song);
        }

    }

    public List<Song> getSongs(){
        return songs;
    }

    public void setSongs(List<Song> songs){
        this.songs = songs;
    }
}