package ohtu;

import javax.swing.JTextField;

public class Nollaa extends Komento {

    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
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
        sovellus.nollaa();
        this.tuloskentta.setText(""+sovellus.tulos());
    }

    @Override
    void peru() {
        this.tuloskentta.setText(""+super.edellinen);
        this.syotekentta.setText("");
    }
    
}
