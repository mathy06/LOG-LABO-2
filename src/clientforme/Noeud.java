package clientforme;
/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
�tudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. : 
				ROBP20028905
				
Professeur : Ghizlane El boussaidi
Charg� de labo  : Alvine Boaye Belle
Nom du fichier : Communication.java
Date cr�� : 09-10-2012
Date dern. modif. : 09-10-2012
*******************************************************
Historique des modifications
*******************************************************
09-10-2012 Version 1.0 (Patrice Robitaille)
*******************************************************/

/**
 * Classe g�rant le noeud repr�santant une forme dans la liste
 */
public class Noeud {

	private Noeud nSuivant;
	private Noeud nPrecedant;
	private AbstractForme forme;
	
	//Constructor
	public Noeud(AbstractForme _forme){
		nSuivant = null;
		nPrecedant = null;
		forme = _forme;		
	}
	
	public AbstractForme getNoeud(){
		return forme;
	}
	
	/**	 
	 * M�thode servant � d�f�nir le noeud suivant
	 * 
	 * @param _suivant
	 */
	public void setSuivant(Noeud _suivant){
		nSuivant = _suivant;
	}
	
	/**	 
	 * M�thode servant � r�cup�rer le noeud suivant
	 * 
	 * @param _suivant
	 */
	public Noeud getSuivant(){
		
		return nSuivant;
	}
	
	/**	 
	 * M�thode servant � d�terminer si le noeud poss�de
	 * un noeud suivant
	 * 
	 * @param _suivant
	 */
	public boolean possedeSuivant(){
		
		return (nSuivant != null);
	}
	
	/**	 
	 * M�thode servant � d�finir le noeud pr�c�dant
	 * 
	 * @param _suivant
	 */
	public void setPrecedant(Noeud _precedant){
		nSuivant = _precedant;
	}
	
	/**	 
	 * M�thode servant � r�cup�rer le noeud pr�c�dant
	 * 
	 * @param _suivant
	 */
	public Noeud getPrecedant(){
		
		return nPrecedant;
	}
	
	/**	 
	 * M�thode servant � d�terminer si le noeud poss�de
	 * un noeud pr�c�dant
	 * 
	 * @param _suivant
	 */
	public boolean possedePrecedant(){
				
		return (nPrecedant != null);
		
	}
	
}
