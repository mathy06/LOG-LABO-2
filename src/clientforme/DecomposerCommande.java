package clientforme;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

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
Nom du fichier : DecomposerCommande.java
Date cr�� : 21-09-2012
Date dern. modif. : 03-10-2012
*******************************************************
Historique des modifications
*******************************************************
21-09-2012 Version 1.0 (Philippe Charbonneau)
03-10-2012 Version 1.01 (Mathieu Battah)
*******************************************************/

/**
 * Classe de d�composition de commandes.
 */
public final class DecomposerCommande {

	/**
	 * D�compose une cha�ne de caract�res contenant les informations de la forme.
	 * @param commande
	 * @return ArrayList de longueur 3: </br>
	 * index 0 = num�ro de s�quence </br>
	 * index 1 = type de forme </br>
	 * index 2 = coordonn�es et valeurs
	 */
	public static ArrayList<String> trouverCommande(String commande) {
		
		/* 
		 * Pattern permettant de localiser les information utiles dans un cha�ne
		 * semblable � "12345 <RECTANGLE> 20 20 120 120 </RECTANGLE>".
		 */
		Pattern patron = Pattern.compile("^(\\d*) <(.*)>(.*)</\\2>$");
		ArrayList<String> propriete = new ArrayList<String>();
		Matcher matcher = patron.matcher(commande);
		boolean resultats = matcher.find();	
		if(resultats){
			propriete.add(matcher.group(1));
			propriete.add(matcher.group(2));
			propriete.add(matcher.group(3));
		}
		return propriete;
	}
}


