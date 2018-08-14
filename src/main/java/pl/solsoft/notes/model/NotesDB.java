package pl.solsoft.notes.model;

import java.time.LocalDate;
import java.util.*;

public class NotesDB {
    private Map<LocalDate, List<Note>> notesMap = new HashMap<>();

    public Map<LocalDate, List<Note>> getNotesMap() {
        return notesMap;
    }

    public List<Note> getNoteListByDate(LocalDate localDate) {
        return notesMap.get(localDate);
    }

    public void addNote(LocalDate day, Note note) {
        List<Note> noteList = Optional.ofNullable(notesMap.get(day)).orElse(new ArrayList<>());

        noteList.add(note);

        notesMap.put(day, noteList);

    }
}




