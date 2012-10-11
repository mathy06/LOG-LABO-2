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

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
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

	private static final int MARGE_H = 50;

	private static final int MARGE_V = 60;
	
	private static final int FORME_MASK = ActionEvent.CTRL_MASK;

	private static final char FORME_RACC = KeyEvent.VK_F;

	private static final int QUITTER_MASK = ActionEvent.CTRL_MASK;

	private static final char QUITTER_RACC = KeyEvent.VK_Q;

	private static final String
			FICHIER_TITRE = "app.frame.menus.file.title",
			FICHIER_FORME = "app.frame.menus.file.getshape",
			FICHIER_QUITTER = "app.frame.menus.file.exit",
			ORDRE_TITRE = "app.frame.menus.order.title",
			ORDRE_NOSEQASC = "app.frame.menus.order.nosequenceascending",
			ORDRE_NOSEQDESC = "app.frame.menus.order.nosequencedescending",
			ORDRE_AIREASC = "app.frame.menus.order.areaascending",
			ORDRE_AIREDESC = "app.frame.menus.order.areadescending",
			ORDRE_TYPE = "app.frame.menus.order.shapetype",
			ORDRE_TYPEINV = "app.frame.menus.order.shapetypeinverse",
			ORDRE_DISTANCE = "app.frame.menus.order.distance",
			AIDE_TITRE = "app.frame.menus.help.title",
			AIDE_PROPOS = "app.frame.menus.help.about";

	private static final String DIALOGUE_A_PROPOS = "app.frame.dialog.about";
	
	private static final String NOM_SERVER = "localhost";
	
	private static final int PORT_SERVER = 10000;

	private static final long serialVersionUID = 1L;
		
	private GestionForme gestionForme;
	
	private Communication communication;
	
	/**
	 * Traiter l'item "Croissant par num�ro de s�quence".
	 */
	class OrdreNoSequenceCroissant extends AbstractAction{
		public OrdreNoSequenceCroissant(){
			super(ApplicationSupport.getResource(ORDRE_NOSEQASC));
		}
		
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(null, "Je trie en ordre croissant par numero de s�quence.", "TEST",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Traiter l'item "D�croissant par num�ro de s�quence".
	 */
	class OrdreNoSequenceDecroissant extends AbstractAction{
		public OrdreNoSequenceDecroissant(){
			super(ApplicationSupport.getResource(ORDRE_NOSEQDESC));
		}
		
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(null, "Je trie en ordre d�croissant par numero de s�quence.", "TEST",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Traiter l'item "Croissant par l'aire".
	 */
	class OrdreAireCroissant extends AbstractAction{
		public OrdreAireCroissant(){
			super(ApplicationSupport.getResource(ORDRE_AIREASC));
		}
		
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(null, "Je trie en ordre croissant par l'aire.", "TEST",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Traiter l'item "D�croissant par l'aire".
	 */
	class OrdreAireDecroissant extends AbstractAction{
		public OrdreAireDecroissant(){
			super(ApplicationSupport.getResource(ORDRE_AIREDESC));
		}
		
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(null, "Je trie en ordre d�croissant par l'aire.", "TEST",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Traiter l'item "Par type de forme".
	 */
	class OrdreTypeForme extends AbstractAction{
		public OrdreTypeForme(){
			super(ApplicationSupport.getResource(ORDRE_TYPE));
		}
		
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(null, "Je trie par type de forme.", "TEST",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Traiter l'item "Par type de forme inverse".
	 */
	class OrdreTypeFormeInverse extends AbstractAction{
		public OrdreTypeFormeInverse(){
			super(ApplicationSupport.getResource(ORDRE_TYPEINV));
		}
		
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(null, "Je trie par type de forme inverse.", "TEST",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Traiter l'item "Par distance".
	 */
	class OrdreDistance extends AbstractAction{
		public OrdreDistance(){
			super(ApplicationSupport.getResource(ORDRE_DISTANCE));
		}
		
		public void actionPerformed(ActionEvent arg0){
			JOptionPane.showMessageDialog(null, "Je trie par distance.", "TEST",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 *  Traiter l'item "Obtenir formes".
	 */
	class ObtenirFormes extends AbstractAction {
		public ObtenirFormes() {
			super(ApplicationSupport.getResource(FICHIER_FORME));
		}
		
		public void actionPerformed(ActionEvent arg0) {
			String commandeForme = null;
			communication = Communication.getInstance();
			
			try {
				communication.initialiserConnexion(NOM_SERVER, PORT_SERVER);
			
				/* Initialisation du gestionnaire de formes. */
				gestionForme = new GestionForme();
				
				/* On r�cup�re les formes. */
				for(int nbFormes = 0; nbFormes < gestionForme.getTaille(); nbFormes++){
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
				}

				/* On ferme la connexion avec le serveur de formes. */
				try {
					communication.commandeEND();
				} catch (CommunicationException e) {
					JOptionPane.showMessageDialog(null,e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
				}
			} 
			catch (CommunicationException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	/**
	 *  Traiter l'item "Quitter".
	 */
	class QuitterAction extends AbstractAction {
		public QuitterAction() {
			super(ApplicationSupport.getResource(FICHIER_QUITTER));
		}
		
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	/** 
	 * Traiter l'item "A propos". 
	 */
	class AProposDeAction extends AbstractAction {
		public AProposDeAction(){
			super(ApplicationSupport.getResource(AIDE_PROPOS));
		}
		
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, ApplicationSupport.getResource(DIALOGUE_A_PROPOS), ApplicationSupport.getResource(AIDE_PROPOS),JOptionPane.INFORMATION_MESSAGE);
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

	/* Cr�er le menu "Ordre". */
	private JMenu creerMenuOrdre() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(ORDRE_TITRE));
		
		ButtonGroup groupeOrdre = new ButtonGroup();
		
		/* Cr�ation de JRadtioButtonMenuItem. */
		JRadioButtonMenuItem ordreNoSequenceCroissant = new JRadioButtonMenuItem();
		JRadioButtonMenuItem ordreNoSequenceDecroissant = new JRadioButtonMenuItem();
		JRadioButtonMenuItem ordreAireCroissant = new JRadioButtonMenuItem();
		JRadioButtonMenuItem ordreAireDecroissant = new JRadioButtonMenuItem();
		JRadioButtonMenuItem ordreTypeForme = new JRadioButtonMenuItem();
		JRadioButtonMenuItem ordreTypeFormeInverse = new JRadioButtonMenuItem();
		JRadioButtonMenuItem ordreDistance = new JRadioButtonMenuItem();
		
		/* Ajout des actions sp�cifiques � chaque bouton radio. */
		ordreNoSequenceCroissant.setAction(new OrdreNoSequenceCroissant());
		ordreNoSequenceDecroissant.setAction(new OrdreNoSequenceDecroissant());
		ordreAireCroissant.setAction(new OrdreAireCroissant());
		ordreAireDecroissant.setAction(new OrdreAireDecroissant());
		ordreTypeForme.setAction(new OrdreTypeForme());
		ordreTypeFormeInverse.setAction(new OrdreTypeFormeInverse());
		ordreDistance.setAction(new OrdreDistance());

		/* Ajout des boutons radion au groupe de radio bouton. */
		groupeOrdre.add(ordreNoSequenceCroissant);
		groupeOrdre.add(ordreNoSequenceDecroissant);
		groupeOrdre.add(ordreAireCroissant);
		groupeOrdre.add(ordreAireDecroissant);
		groupeOrdre.add(ordreTypeForme);
		groupeOrdre.add(ordreTypeFormeInverse);
		groupeOrdre.add(ordreDistance);
		
		/* Ajout des boutons radion au menu. */
		menu.add(ordreNoSequenceCroissant);
		menu.add(ordreNoSequenceDecroissant);
		menu.add(ordreAireCroissant);
		menu.add(ordreAireDecroissant);
		menu.add(ordreTypeForme);
		menu.add(ordreTypeFormeInverse);
		menu.add(ordreDistance);

		return menu;
	}

	/* Cr�er le menu "Fichier". */
	private JMenu creerMenuFichier() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(FICHIER_TITRE));
		
		menu.add(new ObtenirFormes());
		menu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(FORME_RACC, FORME_MASK));
		
		menu.add(new QuitterAction());
		menu.getItem(1).setAccelerator(KeyStroke.getKeyStroke(QUITTER_RACC, QUITTER_MASK));

		return menu;
	}

	/* Cr�er le menu "Aide". */
	private JMenu creerMenuAide() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(AIDE_TITRE));

		menu.add(new AProposDeAction());

		return menu;
	}	
	
	/* Lancer l'ex�cution de l'application. */
	public static void main(String[] args) {
		
		/* Cr�er la fen�tre de l'application. */
		ApplicationSwing cadre = new ApplicationSwing();
		
		JMenuBar barreMenu = new JMenuBar();
		barreMenu.add(cadre.creerMenuFichier());
		barreMenu.add(cadre.creerMenuOrdre());
		barreMenu.add(cadre.creerMenuAide());
		cadre.setJMenuBar(barreMenu);

		/* On r�cup�re la dimension de l'�cran pour centrer. */	
		Point centre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		/* Lancer l'application. */
		ApplicationSupport.launch(cadre, ApplicationSupport
				.getResource("app.frame.title"), (centre.x - (CANEVAS_LARGEUR / 2)), (centre.y - (CANEVAS_HAUTEUR / 2)), CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
}
