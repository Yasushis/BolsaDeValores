package com.example.bolsadevaloresjavafx;

import com.example.bolsadevaloresjavafx.bolsaDeValores.Acao;
import com.example.bolsadevaloresjavafx.bolsaDeValores.Bolsa;
import com.example.bolsadevaloresjavafx.bolsaDeValores.Corretora;
import com.example.bolsadevaloresjavafx.bolsaDeValores.Investidor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {

    public static Investidor investidor;
    public static Bolsa bolsa;
    public static Corretora corretora;

    private static Scene homepageScene, interfaceScene;
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlHomepage = new FXMLLoader(HelloApplication.class.getResource("homepage-view.fxml"));
        homepageScene = new Scene(fxmlHomepage.load(), 600, 400);
        mainStage.setTitle("Simulador de bolsa de valores");
        mainStage.setScene(homepageScene);
        mainStage.show();
    }

    public static void mudarTela(String tela) throws IOException{
        if (tela.equals("interfaceScene")) {
            FXMLLoader fxmlInterface = new FXMLLoader(HelloApplication.class.getResource("interface-view.fxml"));
            interfaceScene = new Scene(fxmlInterface.load(), 600, 400);
            mainStage.setScene(interfaceScene);
        }

        else if(tela.equals("homepageScene")) {
            mainStage.setScene(homepageScene);
        }
    }

    @Override
    public void init() throws Exception{
        Investidor investidor = new Investidor();
        Bolsa bolsa = new Bolsa("");
    }
    public static void main(String[] args) {
        launch();
    }
}