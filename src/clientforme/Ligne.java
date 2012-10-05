package clientforme;
import java.awt.Color;
import java.awt.Graphics2D;

/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
Étudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. : 
				
				
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : Ligne.java
Date créé : 21-09-2012
Date dern. modif. : 03-10-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Mathieu Battah)
03-10-2012 Version 1.01 (Mathieu Battah)
*******************************************************/

/**
 * Classe définissant une ligne.
 */
public class Ligne extends AbstractForme {

	private int pointX2;
	private int pointY2;
	
	/**
	 * Contructeur par défaut.
	 */
	public Ligne(){
		super();
		pointX2 = pointY2 = 0;
	}
	
	/**
	 * Constructeur avec paramètres.
	 * @param noSeq - numéro de séquence unique permettant d'identifier la forme
	 * @param coordX1 - coordonnées en X du premier point
	 * @param coordY1 - coordonnées en Y du premier point
	 * @param coordX2 - coordonnées en X du second point
	 * @param coordY2 - coordonnées en Y du second point
	 * @param couleurForme - couleur
	 */
	public Ligne(int noSeq, int coordX1, int coordY1, int coordX2, int coordY2, Color couleurForme){
		super(noSeq, coordX1, coordY1, couleurForme);
		pointX2 = coordX2;
		pointY2 = coordY2;
	}
	
	/**
	 * Mutateur de la coordonnées en X du second point.
	 * @param coordX - coordonnées en X du second point
	 */
	public void setX2(int coordX){
		pointX2 = coordX;
	}
	
	/**
	 * Mutateur de la coordonnées en Y du second point.
	 * @param coordY - coordonnées en Y du second point
	 */
	public void setY2(int coordY){
		pointY2 = coordY;
	}
	
	/**
	 * Accesseur de la coordonnée en X du second point.
	 * @return coordonnée en X du second point
	 */
	public int getX2(){
		return pointX2;
	}
	
	/**
	 * Accesseur de la coordonnée en Y du second point.
	 * @return coordonnée en Y du second point
	 */
	public int getY2(){
		return pointY2;
	}
	
	public void dessiner(Graphics2D g2d){
		g2d.setColor(super.getCouleur());
		g2d.drawLine(super.getX1(), super.getY1(), pointX2, pointY2);
	}
}
