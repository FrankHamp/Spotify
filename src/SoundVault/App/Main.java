package soundvault.app;

import SoundVault.App.*;
import SoundVault.Model.*;
import SoundVault.Service.*;
import SoundVault.Util.*;

public class Main {
    public static void main(String[] args) {

        PlaylistManager manager = new PlaylistManager();
        manager.addSong(new Song("Halo", Genre.POP));
        manager.addSong(new Song("Thunderstruck", Genre.ROCK));

        manager.displaySongs();
    }

    boolean running = true;

    while(running)

    {
        System.out.println("1. Tilføj sang");
        System.out.println("2. Fjern sang");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                // Tilføj
                break;
            case 2:
                // Fjern
                break;
            case 3:
                running = false;
                break;
        }
    }
    fileHandler.saveToFile(manager.getSongs());


    Genre genre = Genre.fromString(userInput);

    if(genre ==null)

    {
        System.out.

                println("Ugyldig genre!");
    }

    PlaylistManager manager = new PlaylistManager();
    FileHandler fileHandler = new FileHandler();

    manager.

            setSongs(fileHandler.loadFromFile());
}