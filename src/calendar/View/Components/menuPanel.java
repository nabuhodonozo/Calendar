package calendar.View.Components;

import calendar.model.SkipButton;
import calendar.model.ViewSwitch;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;

public class menuPanel extends JPanel {

    public menuPanel() {
        super();
        create();
    }

   private void create(){
        this.add(new SkipButton("previous"));
        this.add(new JXDatePicker());
        this.add(new SkipButton("next"));

        String[] bookTitles = new String[] {"Week", "Month"};

        JComboBox<String> bookList = new ViewSwitch(bookTitles);

        String selectedBook = (String) bookList.getSelectedItem();
        System.out.println("You seleted the book: " + selectedBook);

        this.add(bookList);
    }
}
