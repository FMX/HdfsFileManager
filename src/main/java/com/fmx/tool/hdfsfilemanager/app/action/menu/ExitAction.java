package com.fmx.tool.hdfsfilemanager.app.action.menu;

import org.eclipse.jface.action.Action;

/**
 */
public class ExitAction extends Action {

    public ExitAction() {
        super();
        this.setText("退出");
        this.setToolTipText("退出");
        this.setEnabled(true);
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
