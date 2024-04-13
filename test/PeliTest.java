package test;

import kivipaperisakset.Peli;
import kivipaperisakset.Pelaaja;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PeliTest {

    @Test
    void kukaVoittaaPalauttaaOikeanVoittajan() {
        assertEquals("p1", Peli.kukaVoittaa("kivi", "sakset"), "Kiven pitäisi voittaa sakset.");
        assertEquals("p2", Peli.kukaVoittaa("sakset", "kivi"), "Kiven pitäisi voittaa sakset.");
        assertEquals("", Peli.kukaVoittaa("kivi", "kivi"), "Saman valinnan pitäisi johtaa tasapeliin.");
    }
}
