package com.fmx.tool.hdfsfilemanager.app.action.operator;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Property extends Action {

    public Property() {
        super();
        this.setText("属性");
        this.setEnabled(true);
        this.setAccelerator(SWT.CTRL + 'P');
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
