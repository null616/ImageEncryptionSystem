package edu.jlu.csw.front;

import com.dlsc.formsfx.model.structure.Field;
import com.dlsc.formsfx.model.structure.Form;
import com.dlsc.formsfx.model.structure.Group;
import com.dlsc.formsfx.view.renderer.FormRenderer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Arrays;

/**
 * @author 10186
 * 主入口点，一个 JavaFX 应用程序子类
 */
public class MainApplication extends Application {
    @Override
    public void start(Stage stage) {
        Scene scene=new Scene(new FormRenderer(Form.of(Group.of(
                Field.ofStringType("").label("要处理的图片"),
                Field.ofStringType("").label("图片保存的位置"),
                Field.ofPasswordType("").label("输入密码"),
                Field.ofSingleSelectionType(Arrays.asList("（原文件格式）","BMP(*.BMP;*.RLE;*.DIB)",
                        "Dicom(*.DCM;*.DC3;*.DIC)","GIF(*.GIF)","IFF(*.IFF;*.TDI)","JPEG(*.JPG;*.GPEG;*.JPE",
                        "JPEG 2000(*.JPF;*.JPX;*.JP2;*.J2C;*.J2K;*.JPC)","JPEG 立体(*.JPS)","PDF(*.PDF;*.PDP)",
                        "PNG(*.PNG)","TIFF(*.TIF;*.TIFF)","HEIF(*.HEIF)"),0).label("新图片格式"),
                Field.ofSingleSelectionType(Arrays.asList("保持PC运行","关闭PC电源","休眠","睡眠","重启"),0)
                        .label("当完成后"),
                Field.ofBooleanType(false).label("后台压缩"),
                Field.ofBooleanType(false).label("加密/解密后删除原来的文件"),
                Field.ofSingleSelectionType(Arrays.asList("删除文件","移动文件到回收站","清除文件"),0)
                        .label("删除模式"),
                Field.ofBooleanType(false).label("解密"),
                Field.ofBooleanType(false).label("把完全相同的文件保存为引用")
        ))));
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