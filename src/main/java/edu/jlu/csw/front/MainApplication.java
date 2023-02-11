package edu.jlu.csw.front;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * @author 10186
 */
public class MainApplication extends Application {
    @Override
    public void start(Stage stage) {
        AnchorPane an=new AnchorPane();
        an.setStyle("-fx-background-color: #f0f0f0");

        TabPane tabPane=new TabPane();
        tabPane.setStyle("-fx-background-color: #FFFFFF");
        //所有Tab都不能关闭
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab commonTab=new Tab("常规"), seniorTab=new Tab("高级"),optionTab=new Tab("选项"),notesTab=new Tab("注释");
        tabPane.getTabs().addAll(commonTab,seniorTab,optionTab,notesTab);


        setTabs(commonTab, seniorTab, optionTab, notesTab);

        Button onBtn=new Button("确定"),cancelBtn=new Button("取消"),previewPictureBtn=new Button("预览图片");

        an.getChildren().addAll(tabPane,onBtn,cancelBtn,previewPictureBtn);

        setAnchorPane(tabPane, onBtn, cancelBtn, previewPictureBtn);

        Scene scene=new Scene(an);
        stage.setScene(scene);
        stage.setTitle("锁图");
//        FontIcon icon=new FontIcon("fa-key");/*fa-lock;fa-unlock-alt*/
        stage.setWidth(466.5);
        stage.setHeight(425);
        //设置不可改变窗口大小
        stage.setResizable(false);
        stage.show();
    }

    /**
     * 设置四个Tab内部的结构
     */
    private void setTabs(Tab commonTab, Tab seniorTab, Tab optionTab, Tab notesTab) {
        AnchorPane commonAnchorPane=new AnchorPane(),seniorAnchorPane=new AnchorPane(),optionAnchorPane=new AnchorPane(), noteAnchorPane=new AnchorPane();
        commonTab.setContent(commonAnchorPane);
        seniorTab.setContent(seniorAnchorPane);
        optionTab.setContent(optionAnchorPane);
        notesTab.setContent(noteAnchorPane);
        Label label1 = new Label("从文件中加载注释"),label2=new Label("手动输入注释内容");
        label1.setPrefWidth(100);
        label1.setPrefHeight(10);
        label2.setPrefWidth(100);
        label2.setPrefHeight(10);
        TextField textField=new TextField();
//        textField.setFont(Font.font(14));
        textField.setPrefWidth(400);
        textField.setPrefHeight(14);

        Button browse=new Button("浏览");
        TextArea textArea=new TextArea();
        textArea.setPrefWidth(400);
        textArea.setPrefHeight(150);
        //禁止自动换行
        textArea.setWrapText(false);
        noteAnchorPane.getChildren().addAll(label1,label2,textField,browse,textArea);

        AnchorPane.setLeftAnchor(label1,10.0);
        AnchorPane.setTopAnchor(label1,10.0);
        AnchorPane.setRightAnchor(browse,10.0);
        AnchorPane.setTopAnchor(browse,10.0);
        AnchorPane.setLeftAnchor(textField,10.0);
        AnchorPane.setTopAnchor(textField,40.0);
        AnchorPane.setLeftAnchor(label2,10.0);
        AnchorPane.setTopAnchor(label2,70.0);
        AnchorPane.setLeftAnchor(textArea,10.0);
        AnchorPane.setTopAnchor(textArea,100.0);
        browse.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("选择注释文件");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("所有文件", "*.*"));
            File file = fileChooser.showOpenDialog(new Stage());
            if(file!=null) {
                textField.setText(String.valueOf(file));
            }
        });
    }

    /**
     * 设置范围最大的AnchorPane内容器的位置
     */
    private void setAnchorPane(TabPane tabPane, Button onBtn, Button cancelBtn, Button previewPictureBtn) {
        AnchorPane.setLeftAnchor(tabPane,10.0);
        AnchorPane.setTopAnchor(tabPane,10.0);
        AnchorPane.setRightAnchor(tabPane,10.0);
        AnchorPane.setBottomAnchor(tabPane,50.0);
        AnchorPane.setBottomAnchor(onBtn,10.0);
        AnchorPane.setBottomAnchor(cancelBtn,10.0);
        AnchorPane.setBottomAnchor(previewPictureBtn,10.0);
        AnchorPane.setRightAnchor(onBtn,130.0);
        AnchorPane.setRightAnchor(cancelBtn,80.0);
        AnchorPane.setRightAnchor(previewPictureBtn,10.0);
    }

    public static void main(String[] args) {
        launch();
    }
}