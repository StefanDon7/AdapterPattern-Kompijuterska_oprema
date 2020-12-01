/* EkranskaForma.java
 * @autor student Miro Maric 1031/16,
 * Univerzitet u Beogradu
 * Fakultet organizacionih nauka 
 * 4.11.2018
 */
package AbstractProductA;

import AbstractProductA.Panel;
import AbstractProductA.Panel;
import javax.swing.JFrame;

public abstract class EkranskaForma extends JFrame{

    public Panel getPanel() {
        return (Panel) getContentPane();
    }

    public void setPanel(Panel pan1) {
        setContentPane(pan1);
    }

    public void prikaziEkranskuFormu() {
        setVisible(true);
    }

    abstract public void odrediDekoracijuForme();
}
