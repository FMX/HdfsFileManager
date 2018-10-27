package com.fmx.tool.hdfsfilemanager.app.treeviewer.action;

import com.fmx.tool.hdfsfilemanager.app.HDFSBrowserWindow;
import com.fmx.tool.hdfsfilemanager.app.treeviewer.HTreeViewer;
import com.fmx.tool.hdfsfilemanager.app.treeviewer.action.impl.TreeAction;
import com.fmx.tool.hdfsfilemanager.service.core.impl.HDFSCore;
import org.apache.log4j.Logger;
import org.eclipse.jface.dialogs.InputDialog;

/**
 */
public class Mkdir extends TreeAction {

    private static final Logger LOGGER = Logger.getLogger(Mkdir.class);


    public Mkdir(HTreeViewer treeViewer, HDFSCore hdfsCore) {
        super(treeViewer, hdfsCore);
        this.setText("新建文件夹");
        this.setEnabled(true);
    }

    @Override
    public void run() {
        //
        InputDialog dialog = new InputDialog(HDFSBrowserWindow.GetApp().getShell(), "创建文件", "请输入名称", "新建文件夹", null);
        dialog.open();
        String name = dialog.getValue();
    }
}
