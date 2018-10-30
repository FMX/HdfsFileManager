package com.fmx.tool.hdfsfilemanager.newapp;/**
 * Created by Ethan.F on 2018/10/28 10:53 PM
 */

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HdfsFileManager extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("HdfsFileManager");

        Parent root = FXMLLoader.load(getClass().getResource("/mainwindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setResizable(false);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
