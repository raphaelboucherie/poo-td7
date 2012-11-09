package tec;
//Classe Faussaire PassagerStandard

class FauxPassager extends Passager implements Usager {
    
    static final byte DEBOUT=0;
    static final byte DEHORS=-1;
    static final byte ASSIS=1;
    byte status;
    
    final Messages messages = new Messages();
    public FauxPassager(String nom,int destination) {
    }
    
    public String nom() {
	return "Nom1";
    }
    
    public boolean estDehors() {
	return status==DEHORS;
    }
    
    public boolean estAssis() {
	return status==ASSIS;
    }
    
    public boolean estDebout() {
	return status==DEBOUT;
    }
    
    public void accepterSortie() {
	status=DEHORS;
    }
    
    public void accepterPlaceAssise() {
	status=ASSIS;
    }
    
    public void accepterPlaceDebout() {
	status=DEBOUT;
    }
    
    public void nouvelArret(Bus bus, int numeroArret) {
	messages.add("nouvelArret");
    }
    
    public void monterDans(Transport t) { 
	messages.add("monterDans");
  }
}
