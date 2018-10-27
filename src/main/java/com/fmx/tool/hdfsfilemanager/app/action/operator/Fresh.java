package com.fmx.tool.hdfsfilemanager.app.action.operator;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Fresh extends Action {

    public Fresh() {
        super();
        this.setText("刷新");
        this.setEnabled(true);
        this.setAccelerator(SWT.F5);
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
