package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

class FilmarkivTest {
    private Filmarkiv filmarkiv;

    @BeforeEach
    void setUp() {
        filmarkiv = new Filmarkiv(5); // Starter med en liten tabell
        filmarkiv.leggTilFilm(new Film(1, "Spielberg", "Jurassic Park", 1993, Sjanger.ACTION, "Universal"));
        filmarkiv.leggTilFilm(new Film(2, "Nolan", "Inception", 2010, Sjanger.SCIFI, "Warner Bros"));
        filmarkiv.leggTilFilm(new Film(3, "Cameron", "Titanic", 1997, Sjanger.DRAMA, "Paramount"));
    }

    @Test
    void testLeggTilFilm() {
        int antallFør = filmarkiv.antall();
        filmarkiv.leggTilFilm(new Film(4, "Ridley Scott", "Gladiator", 2000, Sjanger.HISTORY, "DreamWorks"));
        assertEquals(antallFør + 1, filmarkiv.antall(), "Antall filmer økte ikke riktig!");
    }

    @Test
    void testFinnFilm() {
        Film film = filmarkiv.finnFilm(2);
        assertNotNull(film, "Filmen ble ikke funnet!");
        assertEquals("Inception", film.getTittel(), "Feil film ble funnet!");
    }

    @Test
    void testSlettFilm() {
        assertTrue(filmarkiv.slettFilm(1), "Filmen ble ikke slettet!");
        assertNull(filmarkiv.finnFilm(1), "Filmen finnes fortsatt etter sletting!");
        assertEquals(2, filmarkiv.antall(), "Antall filmer er feil etter sletting!");
    }

    @Test
    void testSoekTittel() {
        Film[] treff = filmarkiv.soekTittel("Titanic");
        assertEquals(1, treff.length, "Feil antall treff på søk!");
        assertEquals("Titanic", treff[0].getTittel(), "Feil film funnet!");
    }

    @Test
    void testAntallSjanger() {
        assertEquals(1, filmarkiv.antall(Sjanger.ACTION), "Feil antall Action-filmer!");
        assertEquals(1, filmarkiv.antall(Sjanger.DRAMA), "Feil antall Drama-filmer!");
        assertEquals(0, filmarkiv.antall(Sjanger.HISTORY), "Feil antall History-filmer!");
    }
}
