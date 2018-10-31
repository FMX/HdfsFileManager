package com.fmx.tool.hdfsfilemanager.newapp.mainWindow;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Ethan.F on 2018/10/29 12:14 AM
 */
public class HdfsFileManagerController implements Initializable {

    @FXML
    Button forward;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("asd");
        forward.setOnMouseClicked(event -> {
            System.out.println("asdc");
        });
    }
}
