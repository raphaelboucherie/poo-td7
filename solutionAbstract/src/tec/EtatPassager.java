
package tec;

/**
 * Cette classe représente l'état d'un passager dans un transport en commun.
 * Il y a un état à l'exterieur du transport (dehors) et deux états à 
 * l'intérieur (assis, debout).
 *  
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2008
 **/


class EtatPassager {
    
    public static final EtatPassager DEBOUT=new EtatPassager(Etat.DEBOUT);
    public static final EtatPassager DEHORS=new EtatPassager(Etat.DEHORS);
    public static final EtatPassager ASSIS=new EtatPassager(Etat.ASSIS);
    
    private final Etat monEtat;
    
    /**
     * Construit une instance en précisant l'état du passager.
     * 
     * @param e  valeur de l'état.
     */
    public EtatPassager(Etat e) {
	monEtat = e;
	
	/* Le constructeur d'une classe permet d'initialiser l'etat de l'instance creee.
	 * Son nom correspond toujours au nom de la classe. Il n'y a pas de type de retour.
	 */
    }
    
    
    /**
     * Le passager est-il à l'extérieur du transport ?
     *
     * @return vrai si instanciation avec DEHORS;
     */
    public boolean estExterieur() {
	return monEtat != Etat.ASSIS && monEtat != Etat.DEBOUT; //Erreur Corrigée: && à la place de ||
    }
    
    /**
     * Le passager est-il assis à l'intérieur du transport ?
     *
     * @return vrai si instanciation avec ASSIS;
     */
    public boolean estAssis() {
	return monEtat == Etat.ASSIS;
    }
    
    /**
     * Le passager est-il debout à l'intérieur du transport ?
     *
     * @return vrai si instanciation avec DEBOUT;
     */
    public boolean estDebout() {
	return monEtat==Etat.DEBOUT; // Erreur corrigée return (monEtat==Etat.DEBOUT) au lieu de return false tout le temps!
    }
    
    /**
     * Le passager est-il a l'intérieur du transport ?
     *
     * @return vrai si instanciation avec ASSIS ou DEBOUT.
     */
    public boolean estInterieur() {
	return monEtat != Etat.DEHORS;
    }
    
    
    
    /**
     * Cette méthode est heritée de la classe {@link java.lang.Object}.
     * Très utile pour le débogage, elle permet de fournir une 
     * chaîne de caractères correspondant à l'état d'un objet.
     * <p> Un code par défaut est définit dans 
     * {@link java.lang.Object#toString() la classe Object} 
     * Il faut adapter (redéfinir) le code de cette méthode à chaque classe.
     *
     * Pour les chaînes de cararctères, l'opérateur + correspond a la concaténation. 
     */
    @Override
	public String toString() {
	return "<" + monEtat + ">";
    } 
}