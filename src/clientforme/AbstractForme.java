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
Nom du fichier : Forme.java
Date créé : 21-09-2012
Date dern. modif. : 03-10-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Mathieu Battah)
03-10-2012 Version 1.01 (Mathieu Battah)
*******************************************************/

/**
 * Classe abstraite définissant les propriétés et méthodes communes à une forme.
 */
public abstract class AbstractForme {
	
	private int noSequence;
	private int pointX1;
	private int pointY1;
	private Color couleur;
	private double distanceMax; 
	
	/**
	 * Constructeur par défaut.
	 */
	public AbstractForme(){
		noSequence = pointX1 = pointY1 = 0;
	}
	
	/**
	 * Constructeur avec paramètres.
	 * @param noSeq - numéro de séquence unique permettant d'identifier la forme
	 * @param coordX1 - coordonnées en X
	 * @param coordY1 - coordonnées en Y
	 * @param couleurForme - couleur
	 */
	public AbstractForme(int noSeq, int coordX1, int coordY1, Color couleurForme){
		noSequence = noSeq;
		pointX1 = coordX1;
		pointY1 = coordY1;
		couleur = couleurForme;
	}
	
	/**
	 * Mutateur du numéro de séquence.
	 * @param noSeq - numéro de séquence unique permettant d'identifier la forme
	 */
	public void setNoSequence(int noSeq){
		noSequence = noSeq;
	}
	
	/**
	 * Mutateur de la coordonnées en X.
	 * @param coordX1 - coordonnées en X
	 */
	public void setX1(int coordX1){
		pointX1 = coordX1;
	}
	
	/**
	 * Mutateur de la coordonnées en Y.
	 * @param coordY1 - coordonnées en Y
	 */
	public void setY1(int coordY1){
		pointY1 = coordY1;
	}
	
	/**
	 * Mutateur de la couleur.
	 * @param couleurForme - couleur
	 */
	public void setCouleur(Color couleurForme){
		couleur = couleurForme;
	}
	
	/**
	 * Accesseur du numéro de séquence.
	 * @return numéro de séquence identifiant la forme
	 */
	public int getNoSequence(){
		return noSequence;
	}
	
	/**
	 * Accesseur de la coordonnée en X.
	 * @return coordonnée en X
	 */
	public int getX1(){
		return pointX1;
	}
	
	/**
	 * Accesseur de la coordonnée en Y.
	 * @return coordonnée en Y
	 */
	public int getY1(){
		return pointY1;
	}
	
	/**
	 * Accesseur de la couleur.
	 * @return couleur de la forme.
	 */
	public Color getCouleur(){
		return couleur;
	}
	
	/**
	 * Méthode servant à modifier la distance
	 * maxiamle entre 2 points sur une forme
	 * @param nDistanceMax
	 */
	protected void setDistanceMax(double nDistanceMax){
		distanceMax = nDistanceMax;
	}
	
	/**
	 * Retourne la propriété distanceMax
	 * qui est la distance maximale entre
	 * deux point de la forme
	 * @return distanceMax
	 */
	public double getDistanceMax(){
		return distanceMax;
	}
	
	/**
	 * Dessine la forme.
	 * @param g2d - object Graphics2D sur lequel la forme se dessinera
	 */
	abstract void dessiner(Graphics2D g2d);
	
	/**
	 * Retourne l'aire de la forme.
	 * @return aire de la forme
	 */
	abstract double getAire();
	
	/**
	 * Calculer l'aire d'une forme.
	 */
	protected abstract void calculerAire();
	
	protected abstract void calculerDistanceMax();
}
