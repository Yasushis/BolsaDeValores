package com.example.bolsadevaloresjavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class homepageController {

    @FXML
    void startSimulation(ActionEvent event) {
        HelloApplication.mudarTela("interfaceScene");
    }

}

