package tec;

class TestPassagerStresse extends TestPassagerAbstrait {
    
    void lancer() {
	super.lancer();
    }
    
    protected PassagerAbstrait creerPassager(String nom, int destination){
	return new Fatigue(nom,destination,new Prudent());
    }
    
    void testChoixChangerPlace(){
	
	FauxBus f = new FauxBus(2,4);
	PassagerAbstrait p = creerPassager("aa",5);
	
	p.accepterPlaceAssise();
	p.caractere.choixChangerPlace(f, 2, p);
	
	assert "demanderPlaceDebout" == f.messages.getLast();
	
    }
    
    void testChoixPlaceMontee(){
	PassagerAbstrait p = creerPassager("aaa",4);
	FauxBus f = new FauxBus(2,4);
	f.status = FauxBus.ASSIS;
	
	p.choixPlaceMontee(f);
	assert "demanderPlaceAssise" == f.messages.getLast();
    }
}
