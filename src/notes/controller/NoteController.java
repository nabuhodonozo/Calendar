package notes.controller;

import notes.model.NotesDB;
import notes.views.NoteView;
import notes.views.panel.NoteEdit;
import notes.views.panel.NotesDisplay;
import notes.views.panel.TopPanel;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class NoteController {
    private static NoteController ourInstance = new NoteController();
    private NotesDB notesDB = new NotesDB();
    private NoteView noteView = new NoteView();

    private CardLayout cardLayout = noteView.getTopPanel().getCardLayout();
    private NoteEdit noteEdit = noteView.getTopPanel().getNoteEdit();
    private NotesDisplay notesDisplay = noteView.getTopPanel().getNotesDisplay();
    private TopPanel topPanel = noteView.getTopPanel();

    private List<String> noteList;

    public static NoteController getInstance() {
        return ourInstance;
    }

    public void showNotesEvent(String date) {
        noteView.setVisible(true);
        noteView.setTitle("Note " + date);
        noteList = notesDB.getNotesMap().get(LocalDate.parse(date));

        if (noteList == null) {
            noteList = new ArrayList<String>();
            notesDB.getNotesMap().put(LocalDate.parse(date), noteList);
            newNote();
        } else {
            notesDisplay.onNoteAdded(noteList);
            cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
        }
    }

    public void saveNote() {
        noteList.add(noteEdit.getText());
        notesDisplay.onNoteAdded(noteList);
        cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
    }

    public void newNote() {
        cardLayout.show(topPanel, noteEdit.getClass().getSimpleName());
        noteEdit.setText("");
    }

/*    private void actionBasedOnNotesList(List<String> notesList) {
        if (notesList.isEmpty()) {
            cardLayout.show(topPanel, noteEdit.getClass().getSimpleName());
        } else {
            cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
        }
    }*/
}
