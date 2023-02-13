package edu.jlu.csw.front;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
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
        cancelBtn.setOnAction(actionEvent -> stage.close());
        an.getChildren().addAll(tabPane,onBtn,cancelBtn,previewPictureBtn);

        setAnchorPane(tabPane, onBtn, cancelBtn, previewPictureBtn);

        Scene scene=new Scene(an);
        scene.getStylesheets().add("edu/jlu/csw/front/static/mycss.css");
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
        setCommonTab(commonAnchorPane);
        setNoteTab(noteAnchorPane);
    }

    private void setCommonTab(AnchorPane commonAnchorPane) {
        Label label1=new Label("要处理的图片"),label2=new Label("图片保存的位置"),label3=new Label("新图片格式"),
                label4=new Label("处理方式"),label5=new Label("输入密码"),label6=new Label("加密/解密");
        TextField textField1=new TextField(),textField2=new TextField();
        textField1.setPrefWidth(400);
        textField1.setPrefHeight(14);
        textField2.setPrefWidth(400);
        textField2.setPrefHeight(14);
        PasswordField passwordField=new PasswordField();
        passwordField.setPrefWidth(300);
        passwordField.setPrefHeight(14);
        Button button1=new Button("浏览"),button2=new Button("浏览");
        ChoiceBox<String> choiceBox1=new ChoiceBox<>(),choiceBox2=new ChoiceBox<>();
        choiceBox1.getItems().addAll("（原文件格式）","BMP(*.BMP;*.RLE;*.DIB)","Dicom(*.DCM;*.DC3;*.DIC)","GIF(*.GIF)",
                "IFF(*.IFF;*.TDI)","JPEG(*.JPG;*.GPEG;*.JPE","JPEG 2000(*.JPF;*.JPX;*.JP2;*.J2C;*.J2K;*.JPC)",
                "JPEG 立体(*.JPS)","PDF(*.PDF;*.PDP)","PNG(*.PNG)","TIFF(*.TIF;*.TIFF)","HEIF(*.HEIF)");
        choiceBox1.getSelectionModel().selectFirst();
        choiceBox2.getItems().addAll("像素级别","位级别","块级别");
        choiceBox2.getSelectionModel().selectFirst();
        ToggleButton toggleButton=new ToggleButton("加密");



        commonAnchorPane.getChildren().addAll(label1, label2,label3,label4,label5,label6,textField1,textField2,passwordField,
                button1,button2,choiceBox1,choiceBox2,toggleButton);
        AnchorPane.setLeftAnchor(label1,10.0);
        AnchorPane.setTopAnchor(label1,10.0);
        AnchorPane.setLeftAnchor(textField1,10.0);
        AnchorPane.setTopAnchor(textField1,40.0);
        AnchorPane.setRightAnchor(button1,10.0);
        AnchorPane.setTopAnchor(button1,10.0);

        AnchorPane.setLeftAnchor(label2,10.0);
        AnchorPane.setTopAnchor(label2,70.0);
        AnchorPane.setLeftAnchor(textField2,10.0);
        AnchorPane.setTopAnchor(textField2,100.0);
        AnchorPane.setRightAnchor(button2,10.0);
        AnchorPane.setTopAnchor(button2,70.0);

        AnchorPane.setLeftAnchor(label3,10.0);
        AnchorPane.setTopAnchor(label3,130.0);
        AnchorPane.setLeftAnchor(choiceBox1,100.0);
        AnchorPane.setTopAnchor(choiceBox1,130.0);

        AnchorPane.setLeftAnchor(label4,10.0);
        AnchorPane.setTopAnchor(label4,160.0);
        AnchorPane.setLeftAnchor(choiceBox2,10.0);
        AnchorPane.setTopAnchor(choiceBox2,190.0);

        AnchorPane.setRightAnchor(label6,10.0);
        AnchorPane.setTopAnchor(label6,160.0);
        AnchorPane.setRightAnchor(toggleButton,10.0);
        AnchorPane.setTopAnchor(toggleButton,190.0);

        AnchorPane.setLeftAnchor(label5,10.0);
        AnchorPane.setTopAnchor(label5,220.0);
        AnchorPane.setLeftAnchor(passwordField,10.0);
        AnchorPane.setTopAnchor(passwordField,250.0);
        toggleButton.selectedProperty().addListener((observableValue, oldValue, newValue) -> toggleButton.setText(newValue?"解密":"加密"));

    }

    private void setNoteTab(AnchorPane noteAnchorPane) {
        Label label1 = new Label("从文件中加载注释"),label2=new Label("手动输入注释内容");
        label1.setPrefWidth(100);
        label1.setPrefHeight(10);
        label2.setPrefWidth(100);
        label2.setPrefHeight(10);
        TextField textField=new TextField();
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
                textField.setText(String.valueOf(file) );
            }
        });
        textArea.textProperty().addListener((observableValue, oldValue, newValue) -> {
            textField.setDisable(!newValue.isEmpty());
            browse.setDisable(!newValue.isEmpty());
        });
        textField.onKeyPressedProperty().set(keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                if (!new File(textField.getText()).exists()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("锁图：诊断信息");
                    alert.setHeaderText("无法打开 "+textField.getText());
                    alert.setContentText("系统找不到指定的文件");
                    alert.show();
                }
            }
        });
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> textArea.setDisable(!newValue.isEmpty()));
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