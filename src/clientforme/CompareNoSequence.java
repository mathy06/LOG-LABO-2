package clientforme;

import java.util.Comparator;

public class CompareNoSequence implements Comparator<AbstractForme> {

	private int ordre;
	
	/**
	 * Constructeur avec param�tre.
	 * @param ordreCroissant - D�finit si la comparaison est en ordre croissant ou non.
	 */
	public CompareNoSequence(boolean ordreCroissant) {

		if (ordreCroissant){
			ordre = 1;
		}
		else{
			ordre = -1;
		}
	}
	
	public int compare(AbstractForme forme1, AbstractForme forme2){
		
		if (forme1.getNoSequence() > forme2.getNoSequence()){
			return 1 * ordre;
		}
		else if (forme1.getNoSequence() < forme2.getNoSequence()){
			return -1 * ordre;
		}
		else{
			return 0;
		}
	}

}