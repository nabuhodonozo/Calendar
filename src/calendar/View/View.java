package calendar.View;

import calendar.model.SkipButton;
import calendar.model.TextFieldDisplay;
import calendar.model.ViewSwitch;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    public View() {
        initUI();
    }

    private void initUI() {
        getContentPane().setLayout(
                new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS)
        );

        JPanel menuPanel = menuPanel();

        this.add(menuPanel);
        this.add(calenarDisplayPanel());

        setTitle("Calendar");
        setSize(1000, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void run(){
        EventQueue.invokeLater(() -> {
            View ex = new View();
            ex.setVisible(true);
        });
    }

    public JPanel menuPanel(){
        JPanel panel = new JPanel();

        panel.add(new SkipButton("previous"));
        panel.add(new JXDatePicker());
        panel.add(new SkipButton("next"));

        String[] bookTitles = new String[] {"Week", "Month"};

        JComboBox<String> bookList = new ViewSwitch(bookTitles);

        String selectedBook = (String) bookList.getSelectedItem();
        System.out.println("You seleted the book: " + selectedBook);

        panel.add(bookList);

        return panel;
    }

    public JPanel calenarDisplayPanel(){
        JPanel panel = new JPanel();


        JTextField tf = new TextFieldDisplay();

        tf.setColumns(20);

        panel.add(tf);
        return panel;
    }
}