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
Nom du fichier : Ovale.java
Date créé : 21-09-2012
Date dern. modif. : 18-10-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Mathieu Battah)
03-10-2012 Version 1.01 (Mathieu Battah)
*******************************************************/

/**
 * Classe définissant un ovale.
 */
public class Ovale extends AbstractForme {

	private int hauteur;
	private int largeur;
	private int rayonH;
	private int rayonV;
	private double aire;
	
	/**
	 * Constructeur par défaut.
	 */
	public Ovale(){
		super();
		hauteur = largeur = rayonH = rayonV = 0;
	}
	

	
	/**
	 * Contructeur d'ovale.
	 * @param noSeq - numéro de séquence unique
	 * @param coordX1 - coordonnée en X du centre de l'ovale
	 * @param coordY1 - coordonnée en Y du centre de l'ovale
	 * @param rayonHorizontal - rayon horizontal de l'ovale
	 * @param rayonVertical - rayon vertical de l'ovale
	 * @param couleurForme - couleur
	 */
	public Ovale(int noSeq, int coordX1, int coordY1, int rayonHorizontal, int rayonVertical, Color couleurForme){
		super(noSeq, coordX1, coordY1, couleurForme);
		hauteur = 2 * rayonVertical;
		largeur = 2 * rayonHorizontal;
		rayonH = rayonHorizontal;
		rayonV = rayonVertical;
		calculerAire();
		calculerDistanceMax();
	}
	
	/**
	 * Mutateur du rayon horizontal.
	 * @param rayon - rayon horizontal.
	 */
	public void setRayonH(int rayon){
		rayonH = rayon;
	}
	
	/**
	 * Mutateur du rayon vertical.
	 * @param rayon - rayon vertical.
	 */
	public void setRayonV(int rayon){
		rayonV = rayon;
	}
	
	/**
	 * Accesseur du rayon horizontal.
	 * @return rayon horizontal
	 */
	public int getRayonH(){
		return rayonH;
	}

	/**
	 * Accesseur du rayon vertical.
	 * @return rayon vertical
	 */
	public int getRayonV(){
		return rayonV;
	}
	
	public void dessiner(Graphics2D g2d, int coordX, int coordY){
		g2d.setColor(super.getCouleur());
		g2d.fillOval(coordX, coordY, largeur, hauteur);
		g2d.setColor(Color.BLACK);
		g2d.drawRect(coordX, coordY, largeur, hauteur);
	}

	protected void setAire(double nouvelleAire){
		aire = nouvelleAire;
		
	}
	public double getAire(){
		return aire;
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
	
	/**
	 * Calculer l'aire d'un ovale
	 * PI*rayon1*rayon2
	 */
	protected void calculerAire() {
		aire = Math.PI * rayonV * rayonH;
		
	}

	protected void calculerDistanceMax() {
		setDistanceMax((rayonV > rayonH) ? rayonV*2 : rayonH*2);
	}
}
