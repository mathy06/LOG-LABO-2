package clientforme;

/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
Étudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :    CHAP07110906
                    ROBP2002805 
                    BATM19038902 
				
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : ListeIterateur.java
Date créé : 18-10-2012
Date dern. modif. : 18-10-2012
*******************************************************/

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
