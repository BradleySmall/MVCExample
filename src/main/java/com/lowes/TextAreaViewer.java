package com.lowes;

import javax.swing.*;

public class TextAreaViewer extends JTextArea implements DataViewer {
    public TextAreaViewer(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    public void show(String data) {
        append(data + "\n");
    }
}
