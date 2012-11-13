package tec;

public class TestAutobus {
    
    void lancer() { 
	int nbTest = 0;
	System.out.print(getClass().getName());
	
	System.out.print('.'); nbTest++;
	testFaussaire();
	
	System.out.print('.'); nbTest++;
	testConstructeur();

	System.out.print('.'); nbTest++;
	testDemandePlace();
	
	System.out.print('.'); nbTest++;
	testChangerPlace();
	
	System.out.print('.'); nbTest++;
	testSortie();

	System.out.print('.'); nbTest++;
	testArretSuivant();

	System.out.println("OK (" + nbTest + ")"); 
    }
    
    private void testConstructeur() {
	FauxPassager f = new FauxPassager("a",1);
	
	Bus bus = new Autobus(10,1);
	assert bus.aPlaceAssise();
	bus.demanderPlaceDebout(f);
	assert !bus.aPlaceDebout();
	
	Bus bus2 = new Autobus(1,10);
	bus2.demanderPlaceAssise(f);
	assert !bus2.aPlaceAssise();
	assert bus2.aPlaceDebout();
    }
    
 
    
    // Remplir toutes les places assises d'un autobus.
    // Remplir toutes les places debout d'un autobus.
    
    private void testDemandePlace() {
	
	Bus bus = new Autobus(5, 3);
	FauxPassager[] faux = {null,
				   new FauxPassager("a",1),
				   new FauxPassager("b",2),
				   new FauxPassager("c",3),
				   new FauxPassager("d",4),
				   new FauxPassager("e",5),
				   new FauxPassager("f",6),
				   new FauxPassager("g",7),
				   new FauxPassager("h",8),
				   new FauxPassager("i",9)}; //9
	
	
	//test de demanderPlaceAssise
	for (int i = 1; i <= 5; i++) {
	    bus.demanderPlaceAssise(faux[i]);
	    if (i == 5)
		assert !bus.aPlaceAssise();
	    else
		assert bus.aPlaceAssise();
	}
	
	//test de demanderPlaceDebout    
	for (int i = 6; i <= 8; i++) {
	    bus.demanderPlaceDebout(faux[i]);
	    if (i == 8)
		assert !bus.aPlaceDebout();
	    else
		assert bus.aPlaceDebout();
	}
    }
    
    private void testSortie(){
	FauxPassager[] faux = {null,
				   new FauxPassager("aa",5),
				   new FauxPassager("aa",6),
				   new FauxPassager("aa",5),
				   new FauxPassager("aa",5)}; //4
	
	Bus bus = new Autobus(2, 2);
	bus.demanderPlaceAssise(faux[1]);
	bus.demanderPlaceAssise(faux[2]);
	bus.demanderPlaceDebout(faux[3]);
	bus.demanderPlaceDebout(faux[4]);
	bus.demanderSortie(faux[4]);
	bus.demanderSortie(faux[1]);
	assert bus.aPlaceDebout();
	assert bus.aPlaceAssise();
    }

    private void testArretSuivant(){
	FauxPassager[] faux = {null,
				   new FauxPassager("aa",3),
				   new FauxPassager("aa",3),
				   new FauxPassager("aa",3),
				   new FauxPassager("aa",3),
				   new FauxPassager("aa",3),
				   new FauxPassager("aa",3)}; //6
	
	Bus bus = new Autobus(4, 2);
	bus.demanderPlaceAssise(faux[1]);
	bus.demanderPlaceAssise(faux[2]);
	bus.demanderPlaceDebout(faux[3]);
	bus.demanderPlaceDebout(faux[4]);
	
	//test d'interaction 
	try {
	    bus.allerArretSuivant();
	}catch(TecInvalidException e){}
	
       	for (int i=1;i<=4;i++)
	    assert "nouvelArret" == faux[i].messages.getLast();
	
    }
    
    
    private void testChangerPlace(){
	FauxPassager[] faux = {null,
				   new FauxPassager("aa",3),
				   new FauxPassager("aa",3),
				   new FauxPassager("aa",3)}; //3
	
	//test de changerEnDebout
	Bus bus = new Autobus(2, 2);
	bus.demanderPlaceAssise(faux[1]);
	bus.demanderPlaceAssise(faux[2]);
	bus.demanderPlaceDebout(faux[3]);
	bus.demanderChangerEnDebout(faux[1]);
	assert !bus.aPlaceDebout();
	assert bus.aPlaceAssise();
	
	//test de changerEnAssis
	Bus bus2 = new Autobus(2, 2);
	bus2.demanderPlaceDebout(faux[1]);
	bus2.demanderPlaceDebout(faux[2]);
	bus2.demanderPlaceAssise(faux[3]);
	bus2.demanderChangerEnAssis(faux[2]);
	assert bus2.aPlaceDebout();
	assert !bus2.aPlaceAssise();
    }
    
    
    
    void testFaussaire() {
	FauxPassager f = new FauxPassager("aa",3);
	assert "Nom1"==f.nom();
	
	f.status = FauxPassager.DEBOUT;
	assert 0 == f.messages.size();
	
	assert !f.estDehors();
	assert f.estDebout();
	assert !f.estAssis();
	
	f.accepterSortie();
	assert f.estDehors();
	assert !f.estDebout();
	assert !f.estAssis();
	
	f.accepterPlaceAssise();
	assert !f.estDehors();
	assert !f.estDebout();
	assert f.estAssis();

	f.accepterPlaceDebout();
	assert !f.estDehors();
	assert f.estDebout();
	assert !f.estAssis();
	
	f.nouvelArret(null, -999);
	assert "nouvelArret" == f.messages.getLast();
	f.monterDans(null);
	assert "monterDans" == f.messages.getLast();
    }
    
}
