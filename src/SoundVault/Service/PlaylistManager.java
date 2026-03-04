package SoundVault.Service;

public class PlaylistManager {
    private List<Song> songs;

    songs =new ArrayList<>();
}

public void addSong(Song song) {
    songs.add(song);
}

public void displaySongs() {
    if (songs.isEmpty()) {
        System.out.println("Playlisten er tom.");
        return;
    }
    for (Song song : songs) {
        System.out.println(song);
    }
    public Song findSong (String title){
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                return song;
            }
        }
        return null;
    }
    public boolean removeSong (String title){
        Song song = findSong(title);
        if (song != null) {
            songs.remove(song);
            return true;
        }
        return false;
    }
    public boolean editSong (String oldtitle, String newTitle){
        Song song = findSong(oldTitle);
        if (song != null) {
            song.setTitle(newTitle);
            return true;
        }
        return false;
    }
    public void sortSongs () {
        songs.sort(Comparator.comparing(Song::getTitle));
    }
}