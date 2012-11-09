package tec;
/**
 * Cette énumération définit les états possible d'un passager 
 * dans un transport en commun. 
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2011
 **/

enum Etat { 
  /** passager assis à l'intérieur */  ASSIS,   
  /** passager debout à l'intérieur */ DEBOUT, 
  /** passager à l'extérieur */        DEHORS  
}
