import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {
    private ArrayList<String> playlist;
    private int currentTrackIndex;

    public MusicPlayer() {
        playlist = new ArrayList<>();
        currentTrackIndex = -1;
    }

    // Add a music track to the playlist
    public void addTrack(String track) {
        playlist.add(track);
        System.out.println("Track added: " + track);
    }

    // Remove a music track from the playlist
    public void removeTrack(String track) {
        if (playlist.remove(track)) {
            System.out.println("Track removed: " + track);
        } else {
            System.out.println("Track not found: " + track);
        }
    }

    // Play a track from the playlist
    public void playTrack() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        if (currentTrackIndex == -1) {
            currentTrackIndex = 0;
        }
        System.out.println("Playing: " + playlist.get(currentTrackIndex));
    }

    // Skip to the next track
    public void nextTrack() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        currentTrackIndex = (currentTrackIndex + 1) % playlist.size();
        System.out.println("Playing: " + playlist.get(currentTrackIndex));
    }

    // Display the entire playlist
    public void displayPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("Current Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i));
        }
    }

    // Main method to interact with the user
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer musicPlayer = new MusicPlayer();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Track");
            System.out.println("2. Remove Track");
            System.out.println("3. Play Track");
            System.out.println("4. Next Track");
            System.out.println("5. Display Playlist");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter track name to add: ");
                    String addTrack = scanner.nextLine();
                    musicPlayer.addTrack(addTrack);
                    break;
                case 2:
                    System.out.print("Enter track name to remove: ");
                    String removeTrack = scanner.nextLine();
                    musicPlayer.removeTrack(removeTrack);
                    break;
                case 3:
                    musicPlayer.playTrack();
                    break;
                case 4:
                    musicPlayer.nextTrack();
                    break;
                case 5:
                    musicPlayer.displayPlaylist();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}

