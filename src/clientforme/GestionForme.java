package clientforme;

import java.util.Comparator;

/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
Étudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :    CHAP07110906
                    ROBP2002805 
                    BATM19038902 
				
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : GestionForme.java
Date créé : 21-09-2012
Date dern. modif. : 28-09-2012
*******************************************************/

/**
 * Classe gérant une liste de forme
 */
public class GestionForme {
	
	private final int MAX_FORME = 10;
	private ListeForme listeForme = new ListeForme(MAX_FORME);
	private int taille;

	/**
	 * Accesseur de la liste de formes.
	 * @return tableau contenant les formes
	 */
	public ListeForme getListeForme(){
		return listeForme;
	}
	public ListeForme getListeFormeTrier(){
		return listeForme.getListeTrier()==null ? listeForme : listeForme.getListeTrier();
	}
	
	/**
	 * Permet de définir la liste originale
	 * 
	 */
	public void setListeOriginal(){
		listeForme.reinitialiserListeTriee();
	}
	
	/**
	 * @return nombre de place prise dans la liste
	 */
	public int getTaille(){
		return taille;
	}
		
	/**
	 * @return nombre de place prise dans la liste
	 */
	public int getMaxTaille(){
		return MAX_FORME;
	}
	
	/**
	* Ajoute une forme à la liste.
	* @param AbstractForme préconstruite
	*/
	public void ajouterForme(AbstractForme forme){
		try{
			listeForme.ajouterNoeud(forme);
		}catch(Exception ex){
			ex.getMessage();
		}
		taille = listeForme.obtenirTaille();
	}
	
	
	public void tri(Comparator<AbstractForme> comp) throws Exception{
		try{
			listeForme.tri(comp);
		}catch(Exception ex){
			throw ex;
		}
	}
}
