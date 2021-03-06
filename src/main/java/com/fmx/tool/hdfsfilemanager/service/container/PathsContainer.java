package com.fmx.tool.hdfsfilemanager.service.container;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.TreeItem;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class PathsContainer {

    private static final Logger LOGGER = Logger.getLogger(PathsContainer.class);

    public static volatile PathsContainer CONTAINER = null;
    private List<TreeItem> container = null;
    private int index;
    private PathsContainer() {
        container = new ArrayList<>(20);
        index = 0;
    }

    public static PathsContainer getContainer() {
        if (CONTAINER == null) {
            synchronized (PathsContainer.class) {
                if (CONTAINER == null) {
                    CONTAINER = new PathsContainer();
                }
            }
        }
        return CONTAINER;
    }

    public synchronized void add(TreeItem node) {
        container.add(node);
        index = container.size() - 1;
    }

    public synchronized TreeItem back() {
        index--;
        if (index < 0) {
            index = 0;
        }
        return container.get(index);
    }

    public synchronized TreeItem prev() {
        index++;
        if (index >= container.size()) {
            index = container.size() - 1;
        }
        return container.get(index);
    }

    public void close() {
        this.container.clear();
    }
}
