package tec;
//Classe Faussaire Autobus
class FauxBus extends Bus implements Transport{
    static final byte ASSIS  = 0;
    static final byte DEBOUT = 1;
    static final byte VIDE   = 2;
    static final byte PLEIN  = 3;
    final Messages messages = new Messages();
    byte status ;
    public FauxBus(int assis ,int debout) {
    }
    
    public boolean aPlaceAssise() {
	return ((status==ASSIS || status==VIDE) && !(status==PLEIN)); 
    }
    
    public boolean aPlaceDebout() {
	return ((status==DEBOUT || status==VIDE) && !(status==PLEIN)); 
    }
    
    public void demanderPlaceAssise(Passager p) {
	messages.add ( "demanderPlaceAssise");
    }
    
    public void demanderPlaceDebout(Passager p) {
	messages.add ( "demanderPlaceDebout");
    }
    
    public void demanderChangerEnDebout(Passager p) {
	messages.add ( "demanderChangerEnDebout");
    }
  
    public void demanderChangerEnAssis(Passager p) {
	messages.add ( "demanderChangerEnAssis");
    }
    
    public void demanderSortie(Passager p) {
	messages.add ( "demanderSortie");    
    }
    
    public void allerArretSuivant() { 
	messages.add ( "allerArretSuivant");    
    }
}

