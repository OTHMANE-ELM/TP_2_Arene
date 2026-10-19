public class Archer extends Personnage {
    private int fleches;
public Archer(String nom,String univers,String attaqueSpeciale,int pv,int fleches){
    super(nom,univers,attaqueSpeciale,pv);
    this.fleches = fleches;

}
    public int getFleches() {
        return fleches;
    }

    @Override
    public void afficherEtat() {
        super.afficherEtat();
        System.out.println("Archer : " + getFleches());
    }

    @Override
    protected int calculerDegats() {
        if(fleches > 0){
            fleches--;
             return degatsDeBase() + 8;
        }
        else {
            System.out.println(getNom() +" n'a plus de flèches : coup de poing");
            return  5;
        }

    }




}
