package notes.views.panel;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class NotesDisplay extends JPanel {
    private GridLayout gridLayout = new GridLayout();

    public NotesDisplay() {
        setLayout(gridLayout);
    }

    public void onNoteAdded(List<String> noteList) {
        removeAll();

        int dimensionParameter = (int) Math.floor(Math.sqrt(noteList.size())) + 1;

        gridLayout.setColumns(dimensionParameter);
        gridLayout.setRows(dimensionParameter);

        for (String string : noteList) {
            JTextField tf = new JTextField();
            tf.setText(string);
            tf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            tf.setEditable(false);
            tf.setHighlighter(null);
            add(tf);
        }
    }
}