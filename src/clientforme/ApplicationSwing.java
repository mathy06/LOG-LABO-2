package clientforme;
/******************************************************
 Cours :             LOG-121
 Session :           Automne 2012
 Groupe :            4
 Projet :            Laboratoire #1
�tudiant(e)(s) : 	Philippe Charbonneau
				 	Patrice Robitaille
				 	Mathieu Battah
 Code(s) perm. :     
                     
                     
 Professeur :        Groucho Marx
 Date cr��e :        2002-05-28
 Date dern. modif. : 2012-09-21
 
*******************************************************
 Historique des modifications
*******************************************************
  2002-05-28	Cris Fuhrman : Version initiale
  
  2004-03-07	Cris Fuhrman : Int�gration de SwingWorker 
                requierant la classe additionnelle 
                SwingWorker.java, utilisation des variables 
                constantes, formatage de code source, 
                organisation des imports, etc.

  2005-05-01	Cris Fuhrman : Int�gration de ApplicationSupport
  				requierant la classe additionnelle
  				ApplicationSupport.java et les fichiers
  				prefs.properties, app_xx.properties (o� xx est le
  				code de la langue, p. ex. fr = fran�ais, en = anglais).
  				Suppression de l'interface Shape.
  				
  2006-05-03	S�bastien Adam :
  
                Uniformisation et maintenance du code.

                Ajout des classes pour la gestion des
                items de menu. Un �couteur ajout� pour chaque item 
                (DemarrerListener, ArreterListener, QuitterListener, 
                AProposDeListener).  
                
                La classe ApplicationSwing n'impl�mente plus ActionListener. 
                Elle d�l�gue la gestion des items.
                
                Plus besion d'un "if else if" dans la methode actionPerformed pour 
                ex�cuter l'action associ�e � un item. Le code est plus
                simple � comprendre, lire et maintenir.	
                
  2012-09-21    Patrice Robitaille:
  
  				Ajout d'une fen�tre dialog qui g�re le input de connexion
  				pour le serveur. Le script fait �galement une validation
  				� la source et r�cup�re le nom du serveur ainsi que le num�ro
  				de port � l'aide du d�limiteur ':'.
  				
  				Ajout de 2 variables contenant le nom du serveur et le num�ro de port
  				� valider.
  				
  2012-09-28	Mathieu Battah
  
  				Ajout de l'utilisation de GestionForme pour g�rer la liste de formes.
              

 La distribution originale se trouve � 
 https://cours.ele.etsmtl.ca/academique/log120/notesdecours/exemples/lab/lab1/ApplicationSwing.zip
********************************************************/

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

/**
 * <code>ApplicationSwing</code> est un exemple d'une
 * application en Java qui fournit une interface Swing, avec un simple
 * menu et un dessin.
 *
 * <h4>References</h4> 
 * <ul> 
 *
 * <li>C. Fuhrman, &quot;Notes de cours de LOG120,&quot; &Eacute;cole
 * de technologie sup&eacute;rieure, Montr&eacute;al, Qu&eacute;bec,
 * Canada, 2002
 *
 * <li>Xemacs (for generation of the initial template), <a target="_top" 
 * href="http://www.xemacs.org">www.xemacs.org</a>, 2002 
 *
 * <li><a target="_top" 
 * href="http://java.sun.com/docs/books/tutorial/uiswing/painting/overview.html">Overview
 * of Custom Painting</a>, une partie du tutoriel Java de Sun, 2002.
 *
 * <li>Java Software, <a target="_top" 
 * href="http://java.sun.com/j2se/javadoc/writingdoccomments/index.html">&quot;How
 * to Write Doc Comments for the Javadoc<sup>TM</sup> Tool,&quot;</a>
 * 2002
 *
 * </ul>
 *
 * Distribution originale &agrave; partir du 
 * <a target="_top" href="https://cours.ele.etsmtl.ca/academique/log120/">site Web</a>
 * du cours LOG120.
 * 
 * Created: Tue May 28 11:31:18 2002
 *
 * @author <a href="mailto:christopher.fuhrman@etsmtl.ca">Christopher Fuhrman</a>
 *
 * @version 1.1
 */

public class ApplicationSwing extends JFrame {

	private static final int CANEVAS_HAUTEUR = 500;

	private static final int CANEVAS_LARGEUR = 500;

	private static final int DELAI_FORMES = 1500;

	private static final int DELAI_QUITTER = 200;

	private static final int MARGE_H = 50;

