package maurotuzzolino.u5_w1_d1_compito.entities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaTest {

    @Test
    public void testPizzaSenzaToppingHaPrezzoECalorieZero() {
        Pizza pizza = new Pizza("Pizza Vuota");

        assertEquals(5.0, pizza.getPrezzo(), 0.01);
        assertEquals(700, pizza.getCalorie());
    }

    @Test
    public void testAggiuntaToppingModificaPrezzoECalorie() {
        Pizza pizza = new Pizza("Test Pizza");
        Topping salame = new Topping("Salame", 1.50, 200);

        pizza.aggiungiTopping(salame);

        assertEquals(6.50, pizza.getPrezzo(), 0.01);
        assertEquals(900, pizza.getCalorie());
    }

    @Test
    public void testCalcoloTotaleOrdine() {
        // Setup
        Tavolo tavolo = new Tavolo(1, 4, true);
        VoceMenu pizza = new Pizza("Pizza Test"); // 5.00 €
        VoceMenu bevanda = new Bevanda("Acqua", 1.00, 0); // 1.00 €
        int coperti = 2;
        double costoCoperto = 2.50;

        Ordine ordine = new Ordine(1, StatoOrdine.INCORSO, coperti, tavolo,
                Arrays.asList(pizza, bevanda), costoCoperto);

        // Totale atteso: (5.00 + 1.00) + (2 * 2.50) = 6.00 + 5.00 = 11.00
        assertEquals(11.00, ordine.getTotale(), 0.01);
    }


    @ParameterizedTest(name = "{index} => toppingsCount={0}, expectedPrice={1}")
    @CsvSource({
            "0, 5.00",
            "1, 6.50",
            "2, 8.00"
    })
    public void testPrezzoPizzaConTopping(int toppingsCount, double expectedPrice) {
        Pizza pizza = new Pizza("Test Pizza");
        Topping prosciutto = new Topping("Prosciutto", 1.50, 150);
        Topping ananas = new Topping("Ananas", 1.50, 150);

        // Aggiungi i topping in base al toppingsCount
        if (toppingsCount >= 1) pizza.aggiungiTopping(prosciutto);
        if (toppingsCount >= 2) pizza.aggiungiTopping(ananas);

        assertEquals(expectedPrice, pizza.getPrezzo(), 0.01);
    }


    @Test
    void testCalcoloTotaleOrdineConCoperti() {
        Tavolo tavolo = new Tavolo(1, 4, true);

        Pizza pizza = new Pizza("Margherita");
        // Margherita base ha prezzo 5 euro come da specifica
        pizza.aggiungiTopping(new Topping("Mozzarella", 1.50, 200));

        Bevanda bevanda = new Bevanda("Acqua Naturale", 1.00, 0);

        // Creo ordine con 3 coperti, costo coperto 2.50 euro
        Ordine ordine = new Ordine(
                101,
                StatoOrdine.INCORSO,
                3,
                tavolo,
                Arrays.asList(pizza, bevanda),
                2.50
        );

        // Calcolo manuale:
        // pizza: 5 (base) + 1.5 (topping) = 6.5
        // bevanda: 1.0
        // coperti: 3 * 2.5 = 7.5
        // totale = 6.5 + 1.0 + 7.5 = 15.0

        double expectedTotale = 15.0;
        assertEquals(expectedTotale, ordine.getTotale(), 0.001);

        // Verifico stato ordine
        assertEquals(StatoOrdine.INCORSO, ordine.getStato());

        // Verifico che il tavolo sia quello giusto
        assertEquals(1, ordine.getTavolo().getNumero());
    }
}
