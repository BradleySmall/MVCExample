package com.lowes;

import java.util.Objects;

public class View implements DataViewer {
    private final DataViewer dataViewer;

    View() {
        this(null);
    }
    View(DataViewer dataViewer) {
        this.dataViewer = Objects.requireNonNullElse(dataViewer, this);
    }

    public void showViewData(String data) {
        dataViewer.show(data);
    }

    @Override
    public void show(String data) {
        System.out.println(data);
    }
}
