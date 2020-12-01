/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Stefan
 */
public class Rezervacija implements GeneralDObject {

    private int sifraRezervacija;
    private String nazivDogadjaja;
    private String sifraKlijenta;
    private int brojKarata;
    private TipDogadjaja tipDogadjaja;
    private Date datum;

    public Rezervacija() {
        this.sifraRezervacija = 0;
        this.sifraKlijenta = "Nepoznato";
        this.nazivDogadjaja = "Nepoznato";
        this.brojKarata = 0;
        this.tipDogadjaja = TipDogadjaja.OSTALO;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        this.datum = java.sql.Date.valueOf(sdf.format(d));
    }

    public Rezervacija(int sifraRezervacija, String nazivDogadjaja, String sifraKlijenta, int brojKarata, TipDogadjaja tipDogadjaja, Date datumPolaska) {
        this.sifraRezervacija = sifraRezervacija;
        this.nazivDogadjaja = nazivDogadjaja;
        this.sifraKlijenta = sifraKlijenta;
        this.brojKarata = brojKarata;
        this.tipDogadjaja = tipDogadjaja;
        this.datum = datumPolaska;
    }

    public String getNazivDogadjaja() {
        return nazivDogadjaja;
    }

    public void setNazivDogadjaja(String nazivDogadjaja) {
        this.nazivDogadjaja = nazivDogadjaja;
    }
    

    public int getSifraRezervacija() {
        return sifraRezervacija;
    }

    public void setSifraRezervacija(int sifraRezervacija) {
        this.sifraRezervacija = sifraRezervacija;
    }

    public String getSifraKlijenta() {
        return sifraKlijenta;
    }

    public void setSifraKlijenta(String sifraKlijenta) {
        this.sifraKlijenta = sifraKlijenta;
    }

    public int getBrojKarata() {
        return brojKarata;
    }

    public void setBrojKarata(int brojKarata) {
        this.brojKarata = brojKarata;
    }

    public TipDogadjaja getTipDogadjaja() {
        return tipDogadjaja;
    }

    public void setTipDogadjaja(TipDogadjaja tipDogadjaja) {
        this.tipDogadjaja = tipDogadjaja;
    }

    public Date getDatum() {
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    @Override
    public String getAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append(sifraRezervacija).append(", ")
                .append(nazivDogadjaja == null ? null : "'" + nazivDogadjaja + "'").append(", ")
                .append(sifraKlijenta == null ? null : "'" + sifraKlijenta + "'").append(", ")
                .append("'" + brojKarata + "'").append(", ")
                .append(tipDogadjaja == null ? null : "'" + tipDogadjaja + "'").append(", ")
                .append("'").append(datum)
                .append("'");
        System.out.println(sb);
        return sb.toString();
    }

    @Override
    public String setAtrValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("sifraRezervacije=").append(sifraRezervacija).append(", ")
                .append("nazivDogadjaja=").append(nazivDogadjaja == null ? null : "'" + nazivDogadjaja + "'").append(", ")
                .append("sifraKlijenta=").append(sifraKlijenta == null ? null : "'" + sifraKlijenta + "'").append(", ")
                .append("brojKarata=").append(brojKarata).append(", ")
                .append("tipDogadjaja=").append(tipDogadjaja == null ? null : "'" + tipDogadjaja + "'").append(", ")
                .append("datum=").append("'").append(datum)
                .append("'");
        System.out.println(sb);
        return sb.toString();
    }

    @Override
    public String getClassName() {
        return "Rezervacija";
    }

    @Override
    public String getWhereCondition() {
        return "sifraRezervacije = " + sifraRezervacija;
    }

    @Override
    public String getNameByColumn(int column) {
        String[] names = {"sifraRezervacije", "nazivDogadjaja", "sifraKlijenta", "brojKarata", "tipDogadjaja", "datum"};
        return names[column];
    }

    @Override
    public GeneralDObject getNewRecord(ResultSet rs) throws SQLException {
        int sifraRezervacije = rs.getInt("sifraRezervacije");
        String nazivDogadjaja = rs.getString("nazivDogadjaja");
        String sifraKlijenta = rs.getString("sifraKlijenta");
        int brojKarata = rs.getInt("brojKarata");
        String tipDogadjajaString = rs.getString("tipDogadjaja");
        TipDogadjaja tipDogadjaja;
        switch (tipDogadjajaString) {
            case "SPORTSKI":
                tipDogadjaja = TipDogadjaja.SPORTSKI;
                break;
            case "KULTURNI":
                tipDogadjaja = TipDogadjaja.KULTURNI;
                break;
            default:
                tipDogadjaja = TipDogadjaja.OSTALO;
                break;
        }
        Date datum = rs.getDate("datum");
        return new Rezervacija(sifraRezervacije, nazivDogadjaja, sifraKlijenta, brojKarata, tipDogadjaja, datum);
    }

}
