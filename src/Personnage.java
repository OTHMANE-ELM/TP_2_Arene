public abstract class Personnage
{

    // Attributs d'instance
    private static int nombrePersonnages = 0;
    private String nom = "Inconnu"; // valeur de secours (voir étape 1.4)
    private String univers;
    private String attaqueSpeciale;
    private int pv;
    private int niveau;

    public Personnage(String nom, String univers, String attaqueSpeciale, int
            pv) {
        setNom(nom); // validation réutilisée
        this.univers = univers;
        this.attaqueSpeciale = attaqueSpeciale;
        setPv(pv); // validation réutilisée
        this.niveau = 1;
        nombrePersonnages++;
    }

    public static int getNombrePersonnages() {
        return nombrePersonnages;
    }

    public String getNom() {
        return nom;
    }

    public String getUnivers() {
        return univers;
    }

    public String getAttaqueSpeciale() {
        return attaqueSpeciale;
    }

    public int getPv() {
        return pv;
    }

    public int getNiveau() {
        return niveau;
    }

    public static void setNombrePersonnages(int nombrePersonnages) {
        Personnage.nombrePersonnages = nombrePersonnages;
    }

    public void setNom(String nom) {
        if(nom == null || nom.trim().length() < 2) {
            System.out.println("Nom invalide ");
        }
        this.nom = nom.trim();
    }

    public void setUnivers(String univers) {
        this.univers = univers;
    }

    public void setAttaqueSpeciale(String attaqueSpeciale) {
        this.attaqueSpeciale = attaqueSpeciale;
    }

    public void setPv(int pv) {
        if (pv < 0) {
            this.pv = 0; // un personnage n'a jamais de PV négatifs
        } else {
            this.pv = pv;
        }
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public boolean estVivant() {
        return pv > 0;
    }
    public void afficherEtat() {
        String ko = "";
        if (!estVivant()) {
            ko = " [KO]";
        }
        System.out.println("--- " + nom + " (" + univers + ")" + ko + " ---");
                System.out.println("PV : " + pv);
        System.out.println("Niveau : " + niveau);
        System.out.println("Attaque : " + attaqueSpeciale);
    }
    public void monterDeNiveau() {
        niveau++;
        setPv(getPv() + 20);
        System.out.println(nom + " passe au niveau " + niveau
                + " ! (+20 pv, total : " + pv + ")");
    }
    public void attaquer(Personnage cible) {
// Règle 1 : l'attaquant est KO
        if (!this.estVivant()) {
            System.out.println(this.nom + " est KO et ne peut pas attaquer");
            return;
        }
// Règle 2 : la cible est déjà KO
        if (!cible.estVivant()) {
            System.out.println(cible.nom + " est déjà KO");
            return;
        }
// Règles 3 et 4 : dégâts de base, doublés tous les 3 niveaux
        boolean special = estAttaqueSpeciale();
        int degats = calculerDegats();
// Règle 5 : appliquer les dégâts sans descendre sous 0
        cible.setPv(cible.getPv() - degats);
// Règle 6 : affichage
        if (special) {
            System.out.println(nom + " attaque " + cible.nom + " avec "
                    + attaqueSpeciale + " : -" + degats + " pv");
        } else {
            System.out.println(nom + " attaque " + cible.nom + " : -" +
                    degats + " pv");
        }
    }

    // Règle 4 : une attaque spéciale tous les 3 niveaux
    private boolean estAttaqueSpeciale() {
        return niveau % 3 == 0;
    }

    // Règles 3 et 4 : dégâts de base, doublés si attaque spéciale
    protected int degatsDeBase() {
        int degats = 10 + niveau * 5;
        if (estAttaqueSpeciale()) {
            degats = degats * 2;
        }
        return degats;
    }
    protected abstract int calculerDegats();


}




