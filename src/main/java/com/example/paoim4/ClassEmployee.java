package com.example.paoim4;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class ClassEmployee
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_grupy;
    private String nazwa_grupy;
    private int max_p;
    private String Zapełnienie;
    public String getZapełnienie() {
        return Zapełnienie;
    }

    public void setZapełnienie(String zapełnienie) {
        Zapełnienie = zapełnienie;
    }




  //  @OneToMany(mappedBy = "ClassEmployee")
 //   private List<Employee> Employee;
 //   @OneToMany(mappedBy = "ClassEmployee")
 //   private List<Rate> rates;
    public String getNazwa_grupy() {
        return nazwa_grupy;
    }

    public double getMax_p() {

        return max_p;
    }

    public void setNazwa_grupy(String nazwa_grupy) {
        this.nazwa_grupy = nazwa_grupy;
    }

    public void setMax_p(int max_p) {
        this.max_p = max_p;
    }

    public int getID_grupy() {
        return ID_grupy;
    }

    public void setID_grupy(int id) {
        this.ID_grupy = id;
    }


}