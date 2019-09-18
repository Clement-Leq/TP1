
import personnage.Personnage;
import combat.CompteurDeTour;
import combat.AffichageEcran;

public class JeuGladiateurs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CompteurDeTour tour = new CompteurDeTour();
        AffichageEcran affichage = new AffichageEcran();
        Personnage personnage1 = new Personnage("Bob le malchanceux", 15, 15, 70, 15); //L'initialisation du personnage doit se faire dans le constructeur
        Personnage personnage2 = new Personnage("Igor l'empaleur", 25, 5, 100, 30); //L'initialisation du personnage doit se faire dans le constructeur
        
        personnage1.afficherInfosPersonnage();
        personnage2.afficherInfosPersonnage();
        System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>\r\n" + 
        		">>>>> Que le combat commence ! <<<<<\r\n" + 
        		"<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
        
        while(!personnage1.isEstMort() && !personnage2.isEstMort()) {
        	
        	for(int i = 0; i < 100; i++) {
        		
        	}
        	
        	System.out.println("   Statut : Mort\n");
        	personnage1.setEstMort(true);
        }
    }

}
