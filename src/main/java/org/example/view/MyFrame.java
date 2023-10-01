package org.example.view;

import org.example.controller.CreateBaseIngredients;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFrame extends JFrame {
    private final Path filePath; // The path to the file you want to delete

    public MyFrame() {
        filePath = Paths.get("C:\\Users\\Юлия\\Desktop\\Костя Документы\\projects\\WhatsForDinner\\src\\main\\resources\\baseIngredients");
        JFrame jfrm = new JFrame("JTextFieldDemo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfrm.setSize(new Dimension(300, 120));

        Button delete = new Button("delete");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Files.deleteIfExists(filePath);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });


        jfrm.add(delete);
        jfrm.setVisible(true);
    }

    public static void main(String[] args) {

        CreateBaseIngredients createBaseIngredients = new CreateBaseIngredients();
        createBaseIngredients.initialiseBaseIngredients();

        SwingUtilities.invokeLater(() -> {
            MyFrame jfrm = new MyFrame();
        });
    }
}
