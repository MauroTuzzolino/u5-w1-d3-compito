package maurotuzzolino.u5_w1_d1_compito.entities;

import java.util.List;

public class Menu {
    private List<VoceMenu> voci;

    public Menu(List<VoceMenu> voci) {
        this.voci = voci;
    }

    public List<VoceMenu> getVoci() {
        return voci;
    }

    public void stampaMenu() {
        System.out.println("=== MENÙ PIZZERIA ===");
        for (VoceMenu voce : voci) {
            System.out.printf("- %s: %.2f€ (%d cal)%n", voce.getNome(), voce.getPrezzo(), voce.getCalorie());
        }
    }
}
