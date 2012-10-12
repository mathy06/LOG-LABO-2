package clientforme;

import java.util.Comparator;
import java.util.Hashtable;

public class CompareForme implements Comparator<AbstractForme> {

	private int ordre;
	private Hashtable<String, Integer> typeForme = new Hashtable<String, Integer>();
	
	/**
	 * Constructeur avec paramètre.
	 * @param ordreCroissant - Définit si la comparaison est en ordre croissant ou non.
	 */
	public CompareForme(boolean ordreCroissant) {

		if (ordreCroissant){
			ordre = 1;
		}
		else{
			ordre = -1;
		}

		typeForme.put(Carre.class.getName(), new Integer(1));
		typeForme.put(Rectangle.class.getName(), new Integer(2));
		typeForme.put(Cercle.class.getName(), new Integer(3));
		typeForme.put(Ovale.class.getName(), new Integer(4));
		typeForme.put(Ligne.class.getName(), new Integer(5));
	}
		
	public int compare(AbstractForme forme1, AbstractForme forme2){
		
		Integer type1 = (Integer) typeForme.get(forme1.getClass().getName());
		Integer type2 = (Integer) typeForme.get(forme2.getClass().getName());
		
		return type1.compareTo(type2) * ordre;
	}

}