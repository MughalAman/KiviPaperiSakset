package kivipaperisakset;

/**
 * Luokka edustaa kivi-paperi-sakset -pelin pelaajaa.
 * Pelaaja voi valita kiven, paperin tai sakset ja pitää kirjaa voitoistaan.
 * @author Aman Mughal
 */
public class Pelaaja {

    private int voitot; // Pelaajan voittojen lukumäärä

    /**
     * Luo uuden pelaajan.
     */
    public Pelaaja() {
        this.voitot = 0;
    }

    /**
     * Valitsee satunnaisesti kiven, paperin tai sakset.
     * 
     * @return Pelaajan valinta merkkijonona.
     */
    public String pelaajanValinta() {
        String valinta = "";
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                valinta = "kivi";
                break;
            case 1:
                valinta = "paperi";
                break;
            case 2:
                valinta = "sakset";
                break;
        }
        return valinta;
    }

    /**
     * Lisää yhden voiton pelaajan voittojen kokonaismäärään.
     */
    public void lisaaVoitto() {
        this.voitot++;
    }

    /**
     * Palauttaa pelaajan voittojen kokonaismäärän.
     * 
     * @return Pelaajan voittojen lukumäärä.
     */
    public int getVoitot() {
        return this.voitot;
    }
}