package pl.solsoft.notes.services;

import pl.solsoft.notes.interfaces.DatabaseInterface;
import pl.solsoft.notes.model.Note;
import pl.solsoft.notes.model.NotesDB;
import pl.solsoft.notes.views.NoteView;
import pl.solsoft.notes.views.panel.NoteEditPanel;
import pl.solsoft.notes.views.panel.NotesDisplay;
import pl.solsoft.notes.views.panel.TopPanel;

import java.awt.*;
import java.time.LocalDate;

public final class NotesService implements DatabaseInterface {
    private static NotesService ourInstance = new NotesService();
    private NotesDB notesDB = new NotesDB();
    private NoteView noteView = new NoteView();

    private CardLayout cardLayout = noteView.getTopPanel().getCardLayout();
    private NoteEditPanel noteEditPanel = noteView.getTopPanel().getNoteEditPanel();
    private NotesDisplay notesDisplay = noteView.getTopPanel().getNotesDisplay();
    private TopPanel topPanel = noteView.getTopPanel();

    private LocalDate noteDate;

    public static NotesService getInstance() {
        return ourInstance;
    }

    public void showNotesEvent(String date) {
        noteView.setVisible(true);
        noteView.setTitle("Note " + date);

        noteDate = LocalDate.parse(date);

        if (notesDB.getNoteListByDate(noteDate).isEmpty()) {
            newNote();
        } else {
            showNoteDisplayPanel();
        }
    }

    public void newNote() {
        noteEditPanel.setNote(new Note(noteDate));
        showEditNotePanel();
    }

    public void saveNoteEvent() {
        saveNote(noteEditPanel.getNote());
    }

    public void editNoteEvent(int id) {
        noteEditPanel.setNote(notesDB.getNoteById(id));
        showEditNotePanel();
    }

    @Override
    public Note getNoteById(int id) {
        return null;
    }

    @Override
    public void removeNote(int noteID) {
        notesDB.removeNote(noteID);
        showNoteDisplayPanel();
    }

    @Override
    public void saveNote(Note note) {
        notesDB.saveNote(note);
        noteEditPanel.getNote().setText(noteEditPanel.getText());
        showNoteDisplayPanel();
    }

    private void showEditNotePanel() {
        cardLayout.show(topPanel, noteEditPanel.getClass().getSimpleName());
    }

    private void showNoteDisplayPanel() {
        notesDisplay.onNoteAdded(notesDB.getNoteListByDate(noteDate));
        cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
    }


}