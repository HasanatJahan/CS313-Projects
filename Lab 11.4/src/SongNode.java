public class SongNode {
    private String songTitle;
    private int songLength;
    private String songArtist;
    private SongNode nextNodeRef; // Reference to the next node

    public SongNode() {
        songTitle = "";
        songLength = 0;
        songArtist = "";
        nextNodeRef = null;
    }

    // Constructor
    public SongNode(String songTitleInit, int songLengthInit, String songArtistInit) {
        this.songTitle = songTitleInit;
        this.songLength = songLengthInit;
        this.songArtist = songArtistInit;
        this.nextNodeRef = null;
    }

    // Constructor
    public SongNode(String songTitleInit, int songLengthInit, String songArtistInit, SongNode nextLoc) {
        this.songTitle = songTitleInit;
        this.songLength = songLengthInit;
        this.songArtist = songArtistInit;
        this.nextNodeRef = nextLoc;
    }

    // insertAfter
    public void insertAfter(SongNode nodeLoc) {
        SongNode tmpNext;

        tmpNext = this.nextNodeRef;
        this.nextNodeRef = nodeLoc;
        nodeLoc.nextNodeRef = tmpNext;
    }

    // Get location pointed by nextNodeRef
    public SongNode getNext() {
        return this.nextNodeRef;
    }


    //Accessor Methods for the print
    public String getSongTitle(){
        return this.songTitle;
    }

    public int getSongLength(){
        return this.songLength;
    }

    public String getSongArtist(){
        return this.songArtist;
    }

    // TODO: Write printSongInfo() method
    public void printSongInfo(){
        System.out.println("Title: " + this.getSongTitle());
        System.out.println("Length: " + this.getSongLength());
        System.out.println("Artist: " + this.getSongArtist());
        System.out.println();
    }

}