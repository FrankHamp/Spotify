package SoundVault.Model;

public enum Genre {
    ROCK,
    POP,
    JAZZ,
    HIPHOP,
    CLASSICAL,
    AFROBEAT,
    DANCEHALL,
    ELECTRONIC;

    public static Genre fromString(String input) {
        try {
            return Genre.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

}
