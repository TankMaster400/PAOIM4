package com.example.paoim4;
import jakarta.persistence.*;

import java.sql.Date;
@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID_R;
    int Ocena;
    int ID_g;
    java.sql.Date Data;
    String Komentarz;

    public int getID_R() {
        return ID_R;
    }

    public void setID_R(int ID_R) {
        this.ID_R = ID_R;
    }

    public int getOcena() {
        return Ocena;
    }

    public void setOcena(int ocena) {
        Ocena = ocena;
    }

    public int getID_g() {
        return ID_g;
    }

    public void setID_g(int ID_g) {
        this.ID_g = ID_g;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public String getKomentarz() {
        return Komentarz;
    }

    public void setKomentarz(String komentarz) {
        Komentarz = komentarz;
    }
//   @ManyToOne
 //   @JoinColumn(name = "ClassEmplyoee")
  //  private ClassEmployee ClassEmployee;

}
