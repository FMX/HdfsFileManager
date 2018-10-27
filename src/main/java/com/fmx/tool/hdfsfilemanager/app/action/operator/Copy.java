package com.fmx.tool.hdfsfilemanager.app.action.operator;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Copy extends Action {

    public Copy() {
        this.setEnabled(true);
        this.setText("复制");
        this.setAccelerator(SWT.CTRL + 'C');
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
