package ohtu;

import javax.swing.JTextField;

public class Summa extends Komento {

    public Summa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
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
        sovellus.plus(arvo);
        this.tuloskentta.setText(""+sovellus.tulos());
        
    }

    @Override
    void peru() {
        sovellus.miinus((super.edellinen));
        this.tuloskentta.setText(""+sovellus.tulos());
        this.syotekentta.setText("");
    }
    
}
