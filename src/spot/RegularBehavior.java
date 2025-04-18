package spot;

public class RegularBehavior implements UserBehavior {

    private int playingLimit = 5;

    @Override
    public void creatPlaylist(String Title, User Owner) {
        throw new InvalidOperationException("You are not allowed to creat play list.");
    }

    @Override
    public void playMusic(Music music) {
        if (playingLimit <= 0) {
            throw new InvalidOperationException("You are not allowed to play anything.");
        }
        music.play();
        playingLimit--;
    }

    @Override
    public void buyPremium(User owner, int month) {
        owner.setBehavior(new PremiumBehavior(month));
    }
}
