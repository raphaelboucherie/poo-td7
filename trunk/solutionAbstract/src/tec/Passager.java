package tec;

abstract class Passager {
    abstract String nom();
    abstract boolean estDehors();
    
    abstract boolean estAssis();
    abstract boolean estDebout();
    
    abstract void accepterSortie();
    abstract void accepterPlaceAssise();
    abstract void accepterPlaceDebout();
    
    abstract void nouvelArret(Bus b, int numeroArret);
    abstract void monterDans(Transport t)  throws TecInvalidException;
}
