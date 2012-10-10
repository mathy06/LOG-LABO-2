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
	 * M�thode servant � d�f�nir le noeud suivant
	 * 
	 * @param _suivant
	 */
	public void definirSuivant(Noeud _suivant){
		Suivant = _suivant;
	}
	
	/**	 
	 * M�thode servant � r�cup�rer le noeud suivant
	 * 
	 * @param _suivant
	 */
	public Noeud obtenirSuivant(){
		
		return Suivant;
	}
	
	/**	 
	 * M�thode servant � d�finir le noeud pr�c�dant
	 * 
	 * @param _suivant
	 */
	public void definirPrecedant(Noeud _precedant){
		Suivant = _precedant;
	}
	
	/**	 
	 * M�thode servant � r�cup�rer le noeud pr�c�dant
	 * 
	 * @param _suivant
	 */
	public Noeud obtenirPrecedant(){
		
		return Precedant;
	}
	
}
