package com.fmx.tool.hdfsfilemanager.app.action.operator;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Rename extends Action {

    public Rename() {
        this.setText("重命名");
        this.setEnabled(true);
        this.setAccelerator(SWT.CTRL + SWT.SHIFT + 'R');
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
