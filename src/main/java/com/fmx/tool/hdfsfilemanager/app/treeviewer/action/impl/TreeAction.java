package com.fmx.tool.hdfsfilemanager.app.treeviewer.action.impl;

import com.fmx.tool.hdfsfilemanager.app.HDFSBrowserWindow;
import com.fmx.tool.hdfsfilemanager.app.treeviewer.HTreeViewer;
import com.fmx.tool.hdfsfilemanager.service.core.impl.HDFSCore;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;

/**
 */
public class TreeAction extends Action {

    private static final Logger LOGGER = Logger.getLogger(TreeAction.class);

    private HTreeViewer tree;
    private HDFSCore hdfsCore;

    public TreeAction(HTreeViewer treeViewer, HDFSCore hdfsCore) {
        super();
        this.tree = treeViewer;
        this.hdfsCore = hdfsCore;
        this.hdfsCore = HDFSBrowserWindow.GetApp().getHdfsCore();
    }
}
