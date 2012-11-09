package tec;
import java.util.ArrayList;

public class Autobus extends Bus implements Transport {
    private JaugeNaturel jaugeAssis; 
    private JaugeNaturel jaugeDebout;
    private int nbArret;
    private ArrayList<Passager> Passagers; 
    
    public Autobus(int nb_assis, int nb_debout) {
	
	jaugeAssis = new JaugeNaturel(0,nb_assis,0);
	jaugeDebout  = new JaugeNaturel(0,nb_debout,0);
	nbArret=0;
	Passagers = new ArrayList<Passager>();
    }
    
    public boolean aPlaceAssise() {
	return !jaugeAssis.estRouge();
    }
    
    public boolean aPlaceDebout() {
	return !jaugeDebout.estRouge();
    }
    
    public void demanderPlaceAssise(Passager p) {
	jaugeAssis.incrementer();
	p.accepterPlaceAssise();
	Passagers.add(p);
    }
    
    public void demanderPlaceDebout(Passager p) {
	jaugeDebout.incrementer();
	p.accepterPlaceDebout();
	Passagers.add(p);
    }
    
    public void demanderSortie(Passager p) {
	if (p.estDebout()){
	    jaugeDebout.decrementer();
	    p.accepterSortie();
	}
	if (p.estAssis()){
	    jaugeAssis.decrementer();
	    p.accepterSortie();
	}
	Passagers.remove(Passagers.indexOf(p));
    }
    
    public void demanderChangerEnDebout(Passager p) {
	jaugeAssis.decrementer();
	jaugeDebout.incrementer();
	p.accepterPlaceDebout();
    }
    
    public void demanderChangerEnAssis(Passager p) {
	jaugeAssis.incrementer();
	jaugeDebout.decrementer();
	p.accepterPlaceAssise();
    }
    
    public void allerArretSuivant() { 
	nbArret++;
	int tailleInit;/*regle le problème quand plusieurs
			 passagers descendent au même arret*/
	do{
	    tailleInit=Passagers.size();
	    for(int i=0;i<Passagers.size();i++)
		Passagers.get(i).nouvelArret(this,nbArret);
	}while(tailleInit!=Passagers.size());
    }
    public String toString() {
	return "[arret:"+nbArret+",assis:"+jaugeDebout.valeur()+",debout:"+jaugeAssis.valeur()+"]";
    }
    
}
