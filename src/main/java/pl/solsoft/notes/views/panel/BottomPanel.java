package pl.solsoft.notes.views.panel;

import pl.solsoft.notes.views.component.NewButton;
import pl.solsoft.notes.views.component.SaveButton;

import javax.swing.*;

public class BottomPanel extends JPanel {
    private NewButton newButton = new NewButton();
    private SaveButton saveButton = new SaveButton();

    public BottomPanel() {
        add(newButton);
        add(saveButton);
    }
}
