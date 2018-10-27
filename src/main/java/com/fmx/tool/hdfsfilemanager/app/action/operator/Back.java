package com.fmx.tool.hdfsfilemanager.app.action.operator;

import com.fmx.tool.hdfsfilemanager.app.treeviewer.HTreeViewer;
import com.fmx.tool.hdfsfilemanager.service.container.PathsContainer;
import org.eclipse.jface.action.Action;

/**
 */
public class Back extends Action {

    private PathsContainer container = null;

    public Back() {
        this(null);
    }

    public Back(HTreeViewer treeViewer) {
        super();
        this.setText("后退");
        this.setToolTipText("后退");
        this.setEnabled(true);
//        this.setImageDescriptor();
//        container=PathsContainer.getContainer();
    }
}
