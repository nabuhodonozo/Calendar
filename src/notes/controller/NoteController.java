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
    private LocalDate noteDate;

    public static NoteController getInstance() {
        return ourInstance;
    }

    public void showNotesEvent(String date) {
        noteView.setVisible(true);
        noteView.setTitle("Note " + date);

        noteDate = LocalDate.parse(date);
        noteList = notesDB.getNotesMap().get(noteDate);

        if (noteList == null) {
            newNote();
        } else {
            notesDisplay.onNoteAdded(noteList);
            cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
        }
    }

    public void saveNote() {
        if (noteList == null) {
            noteList = new ArrayList<>();
            notesDB.getNotesMap().put(noteDate, noteList);
        }
        noteList.add(noteEdit.getText());


        cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
        notesDisplay.onNoteAdded(noteList);
    }

    public void newNote() {
        cardLayout.show(topPanel, noteEdit.getClass().getSimpleName());
        noteEdit.setText("");
    }
}