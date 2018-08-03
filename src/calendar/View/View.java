package calendar.View;

import calendar.View.Components.menuPanel;
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

        JPanel menuPanel = new calendar.View.Components.menuPanel();


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


    public JPanel calenarDisplayPanel(){
        JPanel panel = new JPanel();


        JTextField tf = new TextFieldDisplay();

        tf.setColumns(20);

        panel.add(tf);
        return panel;
    }
}