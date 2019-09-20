
package combat;

public class CompteurDeTour {
	
	int compteur;
	
    // -------------------------------------------------------------------------
    public CompteurDeTour() {
        // TODO : Constructeur SANS paramètres qui initialise un compteur de tour (attribut) à 1
    	compteur = 1; 
    }

    // -------------------------------------------------------------------------
    // TODO : Le getter
    
    public int getCompteur() {
		return compteur;
	}
    // TODO : Le setter
    
 	public void setCompteur(int compteur) {
 		this.compteur = compteur;
 	}
 	
    // -------------------------------------------------------------------------
    public void augmenteTour() {
        // TODO : Incrémenter le compteur de tour
    	compteur++;
    }



	// -------------------------------------------------------------------------
    public void afficheTour() {
        // TODO : Afficher le tour actuel, tel que montré dans l'énoncé
    	System.out.println("---------------\r\n" + 
        		"TOUR ACTUEL: " + getCompteur() + "\r\n" + 
        		"---------------\r\n");
    }
}
