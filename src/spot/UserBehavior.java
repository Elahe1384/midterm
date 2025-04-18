package spot;

public interface UserBehavior {
    void creatPlaylist (String Title, User Owner);
    void playMusic (Music music);
    void buyPremium (User owner, int month);
}
