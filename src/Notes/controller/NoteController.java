package Notes.controller;

import Notes.views.NoteView;

public final class NoteController {
    private static NoteController ourInstance = new NoteController();

    public static NoteController getInstance() {
        return ourInstance;
    }

    public void createNote() {
        NoteView noteView = new NoteView();
        noteView.setVisible(true);
    }
}
