package clientforme;

import java.awt.Color;

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
Nom du fichier : Cercle.java
Date créé : 18-10-2012
Date dern. modif. : Date créé : 18-10-2012
*******************************************************/

public class Cercle extends Ovale {

	public Cercle(){
		super();
		calculerAire();
	}
	
	/**
	 * Constructeur de cercle.
	 * @param noSeq - numéro de séquence unique
	 * @param coordX1 - coordonnée en X du centre du cercle
	 * @param coordY1 - coordonnée en Y du centre du cercle
	 * @param rayon - rayon du cercle
	 * @param couleurForme - couleur
	 */
	public Cercle(int noSeq, int coordX1, int coordY1, int rayon, Color couleurForme){
		super(noSeq,coordX1,coordY1,rayon,rayon, couleurForme);
		calculerAire();
	}
	
	/**
	 * Calculer l'aire d'un cercle 
	 * PI*r²
	 */
	protected void calculerAire(){
		setAire(Math.PI * Math.pow(getRayonV(), 2));
	}
	
	
}
