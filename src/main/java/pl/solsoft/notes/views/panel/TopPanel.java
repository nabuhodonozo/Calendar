package pl.solsoft.notes.views.panel;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel {
    private CardLayout cardLayout = new CardLayout();
    private NotesDisplay notesDisplay = new NotesDisplay();
    private NoteEditPanel noteEditPanel = new NoteEditPanel();

    public TopPanel() {
        setLayout(cardLayout);
        add(notesDisplay, notesDisplay.getClass().getSimpleName());
        add(noteEditPanel, noteEditPanel.getClass().getSimpleName());
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public NoteEditPanel getNoteEditPanel() {
        return noteEditPanel;
    }

    public NotesDisplay getNotesDisplay() {
        return notesDisplay;
    }
}
