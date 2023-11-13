package com.example.bolsadevaloresjavafx;

import com.example.bolsadevaloresjavafx.HelloApplication;
import com.example.bolsadevaloresjavafx.bolsaDeValores.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class interfaceController implements Initializable{

    @FXML
    private TableColumn<Ativo, String> columnNomeAcoesBolsa;

    @FXML
    private TableColumn<Ativo, String> columnNomeMyAcoes;

    @FXML
    private TableColumn<Ativo, Float> columnValorAcoesBolsa;

    @FXML
    private TableColumn<Ativo, Float> columnValorMyAcoes;

    @FXML
    private TableView<Ativo> tableAcoesBolsa;

    @FXML
    private TableView<Ativo> tableMyAcoes;

    @FXML
    private Button btBack;

    @FXML
    private Button btBuy;

    @FXML
    private Button btSell;

    @FXML
    private Text nameBolsa;

    @FXML
    private Label userName;

    @FXML
    private Label corretoraName;

    @FXML
    private Text userMoney;


    private List<Ativo> myAtivos = new ArrayList<>();
    private List<Ativo> bolsaAtivos = new ArrayList<>();

    private ObservableList<Ativo> obsMyAtivos;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void backStart(ActionEvent event) throws IOException {
        HelloApplication.mudarTela("homepageScene");
    }

    @FXML
    void buy(ActionEvent event) {

    }

    @FXML
    void sell(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

           Acao acao = new Acao("Salgabitos","B132", 132f);
           Acao acao1 = new Acao("MeuÔnibus","OILU", 300f);
           Acao acao2 = new Acao("BolinhosJoelinton","BOLU", 890f);
           List<Ativo> bolsaAtivos = new ArrayList<>();

           bolsaAtivos.add(acao);
           bolsaAtivos.add(acao1);
           bolsaAtivos.add(acao2);

           ObservableList<Ativo> obsBolsaAtivos = FXCollections.observableArrayList(bolsaAtivos);

        userName.setText(HelloApplication.investidor.getNome());
        userMoney.setText(String.valueOf(HelloApplication.investidor.getDinheiro()));
        nameBolsa.setText(HelloApplication.bolsa.getNome());
        corretoraName.setText(HelloApplication.corretora.getNome());
    }
}