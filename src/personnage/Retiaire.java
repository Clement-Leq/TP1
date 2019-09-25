package personnage;

import java.util.Random;

public class Retiaire extends Personnage {
	private String classe = "Retiaire";
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

	public void afficherInfosPersonnage() {
		super.afficherInfosPersonnage(); 
    	System.out.println("   Classe : " + getClasse() + "\n");
	}
	
	// -------------------------------------------------------------------------

	public void frapperPersonnage(Personnage personnageCible) {

    	int degats;
    	if(isFilet() == true) {
    		System.out.println(getNom() + " lance son filet ... \n");
    		setFilet(false);
    		if(randomFilet() <= 10) {
    			System.out.println("Son filet attrape " + personnageCible.getNom() + " et il l’empale sauvagement avec sa lance.\n");
    			personnageCible.setPv(0);
    			personnageCible.setEstMort(true);
    		}
    		else {
    			System.out.println("Le filet n'atteint pas sa cible ... \n");
    		}
    	}
    	else {
    		System.out.println(getNom() + " ramasse son filet et en profite pour attaquer !\n");
    		setFilet(true);
    		
    		int valeurAttaque = attaqueCalcul();
        	degats = valeurAttaque - personnageCible.getDef();
        	
        	if(degats <= 0) {
        		System.out.println(getNom() + " essaye d'attaquer mais il échoue ... \n");
        	}
        	else {
        		System.out.println(getNom() + " attaque avec une puissance de : " + valeurAttaque);
        		System.out.println(personnageCible.getNom() + " a une défense de : " + personnageCible.getDef());
            	System.out.println("Les dégâts sont de : " + degats + "\n");
            	personnageCible.setPv(personnageCible.getPv() - degats);
            	if(personnageCible.getPv() <= 0) {
    				personnageCible.setPv(0);
    				personnageCible.setEstMort(true);
            	}
        	}
    	}
    	
    }
	
	public int randomFilet(){
		Random rand = new Random();
		int chance = rand.nextInt(100-0);
		return chance;
	}
}
