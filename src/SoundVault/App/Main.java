package SoundVault.App;

import SoundVault.Model.*;
import SoundVault.Service.PlaylistManager;
import SoundVault.Util.FileHandler;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PlaylistManager manager = new PlaylistManager();
        FileHandler fileHandler = new FileHandler();

        // Automatisk load
        manager.setSongs(fileHandler.loadFromFile());

        User currentUser = new FreeUser("TestUser");

        boolean running = true;

        while (running) {

            System.out.println("\nVelkommen til SoundVault!");
            System.out.println("1. Tilføj sang");
            System.out.println("2. Fjern sang");
            System.out.println("3. Vis alle sange");
            System.out.println("4. Søg efter sang");
            System.out.println("5. Rediger sang");
            System.out.println("6. Sorter sange");
            System.out.println("7. Afslut");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Titel: ");
                    String title = scanner.nextLine();

                    System.out.print("Genre: ");
                    String genreInput = scanner.nextLine();

                    Genre genre = Genre.fromString(genreInput);

                    if (genre == null) {
                        System.out.println("Ugyldig genre!");
                    } else {
                        manager.addSong(new Song(title, genre));
                        System.out.println("Sang tilføjet.");
                    }
                    break;

                case 2:
                    System.out.print("Titel på sang der skal fjernes: ");
                    String removeTitle = scanner.nextLine();

                    if (manager.removeSong(removeTitle)) {
                        System.out.println("Sang fjernet.");
                    } else {
                        System.out.println("Sangen blev ikke fundet.");
                    }
                    break;

                case 3:
                    manager.displaySongs();
                    break;

                case 4:
                    System.out.print("Titel der søges efter: ");
                    String searchTitle = scanner.nextLine();

                    Song found = manager.findSong(searchTitle);

                    if (found != null) {
                        System.out.println("Fundet: " + found);
                    } else {
                        System.out.println("Sangen blev ikke fundet.");
                    }
                    break;

                case 5:
                    System.out.print("Gammel titel: ");
                    String oldTitle = scanner.nextLine();

                    System.out.print("Ny titel: ");
                    String newTitle = scanner.nextLine();

                    if (manager.editSong(oldTitle, newTitle)) {
                        System.out.println("Sang opdateret.");
                    } else {
                        System.out.println("Sangen blev ikke fundet.");
                    }
                    break;

                case 6:
                    manager.sortSongs();
                    System.out.println("Sange sorteret.");
                    break;

                case 7:
                    fileHandler.saveToFile(manager.getSongs());
                    running = false;
                    System.out.println("Programmet afsluttes...");
                    break;

                default:
                    System.out.println("Ugyldigt valg.");
            }

            currentUser.showAds();
        }

        scanner.close();
    }
}