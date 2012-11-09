package tec;

public final class Sportif extends PassagerAbstrait {
  
    public Sportif(String nom, int numeroArret,Caractere nom_caractere) {
	super(nom,numeroArret);
	super.caractere=nom_caractere;	
	}
    
    protected void choixPlaceMontee(Bus bus){
	//Passager Lunatique
	if (bus.aPlaceDebout())
	    bus.demanderPlaceDebout(this);
	
    }
}