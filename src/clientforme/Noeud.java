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

	private Noeud Suivant;
	private Noeud Precedant;
	public AbstractForme forme;
	
	//Constructor
	public Noeud(AbstractForme _forme){
		Suivant = null;
		Precedant = null;
		forme = _forme;		
	}
	
	/**	 
	 * Méthode servant à défénir le noeud suivant
	 * 
	 * @param _suivant
	 */
	public void definirSuivant(Noeud _suivant){
		Suivant = _suivant;
	}
	
	/**	 
	 * Méthode servant à récupérer le noeud suivant
	 * 
	 * @param _suivant
	 */
	public Noeud obtenirSuivant(){
		
		return Suivant;
	}
	
	/**	 
	 * Méthode servant à définir le noeud précédant
	 * 
	 * @param _suivant
	 */
	public void definirPrecedant(Noeud _precedant){
		Suivant = _precedant;
	}
	
	/**	 
	 * Méthode servant à récupérer le noeud précédant
	 * 
	 * @param _suivant
	 */
	public Noeud obtenirPrecedant(){
		
		return Precedant;
	}
	
}
