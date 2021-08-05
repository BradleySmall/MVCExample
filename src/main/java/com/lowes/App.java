package com.lowes;

import javax.swing.*;

public class App extends JFrame {
    TextAreaViewer textArea;
    TextAreaObserver textAreaObserver1;
    TextAreaObserver textAreaObserver2;
    Controller controller;
    JButton buttonKillObserver;
    JButton buttonAddObserver;

    App() {
        initGui();
    }

    private void initGui() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        JPanel panel = new JPanel();

        textArea = new TextAreaViewer(5, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        panel.add(scrollPane);

        textAreaObserver1 = new TextAreaObserver(5, 40);
        JScrollPane scrollPane1 = new JScrollPane(textAreaObserver1);
        textAreaObserver1.setEditable(false);
        panel.add(scrollPane1);

        textAreaObserver2 = new TextAreaObserver(5, 40);
        JScrollPane scrollPane2 = new JScrollPane(textAreaObserver2);
        textAreaObserver2.setEditable(false);
        panel.add(scrollPane2);

        JPanel buttonPanel = new JPanel();
        buttonKillObserver = new JButton("Kill Observer 1");
        buttonKillObserver.addActionListener(e->kill());
        buttonPanel.add(buttonKillObserver);
        buttonAddObserver = new JButton("Add Observer 1");
        buttonAddObserver.addActionListener(e->add());
        buttonPanel.add(buttonAddObserver);
        panel.add(buttonPanel);

        add(panel);
        setVisible(true);
    }

    private void add() {
        controller.addObserver(textAreaObserver1);
        buttonAddObserver.setEnabled(false);
        buttonKillObserver.setEnabled(true);
    }

    private void kill() {
        controller.removeObserver(textAreaObserver1);
        buttonAddObserver.setEnabled(true);
        buttonKillObserver.setEnabled(false);
    }

    public static void main(String[] args) {
        App app = new App();
        Model model = new Model();
        View view = new View(app.textArea);

        app.controller = new Controller(model, view);
        app.controller.addObserver(app.textAreaObserver1);
        app.controller.addObserver(app.textAreaObserver2);

        Timer timer = new Timer(1000,e-> app.controller.checkNewData());
        timer.start();

    }
}
