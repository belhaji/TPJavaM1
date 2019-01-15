package fr.idmc.m1.exo3.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainScreenController
{
    public static final String FILENAME = "/ui/main_screen.fxml";
    @FXML
    private JFXButton clickMeBtn;

    @FXML
    private JFXTextArea textOutput;

    @FXML
    void onClick(ActionEvent event)
    {
        textOutput.appendText("Hello world\n");
    }
}
