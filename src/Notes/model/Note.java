package Notes.model;

public class Note {
    private StringBuilder text = new StringBuilder();

    public StringBuilder getText() {
        return text;
    }

    public void setText(StringBuilder text) {
        this.text = text;
    }
}
