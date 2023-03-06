package edu.jlu.csw.front;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author 10186
 * 主入口点，一个 JavaFX 应用程序子类
 */
public class MainApplication extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene=new Scene(new View());
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

    public static void main(String[] args) {
        launch();
    }
}