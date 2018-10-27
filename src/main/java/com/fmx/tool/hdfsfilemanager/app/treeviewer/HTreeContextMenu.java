package com.fmx.tool.hdfsfilemanager.app.treeviewer;

import com.fmx.tool.hdfsfilemanager.app.HDFSBrowserWindow;
import com.fmx.tool.hdfsfilemanager.app.treeviewer.action.Mkdir;
import com.fmx.tool.hdfsfilemanager.service.core.impl.HDFSCore;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;

/**
 */
public class HTreeContextMenu extends MenuManager {

    private static final Logger LOGGER = Logger.getLogger(HTreeContextMenu.class);

    private static volatile HTreeContextMenu contextMenu = null;
    private HTreeViewer treeViewer = null;
    private Mkdir mkdir;
    private HDFSCore hdfsCore = null;
    public HTreeContextMenu(HTreeViewer treeViewer) {
        super();
        this.treeViewer = treeViewer;
        this.hdfsCore = HDFSBrowserWindow.GetApp().getHdfsCore();
        mkdir = new Mkdir(treeViewer, hdfsCore);
        this.setRemoveAllWhenShown(true);
        this.addMenuListener(new HTreeMenuListen());
    }

    public static HTreeContextMenu getContextMenu(HTreeViewer treeViewer) {
        if (contextMenu == null) {
            synchronized (HTreeContextMenu.class) {
                if (contextMenu == null) {
                    contextMenu = new HTreeContextMenu(treeViewer);
                }
            }
        }
        return contextMenu;
    }

    public class HTreeMenuListen implements IMenuListener {

        @Override
        public void menuAboutToShow(IMenuManager iMenuManager) {
            System.out.print("create the context menu");
            add(mkdir);
        }
    }
}
