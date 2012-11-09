package tec;

public final class Tetu extends PassagerAbstrait {
      
    public Tetu(String nom, int numeroArret,Caractere nom_caractere) {
	super(nom,numeroArret);
	super.caractere = nom_caractere;
    }
    
    protected void choixPlaceMontee(Bus b){
	b.demanderPlaceDebout(this);
    }
    
    
}
