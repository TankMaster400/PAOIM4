package com.example.paoim4;

import jakarta.persistence.*;

@Entity
public class Employee
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_employee;
    private String imie;
    private String nazwisko;
    private String employee_C;
    private int rok_urodzenia;
    private int wynagrodzenie;
    private int ID_grupy;

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }
// @ManyToOne
  //  @JoinColumn(name = "ClassEmployee")
  //  private ClassEmployee ClassEmployee;

    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public int getID_grupy() {
        return ID_grupy;
    }
    public void setID_grupy(int ID_grupy) {
        this.ID_grupy = ID_grupy;
    }
    public int getRok_urodzenia() {
        return rok_urodzenia;
    }

    public double getWynagrodzenie() {
        return wynagrodzenie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getEmployee_C() {
        return employee_C;
    }

    public void setEmployee_C(String employee_C) {
        employee_C = employee_C;
    }

    public void setRok_urodzenia(int rok_urodzenia) {
        this.rok_urodzenia = rok_urodzenia;
    }

    public void setWynagrodzenie(int wynagrodzenie) {
        this.wynagrodzenie = wynagrodzenie;
    }
}
