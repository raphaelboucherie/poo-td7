package tec;

class TestPassagerLunatique extends TestPassagerAbstrait {
       
    void lancer() {
	super.lancer();
    }
   
    protected PassagerAbstrait creerPassager(String nom, int destination){
	return new Sportif(nom,destination,new Nerveux());
    }
    
    void testChoixChangerPlace(){
	
	FauxBus f = new FauxBus(2,4);
	PassagerAbstrait p = creerPassager("aa",3);
	
	p.accepterPlaceAssise();
	p.caractere.choixChangerPlace(f, 1,p);
	
	assert "demanderPlaceDebout" == f.messages.getLast();
	
	p.accepterPlaceDebout();
	p.caractere.choixChangerPlace(f, 1, p);
	assert "demanderPlaceAssise" == f.messages.getLast();
    }
    
    void testChoixPlaceMontee(){
	PassagerAbstrait p = creerPassager("aaa",4);
	FauxBus f = new FauxBus(2,4);
	f.status = FauxBus.DEBOUT;
	
	p.choixPlaceMontee(f);
	assert "demanderPlaceDebout" == f.messages.getLast();
    }
}
