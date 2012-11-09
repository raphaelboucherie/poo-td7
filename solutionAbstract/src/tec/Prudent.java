package tec;

public final class Prudent implements Caractere{

    public void choixChangerPlace(Bus b, int numeroArret, PassagerAbstrait p){
	if(!p.estAssis()){
	    if(numeroArret < p.destination() - 5)
		b.demanderPlaceAssise(p);
	}
	if(!p.estDebout()){
	    if(numeroArret >= p.destination() - 3)
		b.demanderPlaceDebout(p);
	}
    }

}
