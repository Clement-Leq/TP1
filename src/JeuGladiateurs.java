
import personnage.Mirmillon;
import personnage.Personnage;
import personnage.Retiaire;
import combat.CompteurDeTour;
import combat.AffichageEcran;

public class JeuGladiateurs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CompteurDeTour tour = new CompteurDeTour();
        AffichageEcran affichage = new AffichageEcran();
        Mirmillon personnage1 = new Mirmillon("Bob le malchanceux", 15, 15, 70, 15); //L'initialisation du personnage doit se faire dans le constructeur
        Retiaire personnage2 = new Retiaire("Igor l'empaleur", 25, 5, 100, 30); //L'initialisation du personnage doit se faire dans le constructeur
        
        personnage1.afficherInfosPersonnage();
        personnage2.afficherInfosPersonnage();
        System.out.println("<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>\r\n" + 
        		">>>>> Que le combat commence ! <<<<<\r\n" + 
        		"<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>");
        
        while(!personnage1.isEstMort() && !personnage2.isEstMort()) {
        	
        	tour.afficheTour();
        	
        	for(int ini = 0; ini <= 100; ini++) {
        		
        		if(personnage1.getInit() == ini) {
        			personnage1.frapperPersonnage(personnage2);
        			if(personnage2.getPv() <= 0) {
        				personnage2.setPv(0);
        				personnage2.setEstMort(true);
        				break;
        			}
        			else if(personnage1.isDecapite() == true) {
        				System.out.println(personnage1.getNom() + " frappe de nouveau !\n");
        				personnage1.frapperPersonnage(personnage2);
        				personnage1.setDecapite(false);
        				
        			}
        		}
        		if(personnage2.getInit() == ini) {
        			personnage2.frapperPersonnage(personnage1);
        			if(personnage1.getPv() <= 0) {
        				personnage1.setPv(0);
        				personnage1.setEstMort(true);
        				break;
        			}
        		}
        	}
        	
    		affichage.afficherSeparateurInfosPerso();
    		
        	personnage1.afficherInfosPersonnage();
        	personnage2.afficherInfosPersonnage();
        	personnage1.randomInit();
    		personnage2.setNewIniRandom();

        	tour.augmenteTour();
    		affichage.afficherSeparateurDeTour();
        }
        affichage.afficheVictoire(personnage1, personnage2);
    }

}
