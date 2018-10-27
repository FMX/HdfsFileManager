package com.fmx.tool.hdfsfilemanager.app.action.menu;

import com.fmx.tool.hdfsfilemanager.app.HDFSBrowserWindow;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

/**
 */
public class DisconnectionAction extends Action {

    private static final Logger LOGGER = Logger.getLogger(DisconnectionAction.class);

    public DisconnectionAction() {
        super();
        this.setText("断开连接");
        this.setAccelerator(SWT.CTRL + SWT.SINGLE + 'D');
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        LOGGER.info("start to disconnection ");
        HDFSBrowserWindow app = HDFSBrowserWindow.GetApp();
        if (!app.isConnected()) {
            MessageBox messageBox = new MessageBox(Display.getCurrent().getActiveShell());
            messageBox.setMessage("未连接");
            messageBox.open();
            return;
        }
        app.disconnection();
    }
}
