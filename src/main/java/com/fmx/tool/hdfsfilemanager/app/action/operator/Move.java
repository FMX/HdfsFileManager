package com.fmx.tool.hdfsfilemanager.app.action.operator;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Move extends Action {

    public Move() {
        super();
        this.setText("移动");
        this.setAccelerator(SWT.CTRL + SWT.SHIFT + 'M');
        this.setEnabled(true);
    }

    @Override
    public void run() {
        super.run();
    }
}
