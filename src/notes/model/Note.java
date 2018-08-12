package notes.model;

public class Note {
    private String text;

    public Note(String text) {
        this.text = text;
    }

    public Note() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
