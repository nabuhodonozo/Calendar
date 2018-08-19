package pl.solsoft.notes.interfaces;

import pl.solsoft.notes.model.Note;

public interface DatabaseInterface {
    void saveNote(Note note);

    void removeNote(int id);

    Note getNoteById(int id);
}
