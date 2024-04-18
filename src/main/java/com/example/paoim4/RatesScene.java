package com.example.paoim4;

import jakarta.persistence.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RatesScene implements Initializable {

    @FXML
    private TableColumn<Rate, Integer> ID_R;
    @FXML
    private TableColumn<Rate, Integer> ID_grupy;
    @FXML
    private TableColumn<Rate, Integer> ocena;
    @FXML
    private TableColumn<Rate, Date> Date;
    @FXML
    private TableColumn<Rate, String> komentarz;

    @FXML
    private TextField ID_d;
    @FXML
    private TextField ocena_d;
    @FXML
    private DatePicker data_d;
    @FXML
    private TextField kom;
    @FXML
    private TableView<Rate> table1;

    @FXML
    private Button closeButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        ID_R.setCellValueFactory(new PropertyValueFactory<Rate, Integer>("ID_R"));
        ID_grupy.setCellValueFactory(new PropertyValueFactory<Rate, Integer>("ID_g"));
        ocena.setCellValueFactory(new PropertyValueFactory<Rate, Integer>("Ocena"));
        Date.setCellValueFactory(new PropertyValueFactory<Rate, Date>("Data"));
        komentarz.setCellValueFactory(new PropertyValueFactory<Rate, String>("Komentarz"));


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();

        try
        {
            EM.getTransaction().begin();
            String sql = "SELECT a FROM Rate a";
            TypedQuery<Rate> q = EM.createQuery(sql, Rate.class);

            table1.setItems(FXCollections.observableArrayList(q.getResultList()));

            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
        }

    @FXML
    private void powr(ActionEvent event)throws IOException
    {

        Stage stage2 = (Stage) closeButton.getScene().getWindow();
        stage2.close();
    }
    @FXML
    private void dodaj(ActionEvent event)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();
        int val = Integer.parseInt(ocena_d.getText());

        if(val >6){val =6;}
        if(val<0){val =0;}
        try {
            EM.getTransaction().begin();
            String sql = "INSERT INTO Rate(Ocena, ID_g, Komentarz) VALUES ("+val+", "+Integer.parseInt(ID_d.getText())+",'"+kom.getText()+"')";
            Query q = EM.createQuery(sql);
            q.executeUpdate();
            String sql2 = "SELECT a FROM Rate a";
            TypedQuery<Rate> q2 = EM.createQuery(sql2, Rate.class);

            table1.refresh();
            table1.setItems(FXCollections.observableArrayList(q2.getResultList()));
            table1.refresh();

            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
        ID_d.clear();
        ocena_d.clear();

        kom.clear();
    }
}
