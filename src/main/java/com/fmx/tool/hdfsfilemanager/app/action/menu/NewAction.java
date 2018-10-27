package com.fmx.tool.hdfsfilemanager.app.action.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class NewAction extends Action {

    public NewAction() {
        super();
        this.setText("新建");
        this.setAccelerator(SWT.SHIFT + SWT.ALT + 'N');
        this.setEnabled(true);
    }

    @Override
    public void run() {
        super.run();
    }
}
