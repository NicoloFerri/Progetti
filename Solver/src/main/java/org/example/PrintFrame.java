package org.example;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PrintFrame {


    public static void start(){

        Frame frame = new Frame("La mia prima GUI con AWT");


        frame.setLayout(new BorderLayout());


        Button button = new Button("Cliccami!");


        TextArea textArea = new TextArea();
        textArea.setEditable(false);


        frame.add(button, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.append("Hai cliccato il pulsante!\n");
            }
        });


        frame.setSize(400, 300);
        frame.setVisible(true);


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
