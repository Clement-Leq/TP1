
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
        			
        			//On met un "break" afin de sortir de notre boucle si notre personnage tue son ennemi
        			//en premier pour ne pas que l'ennemi puis attaqué après
        			if(personnage2.getPv() <= 0) break;
        		}
        		if(personnage2.getInit() == ini) {
        			personnage2.frapperPersonnage(personnage1);
        			
        			//Même raison que le premier "break"
        			if(personnage1.getPv() <= 0) break;
        		}
        	}
        	//On fait un joli affichage pour que  le combat soit compréhensible et l'interface soit propre :D
    		affichage.afficherSeparateurInfosPerso();
        	personnage1.afficherInfosPersonnage();
        	personnage2.afficherInfosPersonnage();
        	
        	personnage1.randomInit();
    		personnage2.setNewIniRandom();
    		
        	tour.augmenteTour();
    		affichage.afficherSeparateurDeTour();
        }
        //Une fois sorti de la boucle de combat on affiche la victoire du combatant gagnant cette épreuve de force.
        affichage.afficheVictoire(personnage1, personnage2);
    }

}
