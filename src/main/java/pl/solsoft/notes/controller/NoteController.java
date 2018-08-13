package pl.solsoft.notes.controller;

import pl.solsoft.notes.model.Note;
import pl.solsoft.notes.model.NotesDB;
import pl.solsoft.notes.views.NoteView;
import pl.solsoft.notes.views.panel.NoteEdit;
import pl.solsoft.notes.views.panel.NotesDisplay;
import pl.solsoft.notes.views.panel.TopPanel;

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

    private List<Note> noteList;
    private LocalDate noteDate;
    private Note currentlyEditedNote;

    public static NoteController getInstance() {
        return ourInstance;
    }

    public void showNotesEvent(String date) {
        noteView.setVisible(true);
        noteView.setTitle("Note " + date);

        noteDate = LocalDate.parse(date);
        noteList = notesDB.getNoteListByDate(noteDate);

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

        if (currentlyEditedNote.isRecentlyCreated()) {
            noteList.add(currentlyEditedNote);
        }

        currentlyEditedNote.setText(noteEdit.getText());

        notesDisplay.onNoteAdded(noteList);
        cardLayout.show(topPanel, notesDisplay.getClass().getSimpleName());
    }

    public void newNote() {
        currentlyEditedNote = new Note();
        cardLayout.show(topPanel, noteEdit.getClass().getSimpleName());
        noteEdit.setText("");
    }

    public void editNote(Note note) {
        currentlyEditedNote = note;
        currentlyEditedNote.setRecentlyCreated(false);
        cardLayout.show(topPanel, noteEdit.getClass().getSimpleName());
        noteEdit.setText(note.getText());
    }
}