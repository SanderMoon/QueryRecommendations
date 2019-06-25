/**
 * @Authors:    Sander Moonemans (Radboud University) &
 *              Thom Theunissen (Avans university of applied sciences)
 *
 *
 */

package Vec2Rec.ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame {
    public JPanel mainPanel;
    public JTextField inputField;
    public JList wordList;
    private JButton searchButton;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public MainFrame(){
        setSize(500,500);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        Border border = BorderFactory.createLineBorder(Color.GRAY, 2);
        String title = "Vec2Rec";
        Border titleBorder = BorderFactory.createTitledBorder(title);
        mainPanel.setBorder(titleBorder);
        inputField.setBorder(border);
    }

    public JTextField getTextField(){
        return inputField;
    }

    public JList getScrollPane(){
        return wordList;
    }

    public JButton getSearchButton(){
        return searchButton;
    }



}
