package notes.views;

import notes.views.panel.BottomPanel;
import notes.views.panel.TopPanel;

import javax.swing.*;

public class NoteView extends JFrame {
    private BottomPanel bottomPanel = new BottomPanel();
    private TopPanel topPanel = new TopPanel();

    public NoteView() {
        initUI();
    }

    private void initUI() {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        add(topPanel);
        add(bottomPanel);

        setTitle("Note");
        setSize(200, 200);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public TopPanel getTopPanel() {
        return topPanel;
    }
}