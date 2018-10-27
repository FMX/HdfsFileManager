package com.fmx.tool.hdfsfilemanager.app.action.operator;

import org.eclipse.jface.action.Action;
import org.eclipse.swt.SWT;

/**
 */
public class Upload extends Action {

    public Upload() {
        super();
        this.setText("上传");
        this.setEnabled(true);
        this.setAccelerator(SWT.CTRL + 'U');
//        this.setImageDescriptor();
    }

    @Override
    public void run() {
        super.run();
    }
}
