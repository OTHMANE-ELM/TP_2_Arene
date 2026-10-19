public interface Soigneur {
    // Constante : implicitement public static final
    int PUISSANCE_SOIN = 25;
    // Méthode abstraite : implicitement public abstract, donc pas de corps
    void soigner(Personnage cible);
}
