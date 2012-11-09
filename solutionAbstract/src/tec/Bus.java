package tec;

abstract class Bus {
    abstract boolean aPlaceAssise();
    abstract boolean aPlaceDebout();
    
    abstract void demanderPlaceAssise(Passager p);
    abstract void demanderPlaceDebout(Passager p);
    abstract void demanderSortie(Passager p);
    
    abstract void demanderChangerEnDebout(Passager p);
    abstract void demanderChangerEnAssis(Passager p);

    abstract void allerArretSuivant();
}
