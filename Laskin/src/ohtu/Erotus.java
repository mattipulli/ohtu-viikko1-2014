package ohtu;

import javax.swing.JTextField;

public class Erotus extends Komento {

    public Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        super.sovellus=sovellus;
        super.tuloskentta=tuloskentta;
        super.syotekentta=syotekentta;
    }
    
    @Override
    void suorita() {
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        this.edellinen=arvo;
        sovellus.miinus(arvo);
        this.tuloskentta.setText(""+sovellus.tulos());
    }

    @Override
    void peru() {
        sovellus.plus((super.edellinen));
        this.tuloskentta.setText(""+sovellus.tulos());
        this.syotekentta.setText("");
    }
    
}
