package notes.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotesDB {
    private Map<LocalDate, List<StringBuilder>> notesMap = new HashMap<>();

    public Map<LocalDate, List<String>> getNotesMap() {
        return notesMap;
    }
}
