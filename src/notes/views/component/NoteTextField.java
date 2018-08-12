package notes.views.component;

public class NoteTextField extends javax.swing.JTextField {
    public NoteTextField(String string) {
        super(string);
        setHorizontalAlignment(javax.swing.JTextField.CENTER);
        setEditable(false);
        setHighlighter(null);

        addActionListener(actionEvent ->);
    }
}