public class Mage extends Personnage implements Soigneur  {
    private int mana;

    public Mage(String nom, String univers, String attaqueSpeciale, int pv,
                int mana) {
        super(nom, univers, attaqueSpeciale, pv);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }
    @Override
    public void soigner(Personnage cible) {
        if (!estVivant()) {
            System.out.println(getNom() + " est KO et ne peut pas soigner");
            return;
        }
        if (!cible.estVivant()) {
            System.out.println(cible.getNom() + " est KO : impossible de le soigner");
            return;
        }
        if(mana < 15){
            System.out.println(getNom() + " n'a pas assez de mana pour soigner");
            return;
        }
        mana = mana -  15;
        setPv(getPv() + PUISSANCE_SOIN);
        System.out.println(getNom() + " soigne " + cible.getNom() + " : +" + PUISSANCE_SOIN + " pv");

    }



    @Override
    public void afficherEtat() {
            super.afficherEtat();
            System.out.println("mana : " + mana);
    }

    @Override
    public void monterDeNiveau() {
          super.monterDeNiveau();
        mana = mana + 10;
        System.out.println("mana : " + mana);
    }

    @Override
    protected int calculerDegats() {
        if (mana >= 10) {
          mana = mana - 10 ;
            return degatsDeBase() + 15;
        }
        System.out.println(getNom()+"  n'a plus assez de mana : attaque affaiblie");
        return degatsDeBase() / 2;
    }

}