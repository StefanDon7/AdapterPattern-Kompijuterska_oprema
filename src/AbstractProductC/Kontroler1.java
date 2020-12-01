/* Kontroler1.java
 * @autor  prof. dr Sinisa Vlajic,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * Katedra za softversko inzenjerstvo
 * Laboratorija za softversko inzenjerstvo
 * 06.11.2017
 */
package AbstractProductC;

import AbstractProductA.*;
import AbstractProductB.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Timer;
import java.util.TimerTask;
import DomainClasses.Rezervacija;  // Promenljivo
import DomainClasses.TipDogadjaja;

public final class Kontroler1 extends Kontroler {

    public Kontroler1(EkranskaForma ef1, BrokerBazePodataka bbp1) {
        ef = ef1;
        bbp = bbp1;
        Povezi();
    }

    void Povezi() {
        javax.swing.JButton Kreiraj = ef.getPanel().getKreiraj();
        javax.swing.JButton Promeni = ef.getPanel().getPromeni();
        javax.swing.JButton Obrisi = ef.getPanel().getObrisi();
        javax.swing.JButton Nadji = ef.getPanel().getNadji();
        Kreiraj.addActionListener(new OsluskivacKreiraj(this));
        Promeni.addActionListener(new OsluskivacPromeni(this));
        Obrisi.addActionListener(new OsluskivacObrisi(this));
        Nadji.addActionListener(new OsluskivacNadji(this));

        javax.swing.JTextField SifraPrijave = ef.getPanel().getSifraRezervacije1(); // Promenljivo!!!
        SifraPrijave.addFocusListener(new OsluskivacNadji1(this));
    }

// Promenljivo!!!  
    void napuniDomenskiObjekatIzGrafickogObjekta() {
        ip = new Rezervacija();
        ip.setSifraRezervacija(getInteger(ef.getPanel().getSifraRezervacije()));
        ip.setSifraKlijenta(ef.getPanel().getSifraKlijenta());
        ip.setNazivDogadjaja(ef.getPanel().getNazivDogadjaja());
        ip.setBrojKarata(getInteger(ef.getPanel().getBrojKarata()));
        ip.setTipDogadjaja(ef.getPanel().getTipDogadjaja());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date Datum = java.sql.Date.valueOf(sdf.format(ef.getPanel().getDatum()));
        ip.setDatum(Datum);

    }

// Promenljivo!!!
    void napuniGrafickiObjekatIzDomenskogObjekta(Rezervacija ip) {
        ef.getPanel().setSifreRezervacije(Integer.toString(ip.getSifraRezervacija()));
        ef.getPanel().setSifraKlijenta(ip.getSifraKlijenta());
        ef.getPanel().setNazivDogadjaja(ip.getNazivDogadjaja());
        ef.getPanel().setBrojKarata(ip.getBrojKarata());
        ef.getPanel().setTipDogadjaja(ip.getTipDogadjaja());
        ef.getPanel().setDatum(ip.getDatum());

    }

// Promenljivo!!!
    void isprazniGrafickiObjekat() {

        ef.getPanel().setSifreRezervacije("0");
        ef.getPanel().setSifraKlijenta("Nepoznato");
        ef.getPanel().setNazivDogadjaja("Nepoznato");
        ef.getPanel().setBrojKarata(0);
        ef.getPanel().setTipDogadjaja(TipDogadjaja.OSTALO);
        ef.getPanel().setDatum(new java.util.Date());
    }

    void prikaziPoruku() {
        ef.getPanel().setPoruka(poruka);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ef.getPanel().setPoruka("");
            }
        }, 3000);

    }

    public int getInteger(String s) {
        int broj = 0;
        try {
            if (s != null) {
                broj = Integer.parseInt(s);
            }
        } catch (NumberFormatException e) {
            broj = 0;
        }

        return broj;
    }

    boolean zapamtiDomenskiObjekat() {

        bbp.makeConnection();
        boolean signal = bbp.insertRecord(ip);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем је запамтио нову резервацију."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            poruka = "Систем не може да запамти нову резервацију"; // Promenljivo!!!  
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;

    }

    boolean kreirajDomenskiObjekat() {
        boolean signal;
        ip = new Rezervacija(); // Promenljivo!!!
        AtomicInteger counter = new AtomicInteger(0);

        bbp.makeConnection();
        if (!bbp.getCounter(ip, counter)) {
            return false;
        }
        if (!bbp.increaseCounter(ip, counter)) {
            return false;
        }

        ip.setSifraRezervacija(counter.get()); // Promenljivo!!!
        signal = bbp.insertRecord(ip);
        if (signal == true) {
            bbp.commitTransation();
            napuniGrafickiObjekatIzDomenskogObjekta(ip);
            poruka = "Систем је креирао нову резеревацију."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Систем не може да креира нову резеревацију."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean obrisiDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.deleteRecord(ip);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем je oбрисао резеревацију."; // Promenljivo!!!
            isprazniGrafickiObjekat();
        } else {
            bbp.rollbackTransation();
            poruka = "Систем не може да обрише резеревацију."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean promeniDomenskiObjekat() {
        bbp.makeConnection();
        boolean signal = bbp.updateRecord(ip);
        if (signal == true) {
            bbp.commitTransation();
            poruka = "Систем je променио резеревацију."; // Promenljivo!!!
        } else {
            bbp.rollbackTransation();
            isprazniGrafickiObjekat();
            poruka = "Систем не може да промени резеревацију."; // Promenljivo!!!
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

    boolean nadjiDomenskiObjekat() {
        boolean signal;
        bbp.makeConnection();
        ip = (Rezervacija) bbp.findRecord(ip); // Promenljivo!!!
        if (ip != null) {
            napuniGrafickiObjekatIzDomenskogObjekta(ip);
            poruka = "Систем je нашао резеревацију."; // Promenljivo!!!
            signal = true;
        } else {
            isprazniGrafickiObjekat();
            poruka = "Систем не може да нађе резеревацију."; // Promenljivo!!!
            signal = false;
        }
        prikaziPoruku();
        bbp.closeConnection();
        return signal;
    }

}

class OsluskivacZapamti implements ActionListener {

    Kontroler1 kon;

    OsluskivacZapamti(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.zapamtiDomenskiObjekat();

    }
}

class OsluskivacKreiraj implements ActionListener {

    Kontroler1 kon;

    OsluskivacKreiraj(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.kreirajDomenskiObjekat();

    }
}

class OsluskivacObrisi implements ActionListener {

    Kontroler1 kon;

    OsluskivacObrisi(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.obrisiDomenskiObjekat();

    }
}

class OsluskivacPromeni implements ActionListener {

    Kontroler1 kon;

    OsluskivacPromeni(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.promeniDomenskiObjekat();

    }
}

class OsluskivacNadji implements ActionListener {

    Kontroler1 kon;

    OsluskivacNadji(Kontroler1 kon1) {
        kon = kon1;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }
}

class OsluskivacNadji1 implements FocusListener {

    Kontroler1 kon;

    OsluskivacNadji1(Kontroler1 kon1) {
        kon = kon1;
    }

    public void focusLost(java.awt.event.FocusEvent e) {
        kon.napuniDomenskiObjekatIzGrafickogObjekta();
        kon.nadjiDomenskiObjekat();

    }

    @Override
    public void focusGained(FocusEvent e) {

    }
}
