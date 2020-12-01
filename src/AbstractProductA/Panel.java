/* Panel.java
 * @autor student Miro Maric 1031/16,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * 4.11.2018
 */
package AbstractProductA;

import DomainClasses.TipDogadjaja;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class Panel extends JPanel {

    public abstract String getSifraRezervacije();

    public abstract JTextField getSifraRezervacije1();

    public abstract String getNazivDogadjaja();

    public abstract String getSifraKlijenta();
    
    public abstract String getBrojKarata();

    public abstract TipDogadjaja getTipDogadjaja();

    public abstract String getPoruka();

    public abstract Date getDatum();

    public abstract void setSifreRezervacije(String sifraRezervacije);

    public abstract void setNazivDogadjaja(String nazivDogadjaja);

    public abstract void setSifraKlijenta(String sifraKlijenta);

    public abstract void setBrojKarata(int brojKarata);

    public abstract void setTipDogadjaja(TipDogadjaja tipDogadjaja);

    public abstract void setDatum(Date datum);

    public abstract void setPoruka(String poruka);

    public abstract javax.swing.JButton getKreiraj();

    public abstract javax.swing.JButton getPromeni();

    public abstract javax.swing.JButton getObrisi();

    public abstract javax.swing.JButton getNadji();

}
