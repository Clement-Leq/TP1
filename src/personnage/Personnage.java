
package personnage;

public class Personnage {

    // -------------------------------------------------------------------------
    public Personnage(String nom, int attaqueMax, int defense, int pvs, int ini) {
        // TODO : Constructeur AVEC paramètres
    }

    // -------------------------------------------------------------------------
    public Personnage() {
        // TODO : Constructeur SANS paramètres qui initialise à ZÉRO ou à ""
    }

    // -------------------------------------------------------------------------
    // TODO : Les getters

    // -------------------------------------------------------------------------
    // TODO : Les setters

    // -------------------------------------------------------------------------
    public void afficherInfosPersonnage() {
        // TODO : Afficher les infos du personnage, tel que montré dans l'énoncé
    }

    // -------------------------------------------------------------------------
    private int attaqueCalcul() {
        // TODO : Retourner la valeur de l'attaque du personnage.
        // Cette valeur est trouvée aléatoirement et doit se situer entre ZÉRO et valeurMaxAttaque.
        return 0;
    }

    // -------------------------------------------------------------------------
    public void frapperPersonnage(Personnage personnageCible) {
        // TODO : Récupérer la valeur d'attaque pour ce tour, calculer les dégats,
        //modifier les points de vie du personnage cible, afficher les détails
        // sur l'attaque, tel que montré dans l'énoncé.
    }

    // -------------------------------------------------------------------------
    public void setNewIniRandom() {
        // TODO : Modifier de façon aléatoire la valeur INI du personnage.
    }
}
