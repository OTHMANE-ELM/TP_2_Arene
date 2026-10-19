public class Potion implements Soigneur {
    private int charges;
    public Potion(int charges) {
        this.charges = charges;
    }
    @Override
    public void soigner(Personnage cible) {
        // TODO : si charges == 0, afficher "La potion est vide" et sortir
        if(charges == 0){
            System.out.println("La potion est vide");
            return;
        }
        // TODO : retirer une charge
        charges--;
        // TODO : ajouter PUISSANCE_SOIN * 2 aux PV de la cible
        cible.setPv(PUISSANCE_SOIN * 2);
        // TODO : afficher "Une potion soigne <cible> : +50 pv"
        System.out.println("Une potion soigne "+cible.getNom()+ " " + cible.getPv());

    }
}