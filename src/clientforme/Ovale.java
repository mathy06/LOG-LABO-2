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
Nom du fichier : Ovale.java
Date cr�� : 21-09-2012
Date dern. modif. : 03-10-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Mathieu Battah)
03-10-2012 Version 1.01 (Mathieu Battah)
*******************************************************/

/**
 * Classe d�finissant un ovale.
 */
public class Ovale extends AbstractForme {

	private int hauteur;
	private int largeur;
	private int rayonH;
	private int rayonV;
	
	/**
	 * Constructeur par d�faut.
	 */
	public Ovale(){
		super();
		hauteur = largeur = rayonH = rayonV = 0;
	}
	
	/**
	 * Constructeur de cercle.
	 * @param noSeq - num�ro de s�quence unique
	 * @param coordX1 - coordonn�e en X du centre du cercle
	 * @param coordY1 - coordonn�e en Y du centre du cercle
	 * @param rayon - rayon du cercle
	 * @param couleurForme - couleur
	 */
	public Ovale(int noSeq, int coordX1, int coordY1, int rayon, Color couleurForme){
		super(noSeq, coordX1, coordY1, couleurForme);
		hauteur = largeur = 2 * rayon;
		rayonH = rayonV = rayon;
	}
	
	/**
	 * Contructeur d'ovale.
	 * @param noSeq - num�ro de s�quence unique
	 * @param coordX1 - coordonn�e en X du centre de l'ovale
	 * @param coordY1 - coordonn�e en Y du centre de l'ovale
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
	
	public void dessiner(Graphics2D g2d){
		g2d.setColor(super.getCouleur());
		
		/*
		 * Comme les coordonn�es en X,Y repr�sentent le milieu de l'ovale ou du cercle,
		 * nous devons soustraire le rayon horizontal et vertical afin d'obtenir les
		 * coordonn�es du point sup�rieur gauche qui est requis par les m�thodes
		 * drawOval() et fillOval().
		 */
		g2d.drawOval(super.getX1() - rayonH, super.getY1() - rayonV, largeur, hauteur);
		g2d.fillOval(super.getX1() - rayonH, super.getY1() - rayonV, largeur, hauteur);
	}
}