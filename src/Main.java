public class Main {
    public static void main(String[] args) {
        Personnage[] equipe1 = {
                new Guerrier("Goku", "Dragon Ball", "Kamehameha", 120, 5),
                new Mage("Gandalf", "Le Seigneur des Anneaux", "Éclair blanc", 80, 60)
                                };
        Personnage[] equipe2 = {
                new Archer("Legolas", "Le Seigneur des Anneaux", "Flèche elfique", 90, 6),
                new Guerrier("Zoro", "One Piece", "Santoryu", 110, 8)
                            };
        int manche = 1;
        while (equipeVivante(equipe1) && equipeVivante(equipe2) && manche <= 30)
        {
            System.out.println();
            System.out.println("=== Manche " + manche + " ===");
            jouerEquipe(equipe1, equipe2);
            if (equipeVivante(equipe2)) {
                jouerEquipe(equipe2, equipe1);
            }
            manche++;
        }
        // TODO 1 : quelle équipe a gagné ?
        System.out.println();
        System.out.println("=== FIN DU COMBAT ===");
        if (equipeVivante(equipe1) && !equipeVivante(equipe2)) {
            System.out.println("L'équipe 1 a gagné !");
        } else if (equipeVivante(equipe2) && !equipeVivante(equipe1)) {
            System.out.println("L'équipe 2 a gagné !");
        } else {
            System.out.println("Match nul : limite de 30 manches atteinte.");
        }

        // TODO 2 : état de chaque héros des deux équipes
        System.out.println();
        System.out.println("--- Équipe 1 ---");
        for (Personnage p : equipe1) {
            p.afficherEtat();
        }
        System.out.println("--- Équipe 2 ---");
        for (Personnage p : equipe2) {
            p.afficherEtat();
        }

        // TODO 3 : nombre total de héros créés
        System.out.println("Nombre de héros créés : " + Personnage.getNombrePersonnages());
    }



        // Vrai si au moins un héros de l'équipe est encore vivant
    public static boolean equipeVivante(Personnage[] equipe) {
// TODO : parcourir le tableau et retourner true dès qu'un héros est vivant
        for (Personnage p : equipe) {
            if (p.estVivant()) {
                return true;
            }
        }
// retourner false après la boucle
        return false;
    }

    // Premier héros vivant de l'équipe, ou null si tous sont KO
    public static Personnage premierVivant(Personnage[] equipe) {
        for (Personnage p : equipe) {
            if (p.estVivant()) {
                return p;
            }
        }
        return null;
    }

    // Fait jouer chaque héros vivant de 'attaquants' contre 'adversaires'
    public static void jouerEquipe(Personnage[] attaquants, Personnage[]
            adversaires) {
        for (Personnage heros : attaquants) {
            if (!heros.estVivant()) {
                continue; // un héros KO passe son tour
            }
            Personnage cible = premierVivant(adversaires);
            if (cible == null) {
                return; // plus aucun adversaire : fin de la manche
            }
// TODO : si heros est un Soigneur et que ses PV sont < 40,
// il se soigne lui-même (cast vers Soigneur) ;
            if (heros instanceof Soigneur && heros.getPv() < 40) {
                Soigneur s = (Soigneur) heros;
                s.soigner(heros);
            } else {
                heros.attaquer(cible);
            }
        }

    }
}
