package calendar.View;

import calendar.model.SkipButton;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    public View() {
        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();


        panel.add(new SkipButton("left"));
        panel.add(new JXDatePicker());
        panel.add(new SkipButton("right"));

        String[] bookTitles = new String[] {"Week, Month"};

        JComboBox<String> bookList = new JComboBox<>(bookTitles);


        String selectedBook = (String) bookList.getSelectedItem();
        System.out.println("You seleted the book: " + selectedBook);

        panel.add(bookList);


        this.getContentPane().add(panel);
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
/*
    public JPanel menuPanel(){

        return
    }

    public Jpanel calenarDisplayPanel(){

    }*/
}