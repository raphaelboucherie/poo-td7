package tec;

abstract class Bus  {
    abstract boolean aPlaceAssise();
    abstract boolean aPlaceDebout();
    
    abstract void demanderPlaceAssise(Passager p) throws IllegalStateException;
    abstract void demanderPlaceDebout(Passager p) throws IllegalStateException;
    abstract void demanderSortie(Passager p);
    
    abstract void demanderChangerEnDebout(Passager p) throws IllegalStateException;
    abstract void demanderChangerEnAssis(Passager p) throws IllegalStateException;

    abstract void allerArretSuivant() throws TecInvalidException;
}
