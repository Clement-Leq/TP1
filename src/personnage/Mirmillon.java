package personnage;

import java.util.Random;

public class Mirmillon extends Personnage {
	private String classe = "Mirmillon";
	private boolean decapite = false;
	
	// -------------------------------------------------------------------------
	
	public Mirmillon(String nom, int attMax, int def, int pv, int init) {
        // TODO : Constructeur avec paramètres
    	super(nom, attMax, def, pv, init);
	}
	
	// -------------------------------------------------------------------------
	
	public String getClasse() {
		return classe;
	}
	
	public boolean isDecapite() {
		return decapite;
	}

	// -------------------------------------------------------------------------
	
	public void setClasse(String classe) {
		this.classe = classe;
	}
	
	public void setDecapite(boolean decapite) {
		this.decapite = decapite;
	}


	// -------------------------------------------------------------------------
	
	public void afficherInfosPersonnage() {
		super.afficherInfosPersonnage();   	
    	System.out.println("   Classe : " + getClasse() + "\n");
	}
	
	// -------------------------------------------------------------------------
	
	public void frapperPersonnage(Personnage personnageCible) {

    	int degats;
    	int valeurAttaque = attaqueCalcul();
    	degats = valeurAttaque - personnageCible.getDef();
    	if (degats <= 0) {
    		degats = 0;
    	}
    	personnageCible.setPv(personnageCible.getPv() - degats);
    	
    	
    	if(personnageCible.getPv() > 0){
    		if(degats <= 0) {
        		System.out.println(getNom() + " essaye d'attaquer mais il échoue ... \n");
        		setDecapite(true);
        	}
        	else {
        		System.out.println(getNom() + " attaque avec une puissance de : " + valeurAttaque);
        		System.out.println(personnageCible.getNom() + " a une défense de : " + personnageCible.getDef());
            	System.out.println("Les dégâts sont de : " + degats + "\n");
            	setDecapite(true);
        	}
    	}
    	else if (isDecapite() || personnageCible.getPv() <= 0) {
        		System.out.println(getNom() + " décapite " + personnageCible.getNom() + " avec violence !\n");
        		setDecapite(true);
    	}
    	
    }
    	
	
	// -------------------------------------------------------------------------
	
	public int randomInit(){
		Random rand = new Random();
		int ini = rand.nextInt(30-0);
		return ini;
	}
}
