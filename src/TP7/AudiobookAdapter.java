package TP7;

public class AudiobookAdapter extends Book {
    private AudioBook audiobook;

    public AudiobookAdapter(AudioBook audiobook) {
        super(audiobook.getAuthor(), audiobook.getTitle(), audiobook.getPrice(), audiobook.getAuthor() + " - " + audiobook.getTitle() + " - " + audiobook.getDuration() + " min" + " - " + audiobook.getPrice() + "€");
        this.audiobook = audiobook;
    }
}
