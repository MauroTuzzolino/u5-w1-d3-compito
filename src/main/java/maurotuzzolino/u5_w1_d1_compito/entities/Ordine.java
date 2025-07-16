package maurotuzzolino.u5_w1_d1_compito.entities;

import java.time.LocalTime;
import java.util.List;

public class Ordine {
    private int numero;
    private StatoOrdine stato;
    private int numeroCoperti;
    private LocalTime oraAcquisizione;
    private Tavolo tavolo;
    private List<VoceMenu> elementi;
    private double costoCoperto;

    public Ordine(int numero, StatoOrdine stato, int numeroCoperti, Tavolo tavolo, List<VoceMenu> elementi, double costoCoperto) {
        this.numero = numero;
        this.stato = stato;
        this.numeroCoperti = numeroCoperti;
        this.tavolo = tavolo;
        this.elementi = elementi;
        this.oraAcquisizione = LocalTime.now();
        this.costoCoperto = costoCoperto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public StatoOrdine getStato() {
        return stato;
    }

    public void setStato(StatoOrdine stato) {
        this.stato = stato;
    }

    public int getNumeroCoperti() {
        return numeroCoperti;
    }

    public void setNumeroCoperti(int numeroCoperti) {
        this.numeroCoperti = numeroCoperti;
    }

    public LocalTime getOraAcquisizione() {
        return oraAcquisizione;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public void setTavolo(Tavolo tavolo) {
        this.tavolo = tavolo;
    }

    public List<VoceMenu> getElementi() {
        return elementi;
    }

    public void setElementi(List<VoceMenu> elementi) {
        this.elementi = elementi;
    }

    public double getCostoCoperto() {
        return costoCoperto;
    }

    public void setCostoCoperto(double costoCoperto) {
        this.costoCoperto = costoCoperto;
    }

    public double getTotale() {
        double totaleElementi = elementi.stream().mapToDouble(VoceMenu::getPrezzo).sum();
        return totaleElementi + (numeroCoperti * costoCoperto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("=== ORDINE #" + numero + " ===\n");
        sb.append("Tavolo: ").append(tavolo.getNumero()).append(" | Stato: ").append(stato).append("\n");
        sb.append("Coperti: ").append(numeroCoperti).append(" | Ora: ").append(oraAcquisizione).append("\n");
        sb.append("Elementi:\n");
        for (VoceMenu voce : elementi) {
            sb.append("- ").append(voce.getNome()).append(" (").append(voce.getPrezzo()).append("€)\n");
        }
        sb.append("Totale: ").append(String.format("%.2f", getTotale())).append("€\n");
        return sb.toString();
    }
}
