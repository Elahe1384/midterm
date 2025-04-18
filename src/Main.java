import spot.*;

public class Main {
    public static void main(String[] args) {
        try {

            User user1 = new User("john_doe", "password123");
            User user2 = new User("jane_smith", "securepass456");


            try {
                User user3 = new User("john_doe", "anotherpass");
            } catch (InvalidOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }


            try {
                User user4 = new User("new_user", "short");
            } catch (InvalidOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }


            user1.follow(user2);
            System.out.println(user1.getUsername() + " is now following " + user2.getUsername());


            Music song1 = new Music("Shape of You");
            song1.setSinger(user2);
            Music.allMusic.add(song1);

            Music song2 = new Music("Perfect");
            song2.setSinger(user2);
            Music.allMusic.add(song2);

            Music song3 = new Music("Shape of You");
            song3.setSinger(user1);
            Music.allMusic.add(song3);


            System.out.println("Search results for 'Shape of You': " + song1.search("Shape of You").size());
            System.out.println("Search results for 'Shape of You' by jane_smith: " +
                    song1.search("Shape of You", user2).size());


            System.out.println("\nTesting regular user:");
            user1.playMusic(song1);
            user1.playMusic(song2);
            System.out.println("Stream count for song1: " + song1.getNumberOfStream());


            try {
                user1.creatPlayList("Favorites", user1);
            } catch (InvalidOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }


            try {
                for (int i = 0; i < 5; i++) {
                    user1.playMusic(song1);
                }
                System.out.println("Stream count for song1: " + song1.getNumberOfStream());
                user1.playMusic(song1); // Should throw exception
            } catch (InvalidOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }


            System.out.println("\nUpgrading to premium:");
            user1.buyPremium(user1, 3);


            System.out.println("\nTesting premium user:");
            user1.creatPlayList("Favorites", user1);
            System.out.println("Created playlist successfully");


            for (int i = 0; i < 10; i++) {
                user1.playMusic(song1);
            }
            System.out.println("Stream count for song1: " + song1.getNumberOfStream());


            Playlist playlist = user1.getPlaylists().getFirst();
            playlist.addMusic(song1, "password123");
            playlist.addMusic(song2, "password123");


            try {
                playlist.addMusic(song1, "password123");
            } catch (InvalidOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }


            try {
                playlist.addMusic(song3, "wrongpass");
            } catch (InvalidOperationException e) {
                System.out.println("Expected error: " + e.getMessage());
            }


            System.out.println("Search in playlist: " +
                    playlist.searchInPlaylist("Shape of You").size() + " results");


            System.out.println("\nPlaying playlist:");
            playlist.playPlaylist();

        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}