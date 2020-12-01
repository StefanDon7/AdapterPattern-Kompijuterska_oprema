/* Panel1.java
 * @autor student Miro Maric 1031/16,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * 4.11.2018
 */
package AbstractProductA;

import DomainClasses.TipDogadjaja;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Panel1 extends Panel {

    public Panel1() {
        initComponents();
        initImg();
        initComboBoxEvents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSifraRezervacije = new javax.swing.JLabel();
        lblSifraKlijenta = new javax.swing.JLabel();
        lblNazivDogadjaja = new javax.swing.JLabel();
        lblBrojKarata = new javax.swing.JLabel();
        lblTipDogadjaja = new javax.swing.JLabel();
        lblDatum = new javax.swing.JLabel();
        Datum = new datechooser.beans.DateChooserCombo();
        cmbTipDogadjaja = new javax.swing.JComboBox<>();
        txtNazivDogadjaja = new javax.swing.JTextField();
        txtSifraKlijenta = new javax.swing.JTextField();
        txtSifraRezervacije = new javax.swing.JTextField();
        Nadji = new javax.swing.JButton();
        Promeni = new javax.swing.JButton();
        Kreiraj = new javax.swing.JButton();
        Obrisi = new javax.swing.JButton();
        lblSlika = new javax.swing.JLabel();
        lblPoruka = new javax.swing.JLabel();
        cmbBrojKarata = new javax.swing.JComboBox();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSifraRezervacije.setText("Sifra rezervacije:");
        add(lblSifraRezervacije, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 104, 25));

        lblSifraKlijenta.setText("Sifra klijenta:");
        add(lblSifraKlijenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 104, 25));

        lblNazivDogadjaja.setText("Naziv dogadjaja:");
        add(lblNazivDogadjaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 104, 25));

        lblBrojKarata.setText("Broj karata:");
        add(lblBrojKarata, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 104, 25));

        lblTipDogadjaja.setText("Tip dogadjaja:");
        add(lblTipDogadjaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 104, 25));

        lblDatum.setText("Datum:");
        add(lblDatum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 104, 25));
        add(Datum, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, -1));

        add(cmbTipDogadjaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 130, -1));
        add(txtNazivDogadjaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 130, 25));
        add(txtSifraKlijenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 130, 25));
        add(txtSifraRezervacije, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 130, 25));

        Nadji.setText("Nadji");
        add(Nadji, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 80, 30));

        Promeni.setText("Promeni");
        add(Promeni, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 100, 30));

        Kreiraj.setText("Kreiraj");
        add(Kreiraj, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 90, 30));

        Obrisi.setText("Obrisi");
        add(Obrisi, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 340, 80, 30));

        lblSlika.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSlika.setText(" ");
        add(lblSlika, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 360, 80));

        lblPoruka.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPoruka.setText(" ");
        add(lblPoruka, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 290, -1));

        cmbBrojKarata.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        add(cmbBrojKarata, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 130, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserCombo Datum;
    private javax.swing.JButton Kreiraj;
    private javax.swing.JButton Nadji;
    private javax.swing.JButton Obrisi;
    private javax.swing.JButton Promeni;
    private javax.swing.JComboBox cmbBrojKarata;
    private javax.swing.JComboBox<Object> cmbTipDogadjaja;
    private javax.swing.JLabel lblBrojKarata;
    private javax.swing.JLabel lblDatum;
    private javax.swing.JLabel lblNazivDogadjaja;
    private javax.swing.JLabel lblPoruka;
    private javax.swing.JLabel lblSifraKlijenta;
    private javax.swing.JLabel lblSifraRezervacije;
    private javax.swing.JLabel lblSlika;
    private javax.swing.JLabel lblTipDogadjaja;
    private javax.swing.JTextField txtNazivDogadjaja;
    private javax.swing.JTextField txtSifraKlijenta;
    private javax.swing.JTextField txtSifraRezervacije;
    // End of variables declaration//GEN-END:variables

    private void initImg() {

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("src/Images/movietheater.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image dimg = img.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(dimg);
        lblSlika.setIcon(imageIcon);
    }

    private void initComboBoxEvents() {
        cmbTipDogadjaja.removeAllItems();
        for (TipDogadjaja value : TipDogadjaja.values()) {
            cmbTipDogadjaja.addItem(value);
        }
    }

    @Override
    public String getSifraRezervacije() {
        return txtSifraRezervacije.getText();
    }

    @Override
    public JTextField getSifraRezervacije1() {
        return txtSifraRezervacije;
    }

    @Override
    public String getNazivDogadjaja() {
        return txtNazivDogadjaja.getText();
    }

    @Override
    public String getSifraKlijenta() {
        return txtSifraKlijenta.getText();
    }

    @Override
    public String getBrojKarata() {
        return cmbBrojKarata.getSelectedItem().toString();
    }

    @Override
    public TipDogadjaja getTipDogadjaja() {
        String strTipDogadjaja = cmbTipDogadjaja.getSelectedItem().toString();
        TipDogadjaja tipDogadjaja;
        switch (strTipDogadjaja) {
            case "SPORTSKI":
                tipDogadjaja = TipDogadjaja.SPORTSKI;
                break;
            case "KULTURNI":
                tipDogadjaja = TipDogadjaja.KULTURNI;
                break;
            default:
                tipDogadjaja=TipDogadjaja.OSTALO;
                break;
        }
        return tipDogadjaja;
    }

    @Override
    public String getPoruka() {
        return lblPoruka.getText();
    }

    @Override
    public Date getDatum() {
         return Datum.getSelectedDate().getTime();
    }

    @Override
    public void setSifreRezervacije(String sifraRezervacije) {
        txtSifraRezervacije.setText(sifraRezervacije);
    }

    @Override
    public void setNazivDogadjaja(String nazivDogadjaja) {
        txtNazivDogadjaja.setText(nazivDogadjaja);
    }

    @Override
    public void setSifraKlijenta(String sifraKlijenta) {
        txtSifraKlijenta.setText(sifraKlijenta);
    }

    @Override
    public void setBrojKarata(int brojKarata) {
        cmbBrojKarata.setSelectedItem(brojKarata);
    }

    @Override
    public void setTipDogadjaja(TipDogadjaja tipDogadjaja) {
        switch (tipDogadjaja) {
            case SPORTSKI:
                cmbTipDogadjaja.setSelectedItem(TipDogadjaja.SPORTSKI);
                break;
            case KULTURNI:
                cmbTipDogadjaja.setSelectedItem(TipDogadjaja.KULTURNI);
                break;
            default:
                cmbTipDogadjaja.setSelectedItem(TipDogadjaja.OSTALO);
                break;
        }
    }

    @Override
    public void setDatum(Date datum) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(datum);
        Datum.setSelectedDate(gc);
    }

    @Override
    public void setPoruka(String poruka) {
        lblPoruka.setText(poruka);
    }

    @Override
    public JButton getKreiraj() {
        return Kreiraj;
    }

    @Override
    public JButton getPromeni() {
        return Promeni;
    }

    @Override
    public JButton getObrisi() {
        return Obrisi;
    }

    @Override
    public JButton getNadji() {
        return Nadji;
    }

}
