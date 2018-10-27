package com.fmx.tool.hdfsfilemanager.app.action.operator;

import com.fmx.tool.hdfsfilemanager.app.treeviewer.HTreeViewer;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;

/**
 */
public class Home extends Action {

    private static final Logger LOGGER = Logger.getLogger(Home.class);

    public Home() {
        this(null);
    }

    public Home(HTreeViewer treeViewer) {
        super();
        this.setText("Home");
        this.setEnabled(true);
        this.setToolTipText("家目录");
//        this.setImageDescriptor();
    }

}
