package com.example.bolsadevaloresjavafx;

import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class interfaceController {

    @FXML
    private Button btBack;

    @FXML
    void backStart(ActionEvent event) {
        HelloApplication.mudarTela("homepageScene");
    }

}
