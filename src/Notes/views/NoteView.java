package Notes.views;

import javax.swing.*;

public class NoteView extends JFrame {
    JTextPane jTextPane = new JTextPane();
    JPanel jPanel = new JPanel();
    JButton saveButton = new JButton("Save");
    JButton newButton = new JButton("New");

    public NoteView() {
        initUI();
    }

    private void initUI() {
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        //todo Has to show previous notes if none then show JTextPene
        add(jTextPane);
        add(jPanel);
        jPanel.add(saveButton);
        jPanel.add(newButton);


        setTitle("Calendar");
        setSize(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}