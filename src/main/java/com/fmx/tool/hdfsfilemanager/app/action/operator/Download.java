package com.fmx.tool.hdfsfilemanager.app.action.operator;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Download extends Action {

    public Download() {
        super();
        this.setText("下载");
        this.setEnabled(true);
        this.setAccelerator(SWT.CTRL + 'D');
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
