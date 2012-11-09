package tec;

abstract class TestPassagerAbstrait {
    
    abstract void testChoixPlaceMontee();
    abstract void testChoixChangerPlace(); 
    abstract PassagerAbstrait creerPassager(String nom, int destination);
    
    void lancer() {
	int nbTest = 0;
	
	System.out.print(getClass().getName());
	
	System.out.print('.'); nbTest++;
	testFabrication();
	
	System.out.print('.'); nbTest++;
	testAccepterPlace();
	
	System.out.print('.'); nbTest++;
	testArret();
	
	System.out.print('.'); nbTest++;
	testMonterDans();
	
	System.out.print('.'); nbTest++;
	testChoixChangerPlace();
	
	System.out.print('.'); nbTest++;
	testChoixPlaceMontee();
    	
	System.out.println("OK (" + nbTest + ")");
    }
    
   
    
    void testFabrication(){
	PassagerAbstrait  p = creerPassager("Nom",0);
	assert "Nom"==p.nom();
	assert p.estDehors();
	assert !p.estAssis();
	assert !p.estDebout();
	
    }
    
    
    void testAccepterPlace(){
	PassagerAbstrait p = creerPassager("Nom",4);
	p.accepterPlaceAssise();
	assert p.estAssis();
	p.accepterPlaceDebout();
	assert p.estDebout();
    	p.accepterSortie();
	assert p.estDehors();
    }
    
    void testArret() {
	PassagerAbstrait p = creerPassager("yyy", 5);
	FauxBus f = new FauxBus(3,5);
	
	// test interaction cas numeroArret < destination
	p.nouvelArret(f, 1);
	assert 0 == f.messages.size() ;
	
	// test interaction cas numeroArret >= destination
	p.nouvelArret(f, 5);
	assert "demanderSortie" == f.messages.getLast() ;
    }
    void testMonterDans()
    {
	PassagerAbstrait p = creerPassager("zzz",4);
	FauxBus f = new FauxBus(2,4);
	f.status = FauxBus.VIDE;
	p.monterDans(f);
	assert "demanderPlaceAssise" == f.messages.getLast() || 
	       "demanderPlaceDebout" == f.messages.getLast();
    }
    
}
