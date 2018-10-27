package com.fmx.tool.hdfsfilemanager.app.action.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class AboutAction extends Action {

    public AboutAction() {
        super();
        this.setText("About...");
        this.setAccelerator(SWT.SHIFT + SWT.ALT + 'A');
        this.setEnabled(true);
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
