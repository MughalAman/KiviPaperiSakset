# KIVIPAPERISAKSET - Aman Mughal

[TOC]

## Huomiot

1. Voittojen laskenta: Pelaaja-luokan setVoitot-metodi ei toimi oikein. Se luo uuden paikallisen muuttujan voitotYhteensä, joka ei vaikuta pelaajan voittojen kokonaismäärään. Tämä on korjattava.
2. String-vertailu: Koodissa käytetään == operaattoria String-vertailuun (if (p1Valinta == p2Valinta)), mikä ei ole suositeltavaa. Tulee käyttää equals-metodia.
3. Voittojen päivitys: Pelaajien voittojen päivitys (p1Voitot ja p2Voitot) ei päivity Pelaaja-olion voitot-muuttujaan. Tämä johtuu siitä, että voittojen määrää hallinnoidaan sekä Peli- että Pelaaja-luokassa.

## Muutokset ja Refaktorointi

### `Pelaaja.java`-luokan muutokset

1. **Voittojen laskennan korjaus**: Lisätty [lisaaVoitto](/src/kivipaperisakset/Peli.java#45%2C20-45%2C20)-metodi, joka kasvattaa pelaajan voittojen määrää.
2. **Satunnaisen valinnan toteutus**: [pelaajanValinta](/src/kivipaperisakset/Peli.java#35%2C31-35%2C31)-metodi palauttaa satunnaisesti "kivi", "paperi", tai "sakset".
3. **Voittojen määrän palauttaminen**: [getVoitot](/src/kivipaperisakset/Peli.java#21%2C21-21%2C21)-metodi palauttaa pelaajan voittojen kokonaismäärän.

### `Peli.java`-luokan muutokset

1. **Pelilogiikan eriyttäminen**: Pelilogiikka on siirretty [main](/src/kivipaperisakset/Peli.java#9%2C24-9%2C24)-metodista [pelaaKierros](/src/kivipaperisakset/Peli.java#19%2C13-19%2C13)-metodiin, mikä parantaa koodin selkeyttä ja mahdollistaa pelilogiikan uudelleenkäytön.
2. **Voittojen laskennan korjaus**: Poistettu turhat `p1Voitot` ja `p2Voitot` muuttujat. Voittojen laskenta tapahtuu suoraan [Pelaaja](/src/kivipaperisakset/Peli.java#10%2C9-10%2C9)-olion kautta käyttäen [lisaaVoitto](/src/kivipaperisakset/Peli.java#45%2C20-45%2C20)- ja [getVoitot](/src/kivipaperisakset/Peli.java#21%2C21-21%2C21)-metodeja.
3. **String-vertailun korjaus**: Korjattu [String](/src/kivipaperisakset/Peli.java#9%2C29-9%2C29)-vertailut käyttämään [equals](/src/kivipaperisakset/Peli.java#40%2C23-40%2C23)-metodia `==` operaattorin sijaan.
4. **Voittajan määrittäminen**: Lisätty [kukaVoittaa](/src/kivipaperisakset/Peli.java#43%2C31-43%2C31)-metodi, joka määrittää kierroksen voittajan pelaajien valintojen perusteella.

### Testien lisäys

1. **`PelaajaTest.java`**: Luotu testit [Pelaaja](/src/kivipaperisakset/Peli.java#10%2C9-10%2C9)-luokalle, jotka varmistavat voittojen laskennan toimivuuden ja satunnaisen valinnan validiuden.
2. **`PeliTest.java`**: Luotu testit [Peli](/src/kivipaperisakset/Peli.java#4%2C4-4%2C4)-luokalle, jotka testaavat voittajan määrittämisen logiikkaa. Huomautus: Tämä vaatii, että [Peli](/src/kivipaperisakset/Peli.java#4%2C4-4%2C4)-luokkaa refaktoroidaan testattavaksi, esimerkiksi eriyttämällä pelilogiikka syötteiden ja tulosteiden käsittelystä.

### Yleiset parannukset

- **Koodin selkeyden parantaminen**: Eriyttämällä pelilogiikka omiin metodeihinsa, koodista on tehty selkeämpää ja helpommin ymmärrettävää.
- **Testattavuuden parantaminen**: Muutokset mahdollistavat yksikkötestien kirjoittamisen, mikä parantaa ohjelman laatua ja vähentää virheiden määrää.
- **Dokumentaation lisääminen**: Lisätty ja päivitetty Javadoc-kommentteja, mikä parantaa koodin dokumentaatiota ja helpottaa sen ymmärtämistä.

