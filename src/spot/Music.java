package spot;

import java.util.ArrayList;

public class Music {

    private String title;
    private User singer;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(User singer) {
        this.singer = singer;
    }

    public void setNumberOfStream(int numberOfStream) {
        this.numberOfStream = numberOfStream;
    }

    public static ArrayList<Music> getAllMusic() {
        return allMusic;
    }

    public static void setAllMusic(ArrayList<Music> allMusic) {
        Music.allMusic = allMusic;
    }

    public Music(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public User getSinger() {
        return singer;
    }

    public int getNumberOfStream() {
        return numberOfStream;
    }

    private int numberOfStream = 0;
    public static ArrayList<Music> allMusic = new ArrayList<Music>();

    public void play() {
        System.out.println("Playing " + title + " singer " + singer + " stream "
                + numberOfStream);
        numberOfStream++;
    }

    public ArrayList<Music> search(String title) {
        ArrayList<Music> musicList = new ArrayList<Music>();
        for (Music music : allMusic) {
            if (music.title.equals(title)) {
                musicList.add(music);
            }
        }
        if (musicList.isEmpty())
            return null;
        else
            return musicList;
    }

    public ArrayList<Music> search(String title, User singer) {
        ArrayList<Music> musicList = new ArrayList<Music>();
        for (Music music : allMusic) {
            if (music.title.equals(title) && music.singer.getUsername().equals(singer.getUsername())) {
                musicList.add(music);
            }
        }
        if (musicList.isEmpty())
            return null;
        else
            return musicList;
    }
}
