package clientforme;
import java.io.*;
import java.net.*;
/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #1
�tudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :    CHAP07110906
                    ROBP2002805 
                    BATM19038902 				
				
Professeur : Ghizlane El boussaidi
Charg� de labo  : Alvine Boaye Belle
Nom du fichier : Communication.java
Date cr�� : 17-09-2012
Date dern. modif. : 18-09-2012
*******************************************************
Historique des modifications
*******************************************************
17-09-2012 Version 1.0 (Philippe Charbonneau)
18-09-2012 Version 1.01 (Philippe Charbonneau)
28-09-2012 Version 1.02	(Mathieu Battah)
*******************************************************/

/**
 * Classe g�rant une connexion avec un serveur.
 */
public class Communication {
	
	private static Communication instance;
	private Socket connexion;        //Objet socket servant � �tablir une connexion avec un serveur
	private PrintWriter sortie;		 //Objet servant � parler avec le serveur 
	private BufferedReader entree;   //Objet servant � �couter le serveur
	private boolean estConnecte = false;
	
	private Communication(){}
	
	/**
	 * Retourne l'instance de l'objet unique
	 * @return Communication
	 */
	public static Communication getInstance(){
		if (instance == null)
			instance = new Communication();
		
		return instance;
	}
	
	public boolean isConnected(){
		return estConnecte;
	}
	
	/**	 
	 * M�thode servant � �tablir la connexion
	 * avec un serveur de nom : "nomServeur" 
	 * �coutant sur le port: noPort
	 * @param nomServeur
	 * @param noPort
	 */
	void initialiserConnexion(String nomServeur,int noPort)throws CommunicationException{
		
		try{
			if(!estConnecte){
				connexion = new Socket(nomServeur,noPort);					    					//Initialisation de l'objet socket
				sortie	  = new PrintWriter(connexion.getOutputStream(),true); 						//Initialisation de la discussion
				entree	  = new BufferedReader(new InputStreamReader(connexion.getInputStream())); 	//Initialisation de l'�coute
				estConnecte = true;
			}
			else{
				estConnecte = false;
				throw new CommunicationException("Logiciel d�j� connect� � un serveur, d�connectez vous avant.");
			}
											   	
		}
		catch(UnknownHostException e){
			estConnecte = false;
			throw new CommunicationException("Serveur inconnu");
		}
		catch(IOException e){
			estConnecte = false;
			throw new CommunicationException("Impossible d'�tablir la connexion avec le serveur : "+ nomServeur + " au port : " + noPort);
		}
		
	}	
	
	/**
	 * M�thode servant � envoyer la commande 
	 * "GET" au serveur. Retourne la r�ponse 
	 * du serveur
	 * @return chaine de caract�re contenant les propri�t�es d'une forme
	 */
	String commandeGET()throws CommunicationException{
		try{	
			if(!estConnecte||entree.readLine() == null){
				estConnecte = false;
				throw new CommunicationException("Le client � �t� d�connect� du serveur");
			}
				sortie.println("GET");
				return  entree.readLine();
			}
			catch(IOException e){
				estConnecte = false;
				throw new CommunicationException("Une erreur est survenue lors de la communication avec le serveur");
			}
		
	}
	
	/**
	 * M�thode servant � envoyer la commande 
	 * "End" au serveur. Termine la connexion
	 */
	void commandeEND()throws CommunicationException{
		try{
			if(!estConnecte || entree.readLine() == null){
				estConnecte = false;
				throw new CommunicationException("Le client � �t� d�connect� du serveur");
			}
			sortie.println("END");
				
			connexion.shutdownInput();
			connexion.shutdownOutput();
			connexion.close();
			estConnecte = false;
			}
			catch(IOException e){
				estConnecte = false;
				throw new CommunicationException("Une erreur est survenue lors de la communication avec le serveur");
			}
		}
}
