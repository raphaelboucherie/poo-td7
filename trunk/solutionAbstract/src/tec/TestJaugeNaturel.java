package tec;
public class TestJaugeNaturel {
    
    public void lancer() {
	int nbTest = 0;
	System.out.print(getClass().getName()); 
	System.out.print("."); nbTest++;
	testDansIntervalle();
	
	System.out.print("."); nbTest++;
     	testDeplacement();

	System.out.print("."); nbTest++;
	testInferieurIntervalle();
	
	System.out.print("."); nbTest++;
	testLimiteVigieMaxInferieurVigieMin();
	
	System.out.print("."); nbTest++;
	testMaxEgaleMin();
	
	System.out.print("."); nbTest++;
	testSuperieurIntervalle();
	
	System.out.print("."); nbTest++;
	testExceptionCasLimites();
	
	System.out.println("OK (" + nbTest + ")");
       }

    public void testDeplacement(){    
 
	JaugeNaturel MaJauge = new JaugeNaturel(0,4,2);
	assert MaJauge.estVert();
	MaJauge.incrementer();
	MaJauge.incrementer();
	assert MaJauge.estRouge();
	
	JaugeNaturel MaJauge2 = new JaugeNaturel(0,4,2);
	MaJauge2.decrementer();
	MaJauge2.decrementer();
	assert MaJauge2.estBleu();
	
    }
	
    public void testDansIntervalle(){
    
	//Etat après instanciation pour une valeur de départ dans l'intervalle de vigie.
	
	JaugeNaturel MaJauge = new JaugeNaturel(-345,67899,100);
	assert(!MaJauge.estBleu());
	assert(MaJauge.estVert());
	assert(!MaJauge.estRouge());
	       
    }

    public void testInferieurIntervalle(){
	
	//1) depart < vigieMin < vigieMax,
	JaugeNaturel MaJauge = new JaugeNaturel(5,10,2);
	assert(MaJauge.estBleu());
	assert(!MaJauge.estVert());
	assert(!MaJauge.estRouge());

	//2) depart = vigieMin < vigieMax.
	JaugeNaturel MaJauge2 = new JaugeNaturel(2,10,2);
	assert(MaJauge2.estBleu());
	assert(!MaJauge2.estVert());
	assert(!MaJauge2.estRouge());    
    }
    public void testLimiteVigieMaxInferieurVigieMin() {
	
	// vigieMax < depart < vigieMin. L'état est-il cohérent ?  Non  
	
	JaugeNaturel MaJauge = new JaugeNaturel(5,0,2);
	assert(MaJauge.estBleu());
	assert(!MaJauge.estVert());
	assert(MaJauge.estRouge());    
    }
    public void testMaxEgaleMin() {

	//1) vigieMin = VigieMax < depart
	JaugeNaturel MaJauge = new JaugeNaturel(30,30,1024);
	assert(!MaJauge.estBleu());
	assert(!MaJauge.estVert());
	assert(MaJauge.estRouge());

	//2) vigieMin = VigieMax = depart
	JaugeNaturel MaJauge2 = new JaugeNaturel(500,500,500);
	assert(MaJauge2.estBleu());
	assert(!MaJauge2.estVert());
	assert(MaJauge2.estRouge());    
	
	//L'état est-il cohérent ? Le 1) oui mais le 2) ne l'est pas.
    }

    public void testSuperieurIntervalle() {

	//1) vigieMin < vigieMax < depart
	JaugeNaturel MaJauge = new JaugeNaturel(5,10,100);
	assert(!MaJauge.estBleu());
	assert(!MaJauge.estVert());
	assert(MaJauge.estRouge());

	//2) vigieMin < vigieMax = depart.	
	JaugeNaturel MaJauge2 = new JaugeNaturel(5,10,10);
	assert(!MaJauge2.estBleu());
	assert(!MaJauge2.estVert());
	assert(MaJauge2.estRouge());    

    }
    public void testExceptionCasLimites(){

	//patérible
    try {
	JaugeNaturel inverse = new JaugeNaturel(78,13,55);
	JaugeNaturel egale = new JaugeNaturel(-42,-42,-42);
    } catch (IllegalArgumentException e){}
        
	
    }	
}
