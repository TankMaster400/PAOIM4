package com.example.paoim4;

import jakarta.persistence.spi.PersistenceProvider;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.HashMap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Applicationm extends javafx.application.Application {
  @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Applicationm.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 640);
         stage.setTitle("Hello!");
         stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
launch(args);
    }
}