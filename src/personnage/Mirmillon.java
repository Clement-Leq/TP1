package personnage;

import java.util.Random;

public class Mirmillon extends Personnage {
	private String classe = "Mirmillon";
	
	// -------------------------------------------------------------------------
	
	public Mirmillon(String nom, int attMax, int def, int pv, int init) {
        // TODO : Constructeur avec param�tres
    	super(nom, attMax, def, pv, init);
	}
	
	// -------------------------------------------------------------------------
	
	public String getClasse() {
		return classe;
	}
	
	// -------------------------------------------------------------------------
	
	public void setClasse(String classe) {
		this.classe = classe;
	}

	// -------------------------------------------------------------------------
	//On ajoute la classe dans les infos personnage.
	public void afficherInfosPersonnage() {
		super.afficherInfosPersonnage();   	
    	System.out.println("   Classe : " + getClasse() + "\n");
	}
	
	// -------------------------------------------------------------------------
	
	public void frapperPersonnage(Personnage personnageCible) {

		//On met un increment pour pouvoir faire attaquer le mirmillion 2 fois
		int increment = 0;
		do {
			//On met cette condition pour que le message ne s'affiche pas au moment de la d�capitation
			if (increment == 1 && personnageCible.getPv() > 0) {
				System.out.println(getNom() + " frappe de nouveau !\n");
			}
			
			int degats = 0;
	    	int valeurAttaque = attaqueCalcul();
	    	degats = valeurAttaque - personnageCible.getDef();
	    	//On v�rifie les d�gats pour qu'ils ne soit pas n�gatif et qu'ils ne soignent pas l'adversaire
	    	if (degats <= 0) degats = 0;
	    	if(personnageCible.getPv() > 0){
	    		//Si les d�gats sont nuls, le personnage rate tout simplement sont attaque
	    		if(degats == 0) {
	        		System.out.println(getNom() + " essaye d'attaquer mais il �choue ... \n");
	        		increment++;
	        	}
	        	else {
	        		System.out.println(getNom() + " attaque avec une puissance de : " + valeurAttaque);
	        		System.out.println(personnageCible.getNom() + " a une d�fense de : " + personnageCible.getDef());
	            	System.out.println("Les d�g�ts sont de : " + degats + "\n");
	            	personnageCible.setPv(personnageCible.getPv() - degats);
	            	increment++;
	            	//On tue l'ennemi ici si ses pv arrivent � 0 ou moins (�a nous �vite de le faire dans le main)
	            	if (personnageCible.getPv() <= 0) {
	            		personnageCible.setPv(0);
	            		personnageCible.setEstMort(true);
	            	}
	        	}
	    	}
	    	else if (increment == 1){
	        	System.out.println(getNom() + " d�capite " + personnageCible.getNom() + " avec violence !\n");
	        	increment ++;
	    	}
	    	//On sort de la boucle seulement quand le personnage � fait ses 2 attaque (d�capitation comprise)
		}while (increment < 2);
    }
	
	// -------------------------------------------------------------------------
	//On refait une m�thode d'initialisation de l'initiative pour le Mirmillon car il attaque avec une ini entre 0 et 30.
	public void randomInit(){
		Random rand = new Random();
		setInit(rand.nextInt(30-0));
	}
}
