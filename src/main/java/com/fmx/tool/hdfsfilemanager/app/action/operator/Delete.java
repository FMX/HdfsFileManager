package com.fmx.tool.hdfsfilemanager.app.action.operator;

import com.fmx.tool.hdfsfilemanager.app.treeviewer.HTreeViewer;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Delete extends Action {

    private static final Logger LOGGER = Logger.getLogger(Delete.class);

    public Delete() {
        this(null);
    }

    public Delete(HTreeViewer treeViewer) {
        super();
        this.setText("删除");
        this.setEnabled(true);
        this.setAccelerator(SWT.CTRL + SWT.SHIFT + 'D');
    }
}
