package SoundVault.Util;

public class FileHandler {
    public void saveToFile(List<Song> songs) {
        writer.write(song.getTitle() + ";" + song.getGenre());
        writer.newLine();
    }

    public List<Song> loadFromFile() {
        String[] parts = Line.split(";");
        String title = parts[0];
        Genre genre = Genre.valueOf(parts[1]);
    }
}
