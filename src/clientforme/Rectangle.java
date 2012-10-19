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
Nom du fichier : Rectangle.java
Date créé : 21-09-2012
Date dern. modif. : 03-10-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Mathieu Battah)
03-10-2012 Version 1.01 (Mathieu Battah)
*******************************************************/

/**
 * Classe définissant un rectangle.
 */
public class Rectangle extends AbstractForme{

	private int pointX2;
	private int pointY2;
	private int hauteur;
	private int largeur;
	private int aire;
	
	/**
	 * Constructeur par défaut.
	 */
	public Rectangle(){
		super();
		pointX2 = pointY2 = hauteur = largeur = 0;
	}
	
	/**
	 * Constructeur avec paramètres. Les deux points représentent des points opposés.
	 * @param noSeq - numéro de séquence unique permettant d'identifier la forme
	 * @param coordX1 - coordonnées en X du premier point
	 * @param coordY1 - coordonnées en Y du premier point
	 * @param coordX2 - coordonnées en X du second point
	 * @param coordY2 - coordonnées en Y du second point
	 * @param couleurForme - couleur
	 */
	public Rectangle(int noSeq, int coordX1, int coordY1, int coordX2, int coordY2, Color couleurForme){
		super(noSeq, coordX1, coordY1, couleurForme);
		pointX2 = coordX2;
		pointY2 = coordY2;
		largeur = Math.abs(pointX2 - super.getX1());
		hauteur = Math.abs(pointY2 - super.getY1());
		calculerDistanceMax();
		calculerAire();
		
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

	public void dessiner(Graphics2D g2d, int coordX, int coordY){
		g2d.setColor(super.getCouleur());
		g2d.fillRect(coordX, coordY, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(coordX, coordY, largeur, hauteur);
	}

	/**
	 * Retourne l'aire du rectangle
	 * @return aire
	 */
	public double getAire(){
		return aire;
	}
	
	/**
	 * Retourne la hauteur du rectangle
	 * @return hauteur
	 */
	public double getHauteur(){
		return hauteur;
	}
	
	/**
	 * Retourne la largeur du rectangle
	 * @return largeur
	 */
	public double getLargeur(){
		return largeur;
	}
	
	/**
	 * Calcule l'aire d'un rectangle
	 */
	protected void calculerAire() {
		aire = hauteur * largeur;
		
	}

	/**
	 * Calcule la distance maximale entre
	 * deux points sur un rectangle
	 * a²+b²=c²
	 */
	protected void calculerDistanceMax() {
		setDistanceMax(Math.sqrt(Math.pow(hauteur, 2) + Math.pow(largeur,2)));
	}
}
