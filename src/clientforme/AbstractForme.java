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
Nom du fichier : Forme.java
Date cr�� : 21-09-2012
Date dern. modif. : 03-10-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Mathieu Battah)
03-10-2012 Version 1.01 (Mathieu Battah)
*******************************************************/

/**
 * Classe abstraite d�finissant les propri�t�s et m�thodes communes � une forme.
 */
public abstract class AbstractForme {
	
	private int noSequence;
	private int pointX1;
	private int pointY1;
	private Color couleur;
	private double distanceMax; 
	
	/**
	 * Constructeur par d�faut.
	 */
	public AbstractForme(){
		noSequence = pointX1 = pointY1 = 0;
	}
	
	/**
	 * Constructeur avec param�tres.
	 * @param noSeq - num�ro de s�quence unique permettant d'identifier la forme
	 * @param coordX1 - coordonn�es en X
	 * @param coordY1 - coordonn�es en Y
	 * @param couleurForme - couleur
	 */
	public AbstractForme(int noSeq, int coordX1, int coordY1, Color couleurForme){
		noSequence = noSeq;
		pointX1 = coordX1;
		pointY1 = coordY1;
		couleur = couleurForme;
	}
	
	/**
	 * Mutateur du num�ro de s�quence.
	 * @param noSeq - num�ro de s�quence unique permettant d'identifier la forme
	 */
	public void setNoSequence(int noSeq){
		noSequence = noSeq;
	}
	
	/**
	 * Mutateur de la coordonn�es en X.
	 * @param coordX1 - coordonn�es en X
	 */
	public void setX1(int coordX1){
		pointX1 = coordX1;
	}
	
	/**
	 * Mutateur de la coordonn�es en Y.
	 * @param coordY1 - coordonn�es en Y
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
	 * Accesseur du num�ro de s�quence.
	 * @return num�ro de s�quence identifiant la forme
	 */
	public int getNoSequence(){
		return noSequence;
	}
	
	/**
	 * Accesseur de la coordonn�e en X.
	 * @return coordonn�e en X
	 */
	public int getX1(){
		return pointX1;
	}
	
	/**
	 * Accesseur de la coordonn�e en Y.
	 * @return coordonn�e en Y
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
	 * M�thode servant � modifier la distance
	 * maxiamle entre 2 points sur une forme
	 * @param nDistanceMax
	 */
	protected void setDistanceMax(double nDistanceMax){
		distanceMax = nDistanceMax;
	}
	
	/**
	 * Retourne la propri�t� distanceMax
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
