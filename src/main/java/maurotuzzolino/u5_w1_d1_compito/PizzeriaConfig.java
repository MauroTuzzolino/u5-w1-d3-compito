package maurotuzzolino.u5_w1_d1_compito;

import maurotuzzolino.u5_w1_d1_compito.entities.Bevanda;
import maurotuzzolino.u5_w1_d1_compito.entities.Menu;
import maurotuzzolino.u5_w1_d1_compito.entities.Pizza;
import maurotuzzolino.u5_w1_d1_compito.entities.Topping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class PizzeriaConfig {

    @Value("${coperto.prezzo}")
    private double prezzoCoperto;

    @Bean
    public Double prezzoCoperto() {
        return prezzoCoperto;
    }

    @Bean
    public Topping prosciutto() {
        return new Topping("Prosciutto", 1.50, 150);
    }

    @Bean
    public Topping ananas() {
        return new Topping("Ananas", 1.00, 80);
    }

    @Bean
    public Pizza hawaiiPizza(Topping prosciutto, Topping ananas) {
        Pizza pizza = new Pizza("Hawaii Pizza");
        pizza.aggiungiTopping(prosciutto);
        pizza.aggiungiTopping(ananas);
        return pizza;
    }

    @Bean
    public Pizza doppioProsciutto(Topping prosciutto) {
        Pizza pizza = new Pizza("Pizza Doppio Prosciutto");
        pizza.aggiungiTopping(prosciutto);
        pizza.aggiungiTopping(prosciutto);
        return pizza;
    }

    @Bean
    public Bevanda cocaCola() {
        return new Bevanda("Coca Cola", 2.00, 140);
    }

    @Bean
    public Bevanda acqua() {
        return new Bevanda("Acqua Naturale", 1.00, 0);
    }

    @Bean
    public Menu menu(Pizza hawaiiPizza, Pizza doppioProsciutto, Bevanda cocaCola, Bevanda acqua) {
        return new Menu(Arrays.asList(hawaiiPizza, doppioProsciutto, cocaCola, acqua));
    }
}
