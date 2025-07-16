package maurotuzzolino.u5_w1_d1_compito.entities;

import java.util.ArrayList;
import java.util.List;

public class Pizza implements VoceMenu {
    private String nome;
    private List<Topping> extraToppings = new ArrayList<>();

    public Pizza(String nome) {
        this.nome = nome;
    }

    public void aggiungiTopping(Topping topping) {
        extraToppings.add(topping);
    }

    @Override
    public String getNome() {
        if (extraToppings.isEmpty()) return nome;
        StringBuilder sb = new StringBuilder(nome + " con ");
        for (Topping t : extraToppings) {
            sb.append(t.getNome()).append(", ");
        }
        return sb.substring(0, sb.length() - 2); //Mi serve per rimuovere l'ultima virgola;
    }

    @Override
    public double getPrezzo() {
        double base = 5.00;
        for (Topping t : extraToppings) base += t.getPrezzo();
        return base;
    }

    public int getCalorie() {
        int base = 700;
        for (Topping t : extraToppings) base += t.getCalorie();
        return base;
    }
}
