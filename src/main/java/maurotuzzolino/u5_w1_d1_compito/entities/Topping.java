package maurotuzzolino.u5_w1_d1_compito.entities;

public class Topping {
    private String nome;
    private double prezzo;
    private int calorie;

    public Topping(String nome, double prezzo, int calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

    public String getNome() {
        return nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public int getCalorie() {
        return calorie;
    }
}
