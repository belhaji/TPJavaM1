package fr.idmc.m1.exo4;

import fr.idmc.m1.exo4.controller.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App4 extends Application
{
    public static void main(String[] args)
    {
        launch(App4.class, args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(MainScreenController.FILENAME));
        Parent parent = loader.load();
        MainScreenController controller = loader.getController();
        controller.setStage(primaryStage);
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}