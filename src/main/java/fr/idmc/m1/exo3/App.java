package fr.idmc.m1.exo3;

import fr.idmc.m1.exo3.controller.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
    public static void main(String[] args)
    {
        launch(App.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent parent = FXMLLoader.load(this.getClass().getResource(MainScreenController.FILENAME));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
