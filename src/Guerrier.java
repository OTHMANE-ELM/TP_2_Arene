import org.w3c.dom.ls.LSOutput;

public class Guerrier extends Personnage {
    private int armure;
    public Guerrier(String nom, String univers, String attaqueSpeciale, int pv, int armure) {
        super(nom, univers, attaqueSpeciale, pv); // constructeur de Personnage a l'aide de super
        this.armure = armure;
    }
    public int getArmure() {
        return armure;
    }
    public void renforcerArmure(int points) {
        armure = armure + points;
    }
    @Override
    public void afficherEtat() {
        super.afficherEtat(); // réutilise l'afficha de Personnage
        System.out.println("Armure : " + armure);
    }
        @Override
        public void monterDeNiveau() {
            super.monterDeNiveau(); // niveau + 1 et +20 pv
            armure = armure + 2;
            System.out.println(getNom() + " gagne 2 points d'armure (total : " + armure + ")");
        }
               // Méthode propre au Guerrier : elle appelle une méthode protected de Personnage
        public void afficherPuissance() {
            System.out.println(getNom() + " inflige " + degatsDeBase() + " dégâts de base");
        }

    @Override
    protected int calculerDegats() {
        return degatsDeBase() + armure;
    }


}
