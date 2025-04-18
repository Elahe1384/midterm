package spot;

import java.util.ArrayList;

public class Playlist {
    private String title;
    private ArrayList<Music> playlist = new ArrayList<>();
    private User owner;

    public Playlist(String title, User owner) {
        this.title = title;
        this.owner = owner;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Music> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Music> playlist) {
        this.playlist = playlist;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void addMusic(Music music, String password) {
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("Invalid password");
        if (playlist.contains(music))
            throw new InvalidOperationException("Duplicate music");
        playlist.add(music);
    }

    public void removeMusic(Music music, String password) {
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("Invalid password");
        if (!playlist.contains(music))
            throw new InvalidOperationException("music not exist");
        playlist.remove(music);
    }

    public void editTitle(String title, String password) {
        if (!owner.getPassword().equals(password))
            throw new InvalidOperationException("Invalid password");
        if (title.equals(this.title))
            throw new InvalidOperationException("repetitive title");
        this.title = title;
    }

    public ArrayList<Music> searchInPlaylist(String title) {
        ArrayList<spot.Music> musicList = new ArrayList<spot.Music>();
        for (Music music : playlist) {
            if (music.getTitle().equals(title)) {
                musicList.add(music);
            }
        }
        if (musicList.isEmpty())
            return null;
        else
            return musicList;
    }

    public ArrayList<Music> searchInPlaylist(String title, User singer) {
        ArrayList<Music> musicList = new ArrayList<Music>();
        for (Music music : playlist) {
            if (music.getTitle().equals(title) && music.getSinger().getUsername().equals(singer.getUsername())) {
                musicList.add(music);
            }
        }
        if (musicList.isEmpty())
            return null;
        else
            return musicList;
    }

    public void playPlaylist() {
        for (Music music : playlist) {
            music.play();
        }
    }
}
