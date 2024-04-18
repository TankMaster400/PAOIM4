package com.example.paoim4;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import javafx.stage.Stage;
import jakarta.persistence.*;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.ChoiceBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
public class Controller implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private TableColumn<ClassEmployee, Integer> ID_g;
    @FXML
    private TableColumn<ClassEmployee, String> Nazwa_g;
    @FXML
    private TableColumn<ClassEmployee, String> zapelnienie;
    @FXML
    private TableColumn<Employee, Integer> ID_p;
    @FXML
    private TableColumn<Employee, String> imie;
    @FXML
    private TableColumn<Employee, String> nazwisko;
    @FXML
    private TableColumn<Employee, String> stan;
    @FXML
    private TableView<ClassEmployee> table1;
    @FXML
    private TableView<Employee> table2;
    @FXML
    private TableColumn<Employee, Double> wyplata;
    @FXML
    private TableColumn<Employee, Integer> rok;
    @FXML
    private TextField imie_d;
    @FXML
    private TextField max;
    @FXML
    private TextField nazwa;
    @FXML
    private TextField nazwisko_d;
    @FXML
    private TextField rok_d;
    @FXML
    private ChoiceBox<EmployeeCondition> stan_d;
    @FXML
    private TextField wyplata_d;
    @FXML
    private TextField ID_gp;
    @FXML
    private TextField szukaj;

    int pam;
    int pam2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        table1.setEditable(true);
        table2.setEditable(true);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();

        try
        {
            EM.getTransaction().begin();
            String sql = "SELECT a FROM ClassEmployee a";
            TypedQuery<ClassEmployee> q = EM.createQuery(sql, ClassEmployee.class);

            table1.setItems(FXCollections.observableArrayList(q.getResultList()));


            stan_d.setItems(FXCollections.observableArrayList(EmployeeCondition.values()));
        ID_g.setCellValueFactory(new PropertyValueFactory<ClassEmployee, Integer>("ID_grupy"));

        Nazwa_g.setCellValueFactory(new PropertyValueFactory<ClassEmployee, String>("nazwa_grupy"));
      /*  Nazwa_g.setCellFactory(TextFieldTableCell.forTableColumn());
        Nazwa_g.setOnEditCommit(new EventHandler<CellEditEvent<ClassEmployee, String>>() {
                                    @Override
                                    public void handle(CellEditEvent<ClassEmployee, String> event) {
                                        ClassEmployee gr = event.getRowValue();
                                        gr.setNazwa_grupy(event.getNewValue());

                                    }
                                }
        );
*/



        zapelnienie.setCellValueFactory(new PropertyValueFactory<ClassEmployee, String>("Zapełnienie"));
    /*    zapelnienie.setOnEditCommit(new EventHandler<CellEditEvent<ClassEmployee, String>>() {
                                        @Override
                                        public void handle(CellEditEvent<ClassEmployee, String> event) {
                                            ClassEmployee gr = event.getRowValue();
                                            double wart;
                                            wart = Double.valueOf(event.getNewValue());
                                            gr.setMax_p(wart);
                                            list1.get(table1.getSelectionModel().getSelectedIndex()).setMax_p(wart);
                                            list1.get(table1.getSelectionModel().getSelectedIndex()).setZapelnienie();
                                            table1.refresh();
                                        }
                                    }
        );
        */

        ID_p.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id_employee"));
        imie.setCellValueFactory(new PropertyValueFactory<Employee, String>("imie"));
        /*
        imie.setCellFactory(TextFieldTableCell.forTableColumn());
        imie.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>() {
                                 @Override
                                 public void handle(CellEditEvent<Employee, String> event) {
                                     Employee prac = event.getRowValue();
                                     prac.setImie(event.getNewValue());
                                 }
                             }
        );

         */
        nazwisko.setCellValueFactory(new PropertyValueFactory<Employee, String>("nazwisko"));
        /*
        nazwisko.setCellFactory(TextFieldTableCell.forTableColumn());
        nazwisko.setOnEditCommit(new EventHandler<CellEditEvent<Employee, String>>() {
                                     @Override
                                     public void handle(CellEditEvent<Employee, String> event) {
                                         Employee prac = event.getRowValue();
                                         prac.setNazwisko(event.getNewValue());
                                     }
                                 }
        );

         */
        stan.setCellValueFactory(new PropertyValueFactory<Employee, String>("employee_C"));
        /*
        stan.setCellFactory(ChoiceBoxTableCell.forTableColumn(EmployeeCondition.values()));
        stan.setOnEditCommit(new EventHandler<CellEditEvent<Employee, EmployeeCondition>>() {
                                 @Override
                                 public void handle(CellEditEvent<Employee, EmployeeCondition> event) {
                                     Employee prac = event.getRowValue();
                                     prac.setStan_pracownika(event.getNewValue());
                                 }
                             }

        );

         */
        wyplata.setCellValueFactory(new PropertyValueFactory<Employee, Double>("wynagrodzenie"));
        /*
        wyplata.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        wyplata.setOnEditCommit(new EventHandler<CellEditEvent<Employee, Double>>() {
                                    @Override
                                    public void handle(CellEditEvent<Employee, Double> event) {
                                        Employee prac = event.getRowValue();
                                        prac.setWynagrodzenie(event.getNewValue());
                                    }
                                }
        );
*/

        rok.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("rok_urodzenia"));
        /*
        rok.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        rok.setOnEditCommit(new EventHandler<CellEditEvent<Employee, Integer>>() {
                                @Override
                                public void handle(CellEditEvent<Employee, Integer> event) {
                                    Employee prac = event.getRowValue();
                                    prac.setRok_urodzenia(event.getNewValue());
                                }
                            }
        );

         */






            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
    }

    @FXML
    private void show(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();

        try
        {EM.getTransaction().begin();

                    String sql = "SELECT a FROM Employee a WHERE a.nazwisko = ";
                    CriteriaBuilder builder = EM.getCriteriaBuilder();
                CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
            Root<Employee> customerRoot = query.from(Employee.class);
                    query.select(customerRoot);
                   query.where(builder.like(customerRoot.get("nazwisko"),""+szukaj.getText()));
                            query.orderBy(builder.desc(customerRoot.get("ID_grupy")));
                    TypedQuery<Employee> q = EM.createQuery(query);

                    table2.setItems(FXCollections.observableArrayList(q.getResultList()));
                    table2.refresh();




        EM.getTransaction().commit();
    } finally {
        EM.close();
    }
        }
    }
    @FXML
    private void infoButton(ActionEvent event)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();
        pam = table1.getSelectionModel().getSelectedIndex();

        try {
        EM.getTransaction().begin();
        String sql = "SELECT a FROM Employee a WHERE a.ID_grupy ="+table1.getColumns().get(0).getCellObservableValue(pam).getValue();

        TypedQuery<Employee> q = EM.createQuery(sql, Employee.class);

        table2.setItems(FXCollections.observableArrayList(q.getResultList()));

            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
    }



    @FXML
    private void delButton1(ActionEvent event)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();

        pam = table1.getSelectionModel().getSelectedIndex();
        try
        {
            EM.getTransaction().begin();
            String sql = "DELETE FROM ClassEmployee WHERE ID_grupy = '" +table1.getColumns().get(0).getCellObservableValue(pam).getValue()+"'";
            Query q = EM.createQuery(sql);
            q.executeUpdate();

            String sql2 = "SELECT a FROM ClassEmployee a";
            TypedQuery<ClassEmployee> q2 = EM.createQuery(sql2, ClassEmployee.class);

            table1.refresh();
            table1.setItems(FXCollections.observableArrayList(q2.getResultList()));
            table1.refresh();
            EM.getTransaction().commit();

            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
    }


    @FXML
    private void delButton2(ActionEvent event)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();
        pam2 = table2.getSelectionModel().getSelectedIndex();

        try
        {
            EM.getTransaction().begin();
            String sql = "DELETE FROM Employee WHERE id_employee = '" +table2.getColumns().get(0).getCellObservableValue(pam2).getValue()+"'";
            Query q = EM.createQuery(sql);
            q.executeUpdate();

            String sql2 = "SELECT a FROM Employee a WHERE a.ID_grupy ="+table1.getColumns().get(0).getCellObservableValue(pam).getValue();

            TypedQuery<Employee> q2 = EM.createQuery(sql2, Employee.class);
            table2.refresh();
            table2.setItems(FXCollections.observableArrayList(q2.getResultList()));
            table2.refresh();

            EM.getTransaction().commit();
        } finally {
            EM.close();
        }


    }
    @FXML
    private void addgr(ActionEvent event)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();

        try {
            EM.getTransaction().begin();
            String sql = "INSERT INTO ClassEmployee(nazwa_grupy, max_p, Zapełnienie) VALUES ('"+nazwa.getText()+"', "+Integer.parseInt(max.getText())+", '0.0 %')";
            Query q = EM.createQuery(sql);
            q.executeUpdate();
            String sql2 = "SELECT a FROM ClassEmployee a";
            TypedQuery<ClassEmployee> q2 = EM.createQuery(sql2, ClassEmployee.class);

            table1.refresh();
            table1.setItems(FXCollections.observableArrayList(q2.getResultList()));
            table1.refresh();
            EM.getTransaction().commit();
        } finally {
            EM.close();
        }
        nazwa.clear();
        max.clear();
    }

   @FXML
    private void addpr(ActionEvent event)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager EM = emf.createEntityManager();
        pam = table1.getSelectionModel().getSelectedIndex();
        String wart = stan_d.getValue().toString();
        System.out.println(wart);
        try {
            EM.getTransaction().begin();

            String sql = "INSERT INTO Employee (imie, nazwisko, employee_C , rok_urodzenia, wynagrodzenie, ID_grupy) VALUES ('"+imie_d.getText()+"', '"+nazwisko_d.getText()+"', '"+wart+"'," +Integer.parseInt(wyplata_d.getText())+", "+Integer.parseInt(rok_d.getText())+" , " +Integer.parseInt(ID_gp.getText())+")";
            Query q = EM.createQuery(sql);
            q.executeUpdate();

            String sql2 = "SELECT a FROM Employee a WHERE a.ID_grupy ="+table1.getColumns().get(0).getCellObservableValue(pam).getValue();
            TypedQuery<Employee> q2 = EM.createQuery(sql2, Employee.class);
            table2.refresh();
            table2.setItems(FXCollections.observableArrayList(q2.getResultList()));
            table2.refresh();

            EM.getTransaction().commit();
        } finally {
            EM.close();
        }

        table1.refresh();
        imie_d.clear();
        nazwisko_d.clear();
        wyplata_d.clear();
        rok_d.clear();
        ID_gp.clear();

    }

    @FXML
    private void oceny(ActionEvent event) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Applicationm.class.getResource("ratesScene.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 960, 640);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

    }

}

