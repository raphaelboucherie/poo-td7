package tec;

public final class Repos extends PassagerAbstrait {
  
    public Repos(String nom, int destination,Caractere nom_caractere) {
	super(nom,destination);
	super.caractere = nom_caractere;
    }
    
    protected void choixPlaceMontee(Bus bus){
	//places assises prioritaires
	if (bus.aPlaceAssise())
	    bus.demanderPlaceAssise(this);
	else if (bus.aPlaceDebout())
	    bus.demanderPlaceDebout(this);
    }
    
    
}


