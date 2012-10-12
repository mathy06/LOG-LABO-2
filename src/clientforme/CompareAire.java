package clientforme;

import java.util.Comparator;

public class CompareAire implements Comparator<AbstractForme> {

	private int ordre;
	
	/**
	 * Constructeur avec paramètre.
	 * @param ordreCroissant - Définit si la comparaison est en ordre croissant ou non.
	 */
	public CompareAire(boolean ordreCroissant) {

		if (ordreCroissant){
			ordre = 1;
		}
		else{
			ordre = -1;
		}
	}
	
	public int compare(AbstractForme forme1, AbstractForme forme2){
		
		if (forme1.getAire() > forme2.getAire()){
			return 1 * ordre;
		}
		else if (forme1.getAire() < forme2.getAire()){
			return -1 * ordre;
		}
		else{
			return 0;
		}
	}

}