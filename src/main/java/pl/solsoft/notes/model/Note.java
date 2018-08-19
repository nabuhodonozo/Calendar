package pl.solsoft.notes.model;

import java.time.LocalDate;

public class Note {
    private static int idCounter;
    private final int ID;
    private LocalDate creationDate;
    private String text;

    public Note(LocalDate creationDate) {
        this.creationDate = creationDate;
        ID = idCounter++;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getID() {
        return ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}