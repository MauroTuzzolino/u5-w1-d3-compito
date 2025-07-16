package maurotuzzolino.u5_w1_d1_compito;

import maurotuzzolino.u5_w1_d1_compito.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class GestioneOrdiniRunner implements CommandLineRunner {

    @Autowired
    private Menu menu;

    @Autowired
    private Double prezzoCoperto;

    @Override
    public void run(String... args) {
        // Crea un tavolo
        Tavolo tavolo1 = new Tavolo(1, 4, true);

        // Seleziona 3 voci dal menu
        VoceMenu voce1 = menu.getVoci().get(0);
        VoceMenu voce2 = menu.getVoci().get(1);
        VoceMenu voce3 = menu.getVoci().get(2);

        // Crea ordine passando tutto nel costruttore
        Ordine ordine = new Ordine(
                1001,
                StatoOrdine.INCORSO,
                3,
                tavolo1,
                Arrays.asList(voce1, voce2, voce3),
                prezzoCoperto
        );

        // Stampa ordine (usa toString)
        System.out.println(ordine);
    }
}

