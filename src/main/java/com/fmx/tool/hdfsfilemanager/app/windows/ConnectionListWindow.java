package com.fmx.tool.hdfsfilemanager.app.windows;

import com.fmx.tool.hdfsfilemanager.app.HDFSBrowserWindow;
import com.fmx.tool.hdfsfilemanager.app.action.menu.NewAction;
import com.fmx.tool.hdfsfilemanager.app.action.operator.Delete;
import com.fmx.tool.hdfsfilemanager.app.config.AppConfiguration;
import com.fmx.tool.hdfsfilemanager.service.container.ConnectionContainer;
import com.fmx.tool.hdfsfilemanager.util.ColorUtils;
import org.apache.log4j.Logger;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;


/**
 */
public class ConnectionListWindow extends ApplicationWindow {

    private static final Logger LOGGER = Logger.getLogger(ConnectionListWindow.class);

    private static final String BTN_CLEAR = "list_clear_btn";
    private static final String BTN_CONN = "list_conn_btn";
    private static final String BTN_CANCEL = "list_cancel_btn";
    private static final String BTN_DELETE = "list_delete_btn";


    private Shell parent;
    private Composite composite = null;
    private Table table = null;
    private TableViewer tableViewer = null;

    public ConnectionListWindow(Shell parentShell) {
        super(parentShell);
        this.parent = parentShell;
        this.parent.setBackground(ColorUtils.GetColor(ColorUtils.WHITE));
        //
        this.addToolBar(SWT.NONE);
    }

    @Override
    protected void configureShell(Shell shell) {
        super.configureShell(shell);
        shell.setSize(400, 300);
        shell.setText("连接列表");
    }

    @Override
    protected ToolBarManager createToolBarManager(int style) {
        LOGGER.info("create the toolbar for the windows");
        ToolBarManager toolBarManager = new ToolBarManager(style);
        toolBarManager.add(new NewAction());
        toolBarManager.add(new Delete());
        return toolBarManager;
    }

    @Override
    protected Control createContents(Composite parent) {
        LOGGER.info("create the content of the windows");
        this.composite = new Composite(parent, SWT.NONE);
        this.composite.setBackground(ColorUtils.GetColor(ColorUtils.WHITE));
        this.composite.setLayout(new GridLayout(5, true));
        //
        createTable(this.composite);
        createButtons(this.composite);
        return composite;
    }

    public void createTable(final Composite parent) {
        this.table = new Table(parent, SWT.FULL_SELECTION);
        this.table.setHeaderVisible(true);
        this.table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 5, 1));
        this.table.setTouchEnabled(true);
        String[] headers = new String[]{"选择", "IP地址", "端口号", "用户名"};
        for (String header : headers) {
            TableColumn tableColumn = new TableColumn(this.table, SWT.NONE);
            tableColumn.setText(header);
            tableColumn.pack();
        }
        //
        this.table.addPaintListener(new PaintListener() {
            @Override
            public void paintControl(PaintEvent paintEvent) {
                TableColumn[] columns = table.getColumns();
                int clientWidth = table.getBounds().width;
                for (int i = 0; i < columns.length; i++) {
                    columns[i].setWidth((clientWidth) / columns.length);
                }
            }
        });
        //
        ConnectionContainer connectionContainer = ConnectionContainer.GetConnectionContainer();
        for (ConnectionContainer.Connection connection : connectionContainer.getContainer()) {
            TableItem item = new TableItem(this.table, SWT.NONE);
            item.setText(new String[]{"", connection.getHost(), connection.getPort(), connection.getUser()});
        }
        //
        this.table.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                LOGGER.info("the cell is selection");
                Table table = (Table) selectionEvent.getSource();
                int count = table.getItemCount();
                for (int i = 0; i < count; i++) {
                    table.getItem(i).setText(0, "");
                }
                //
                TableItem tableItem = table.getSelection()[0];
                tableItem.setText(0, ">");
            }
        });
        //
        this.table.pack();
    }

    public void createButtons(Composite parent) {
        LOGGER.info("create the buttons ");
        GridData gridData = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
        for (int i = 0; i < 3; i++) {
            Label label = new Label(parent, SWT.NONE);
            label.setBackground(ColorUtils.GetColor(ColorUtils.WHITE));
            label.setLayoutData(gridData);
        }
        ConnListBtnAdater adater = new ConnListBtnAdater();
        //
        Button connction = new Button(parent, SWT.NONE);
        connction.setLayoutData(gridData);
        connction.setText("连接");
        connction.setData("id", BTN_CONN);
        connction.addSelectionListener(adater);
        //
        Button cancel = new Button(parent, SWT.NONE);
        cancel.setLayoutData(gridData);
        cancel.setText("取消");
        cancel.setData("id", BTN_CANCEL);
        cancel.addSelectionListener(adater);
    }

    public void connection() {
        HDFSBrowserWindow app = HDFSBrowserWindow.GetApp();
        if (app.isConnected()) {
            MessageBox box = new MessageBox(Display.getCurrent().getActiveShell());
            box.setMessage("连接中");
            box.open();
            return;
        }
        //
        TableItem tableItem = this.table.getSelection()[0];
        String host = tableItem.getText(1);
        String port = tableItem.getText(2);
        String user = tableItem.getText(3);
        AppConfiguration configuration = AppConfiguration.GetAppConfiguration();
        configuration.clear();
        configuration.setValue(AppConfiguration.HDFS_HOST, host);
        configuration.setValue(AppConfiguration.HDFS_PORT, port);
        configuration.setValue(AppConfiguration.HDFS_USER, user);
        app.connection();
        this.close();
    }

    public void cancel() {
        this.close();
    }

    public class ConnListBtnAdater extends SelectionAdapter {
        @Override
        public void widgetSelected(SelectionEvent selectionEvent) {
            Button button = (Button) selectionEvent.getSource();
            String id = (String) button.getData("id");
            switch (id) {
                case BTN_CONN:
                    connection();
                    break;
                case BTN_CANCEL:
                    cancel();
                    break;
            }
        }
    }


}
