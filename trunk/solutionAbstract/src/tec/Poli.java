package tec;

public final class Poli implements Caractere{

    public void choixChangerPlace(Bus b, int numeroArret, PassagerAbstrait p){
	if(p.estAssis()){
	    if(!b.aPlaceAssise())
		b.demanderPlaceDebout(p);
	}
    }
}
