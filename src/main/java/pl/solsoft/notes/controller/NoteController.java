package pl.solsoft.notes.controller;

import pl.solsoft.notes.model.Note;
import pl.solsoft.notes.model.NotesDB;
import pl.solsoft.notes.views.NoteView;
import pl.solsoft.notes.views.panel.NoteEdit;
import pl.solsoft.notes.views.panel.NotesDisplay;
import pl.solsoft.notes.views.panel.TopPanel;

import java.awt.*;
import java.time.LocalDate;

public final class NoteController {
    private static NoteController ourInstance = new NoteController();
    private NotesDB notesDB = new NotesDB();
    private NoteView noteView = new NoteView();

    private CardLayout cardLayout = noteView.getTopPanel().getCardLayout();
    private NoteEdit noteEdit = noteView.getTopPanel().getNoteEdit();
    private NotesDisplay notesDisplay = noteView.getTopPanel().getNotesDisplay();
    private TopPanel topPanel = noteView.getTopPanel();

    private LocalDate noteDate;
    private Note currentNote;

    public static NoteController getInstance() {
        return ourInstance;
    }

    public void showNotesEvent(String date) {
        noteView.setVisible(true);
        noteView.setTitle("Note " + date);

        noteDate = LocalDate.parse(date);

        if (notesDB.getNoteListByDate(noteDate) == null) {
            newNote();
        } else {
            notesDisplay.onNoteAdded(notesDB.getNoteListByDate(noteDate));
            cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
        }
    }

    public void saveNote() {
        if (currentNote.isRecentlyCreated()) {
            notesDB.addNote(noteDate, currentNote);
        }

        currentNote.setText(noteEdit.getText());

        notesDisplay.onNoteAdded(notesDB.getNoteListByDate(noteDate));
        cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
    }

    public void newNote() {
        currentNote = new Note();
        cardLayout.show(topPanel, noteEdit.getClass().getSimpleName());
        noteEdit.setText("");
    }

    public void editNote(Note note) {
        currentNote = note;
        currentNote.setRecentlyCreated(false);
        cardLayout.show(topPanel, noteEdit.getClass().getSimpleName());
        noteEdit.setText(note.getText());
    }
}