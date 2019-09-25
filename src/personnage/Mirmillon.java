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
	
	public void afficherInfosPersonnage() {
		super.afficherInfosPersonnage();   	
    	System.out.println("   Classe : " + getClasse() + "\n");
	}
	
	// -------------------------------------------------------------------------
	
	public void frapperPersonnage(Personnage personnageCible) {

    	int degats;
    	int valeurAttaque = attaqueCalcul();
    	degats = valeurAttaque - personnageCible.getDef();
    	if (degats <= 0) degats = 0;
    	
    	if(personnageCible.getPv() > 0){
    		if(degats == 0) {
        		System.out.println(getNom() + " essaye d'attaquer mais il �choue ... \n");
        	}
        	else {
        		System.out.println(getNom() + " attaque avec une puissance de : " + valeurAttaque);
        		System.out.println(personnageCible.getNom() + " a une d�fense de : " + personnageCible.getDef());
            	System.out.println("Les d�g�ts sont de : " + degats + "\n");
            	personnageCible.setPv(personnageCible.getPv() - degats);
            	if (personnageCible.getPv() <= 0) {
            		personnageCible.setPv(0);
            		personnageCible.setEstMort(true);
            	}
        	}
    	}
    	else {
        	System.out.println(getNom() + " d�capite " + personnageCible.getNom() + " avec violence !\n");
    	}
    }
	
	// -------------------------------------------------------------------------
	
	public void randomInit(){
		Random rand = new Random();
		setInit(rand.nextInt(30-0));
	}
}
