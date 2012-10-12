package clientforme;

public class ListeIterateur implements Iterateur {

	private ListeForme listeforme;
	private Noeud courant;
	
	public ListeIterateur(ListeForme liste){
		listeforme = liste;
	}
	
	@Override
	public boolean possedePrecedant() {
		
		return(courant.getPrecedant() != null);
		
	}

	@Override
	public boolean possedeSuivant() {

		return(courant.getPrecedant() != null);
	
	}

	@Override
	public Noeud precedant() {
		
		if(courant == null){
			courant = listeforme.getQueue();
		}
		
		if (this.possedePrecedant()){
					
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
		
		if (this.possedeSuivant()){

			courant = courant.getSuivant();
		
			return courant;
			
		}else{
			return null;
		}
		
	}

}
