package tec;

public final class Fatigue extends PassagerAbstrait {
    
    public Fatigue(String nom, int numeroArret,Caractere nom_caractere) {
	super(nom,numeroArret);
	super.caractere=nom_caractere;	
   }
    
    protected void choixPlaceMontee(Bus bus){
	if (bus.aPlaceAssise())
	    bus.demanderPlaceAssise(this);
    }
    
}




