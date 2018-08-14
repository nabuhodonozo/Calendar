package pl.solsoft.notes.services;

import pl.solsoft.notes.model.Note;
import pl.solsoft.notes.model.NotesDB;
import pl.solsoft.notes.views.NoteView;
import pl.solsoft.notes.views.panel.NoteEdit;
import pl.solsoft.notes.views.panel.NotesDisplay;
import pl.solsoft.notes.views.panel.TopPanel;

import java.awt.*;
import java.time.LocalDate;

public final class NotesService {
    private static NotesService ourInstance = new NotesService();
    private NotesDB notesDB = new NotesDB();
    private NoteView noteView = new NoteView();

    private CardLayout cardLayout = noteView.getTopPanel().getCardLayout();
    private NoteEdit noteEdit = noteView.getTopPanel().getNoteEdit();
    private NotesDisplay notesDisplay = noteView.getTopPanel().getNotesDisplay();
    private TopPanel topPanel = noteView.getTopPanel();

    private LocalDate noteDate;
    private Note currentNote;

    public static NotesService getInstance() {
        return ourInstance;
    }

    public void showNotesEvent(String date) {
        noteView.setVisible(true);
        noteView.setTitle("Note " + date);

        noteDate = LocalDate.parse(date);

        if (notesDB.getNoteListByDate(noteDate) == null) {
            newNote();
        } else {
            showNoteDisplayPanel();
        }
    }

    public void saveNote() {
        if (currentNote.isRecentlyCreated()) {
            notesDB.addNote(noteDate, currentNote);
        }

        currentNote.setText(noteEdit.getText());
        showNoteDisplayPanel();
    }


    public void newNote() {
        currentNote = new Note();
        showEditNotePanel();
        noteEdit.setText("");
    }

    public void editNote(Note note) {
        currentNote = note;
        currentNote.setRecentlyCreated(false);
        showEditNotePanel();
        noteEdit.setText(note.getText());
    }

    private void showEditNotePanel() {
        cardLayout.show(topPanel, noteEdit.getClass().getSimpleName());
    }

    private void showNoteDisplayPanel() {
        notesDisplay.onNoteAdded(notesDB.getNoteListByDate(noteDate));
        cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
    }
}