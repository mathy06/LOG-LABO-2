package clientforme;

public class ListeIterateur implements Iterateur {

	private ListeForme listeforme;
	private Noeud courant;
	
	public ListeIterateur(ListeForme liste){
		listeforme = liste;
	}
	
	@Override
	public boolean possedePrecedant() {
		boolean reponse = false;
		if(courant == null){
			if(!listeforme.estVide())reponse = true;
		}
		else
			reponse = courant.possedePrecedant();
		return reponse;
		
	}

	@Override
	public boolean possedeSuivant() {
		boolean reponse = false;
		if(courant == null){
			if(!listeforme.estVide())reponse = true;
		}
		else
			reponse = courant.possedeSuivant();
		
		return reponse;
	
	}

	@Override
	public Noeud precedant() {
		
		if(courant == null){
			courant = listeforme.getQueue();
		}
		else if (courant.possedePrecedant()){
					
			courant = courant.getPrecedant();
				
		}else{
			return null;
		}
		return courant;
	}

	@Override
	public Noeud suivant() {
		
		if(courant == null){
			courant = listeforme.getSommet();
		}
		else if (courant.possedeSuivant()){
			courant = courant.getSuivant();
			
		}else{
			return null;
		}
		return courant;
		
	}

}
