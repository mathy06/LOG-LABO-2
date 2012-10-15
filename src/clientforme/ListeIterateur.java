package clientforme;

public class ListeIterateur implements Iterateur {

	private ListeForme listeforme;
	private Noeud courant;
	
	public ListeIterateur(ListeForme liste){
		listeforme = liste;
		courant = listeforme.getSommet();
	}
	
	@Override
	public boolean possedePrecedant() {
		
		return courant.possedePrecedant();
		
	}

	@Override
	public boolean possedeSuivant() {

		return courant.possedeSuivant();
	
	}

	@Override
	public Noeud precedant() {
		
		if(courant == null){
			courant = listeforme.getQueue();
		}
		
		if (courant.possedePrecedant()){
					
			courant = courant.getPrecedant();
			
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
		
		if (courant.possedeSuivant()){

			courant = courant.getSuivant();
		
			return courant;
			
		}else{
			return null;
		}
		
	}

}
