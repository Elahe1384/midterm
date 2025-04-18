package spot;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<User> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(ArrayList<User> followerList) {
        this.followerList = followerList;
    }

    public ArrayList<User> getFollowingList() {
        return followingList;
    }

    public void setFollowingList(ArrayList<User> followingList) {
        this.followingList = followingList;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(ArrayList<Playlist> playlists) {
        this.playlists = playlists;
    }

    public static ArrayList<User> getAllUser() {
        return allUser;
    }

    public static void setAllUser(ArrayList<User> allUser) {
        User.allUser = allUser;
    }

    private ArrayList<User> followerList = new ArrayList<User>();
    private ArrayList<User> followingList = new ArrayList<User>();
    private UserBehavior behavior;
    private ArrayList<Playlist> playlists = new ArrayList<>();
    private static ArrayList<User> allUser = new ArrayList<>();

    public User(String username, String password) {
        for (User usr : allUser)
            if (usr.getUsername().equals(username))
                throw new InvalidOperationException("Username is already in use!");
        if (password.length() < 8)
            throw new InvalidOperationException("Password must be at least 8 characters!");
        this.username = username;
        this.password = password;
        behavior = new RegularBehavior();
        allUser.add(this);
    }

    public void follow(User user) {
        followerList.add(user);
        user.followingList.add(this);
    }

    public void creatPlayList(String title, User owner) {
        this.behavior.creatPlaylist(title, owner);
    }

    public void playMusic(Music music) {
        this.behavior.playMusic(music);
    }

    public void buyPremium(User owner, int month) {
        this.behavior.buyPremium(owner, month);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

}