package com.fmx.tool.hdfsfilemanager.app.action.operator;

import com.fmx.tool.hdfsfilemanager.app.treeviewer.HTreeViewer;
import com.fmx.tool.hdfsfilemanager.service.container.PathsContainer;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;

/**
 */
public class Prev extends Action {

    private static final Logger LOGGER = Logger.getLogger(Prev.class);

    private PathsContainer container = null;

    public Prev() {
        this(null);
    }

    public Prev(HTreeViewer treeViewer) {
        super();
        this.setText("前进");
        this.setToolTipText("前进");
//        this.setImageDescriptor();
        this.container = PathsContainer.getContainer();
    }
}
