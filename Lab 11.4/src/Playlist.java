import java.util.Scanner;

public class Playlist {

    // TODO: Write method to ouptut list of songs
    public static void printPlaylist(SongNode n){
        //if it's the headNode then start from the next node
        n = n.getNext(); //skipping over the headnode

        while(n != null){
            n.printSongInfo();
            n = n.getNext();
        }
    }

    public static void main (String[] args) {
        Scanner scnr = new Scanner(System.in);

        SongNode headNode;
        SongNode currNode;
        SongNode lastNode;

        String songTitle;
        int songLength;
        String songArtist;

        // Front of nodes list
        headNode = new SongNode();
        lastNode = headNode;

        // Read user input until -1  entered
        songTitle = scnr.nextLine();
        while (!songTitle.equals("-1")) {
            songLength = scnr.nextInt();
            scnr.nextLine();
            songArtist = scnr.nextLine();

            currNode = new SongNode(songTitle, songLength, songArtist);
            lastNode.insertAfter(currNode);
            lastNode = currNode;

            songTitle = scnr.nextLine();
        }

        // Print linked list
        System.out.println("LIST OF SONGS");
        System.out.println("-------------");
        printPlaylist(headNode);
    }
}
