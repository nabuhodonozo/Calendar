package pl.solsoft.notes.model;

public class Note {
    private String text;
    private boolean recentlyCreated = true;

    public Note(String text) {
        this.text = text;
    }

    public Note() {
    }

    public boolean isRecentlyCreated() {
        return recentlyCreated;
    }

    public void setRecentlyCreated(boolean recentlyCreated) {
        this.recentlyCreated = recentlyCreated;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}