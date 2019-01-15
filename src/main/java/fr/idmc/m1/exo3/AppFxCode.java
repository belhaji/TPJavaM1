package fr.idmc.m1.exo3;

import fr.idmc.m1.exo3.controller.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AppFxCode extends Application
{
    public static void main(String[] args)
    {
        launch(AppFxCode.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        BorderPane parent = new BorderPane();
        TextArea textArea = new TextArea();
        Button button = new Button("Click me");
        button.setOnAction((e) -> textArea.appendText("Hello world\n"));
        parent.setCenter(textArea);
        parent.setBottom(button);
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
