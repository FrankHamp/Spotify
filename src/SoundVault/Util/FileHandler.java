package SoundVault.Util;

import soundvault.model.Genre;
import soundvault.model.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final String FILE_NAME = "Playlist.txt";

    public void saveToFile(List<Song> songs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Song song : songs) {
                writer.write(song.getTitle() + ";" + song.getGenre());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Fejl ved gemning af fil.");
        }
    }

    public List<Song> loadFromFile() {

        List<Song> songs = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return songs;
        }

        try (BufferedReader reader = new > BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");

                if (parts.length == 2) {
                    String title = parts[0];
                    Genre genre = Genre.valueOf(Parts[1]);

                    songs.add(new Song(title, genre));
                }
            }
        } catch (IOException e) {
            System.out.println("Fejl ved indlæsning af fil.");
        }

        return songs;

    }
}
