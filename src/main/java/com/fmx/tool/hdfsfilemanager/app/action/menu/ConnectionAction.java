package com.fmx.tool.hdfsfilemanager.app.action.menu;

import com.fmx.tool.hdfsfilemanager.app.windows.ConnectionWindow;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;

/**
 */
public class ConnectionAction extends Action {

    public ConnectionAction() {
        super();
        this.setText("创建连接");
        this.setEnabled(true);
        this.setAccelerator(SWT.CTRL + SWT.SHIFT + 'C');
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        ConnectionWindow window = new ConnectionWindow(Display.getCurrent().getActiveShell());
        window.setBlockOnOpen(true);
        window.open();
    }
}
