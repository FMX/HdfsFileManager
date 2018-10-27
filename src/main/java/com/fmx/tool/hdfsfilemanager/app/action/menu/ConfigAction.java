package com.fmx.tool.hdfsfilemanager.app.action.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class ConfigAction extends Action {

    public ConfigAction() {
        super();
        this.setText("Config");
        this.setAccelerator(SWT.SHIFT + SWT.ALT + 'c');
        this.setEnabled(true);
    }

    @Override
    public void run() {
        super.run();
    }
}
