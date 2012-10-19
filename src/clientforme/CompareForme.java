package clientforme;

import java.util.Comparator;
import java.util.Hashtable;

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
Nom du fichier : CompareForme.java
Date créé : 18-10-2012
Date dern. modif. : Date créé : 18-10-2012
*******************************************************/

public class CompareForme implements Comparator<AbstractForme> {

	private int ordre;
	private Hashtable<String, Integer> typeForme = new Hashtable<String, Integer>();
	
	/**
	 * Constructeur avec paramètre.
	 * @param ordreCroissant - Définit si la comparaison est en ordre croissant ou non.
	 */
	public CompareForme(boolean ordreCroissant) {

		if (ordreCroissant){
			ordre = 1;
		}
		else{
			ordre = -1;
		}

		typeForme.put(Carre.class.getName(), new Integer(1));
		typeForme.put(Rectangle.class.getName(), new Integer(2));
		typeForme.put(Cercle.class.getName(), new Integer(3));
		typeForme.put(Ovale.class.getName(), new Integer(4));
		typeForme.put(Ligne.class.getName(), new Integer(5));
	}
		
	public int compare(AbstractForme forme1, AbstractForme forme2){
		
		Integer type1 = (Integer) typeForme.get(forme1.getClass().getName());
		Integer type2 = (Integer) typeForme.get(forme2.getClass().getName());
		
		return type1.compareTo(type2) * ordre;
	}

}