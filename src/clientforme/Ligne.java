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
Code(s) perm. :    CHAP07110906
                    ROBP2002805 
                    BATM19038902 
				
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : Ligne.java
Date créé : 18-10-2012
Date dern. modif. : 18-10-2012
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
	private int hauteur;
	private int largeur;
	
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
		
		/* On veut que les lignes soient toujours de en haut à gauche vers en bas à droite. */
		pointX2 = (coordX2 < coordX1 ? coordX1 + coordX2 : coordX2);
		pointY2 = (coordY2 < coordY1 ? coordY1 + coordY2 : coordY2);
		
		largeur = Math.abs(pointX2 - super.getX1());
		hauteur = Math.abs(pointY2 - super.getY1());
		
		calculerDistanceMax();
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
	
	/**
	 * Retourne l'aire d'une ligne
	 * @return 0
	 */
	public double getAire(){
		return 0;
	}
	
	/**
	 * Retourne la hauteur
	 * @return hauteur
	 */
	public double getHauteur(){
		return hauteur;
	}
	
	/**
	 * Retourne la largeur
	 * @return largeur
	 */
	public double getLargeur(){
		return largeur;
	}
	
	public void dessiner(Graphics2D g2d, int coordX, int coordY){
		g2d.setColor(super.getCouleur());
		g2d.drawLine(coordX, coordY, coordX+pointX2-super.getX1(), coordY+pointY2-super.getY1());
		g2d.setColor(Color.BLACK);
		g2d.drawRect(coordX, coordY, Math.abs(pointX2-super.getX1()), Math.abs(pointY2-super.getY1()));
	}

	/**
	 * Cette méthode ne fait rien,
	 * l'aire d'une ligne est 0
	 */
	protected void calculerAire() {	
	}

	
	protected void calculerDistanceMax() {
		setDistanceMax(Math.sqrt(Math.pow( Math.abs(pointY2 - super.getY1()), 2) + Math.pow(Math.abs(pointX2 - super.getX1()),2)));
	}

}
