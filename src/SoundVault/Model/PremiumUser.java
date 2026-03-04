package SoundVault.Model;

public class PremiumUser extends User {

    public PremiumUser(String username) {
        super(username);
    }

    @Override
    public void showAds() {
        // Ingen Reklamer
    }
}
