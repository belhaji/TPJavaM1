package fr.idmc.m1.exo4.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainScreenController
{
    public static final String FILENAME = "/ui/exo4/main_screen.fxml";
    @FXML
    private JFXButton clickMeBtn;
    @FXML
    private JFXButton loadDataBtn;

    @FXML
    private JFXTextArea textOutput;

    private Stage stage;

    @FXML
    void onClick(ActionEvent event)
    {
        textOutput.appendText("Hello world\n");
    }
    @FXML
    void loadData(ActionEvent event)
    {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(this.stage);
        if (!Files.exists(Paths.get(file.getAbsolutePath())))
        {
            System.out.println(file.getAbsolutePath() + ": No such file");
            System.exit(100);
        }
        try
        {
            CSVParser parse = CSVParser.parse(Paths.get(file.getAbsolutePath()),
                                              Charset.defaultCharset(),
                                              CSVFormat.newFormat(';')
                                                  .withCommentMarker('#'));
            parse.getRecords().forEach(r -> textOutput.appendText(String.format("App1 : %s %s%n", r.get(0), r.get(1))));
            parse.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Stage getStage()
    {
        return this.stage;
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }
}