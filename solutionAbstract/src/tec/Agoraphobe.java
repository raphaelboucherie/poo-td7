package tec;

public final class Agoraphobe implements Caractere{

    public void choixChangerPlace(Bus b, int numeroArret, PassagerAbstrait p){
	if(!b.aPlaceAssise())
	    b.demanderSortie(p);
	else{
	    if(!b.aPlaceDebout())
		b.demanderSortie(p);
	}
    }
}
