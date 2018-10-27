package com.fmx.tool.hdfsfilemanager.app.action.operator;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Cut extends Action {

    public Cut() {
        this.setEnabled(true);
        this.setText("剪切");
        this.setAccelerator(SWT.CTRL + 'X');
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
