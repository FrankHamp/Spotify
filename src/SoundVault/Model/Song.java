package SoundVault.Model;

public class Song {
    private String title;
    private Genre genre;

    public Song(String title, Genre genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Title: " + title + " | Genre: " + genre;
    }
}
