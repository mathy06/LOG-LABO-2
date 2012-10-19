package clientforme;

import java.util.Comparator;

/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
�tudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :    CHAP07110906
                    ROBP2002805 
                    BATM19038902 
				
Professeur : Ghizlane El boussaidi
Charg� de labo  : Alvine Boaye Belle
Nom du fichier : CompareAire.java
Date cr�� : 18-10-2012
Date dern. modif. : Date cr�� : 18-10-2012
*******************************************************/

public class CompareAire implements Comparator<AbstractForme> {

	private int ordre;
	
	/**
	 * Constructeur avec param�tre.
	 * @param ordreCroissant - D�finit si la comparaison est en ordre croissant ou non.
	 */
	public CompareAire(boolean ordreCroissant) {

		if (ordreCroissant){
			ordre = 1;
		}
		else{
			ordre = -1;
		}
	}
	
	public int compare(AbstractForme forme1, AbstractForme forme2){
				
		if (forme1.getAire() > forme2.getAire()){
			return 1 * ordre;
		}
		else if (forme1.getAire() < forme2.getAire()){
			return -1 * ordre;
		}
		else{
			return 0;
		}
	}

}