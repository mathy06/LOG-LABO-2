package clientforme;

public class ListeIterateur implements Iterateur {

	private ListeForme listeforme;
	private Noeud courant;
	
	public ListeIterateur(ListeForme liste){
		listeforme = liste;
	}
	
	@Override
	public boolean possedePrecedant() {
		
		return(courant.obtenirPrecedant() != null);
		
	}

	@Override
	public boolean possedeSuivant() {

		return(courant.obtenirPrecedant() != null);
	
	}

	@Override
	public Noeud precedant() {
		
		if(courant == null){
			courant = listeforme.getQueue();
		}
		
		if (this.possedePrecedant()){
					
			courant = courant.obtenirPrecedant();
			
			return courant;
			
		}else{
			return null;
		}
	}

	@Override
	public Noeud suivant() {
		
		if(courant == null){
			courant = listeforme.getSommet();
		}
		
		if (this.possedeSuivant()){

			courant = courant.obtenirSuivant();
		
			return courant;
			
		}else{
			return null;
		}
		
	}

}
