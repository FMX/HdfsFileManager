package com.fmx.tool.hdfsfilemanager.app.treeviewer;

import com.fmx.tool.hdfsfilemanager.app.config.AppConfiguration;
import org.apache.log4j.Logger;

/**
 */
public class HTreeRootNode extends HTreeNode {

    private static final Logger LOGGER = Logger.getLogger(HTreeRootNode.class);

    private static volatile HTreeRootNode ROOT = null;

    private HTreeRootNode() {
        this.name = "我的电脑";
        this.path = AppConfiguration.GetAppConfiguration().getHDFSUri() + "/";
        this.parent = null;
    }

    public static HTreeRootNode GetRootNode() {
        if (ROOT == null) {
            synchronized (HTreeRootNode.class) {
                if (ROOT == null) {
                    ROOT = new HTreeRootNode();
                }
            }
        }
        return ROOT;
    }
}
