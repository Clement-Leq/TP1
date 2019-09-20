
package combat;

import personnage.Personnage;


public class AffichageEcran {

    // -------------------------------------------------------------------------
    public void afficherSeparateurDeTour() {
        // TODO : Afficher un retour à la ligne, suivi d'une ligne d'astérisques, tel que montré dans l'énoncé
    	System.out.println("*************************************\r\n");
    }

    // -------------------------------------------------------------------------
    public void afficherSeparateurInfosPerso() {
        // TODO : Afficher un retour à la ligne, suivi du séparateur "infos personnages", tel que montré dans l'énoncé
    	System.out.println("-----------------\r\n" + 
    			"INFOS PERSONNAGES\r\n" + 
    			"-----------------\n");
    }

    // -------------------------------------------------------------------------
    public void afficheVictoire(Personnage personnage1, Personnage personnage2) {
        // TODO : Afficher le gagnant du combat, tel que montré dans l'énoncé
    	if(personnage1.isEstMort() == true) {
    		System.out.println(personnage2.getNom() + " gagne le combat !!!");
    	}
    	else if(personnage2.isEstMort() == true) {
    		System.out.println(personnage1.getNom() + " gagne le combat !!!");
    	}
    }
}
