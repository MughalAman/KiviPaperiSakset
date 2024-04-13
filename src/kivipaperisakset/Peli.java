package kivipaperisakset;

/**
 * Peli-luokka toteuttaa kivi-paperi-sakset -pelin logiikan.
 * @author Aman Mughal
 */
public class Peli {

    public static void main(String args[]) {
        Pelaaja p1 = new Pelaaja();
        Pelaaja p2 = new Pelaaja();
        boolean peliLoppui = false;
        int pelatutPelit = 0;           // Pelattujen pelien lkm
        int tasapelit = 0;              // Tasapelien lkm

        do {
            System.out.println("Erä: " + pelatutPelit + " =====================\n");
            System.out.println("Tasapelien lukumäärä: " + tasapelit + "\n");
            pelaaKierros(p1, p2);
            pelatutPelit++;
            if ((p1.getVoitot() >= 3) || (p2.getVoitot() >= 3)) {
                peliLoppui = true;
                System.out.println("KOLME VOITTOA - PELI PÄÄTTYY");
            }
            System.out.println();
        } while (!peliLoppui);
    }

    /**
     * Suorittaa yhden pelikierroksen.
     * @param p1 Ensimmäinen pelaaja
     * @param p2 Toinen pelaaja
     */
    private static void pelaaKierros(Pelaaja p1, Pelaaja p2) {
        String p1Valinta = p1.pelaajanValinta();
        String p2Valinta = p2.pelaajanValinta();
        System.out.println("Pelaaja 1: " + p1Valinta + "\n\t Pelaaja 1:llä koossa " + p1.getVoitot() + " voittoa.");
        System.out.println("Pelaaja 2: " + p2Valinta + "\n\t Pelaaja 2:lla koossa " + p2.getVoitot() + " voittoa.");

        if (p1Valinta.equals(p2Valinta)) {
            System.out.println("\n\t\t\t Tasapeli \n");
        } else {
            String voittaja = kukaVoittaa(p1Valinta, p2Valinta);
            if ("p1".equals(voittaja)) {
                p1.lisaaVoitto();
                System.out.println("Pelaaja 1 voittaa");
            } else if ("p2".equals(voittaja)) {
                p2.lisaaVoitto();
                System.out.println("Pelaaja 2 voittaa");
            }
        }
    }

    /**
     * Määrittää kierroksen voittajan perustuen pelaajien valintoihin.
     * @param p1Valinta Ensimmäisen pelaajan valinta
     * @param p2Valinta Toisen pelaajan valinta
     * @return Palauttaa merkkijonon "p1" jos ensimmäinen pelaaja voittaa, "p2" jos toinen pelaaja voittaa, tai tyhjän merkkijonon tasapelin tapauksessa.
     */
    private static String kukaVoittaa(String p1Valinta, String p2Valinta) {
        if ((p1Valinta.equals("kivi") && p2Valinta.equals("sakset")) ||
            (p1Valinta.equals("sakset") && p2Valinta.equals("paperi")) ||
            (p1Valinta.equals("paperi") && p2Valinta.equals("kivi"))) {
            return "p1";
        } else if ((p2Valinta.equals("kivi") && p1Valinta.equals("sakset")) ||
                   (p2Valinta.equals("sakset") && p1Valinta.equals("paperi")) ||
                   (p2Valinta.equals("paperi") && p1Valinta.equals("kivi"))) {
            return "p2";
        }
        return "";
    }
}