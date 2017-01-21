package ram.fichaspokerapp;

import org.junit.Test;

import ram.fichaspokerapp.modelo.*;


import static org.junit.Assert.assertEquals;

/**
 * Created by Samsung on 20/01/2017.
 */

public class ListaDeJugadoresTest {

    @Test
    public void pideElNombreDelJugadorTest() {

        ListaDeJugadores lista = new ListaDeJugadores();
        Jugador jugador3 = new Jugador("Marcos");
        Jugador jugador4 = new Jugador("Robert");
        lista.add(jugador3);
        lista.add(jugador4);

       assertEquals("Robert", lista.get(1).getNombre());

    }

    @Test
    public void pasaAlSiguienteJugadorNoUltimoTest() {

        ListaDeJugadores lista = new ListaDeJugadores();
        Jugador jugador3 = new Jugador("Marcos");
        Jugador jugador4 = new Jugador("Robert");
        Jugador jugador5 = new Jugador("Braian");
        Jugador jugador6 = new Jugador("Andres");
        Jugador jugador7 = new Jugador("Pablo Repetto");

        lista.add(jugador3);
        lista.add(jugador4);
        lista.add(jugador5);
        lista.add(jugador6);
        lista.add(jugador7);

        Jugador siguienteARobert = lista.siguiente(jugador4);

        assertEquals("Braian", siguienteARobert.getNombre());

    }

    @Test
    public void pasaAlSiguienteJugadorDspUltimoTest() {

        ListaDeJugadores lista = new ListaDeJugadores();
        Jugador jugador3 = new Jugador("Marcos");
        Jugador jugador4 = new Jugador("Robert");
        Jugador jugador5 = new Jugador("Braian");
        Jugador jugador6 = new Jugador("Andres");
        Jugador jugador7 = new Jugador("Pablo Repetto");

        lista.add(jugador3);
        lista.add(jugador4);
        lista.add(jugador5);
        lista.add(jugador6);
        lista.add(jugador7);

        Jugador siguienteAPablo = lista.siguiente(jugador7);

        assertEquals("Marcos", siguienteAPablo.getNombre());

    }
}