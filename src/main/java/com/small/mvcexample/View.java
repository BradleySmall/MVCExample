package com.small.mvcexample;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class View implements DataViewer {
    private static final Logger LOGGER = Logger.getLogger((Logger.GLOBAL_LOGGER_NAME));
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
        LOGGER.log(Level.INFO, data);
    }
}
