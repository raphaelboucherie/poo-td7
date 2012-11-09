package tec;

public final class Nerveux implements Caractere{

    public void choixChangerPlace(Bus b, int numeroArret, PassagerAbstrait p){
	if(p.estDebout())
	    b.demanderPlaceAssise(p);
	else if (p.estAssis())
	    b.demanderPlaceDebout(p);
    }

}
