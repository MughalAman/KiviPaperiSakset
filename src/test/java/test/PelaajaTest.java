package test;

import kivipaperisakset.Pelaaja;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PelaajaTest {

    @Test
    void lisaaVoittoKasvattaaVoittojenMaaraa() {
        Pelaaja pelaaja = new Pelaaja();
        pelaaja.lisaaVoitto();
        assertEquals(1, pelaaja.getVoitot(), "Pelaajan voittojen määrän pitäisi kasvaa yhdellä.");
    }

    @Test
    void pelaajanValintaPalauttaaValidinValinnan() {
        Pelaaja pelaaja = new Pelaaja();
        String valinta = pelaaja.pelaajanValinta();
        assertTrue(valinta.equals("kivi") || valinta.equals("paperi") || valinta.equals("sakset"),
                "Pelaajan valinnan pitäisi olla joko kivi, paperi tai sakset.");
    }
}
