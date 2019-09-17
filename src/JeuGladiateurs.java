
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
        Personnage personnage1 = new Personnage(); //L'initialisation du personnage doit se faire dans le constructeur
        Personnage personnage2 = new Personnage(); //L'initialisation du personnage doit se faire dans le constructeur
    }

}