	private static final int MARGE_V = 60;

	private static final int ARRETER_MASK = ActionEvent.CTRL_MASK;

	private static final char ARRETER_RACC = KeyEvent.VK_A;

	private static final int DEMARRER_MASK = ActionEvent.CTRL_MASK;

	private static final char DEMARRER_RACC = KeyEvent.VK_D;

	private static final int QUITTER_MASK = ActionEvent.CTRL_MASK;

	private static final char QUITTER_RACC = KeyEvent.VK_Q;

	private static final String
			FICHIER_TITRE = "app.frame.menus.file.title",
			FICHIER_QUITTER = "app.frame.menus.file.exit",
			SERVEUR_TITRE = "app.frame.menus.server.title",
			DESSIN_DEMARRER = "app.frame.menus.server.connection",
			DESSIN_ARRETER = "app.frame.menus.server.disconnection",
			AIDE_TITRE = "app.frame.menus.help.title",
			AIDE_PROPOS = "app.frame.menus.help.about";

	private static final String DIALOGUE_A_PROPOS = "app.frame.dialog.about";
	
	private static final String NOM_SERVER = "localhost";
	
	private static final int PORT_SERVER = 10000;

	private static final long serialVersionUID = 1L;
		
	private GestionForme gestionForme;
	
	private Communication communication;

	private boolean workerActif;
	
	private JMenuItem arreterMenuItem, demarrerMenuItem;
	
	/** 
	 * Traiter l'item "About...". 
	 */
	class AProposDeListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, ApplicationSupport.getResource(DIALOGUE_A_PROPOS), ApplicationSupport.getResource(AIDE_PROPOS),JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 *  Traiter l'item "Stop".
	 */
	class ArreterListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (workerActif) {
				workerActif = false;
				try {
					communication.commandeEND();
				} catch (CommunicationException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
			rafraichirMenus();
		}
	}
	
	/**
	 *  Traiter l'item "Start". 
	 */
	class DemarrerListener implements ActionListener {
		
		/**
		* demande et valide des donn�es que l'utilisateur
		* doit entr� et affiche des message d'erreurs au besoin
		* @param ActionEvent
		*/
		public void actionPerformed(ActionEvent arg0) {
			
			/* Variable qui d�finit si notre champs est valide */
			Boolean champsValide = false; 
			
			/* Variable qui va contenir le nom et le port du serveur */
			String valeurEntree = "";
			
			do{
				
				/* Cr�ation de la fen�tre qui demande les infos du serveur */
				valeurEntree = JOptionPane.showInputDialog(null,"Quel est le nom d'h�te et le port du serveur de formes ?", "Input", JOptionPane.QUESTION_MESSAGE);

				/* delimiter */
				String delimiter = ":";
				
				if(valeurEntree==null){
					break;
				}
				
				/* On v�rifie si notre valeur contient le d�limiteur. */
				if(!valeurEntree.contains(delimiter)){
					JOptionPane.showMessageDialog(null, "Vous devez inscrire le d�limiteur ':' entre le nom du serveur et le port.", "Erreur", JOptionPane.ERROR_MESSAGE);
				}
				else{
					/* On s�pare le nom du serveur et le port de notre valeur. */
					String[] serveurInfo = valeurEntree.split(delimiter);
					
					String nomServeurEntree = serveurInfo[0];					//Nom du serveur
					int portServeurEntree = Integer.parseInt(serveurInfo[1]);	//Port du serveur
					
					/* Si le num�ro de serveur est "localhost" et le port "10000". */
					if(nomServeurEntree.equals(NOM_SERVER) && portServeurEntree == PORT_SERVER){
						champsValide = true;
						
						communication = Communication.getInstance();
						
						try {
							communication.initialiserConnexion(nomServeurEntree, portServeurEntree);
						
							/* Initialisation du gestionnaire de formes. */
							gestionForme = new GestionForme();
							
							/* On commence � dessiner les formes. */
							final SwingWorker worker = new SwingWorker() {
								public Object construct() {
									dessinerFormes();
									workerActif = false;
									rafraichirMenus();
									return new Integer(0);
								}
							};
							worker.start();
							workerActif = true;
							rafraichirMenus();
						} 
						catch (CommunicationException e) {
							JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
						}	
					}
					else{
						JOptionPane.showMessageDialog(null, "Le nom du serveur ou le num�ro de port est invalide", "Erreur", JOptionPane.ERROR_MESSAGE); 
					}
				}
				
			}
			while(valeurEntree==null || champsValide!=true || !communication.isConnected());

		}
		
