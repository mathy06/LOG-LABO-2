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
Nom du fichier : Carre.java
Date créé : 18-10-2012
Date dern. modif. : Date créé : 18-10-2012
*******************************************************/

public class Carre extends Rectangle{

	public Carre(){
		super();
	}
	public Carre(int noSeq, int coordX1, int coordY1, int coordX2, int coordY2, Color couleurForme){
		super(noSeq, coordX1, coordY1, coordX2, coordY2, couleurForme);
	}
}
