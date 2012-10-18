package clientforme;
import java.util.Comparator;

/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
Étudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. : 
				ROBP20028905
				
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : Communication.java
Date créé : 09-10-2012
Date dern. modif. : 09-10-2012
*******************************************************
Historique des modifications
*******************************************************
09-10-2012 Version 1.0 (Patrice Robitaille)
12-10-2012 Version 1.1 (Patrice Robitaille)
*******************************************************/

/**
 * Classe gérant la liste des formes
 */

public class ListeForme {

	private Noeud nSommet = new Noeud(null); //Premier Noeud de la liste
	private Noeud nQueue = new Noeud(null); //Dernier noeud de la liste
	private int maxForme; //Nombre de noeuds maximum dans la liste
	private int tailleListe; //Taille actuelle de la liste
	private ListeForme listeTrier;

	public ListeForme getListeTrier(){
		return listeTrier;
	}
	
	public Noeud getSommet() {
		return nSommet;
	}

	public void setSommet(Noeud sommet) {
		nSommet = sommet;
	}

	public Noeud getQueue() {
		return nQueue;
	}

	public void setQueue(Noeud queue) {
		nQueue = queue;
	}
	
	/**	 
	 * Constructor
	 * 
	 * @param nbForme Définit le nombre de forme maximum pour la liste
	 */
	public ListeForme(int nbForme)
	{
		tailleListe = 0;
		maxForme = nbForme;
		nQueue = nSommet;
	}
	
	public ListeForme clone(){
		ListeForme lstf = new ListeForme(maxForme);
		lstf.nQueue = nQueue;
		lstf.nSommet = nSommet;
		lstf.tailleListe = tailleListe;
		return lstf;
	}
	
	/**	 
	 * Méthode servant à ajouter un noeud (forme)
	 * à la liste de forme
	 * 
	 * @param forme
	 */
	public void ajouterNoeud(AbstractForme forme) throws Exception{
		
		//Si la liste n'est pas pleine
		if(tailleListe<maxForme){
			if(estVide()){
				nSommet = nQueue = new Noeud(forme);
			}else{	
				Noeud temporaire = new Noeud(forme);
				nQueue.setSuivant(temporaire);
				temporaire.setPrecedant(nQueue);
				
				nQueue = temporaire;
			}
			tailleListe++;
		}else{
			throw new Exception("La liste de noeud est pleine. Maximum: "+maxForme);
		}
	}
	
	/**	 
	 * Méthode servant à vider la liste
	 *  
	 */
	public void viderListe(){
		
	}
	
	
	/**	 
	 * Méthode servant à déterminer si 
	 * la liste est pleine
	 *  
	 */
	public boolean estPleine(){

		if(tailleListe<maxForme){
			return false;
		}else{
			return true;
		}
	}
	
	/**	 
	 * Méthode servant à déterminer si 
	 * la liste est vide
	 *  
	 */
	public boolean estVide(){

		if(tailleListe>0){
			return false;
		}else{
			return true;
		}
	}
	
	
	/**	 
	 * Méthode servant à obtenir la taille actuelle de
	 * la liste
	 *  
	 */
	public int obtenirTaille(){

		return tailleListe;
		
	}
	
	/**	 
	 * Méthode servant à obtenir la taille maximum de
	 * la liste
	 *  
	 */
	public int obternirTailleMaximum(){
		
		return maxForme;
	}
	
	/**
	 * Méthode servant à trier les Noeuds de la liste de forme.
	 * @param comparateur
	 */
	public void tri(Comparator<AbstractForme> comp){
		ListeForme listeTrie = new ListeForme(maxForme);
		ListeIterateur iterateur = new ListeIterateur(this);
		boolean noeudTrier;
		
		while(iterateur.possedeSuivant()){
			noeudTrier = false;
			Noeud aInserer = iterateur.suivant();
			ListeIterateur iterateurTri = new ListeIterateur(listeTrie);
			if(listeTrie.estVide()){
				try{
					listeTrie.ajouterNoeud(aInserer.getNoeud());
				}catch(Exception ex){}
			}
			else{
				while(iterateurTri.possedeSuivant() && !noeudTrier){
					Noeud aComparer = iterateurTri.suivant();
					if(comp.compare(aInserer.getNoeud(),aComparer.getNoeud()) < 0){
						listeTrie.inserer(new Noeud(aInserer.getNoeud()),aComparer); 
						noeudTrier = true;
					}
					
				}
				if(!noeudTrier){
					try{
						listeTrie.ajouterNoeud(aInserer.getNoeud());
					}catch(Exception ex){}
				}
			}
		}
		listeTrier = listeTrie;
	}
	
	private void inserer(Noeud premier,Noeud deuxieme){
		
		if(deuxieme.getPrecedant()!=null)deuxieme.getPrecedant().setSuivant(premier);
		premier.setPrecedant(deuxieme.getPrecedant());
		premier.setSuivant(deuxieme);
		deuxieme.setPrecedant(premier);
		if(deuxieme == this.nSommet)
			this.setSommet(premier);
		++tailleListe;
		
	}
	
	
}
