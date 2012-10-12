package clientforme;
import java.awt.Color;
import java.util.ArrayList;
import ca.etsmtl.log.util.IDLogger;

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
Nom du fichier : FabriqueForme.java
Date créé : 21-09-2012
Date dern. modif. : 28-09-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Mathieu Battah)
28-09-2012 Version 1.01 (Mathieu Battah)
28-09-2012 Version 1.02 (Patrice Robitaille)
03-10-2012 Version 1.03 (Mathieu Battah)
*******************************************************/

/**
 * Classe de fabrication de formes.
 */
public final class FabriqueForme {
	
	/**
	 * Méthode servant à créer un objet de type Forme.
	 * @param infoForme - chaine de caractères contenant les informations pour créer une forme
	 * @return objet Forme
	 */
	public static AbstractForme creerForme(String infoForme){
		
		AbstractForme forme;
		int noSequence;
		String typeForme;
		String[] coord;
		int[] coordonnees;
		
		ArrayList<String> info = DecomposerCommande.trouverCommande(infoForme);
		
		noSequence = Integer.parseInt(info.get(0));
		typeForme = info.get(1);
		coord = info.get(2).trim().split(" ");
		coordonnees = new int[coord.length];
		
		// Transforme les coordonnées de type String en type int.
		for(int i=0; i<coord.length; i++){
			coordonnees[i] = Integer.parseInt(coord[i]);
		}
		
		if (typeForme.equals("LIGNE")){
			forme = new Ligne(noSequence, coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3], Color.BLUE);
		}
		else if (typeForme.equals("RECTANGLE")){
			forme = new Rectangle(noSequence, coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3], Color.RED);
		}
		else if (typeForme.equals("CARRE")){
			forme = new Carre(noSequence, coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3], Color.ORANGE);
		}
		else if (typeForme.equals("OVALE")){
			forme = new Ovale(noSequence, coordonnees[0], coordonnees[1], coordonnees[2], coordonnees[3], Color.GREEN);
		}
		else{	//Cercle
			forme = new Cercle(noSequence, coordonnees[0], coordonnees[1], coordonnees[2], Color.YELLOW);
		}
		
		/*
		 * Nous utilisons IDLogger pour enregistrer dans un fichier le numéro de séquence. 
		 */
		IDLogger logger = IDLogger.getInstance();
		logger.logID(noSequence);
		
		return forme;
	}

}

