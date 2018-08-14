package pl.solsoft.notes.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesDB {
    private Map<LocalDate, List<Note>> notesMap = new HashMap<>();

    public Map<LocalDate, List<Note>> getNotesMap() {
        return notesMap;
    }

    public List<Note> getNoteListByDate(LocalDate localDate) {
        return notesMap.get(localDate);
    }
}
