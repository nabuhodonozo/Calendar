package pl.solsoft.notes.model;

import pl.solsoft.notes.interfaces.DatabaseInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotesDB implements DatabaseInterface {
    private List<Note> noteList = new ArrayList<>();

    public List<Note> getNoteListByDate(LocalDate localDate) {
        return noteList.stream()
                .filter(note -> note.getCreationDate().toString().equals(localDate.toString()))
                .collect(Collectors.toList());
    }

    public void saveNote(Note note) {
        if (noteList.contains(note)) {
            noteList.set(noteList.indexOf(note), note);
        } else {
            noteList.add(note);
        }
    }

    public void removeNote(int id) {
        noteList.remove(getNoteById(id));
    }

    public Note getNoteById(int id) {
        for (Note note : noteList) {
            if (note.getID() == id) {
                return note;
            }
        }
        return null;
    }
}




