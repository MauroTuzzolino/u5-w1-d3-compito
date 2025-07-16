package maurotuzzolino.u5_w1_d1_compito.entities;

public class Bevanda implements VoceMenu {
    private String nome;
    private double prezzo;
    private int calorie;

    public Bevanda(String nome, double prezzo, int calorie) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.calorie = calorie;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public int getCalorie() {
        return calorie;
    }
}