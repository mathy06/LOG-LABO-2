package clientforme;

public class ListeIterateur implements Iterateur {

	private ListeForme listeforme;
	private int tailleListe;
	private int position;
	
	public ListeIterateur(ListeForme liste){
		listeforme = liste;
		tailleListe = listeforme.obtenirTaille();
		position = 0;
	}
	
	@Override
	public boolean possedePrecedant() {
		if (position > 0)
			return true;
		else
			return false;
	}

	@Override
	public boolean possedeSuivant() {
		if (position < tailleListe)
			return true;
		else
			return false;
	}

	@Override
	public Noeud precedant() {
		
		if (this.possedePrecedant()){

			Noeud courant = listeforme.getQueue();
			for(int i = position; i >= 0; i--)
			{
				if(courant.obtenirPrecedant() == null)
					return null;
				
				courant = courant.obtenirPrecedant();
			}
			return courant;
			
		}else{
			return null;
		}
	}

	@Override
	public Noeud suivant() {
		
		if (this.possedeSuivant()){

			Noeud courant = listeforme.getSommet();
			for(int i = 0; i <= position; i++)
			{
				if(courant.obtenirSuivant() == null)
					return null;
				
				courant = courant.obtenirSuivant();
			}
			return courant;
			
		}else{
			return null;
		}
		
	}

}
