package personnage;

import java.util.Random;

public class Retiaire extends Personnage {
	private String classe = "Retiaire";
	//On crée une variable booléenne pour le filet de notre Retiaire
	private boolean filet = true;
	
    // -------------------------------------------------------------------------
	
    public Retiaire(String nom, int attMax, int def, int pv, int init) {
        // TODO : Constructeur avec paramètres
    	super(nom, attMax, def, pv, init);
    }
	
    // -------------------------------------------------------------------------

	public String getClasse() {
		return classe;
	}

	public boolean isFilet() {
		return filet;
	}
	
	// -------------------------------------------------------------------------

	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public void setFilet(boolean filet) {
		this.filet = filet;
	}

	// -------------------------------------------------------------------------
	//On ajoute la classe dans les infos personnage.
	public void afficherInfosPersonnage() {
		super.afficherInfosPersonnage(); 
    	System.out.println("   Classe : " + getClasse() + "\n");
	}
	
	// -------------------------------------------------------------------------

	public void frapperPersonnage(Personnage personnageCible) {

    	int degats;
    	//Si il a son filet alors la variable est sur true et il lance donc son filet mais ne peux pas attaquer
    	if(isFilet() == true) {
    		System.out.println(getNom() + " lance son filet ... \n");
    		setFilet(false);
    		//On teste avec un random si le filet atteint sa cible (10% de chance de toucher)
    		if(randomFilet() <= 10) {
    			//Si le filet touche, le combat est fini car l'adversaire est pris au piège
    			System.out.println("Son filet attrape " + personnageCible.getNom() + " et il l’empale sauvagement avec sa lance.\n");
    			personnageCible.setPv(0);
    			personnageCible.setEstMort(true);
    		}
    		else {
    			//Si le filet ne touche pas, il ne se passe rien et le Retiaire n'attaque pas à ce tour.
    			System.out.println("Le filet n'atteint pas sa cible ... \n");
    		}
    	}
    	else {
    		//Si le filet n'as pas touché il le ramasse et c'est à ce moment qu'il attaque
    		System.out.println(getNom() + " ramasse son filet et en profite pour attaquer !\n");
    		setFilet(true);
    		
    		int valeurAttaque = attaqueCalcul();
        	degats = valeurAttaque - personnageCible.getDef();
        	//Si les dégats sont nuls, le personnage rate tout simplement sont attaque
        	if(degats <= 0) {
        		System.out.println(getNom() + " essaye d'attaquer mais il échoue ... \n");
        	}
        	else {
        		System.out.println(getNom() + " attaque avec une puissance de : " + valeurAttaque);
        		System.out.println(personnageCible.getNom() + " a une défense de : " + personnageCible.getDef());
            	System.out.println("Les dégâts sont de : " + degats + "\n");
            	personnageCible.setPv(personnageCible.getPv() - degats);
            	//On tue le personnage ici si ses pv arrivent à 0 ou moins (ça nous évite de le faire dans le main)
            	if(personnageCible.getPv() <= 0) {
    				personnageCible.setPv(0);
    				personnageCible.setEstMort(true);
            	}
        	}
    	}
    	
    }
	//On randomise le filet entre 0 et 100 pour lui créer une probabilité en pourcentage
	public int randomFilet(){
		Random rand = new Random();
		int chance = rand.nextInt(100-0);
		return chance;
	}
}
