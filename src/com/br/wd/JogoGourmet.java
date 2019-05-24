package com.br.wd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoGourmet extends JFrame {
    private JPanel mainPanel;
    private JButton okButton;
    private Flow flow = new Flow();

    public JogoGourmet() throws HeadlessException {
        add(mainPanel);
        setTitle("Jogo Gourmet");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                flow.start();
            }
        });
    }
}
