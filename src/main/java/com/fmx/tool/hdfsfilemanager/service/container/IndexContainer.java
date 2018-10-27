package com.fmx.tool.hdfsfilemanager.service.container;

import com.fmx.tool.hdfsfilemanager.app.config.AppConfiguration;
import com.fmx.tool.hdfsfilemanager.app.treeviewer.HTreeNode;
import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.TreeItem;

import java.util.HashMap;
import java.util.Map;

/**
 */
public class IndexContainer {

    private static final Logger LOGGER = Logger.getLogger(IndexContainer.class);

    private static volatile IndexContainer CONTAINER = null;
    private Map<String, TreeItem> container = null;
    private AppConfiguration configuration = null;
    private IndexContainer() {
        container = new HashMap<>();
        configuration = AppConfiguration.GetAppConfiguration();
    }

    public static IndexContainer GetContainer() {
        if (CONTAINER == null) {
            synchronized (IndexContainer.class) {
                if (CONTAINER == null) {
                    CONTAINER = new IndexContainer();
                }
            }
        }
        return CONTAINER;
    }

    public TreeItem[] search(String regex) {
        return null;
    }

    public TreeItem get(String path) {
        String hdfsPath = null;
        if (!path.startsWith("hdfs://")) {
            String prefix = "hdfs://" + configuration.getHdfsHost() + ":" + configuration.getHdfsPort();
            if (!path.startsWith("/")) {
                prefix = prefix + "/";
            }
            hdfsPath = prefix + path;
        }
        //
        if (container.containsKey(hdfsPath)) {
            return container.get(hdfsPath);
        }
        return null;
    }

    public synchronized void addIndex(TreeItem item) {
        if (item == null) {
            return;
        }
        HTreeNode node = (HTreeNode) item.getData();
        if (node == null) {
            return;
        }
        String key = node.getPath();
        if (key == null || key.isEmpty()) {
            return;
        }
        //make sure that the key is not end with char /
        while (key.endsWith("/")) {
            key = key.substring(0, key.length() - 2);
        }
        container.put(key, item);
    }

    public void close() {
        container.clear();
        System.gc();
    }
}
