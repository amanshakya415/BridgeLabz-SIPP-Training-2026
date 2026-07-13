package LinkedList;

public class AddingATrackToAPlaylist {
    static class Node {
        String trackName;
        Node next;

        Node(String trackName) {
            this.trackName = trackName;
        }
    }

    public static void insertAfterCurrent(Node currentTrack, String newTrackName) {
        if (currentTrack == null) {
            throw new IllegalArgumentException("Current track cannot be null.");
        }

        Node newTrack = new Node(newTrackName);
        newTrack.next = currentTrack.next;
        currentTrack.next = newTrack;
    }

    public static void displayPlaylist(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.trackName + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node("Song A");
        head.next = new Node("Song B");
        head.next.next = new Node("Song C");

        Node currentTrack = head.next;
        insertAfterCurrent(currentTrack, "Song D");

        displayPlaylist(head);
    }
}
