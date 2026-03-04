package SoundVault.Model;

public class FreeUser extends User {

    public class FreeUser(String username) {
        super(username);
    }

    @Override
    public void showAds() {
        System.out.println("Reklame spiller... Opgrader til Premium!");
    }
}
