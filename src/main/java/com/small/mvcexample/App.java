package com.small.mvcexample;

import javax.swing.*;

public class App extends JFrame {
    Controller controller;

    private final TextAreaViewer textArea = new TextAreaViewer(5, 40);
    private final TextAreaObserver textAreaObserver1 = new TextAreaObserver(5, 40);
    private final TextAreaObserver textAreaObserver2 = new TextAreaObserver(5, 40);
    private final JButton buttonKillObserver = new JButton("Kill Observer 1");
    private final JButton buttonAddObserver = new JButton("Add Observer 1");
    private final JPanel buttonPanel = new JPanel();
    private final JScrollPane scrollPane2 = new JScrollPane(textAreaObserver2);
    private final JScrollPane scrollPane1 = new JScrollPane(textAreaObserver1);
    private final JScrollPane scrollPane = new JScrollPane(textArea);

    App() {
        initGui();
    }

    private void initGui() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        textArea.setEditable(false);
        panel.add(new JLabel("View"));
        panel.add(scrollPane);

        textAreaObserver1.setEditable(false);
        panel.add(new JLabel("Observer 1"));
        panel.add(scrollPane1);

        textAreaObserver2.setEditable(false);
        panel.add(new JLabel("Observer 2"));
        panel.add(scrollPane2);

        buttonKillObserver.addActionListener(e->kill());
        buttonPanel.add(buttonKillObserver);
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
