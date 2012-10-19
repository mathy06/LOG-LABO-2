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
Nom du fichier : CompareDistance.java
Date créé : 18-10-2012
Date dern. modif. : Date créé : 18-10-2012
*******************************************************/

public class CompareDistance implements Comparator<AbstractForme> {

	private int ordre;
	
	/**
	 * Constructeur avec paramètre.
	 * @param ordreCroissant - Définit si la comparaison est en ordre croissant ou non.
	 */
	public CompareDistance(boolean ordreCroissant) {

		if (ordreCroissant){
			ordre = 1;
		}
		else{
			ordre = -1;
		}
	}
	
	public int compare(AbstractForme forme1, AbstractForme forme2){
		
		if (forme1.getDistanceMax() > forme2.getDistanceMax()){
			return 1 * ordre;
		}
		else if (forme1.getDistanceMax() < forme2.getDistanceMax()){
			return -1 * ordre;
		}
		else{
			return 0;
		}
	}

}