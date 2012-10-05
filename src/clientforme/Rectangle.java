package clientforme;
import java.awt.Color;
import java.awt.Graphics2D;

/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
�tudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. : 
				
				
Professeur : Ghizlane El boussaidi
Charg� de labo  : Alvine Boaye Belle
Nom du fichier : Rectangle.java
Date cr�� : 21-09-2012
Date dern. modif. : 03-10-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Mathieu Battah)
03-10-2012 Version 1.01 (Mathieu Battah)
*******************************************************/

/**
 * Classe d�finissant un rectangle.
 */
public class Rectangle extends AbstractForme{

	private int pointX2;
	private int pointY2;
	private int hauteur;
	private int largeur;
	
	/**
	 * Constructeur par d�faut.
	 */
	public Rectangle(){
		super();
		pointX2 = pointY2 = hauteur = largeur = 0;
	}
	
	/**
	 * Constructeur avec param�tres. Les deux points repr�sentent des points oppos�s.
	 * @param noSeq - num�ro de s�quence unique permettant d'identifier la forme
	 * @param coordX1 - coordonn�es en X du premier point
	 * @param coordY1 - coordonn�es en Y du premier point
	 * @param coordX2 - coordonn�es en X du second point
	 * @param coordY2 - coordonn�es en Y du second point
	 * @param couleurForme - couleur
	 */
	public Rectangle(int noSeq, int coordX1, int coordY1, int coordX2, int coordY2, Color couleurForme){
		super(noSeq, coordX1, coordY1, couleurForme);
		pointX2 = coordX2;
		pointY2 = coordY2;
		largeur = Math.abs(pointX2 - super.getX1());
		hauteur = Math.abs(pointY2 - super.getY1());
	}

	/**
	 * Mutateur de la coordonn�es en X du second point.
	 * @param coordX - coordonn�es en X du second point
	 */
	public void setX2(int coordX){
		pointX2 = coordX;
	}

	/**
	 * Mutateur de la coordonn�es en Y du second point.
	 * @param coordY - coordonn�es en Y du second point
	 */
	public void setY2(int coordY){
		pointY2 = coordY;
	}

	/**
	 * Accesseur de la coordonn�e en X du second point.
	 * @return coordonn�e en X du second point
	 */
	public int getX2(){
		return pointX2;
	}

	/**
	 * Accesseur de la coordonn�e en Y du second point.
	 * @return coordonn�e en Y du second point
	 */
	public int getY2(){
		return pointY2;
	}

	public void dessiner(Graphics2D g2d){
		g2d.setColor(super.getCouleur());
		g2d.drawRect(super.getX1(), super.getY1(), largeur, hauteur);
		g2d.fillRect(super.getX1(), super.getY1(), largeur, hauteur);
	}
}
