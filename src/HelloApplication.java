package com.example.bolsadevaloresjavafx;

import com.example.bolsadevaloresjavafx.bolsaDeValores.Acao;
import com.example.bolsadevaloresjavafx.bolsaDeValores.Bolsa;
import com.example.bolsadevaloresjavafx.bolsaDeValores.Corretora;
import com.example.bolsadevaloresjavafx.bolsaDeValores.Investidor;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private static Scene homepageScene, interfaceScene;
    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlHomepage = new FXMLLoader(HelloApplication.class.getResource("homepage-view.fxml"));
        FXMLLoader fxmlInterface = new FXMLLoader(HelloApplication.class.getResource("interface-view.fxml"));
        homepageScene = new Scene(fxmlHomepage.load(), 600, 400);
        interfaceScene = new Scene(fxmlInterface.load(), 600, 400);
        mainStage.setTitle("Simulador de bolsa de valores");
        mainStage.setScene(homepageScene);
        mainStage.show();
    }

    public static void mudarTela(String tela) {
        if (tela.equals("interfaceScene")) {
            mainStage.setScene(interfaceScene);
        }

        else if(tela.equals("homepageScene")) {
            mainStage.setScene(homepageScene);
        }
    }

    @Override
    public void init() throws Exception{
        Bolsa bolsa = new Bolsa("bolsao");

        Investidor investidor = new Investidor("investidor",1000.0f);

        Acao acao1 = new Acao("Salgabitos","B132", 132f);
        Acao acao2 = new Acao("MeuÔnibus","OILU", 300f);
        Acao acao3 = new Acao("BolinhosJoelinton","BOLU", 890f);

        bolsa.add(acao1);
        bolsa.add(acao2);
        bolsa.add(acao3);

        Corretora corretora = new Corretora("Corre", 0.01f);
        Corretora corretora1 = new Corretora("Anda", 0.02f);

    }
    public static void main(String[] args) {
        launch();
    }
}