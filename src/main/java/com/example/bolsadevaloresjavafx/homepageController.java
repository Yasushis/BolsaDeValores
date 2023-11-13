package com.example.bolsadevaloresjavafx;

import com.example.bolsadevaloresjavafx.bolsaDeValores.Bolsa;
import com.example.bolsadevaloresjavafx.bolsaDeValores.Corretora;
import com.example.bolsadevaloresjavafx.bolsaDeValores.Investidor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class homepageController implements Initializable{

    private ObservableList<Corretora> obsCorretoras;

    @FXML
    private Button btStart;

    @FXML
    private TextField initialBolsa;

    @FXML
    private ComboBox<Corretora> initialCorretora;

    @FXML
    private TextField initialMoney;

    @FXML
    private TextField initialName;

    private Stage stage;
    private Scene scene;
    private Parent root;



    @FXML
    public void startSimulation(ActionEvent event) throws IOException {
        HelloApplication.corretora = new Corretora(initialCorretora.getValue().getNome(), 8);
        HelloApplication.investidor = new Investidor(initialName.getText(), Float.parseFloat(initialMoney.getText()));
        HelloApplication.bolsa = new Bolsa(initialBolsa.getText());
        HelloApplication.mudarTela("interfaceScene");

    }

    public void carregarCorretoras() {

        Corretora corretora = new Corretora("XP", 0.01f);
        Corretora corretora1 = new Corretora("Rico", 0.02f);
        Corretora corretora2 = new Corretora("Nu", 0.03f);

        List<Corretora> corretoras = new ArrayList<>();
        corretoras.add(corretora);
        corretoras.add(corretora1);
        corretoras.add(corretora2);

        obsCorretoras = FXCollections.observableArrayList(corretoras);
        initialCorretora.setItems(obsCorretoras);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        carregarCorretoras();
    }
}