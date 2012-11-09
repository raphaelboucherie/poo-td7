package tec;



class TestEtatPassager{
    
    public void lancer(){
	int nbTest = 0;
	System.out.print(getClass().getName());
	
	System.out.print("."); nbTest++;
	testExterieur();
	
	System.out.print("."); nbTest++;
	testAssis();
	
	System.out.print("."); nbTest++;
	testDebout();
	
	System.out.print("."); nbTest++;
	testInterieur();
	
	
	// De la meme maniere, appel aux autres methodes de test.
	
	System.out.println("OK (" + nbTest + ")");

	
    }
    
    private void testExterieur(){
	EtatPassager Passager = new EtatPassager(Etat.DEHORS);
	
	
	assert (Passager.estExterieur());
	assert (!Passager.estAssis() );
	assert (!Passager.estDebout());
	
    }
    
    
    
    private void testAssis(){
	
	EtatPassager Passager = new EtatPassager(Etat.ASSIS);
	
	
	assert (!Passager.estExterieur());
	assert (Passager.estAssis());
	assert (!Passager.estDebout());
	
    }
    
    
    private void testDebout(){
	
	EtatPassager Passager = new EtatPassager(Etat.DEBOUT);
	
	assert (!Passager.estExterieur());
	assert (!Passager.estAssis());
	assert (Passager.estDebout());
    }
    
    
    private void testInterieur(){
	
	
	EtatPassager Passager = new EtatPassager(Etat.ASSIS);
	assert (!Passager.estExterieur());
	
	EtatPassager Passager2 = new EtatPassager(Etat.DEBOUT);
	assert (!Passager2.estExterieur());
	
	
    }
    
}