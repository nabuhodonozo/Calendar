package notes.model;

public class Note {
    private String text;
    private boolean isNew = true;

    public Note(String text) {
        this.text = text;
    }

    public Note() {
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}