package clientforme;

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
			Noeud courant = nSommet;
			Noeud temp = new Noeud(forme);
			
			while(courant.obtenirSuivant() != null){
				courant = courant.obtenirSuivant();
			}
			
			temp.definirSuivant(courant.obtenirSuivant());
			courant.definirSuivant(temp);
			tailleListe++;
		}else{
			throw new Exception("La liste de noeud est pleine. Maximum: "+maxForme);
		}
	}
	
	public void viderListe(){
		
	}
	
	/**	 
	 * Méthode servant à parcourir la liste de forme
	 * à partir du sommet ou de la fin.
	 * 
	 * @param aPartirSommet
	 */	
	/*public ArrayList<Noeud> parcourirListe(boolean aPartirSommet){

		ArrayList<Noeud> listeForme = new ArrayList<Noeud>();
		
		if(aPartirSommet==true){
			
			Noeud courant = nSommet;
			
			for(int i = 1; i < tailleListe; i++)
			{
				if(courant!=null){
					listeForme.add(courant);
					courant = courant.obtenirSuivant();
				}else{
					break;
				}
				
			}
		}else{
			Noeud courant = nQueue;
			
			for(int i = tailleListe; i > 0; i--)
			{
				if(courant!=null){
					listeForme.add(courant);
					courant = courant.obtenirPrecedant();
				}else{
					break;
				}
				
			}
		}
		
		return listeForme;
		
	}*/
	
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
	
}
