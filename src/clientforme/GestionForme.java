package clientforme;
/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
Ã‰tudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. : 
					
					
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : GestionForme.java
Date créé : 21-09-2012
Date dern. modif. : 21-09-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Philippe Charbonneau)
24-09-2012 Version 1.01(Philippe Charbonneau)
28-09-2012 Version 1.02 (Mathieu Battah)
*******************************************************/

/**
 * Classe gérant une liste de forme
 */
public class GestionForme {
	
	private final int MAX_FORME = 10;
	private AbstractForme[] listeForme = new AbstractForme[MAX_FORME];
	private int position = 0;
	private int taille = 0;
	
	/**
	 * Accesseur de la liste de formes.
	 * @return tableau contenant les formes
	 */
	public AbstractForme[] getListeForme(){
		AbstractForme[] clone = listeForme.clone();
		return clone;
	}
	
	/**
	 * @return nombre de place prise dans la liste
	 */
	public int getTaille(){
		return taille;
	}
		
	/**
	* Ajoute une forme à la liste.
	* @param AbstractForme préconstruite
	*/
	public void ajouterForme(AbstractForme forme){
		
		listeForme[position] = forme;
		position = ++position % MAX_FORME;
		if(taille < 10) 
			++taille;
	}
	
}
