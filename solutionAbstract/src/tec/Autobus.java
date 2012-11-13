package tec;
import java.util.ArrayList;
import java.util.Iterator;

public class Autobus extends Bus implements Transport {
    private JaugeNaturel jaugeAssis; 
    private JaugeNaturel jaugeDebout;
    private int nbArret;
    private ArrayList<Passager> Passagers= new ArrayList<Passager>();
    private Iterator<Passager> iterateur = Passagers.iterator();
    
    public Autobus(int nb_assis, int nb_debout) {
	if(nb_assis <= 0 || nb_debout <= 0)
	    throw new IllegalArgumentException("Nb Assis/Debout initiale <=0");
	jaugeAssis = new JaugeNaturel(0,nb_assis,0);
	jaugeDebout  = new JaugeNaturel(0,nb_debout,0);
	nbArret=0;
    }
    
    public boolean aPlaceAssise() {
	return !jaugeAssis.estRouge();
    }
    
    public boolean aPlaceDebout() {
	return !jaugeDebout.estRouge();
    }
    
    public void demanderPlaceAssise(Passager p) {
	//	while(iterateur.hasNext())
	//  if(iterateur.next().equals(p))
	for(int i=0;i<Passagers.size();i++)
	    if (Passagers.get(i)==p)
		throw new IllegalStateException("Passager deja présent bus");
	jaugeAssis.incrementer();
	p.accepterPlaceAssise();
	Passagers.add(p);
    }
    
    public void demanderPlaceDebout(Passager p) {
	//while(iterateur.hasNext())
	//  if(iterateur.next()==p)
	for(int i=0;i<Passagers.size();i++)
	    if (Passagers.get(i)==p)
		throw new IllegalStateException("Passager deja présent bus");
	
	jaugeDebout.incrementer();
	p.accepterPlaceDebout();
	Passagers.add(p);
    }
    
    public void demanderSortie(Passager p) {
	boolean dehors=true;
	//while(iterateur.hasNext())
	//  if(iterateur.next()==p)
	for(int i=0;i<Passagers.size();i++)
	    if (Passagers.get(i)==p)
		dehors=false;
	if (dehors)
	    throw new IllegalStateException("Passager deja présent bus");
	else if (p.estDebout()){
	    jaugeDebout.decrementer();
	    p.accepterSortie();
	}
	else if (p.estAssis()){
	    jaugeAssis.decrementer();
	    p.accepterSortie();
	}
	Passagers.remove(Passagers.indexOf(p));
    }
    
    public void demanderChangerEnDebout(Passager p) {
	if(p.estDebout())
	    throw new IllegalStateException("Deja Debout");
	else {
	    jaugeAssis.decrementer();
	    jaugeDebout.incrementer();
	    p.accepterPlaceDebout();
	}
    }
    public void demanderChangerEnAssis(Passager p) {
	if(p.estAssis())
	    throw new IllegalStateException("Deja assis");
	else {
	
	    jaugeAssis.incrementer();
	    jaugeDebout.decrementer();
	    p.accepterPlaceAssise();
	}
    }
    public void allerArretSuivant() throws TecInvalidException { 
	nbArret++;
	int tailleInit;/*regle le problème quand plusieurs
			 passagers descendent au même arret*/
	
	    do{
		tailleInit=Passagers.size();
		for(int i=0;i<Passagers.size();i++)
		    try {
			Passagers.get(i).nouvelArret(this,nbArret);
		    } catch (IllegalStateException e){
			throw new TecInvalidException("nouvelArret",e);
		    }
	    }while(tailleInit!=Passagers.size());
	    
	    
    }
    public String toString() {
	return "[arret:"+nbArret+",assis:"+jaugeDebout.valeur()+",debout:"+jaugeAssis.valeur()+"]";
    }
    
}
