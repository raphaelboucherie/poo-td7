package tec;

public abstract class PassagerAbstrait extends Passager implements Usager {
    
    private String nom;
    private int destination;
    private EtatPassager monEtat;
    protected abstract void choixPlaceMontee(Bus b);
    Caractere caractere;
    
    public PassagerAbstrait(String nom, int destination) {
	if(destination<=0)
	    throw new IllegalArgumentException("Destination invalide");
	if(nom=="")
	    throw new IllegalArgumentException("Nom invalide"); 
	this.destination=destination;
	monEtat= new EtatPassager(Etat.DEHORS);
	this.nom = nom;
    }
    
    final public String nom(){
	return nom;
    }
    
    final public int destination(){
	return destination;
    }

    final public boolean estDehors() {
	return monEtat.estExterieur();
    }
    
    final public boolean estAssis() {
	return monEtat.estAssis();
    }
    
    final public boolean estDebout() {
	return monEtat.estDebout();
    }
    
    final public void accepterSortie() {
	this.monEtat=monEtat.DEHORS;
    }
    
    final public void accepterPlaceAssise() {
        this.monEtat=monEtat.ASSIS;
    }
    
    final public void accepterPlaceDebout() {
	this.monEtat=monEtat.DEBOUT;
    }
    
    final public void monterDans(Transport t) throws TecInvalidException {
	if( !(t instanceof Bus))
	    throw new TecInvalidException("Echec Conversion") ;
	Bus b = (Bus) t;
	
	try {
	    this.choixPlaceMontee(b);
	} catch(IllegalStateException e){
	    throw new TecInvalidException("choixPlaceMontee", e);
	}
    }
    
    final public void nouvelArret(Bus b, int numeroArret){
	if(numeroArret >= this.destination)
	    b.demanderSortie(this);
	else
	    this.caractere.choixChangerPlace(b, numeroArret, this);
    }
    
    final public String toString() {
	StringBuffer str = new StringBuffer();
	str.append(nom);
	if(estAssis())
	    str.append(" assis");
	else if(estDebout())
	    str.append(" debout");
	else str.append(" dehors");
	return str.toString();
    }
    
}
