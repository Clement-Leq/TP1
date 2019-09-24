
package personnage;

import java.util.Random;

public class Personnage {
	private String nom;
	private int attMax;
	private int def;
	private int pv;
	private int init;
	private boolean estMort = false;
	
    // -------------------------------------------------------------------------
	
    public Personnage(String nom, int attMax, int def, int pv, int init) {
        // TODO : Constructeur AVEC paramètres
    	this.nom = nom;
    	this.attMax = attMax;
    	this.def = def;
    	this.pv = pv;
    	this.init = init;
    }

    // -------------------------------------------------------------------------
    
    public Personnage() {
        // TODO : Constructeur SANS paramètres qui initialise à ZÉRO ou à ""
    	nom = "";
    	attMax = 0;
    	def = 0;
    	pv = 0;
    	init = 0;
    	estMort = false;
    }

    // -------------------------------------------------------------------------
    // TODO : Les getters
    
    public String getNom() {
		return nom;
	}
    
    public int getAttMax() {
		return attMax;
	}
    
    public int getDef() {
		return def;
	}
    
    public int getPv() {
		return pv;
	}
    
    public int getInit() {
		return init;
	}
    
    public boolean isEstMort() {
		return estMort;
	}

    // -------------------------------------------------------------------------
    // TODO : Les setters
    
    public void setNom(String nom) {
		this.nom = nom;
	}
    
    public void setAttMax(int attMax) {
		this.attMax = attMax;
	}
    
    public void setDef(int def) {
		this.def = def;
	}
    
    public void setPv(int pv) {
		this.pv = pv;
	}
    
    public void setInit(int init) {
		this.init = init;
	}

    public void setEstMort(boolean estMort) {
		this.estMort = estMort;
	}

    // -------------------------------------------------------------------------
    
    public void afficherInfosPersonnage() {
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
    	System.out.println(getNom());
    	System.out.println("   Attaque : " + getAttMax());
    	System.out.println("   D�fense : " + getDef());
    	System.out.println("   Points de vie : " + getPv());
    	System.out.println("   Initiative : " + getInit());
    	
    	if(isEstMort() == true) System.out.println("   Statut : Mort");
    	else System.out.println("   Statut : Vivant"); 
    }

	// -------------------------------------------------------------------------
    
    public int attaqueCalcul() {
        // TODO : Retourner la valeur de l'attaque du personnage.
        // Cette valeur est trouvée aléatoirement et doit se situer entre ZÉRO et valeurMaxAttaque.
    	Random rand = new Random();
    	int attaque = rand.nextInt(getAttMax() - 0);
    	return attaque;
    }

    // -------------------------------------------------------------------------
    
    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        //modifier les points de vie du personnage cible, afficher les détails
        // sur l'attaque, tel que montré dans l'énoncé.
    	int degats;
    	int valeurAttaque = attaqueCalcul();
    	degats = valeurAttaque - personnageCible.getDef();
    	
    	if(degats <= 0) {
    		System.out.println(getNom() + " essaye d'attaquer mais il �choue ... \n");
    	}
    	else {
    		System.out.println(getNom() + " attaque avec une puissance de : " + valeurAttaque);
    		System.out.println(personnageCible.getNom() + " a une d�fense de : " + personnageCible.getDef());
        	System.out.println("Les d�g�ts sont de : " + degats + "\n");
        	personnageCible.setPv(personnageCible.getPv() - degats);
    	}
    }

    // -------------------------------------------------------------------------
    
    public void setNewIniRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
    	Random rand =  new Random();
    	setInit(rand.nextInt(100-0));
    }
}
