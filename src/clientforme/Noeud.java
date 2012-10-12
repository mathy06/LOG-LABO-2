package clientforme;
/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
Étudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. : 
				ROBP20028905
				
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : Communication.java
Date créé : 09-10-2012
Date dern. modif. : 09-10-2012
*******************************************************
Historique des modifications
*******************************************************
09-10-2012 Version 1.0 (Patrice Robitaille)
*******************************************************/

/**
 * Classe gérant le noeud représantant une forme dans la liste
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
	 * Méthode servant à défénir le noeud suivant
	 * 
	 * @param _suivant
	 */
	public void setSuivant(Noeud _suivant){
		nSuivant = _suivant;
	}
	
	/**	 
	 * Méthode servant à récupérer le noeud suivant
	 * 
	 * @param _suivant
	 */
	public Noeud getSuivant(){
		
		return nSuivant;
	}
	
	/**	 
	 * Méthode servant à déterminer si le noeud possède
	 * un noeud suivant
	 * 
	 * @param _suivant
	 */
	public boolean possedeSuivant(){
		
		return (nSuivant != null);
	}
	
	/**	 
	 * Méthode servant à définir le noeud précédant
	 * 
	 * @param _suivant
	 */
	public void setPrecedant(Noeud _precedant){
		nSuivant = _precedant;
	}
	
	/**	 
	 * Méthode servant à récupérer le noeud précédant
	 * 
	 * @param _suivant
	 */
	public Noeud getPrecedant(){
		
		return nPrecedant;
	}
	
	/**	 
	 * Méthode servant à déterminer si le noeud possède
	 * un noeud précédant
	 * 
	 * @param _suivant
	 */
	public boolean possedePrecedant(){
				
		return (nPrecedant != null);
		
	}
	
}
