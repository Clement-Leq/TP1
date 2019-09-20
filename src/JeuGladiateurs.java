
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
        		"<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>\r\n");
        
        while(!personnage1.isEstMort() && !personnage2.isEstMort()) {
        	
        	tour.afficheTour();
        	
        	for(int ini = 0; ini < 100; ini++) {
        		
        		if(personnage1.getInit() == ini) {
        			personnage1.frapperPersonnage(personnage2);
        			if(personnage2.getPv() <= 0) {
        				personnage2.setPv(0);
        				personnage2.setEstMort(true);
        				continue;
        			}
        		}
        		if(personnage2.getInit() == ini) {
        			personnage2.frapperPersonnage(personnage1);
        			if(personnage1.getPv() <= 0) {
        				personnage1.setPv(0);
        				personnage1.setEstMort(true);
        				continue;
        			}
        		}
        	}
        	
    		affichage.afficherSeparateurInfosPerso();
    		
        	personnage1.afficherInfosPersonnage();
        	personnage2.afficherInfosPersonnage();
        	
        	personnage1.setNewIniRandom();
    		personnage2.setNewIniRandom();
        	tour.augmenteTour();
    		affichage.afficherSeparateurDeTour();
        }
        affichage.afficheVictoire(personnage1, personnage2);
    }

}