		/**
		 *G�re l'afichage des formes contenu dans une liste 
		 */
		protected void dessinerFormes() {
			String commandeForme = null;
			
			/**
			 *  Tant que le worker est actif on demande des formes au serveur et on les dessine. 
			 */
			while (workerActif) {
				
				try {
					commandeForme = communication.commandeGET();
				} 
				catch (CommunicationException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}

				if (!commandeForme.isEmpty()){
					AbstractForme forme = FabriqueForme.creerForme(commandeForme);
					gestionForme.ajouterForme(forme);
				}

				repaint();
				try {
					Thread.sleep(DELAI_FORMES);
				}
				catch (InterruptedException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	/**
	 *  Traiter l'item "Exit".
	 */
	class QuitterListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (workerActif) {
				workerActif = false;
				try {
					Thread.sleep(DELAI_QUITTER);
					communication.commandeEND();
				} catch (InterruptedException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				} catch (CommunicationException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			}
			System.exit(0);
		}
	}

	/**
	 *  Cr�er le panneau sur lequel les formes sont dessin�es. 
	 */
	class CustomCanvas extends JPanel {
		private static final long serialVersionUID = 1L;

		public CustomCanvas() {
			setSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
			CustomCanvas.this.setBackground(Color.white);
		}

		public Dimension getPreferredSize() {
			return new Dimension(CANEVAS_LARGEUR, CANEVAS_HAUTEUR);
		}

		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			Graphics2D g2d = (Graphics2D) graphics;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			if (gestionForme != null){
				AbstractForme[] listeFormes = gestionForme.getListeForme();
				for(int i=0;i<gestionForme.getTaille();++i){
						listeFormes[i].dessiner(g2d);
				}
			}
		}
	}
	
	/* - Constructeur - Cr�er le cadre dans lequel les formes sont dessin�es. */
	public ApplicationSwing() {
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}

	/* Cr�er le menu "Draw". */
	private JMenu creerMenuDessiner() {
		JMenu menu = ApplicationSupport.addMenu(this, SERVEUR_TITRE,
				new String[] { DESSIN_DEMARRER, DESSIN_ARRETER });

		demarrerMenuItem = menu.getItem(0);
		demarrerMenuItem.addActionListener(new DemarrerListener());
		demarrerMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				DEMARRER_RACC,
				DEMARRER_MASK));

		arreterMenuItem = menu.getItem(1);
		arreterMenuItem.addActionListener(new ArreterListener());
		arreterMenuItem.setAccelerator(KeyStroke.getKeyStroke(
				ARRETER_RACC,
				ARRETER_MASK));

		return menu;
	}

	/* Cr�er le menu "File". */
	private JMenu creerMenuFichier() {
		JMenu menu = ApplicationSupport.addMenu(this, FICHIER_TITRE,
				new String[] { FICHIER_QUITTER });

		menu.getItem(0).addActionListener(new QuitterListener());
		menu.getItem(0).setAccelerator(
				KeyStroke.getKeyStroke(QUITTER_RACC,
						QUITTER_MASK));

		return menu;
	}

	/* Cr�er le menu "Help". */
	private JMenu creerMenuAide() {
		JMenu menu = ApplicationSupport.addMenu(this, AIDE_TITRE,
				new String[] { AIDE_PROPOS });

		menu.getItem(0).addActionListener(new AProposDeListener());

		return menu;
	}

	/* Activer ou d�sactiver les items du menu selon la s�lection. */
	private void rafraichirMenus() {
		demarrerMenuItem.setEnabled(!workerActif);
		arreterMenuItem.setEnabled(workerActif);
	}
	
	
	/* Lancer l'ex�cution de l'application. */
	public static void main(String[] args) {
		
		/* Cr�er la fen�tre de l'application. */
		ApplicationSwing cadre = new ApplicationSwing();

		cadre.creerMenuFichier();
		cadre.creerMenuDessiner();
		cadre.creerMenuAide();
		cadre.rafraichirMenus();

		/* On r�cup�re la dimension de l'�cran pour centrer. */	
		Point centre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		/* Lancer l'application. */
		ApplicationSupport.launch(cadre, ApplicationSupport
				.getResource("app.frame.title"), (centre.x - (CANEVAS_LARGEUR / 2)), (centre.y - (CANEVAS_HAUTEUR / 2)), CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
}
