package com.fmx.tool.hdfsfilemanager.app.treeviewer;

import com.fmx.tool.hdfsfilemanager.app.HDFSBrowserWindow;
import com.fmx.tool.hdfsfilemanager.app.table.HTableViewer;
import com.fmx.tool.hdfsfilemanager.service.container.IndexContainer;
import com.fmx.tool.hdfsfilemanager.service.core.impl.HDFSCore;
import org.apache.log4j.Logger;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TreeItem;

/**
 */
public class HTreeViewer extends TreeViewer {

    private static final Logger LOGGER = Logger.getLogger(HTreeViewer.class);

    private Composite parent;
    private int style;
    private HDFSCore hdfsCore = null;
    private HTableViewer table;
    private IndexContainer container = null;

    public HTreeViewer(Composite parent, int style, HDFSCore hdfsCore) {
        super(parent, style);
        this.parent = parent;
        this.style = style;
        //
        this.table = HDFSBrowserWindow.GetApp().getTable();
        container = IndexContainer.GetContainer();
        //
        this.hdfsCore = hdfsCore;
        this.getControl().setBounds(parent.getBounds());
        createContent();
    }

    public void createContent() {
        LOGGER.info("create the content of the tree view");
        this.setContentProvider(new HTreeContentProvider(hdfsCore));
        this.setLabelProvider(new HTreeLabelProvider());
        this.setInput("HDFS浏览框");
        this.getControl().setMenu(HTreeContextMenu.getContextMenu(this).createContextMenu(this.getControl()));
//        this.getTree().addMouseListener(new HTreeMouseListern());
    }

    @Override
    protected void handleTreeExpand(TreeEvent event) {
        TreeItem parent = (TreeItem) event.item;
        HTreeNode node = (HTreeNode) parent.getData();
        ITreeContentProvider contentProvider = (ITreeContentProvider) this.getContentProvider();
        ILabelProvider labelProvider = (ILabelProvider) this.getLabelProvider();
        if (contentProvider.hasChildren(node) && node.isNeedChange()) {
            node.setNeedChange(false);
            HTreeNode[] children = (HTreeNode[]) contentProvider.getChildren(node);
            parent.setItemCount(0);
            for (HTreeNode child : children) {
                TreeItem treeItem = new TreeItem(parent, SWT.NONE);
                treeItem.setText(labelProvider.getText(child));
                treeItem.setImage(labelProvider.getImage(child));
                child.setParentTreeItem(parent);
                treeItem.setData(child);
                treeItem.setItemCount(1);
                container.addIndex(treeItem);
            }
        }
    }

    @Override
    protected void handleSelect(SelectionEvent event) {
        LOGGER.info("select action");
        if (event.stateMask == SWT.BUTTON1) {
            LOGGER.info("change content of table");
            TreeItem item = (TreeItem) event.item;
            HTreeNode node = (HTreeNode) item.getData();
            String path = node.getPath();
            table.show(node);
        }
    }
}
