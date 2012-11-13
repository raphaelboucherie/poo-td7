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

	System.out.print('.'); nbTest++;
	testException();

	System.out.println("OK (" + nbTest + ")");
    }
    
   
    
    void testFabrication(){
	PassagerAbstrait  p = creerPassager("Nom",1);
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
	try {
	    p.monterDans(f);
	} catch(TecInvalidException e){}
	
	assert "demanderPlaceAssise" == f.messages.getLast() || 
	       "demanderPlaceDebout" == f.messages.getLast();
    }
    
    void testException(){
	
	Transport t = new Transport() {
		
		public void allerArretSuivant() throws TecInvalidException{}
		public boolean aPlaceAssise(){return false;}
		public boolean aPlaceDebout(){return false;}
	    };
	PassagerAbstrait p = creerPassager("zz",5);
	try {
	    p.monterDans(t);
	    assert(false);
	}catch (TecInvalidException e){
	    System.out.println("Exception Levée! (Invalid..)");
	}
	
    }
}
