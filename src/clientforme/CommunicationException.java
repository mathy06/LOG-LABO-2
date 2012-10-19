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
Nom du fichier : CommunicationException.java
Date créé : 18-09-2012
Date dern. modif. : 18-09-2012
*******************************************************
Historique des modifications
*******************************************************
18-09-2012 Version initiale (Philippe Charbonneau)
*******************************************************/
public class CommunicationException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public CommunicationException(){}
	
	public  CommunicationException(String message){
		super(message);
	}
}
