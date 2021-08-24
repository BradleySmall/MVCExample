package com.small.mvcexample;

import javax.swing.*;

public class TextAreaObserver extends JTextArea implements Observer {
    public TextAreaObserver(int rows, int columns) {
        super(rows, columns);
    }

    @Override
    public void update(Object data) {
        append(data + "\n");
    }
}
