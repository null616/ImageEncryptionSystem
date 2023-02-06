module edu.jlu.csw.imageencryptionsystem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens edu.jlu.csw.imageencryptionsystem to javafx.fxml;
    exports edu.jlu.csw.imageencryptionsystem;
}