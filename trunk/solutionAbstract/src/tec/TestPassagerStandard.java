package tec;

class TestPassagerStandard extends TestPassagerAbstrait {
    
    void lancer() {
	super.lancer();
	testFaussaire();
    }
    
    protected PassagerAbstrait creerPassager(String nom, int destination){
	return new Repos(nom,destination,new Calme());
    }
    
    void testChoixChangerPlace(){
	PassagerAbstrait p = creerPassager("zzz",4);
	FauxBus f = new FauxBus(2,4);
	p.caractere.choixChangerPlace(f,3000,p);
	assert 0 == f.messages.size();
    }
    
    void testChoixPlaceMontee()
    {
	PassagerAbstrait p = creerPassager("zzz",4);
	FauxBus f = new FauxBus(2,4);
	f.status = FauxBus.ASSIS;
	p.choixPlaceMontee(f);
	assert "demanderPlaceAssise" == f.messages.getLast();
	
	f.status = FauxBus.DEBOUT;
	p.choixPlaceMontee(f);
	assert "demanderPlaceDebout" == f.messages.getLast();
	
    }
    
    void testFaussaire() {
	FauxBus f = new FauxBus(1,2);
	f.status = FauxBus.ASSIS;
	assert 0 == f.messages.size();
	assert f.aPlaceAssise();
	
	f.status = FauxBus.DEBOUT;
	assert f.aPlaceDebout();
	
	f.status = FauxBus.VIDE;
	assert f.aPlaceDebout();
	assert f.aPlaceAssise();
	
	f.status = FauxBus.PLEIN;
	assert !f.aPlaceDebout();
	assert !f.aPlaceAssise();
	
	f.demanderChangerEnDebout(null);
	assert "demanderChangerEnDebout" == f.messages.getLast();
	f.demanderChangerEnAssis(null);
	assert "demanderChangerEnAssis" == f.messages.getLast();
	f.demanderSortie(null);
	assert "demanderSortie" == f.messages.getLast();
	f.allerArretSuivant();
	assert "allerArretSuivant" == f.messages.getLast();
	f.demanderPlaceAssise(null);
	assert "demanderPlaceAssise" == f.messages.getLast();
	f.demanderPlaceDebout(null);
	assert "demanderPlaceDebout" == f.messages.getLast();
    }
 
}
