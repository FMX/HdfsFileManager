package com.fmx.tool.hdfsfilemanager.app.treeviewer;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

/**
 */
public class HTreeLabelProvider implements ILabelProvider {

    @Override
    public Image getImage(Object o) {
        return null;
    }

    @Override
    public String getText(Object o) {
        HTreeNode parent = (HTreeNode) o;
        return parent.getName();
    }

    @Override
    public void addListener(ILabelProviderListener iLabelProviderListener) {
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean isLabelProperty(Object o, String s) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener iLabelProviderListener) {

    }
}
