/**
 * @Authors:    Sander Moonemans (Radboud University) &
 *              Thom Theunissen (Avans university of applied sciences)
 *
 *
 */

package Vec2Rec;

import Vec2Rec.ui.MainFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

public class FrameController {

    private MainFrame mainFrame;
    private JTextField inputField;
    private JList wordList;
    private String selectedWord;
    private String typedWord;

    public FrameController(){
        selectedWord = "";
        initComponents();
    }

    private void initComponents(){
        mainFrame = new MainFrame();
        inputField = mainFrame.getTextField();
        wordList = mainFrame.getScrollPane();
        wordList.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {
                if(wordList.getSelectedValue() != null){
                    String ieks = wordList.getSelectedValue().toString();
                    if(!selectedWord.equals(ieks)){
                       // System.out.println(ieks);
                        String sentence = inputField.getText().substring(0, inputField.getText().length() - typedWord.length());
                        selectedWord = ieks;

                        inputField.setText(sentence + selectedWord);
                    }
                }
            }
        });
        JButton searchButton = mainFrame.getSearchButton();
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                copyToClip();
            }
        });

    }

    private void copyToClip() {
        StringSelection selection = new StringSelection(inputField.getText());
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        try {
            URI uri = new URI("https://www.navigator.nl/");
            java.awt.Desktop.getDesktop().browse(uri);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        openWebPage();
    }

    private void openWebPage() {
    }

    public String getWord(){
        String[] words = inputField.getText().split(" ");
        typedWord = words[words.length - 1];
        typedWord.replaceAll(" ", "");
        return typedWord;
    }

    public void showMainFrame(){
        mainFrame.setVisible(true);
    }

    public void showResults(Collection<String> results){
        Object[] resultArray = results.toArray();
        wordList.setListData(resultArray);
    }



}
