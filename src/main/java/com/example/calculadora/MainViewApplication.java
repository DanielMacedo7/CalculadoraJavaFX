package com.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainViewApplication extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("MainView"));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainViewApplication.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static Scene getMainScene() {
        return scene;
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}