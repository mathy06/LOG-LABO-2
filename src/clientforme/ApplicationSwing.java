package clientforme;
/******************************************************
 Cours :             LOG-121
 Session :           Automne 2012
 Groupe :            4
 Projet :            Laboratoire #2
�tudiant(e)(s) : 	Philippe Charbonneau
				 	Patrice Robitaille
				 	Mathieu Battah
 Code(s) perm. :    CHAP07110906
                    ROBP2002805 
                    BATM19038902 
 Professeur :        Groucho Marx
 Date cr��e :        2002-05-28
 Date dern. modif. : 2012-10-11
 
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
  				
  2012-10-11	Mathieu Battah
  
  				Modification des menus pour le lab 2.
              

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
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
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
	
	private static final char FICHIER_RACC = KeyEvent.VK_F;
	private static final int FORME_MASK = ActionEvent.CTRL_MASK;
	private static final char FORME_RACC = KeyEvent.VK_O;
	private static final int ORDRE_MASK = ActionEvent.CTRL_MASK;
	private static final char ORDRE_RACC = KeyEvent.VK_R;
	private static final char NOSEQASC_RACC = KeyEvent.VK_N;
	private static final char NOSEQDESC_RACC = KeyEvent.VK_S;
	private static final char AIREASC_RACC = KeyEvent.VK_A;
	private static final char AIREDESC_RACC = KeyEvent.VK_R;
	private static final char TYPEFORME_RACC = KeyEvent.VK_T;
	private static final char TYPEFORMEINV_RACC = KeyEvent.VK_F;
	private static final char DISTANCE_RACC = KeyEvent.VK_D;
	private static final char ORIGINAL_RACC = KeyEvent.VK_G;
	private static final char HAUTEURASC_RACC = KeyEvent.VK_H;
	private static final char HAUTEURDESC_RACC = KeyEvent.VK_C;
	private static final char LARGEURASC_RACC = KeyEvent.VK_L;
	private static final char LARGEURDESC_RACC = KeyEvent.VK_Z;
	private static final int QUITTER_MASK = ActionEvent.CTRL_MASK;
	private static final char QUITTER_RACC = KeyEvent.VK_Q;
	private static final char AIDE_RACC = KeyEvent.VK_A;
	private static final int PROPOS_MASK = ActionEvent.CTRL_MASK;
	private static final char PROPOS_RACC = KeyEvent.VK_P;

	private static final String
			FICHIER_TITRE = "app.frame.menus.file.title",
			FICHIER_FORME = "app.frame.menus.file.getshape",
			FICHIER_QUITTER = "app.frame.menus.file.exit",
			ORDRE_TITRE = "app.frame.menus.order.title",
			ORDRE_NOSEQASC = "app.frame.menus.order.nosequenceascending",
			ORDRE_NOSEQDESC = "app.frame.menus.order.nosequencedescending",
			ORDRE_AIREASC = "app.frame.menus.order.areaascending",
			ORDRE_AIREDESC = "app.frame.menus.order.areadescending",
			ORDRE_TFORME = "app.frame.menus.order.shapetype",
			ORDRE_TFORMEINV = "app.frame.menus.order.shapetypeinverse",
			ORDRE_DISTANCE = "app.frame.menus.order.distance",
			ORDRE_ORIGINAL = "app.frame.menus.order.origine",
			ORDRE_HAUTEURASC = "app.frame.menus.order.hauteurascending",
			ORDRE_HAUTEURDESC = "app.frame.menus.order.hauteurdescending",
			ORDRE_LARGEURASC = "app.frame.menus.order.largeurascending",
			ORDRE_LARGEURDESC = "app.frame.menus.order.largeurdescending",
			AIDE_TITRE = "app.frame.menus.help.title",
			AIDE_PROPOS = "app.frame.menus.help.about";

	private static final String DIALOGUE_A_PROPOS = "app.frame.dialog.about";
	
	private static final String NOM_SERVER = "localhost";
	
	private static final int PORT_SERVER = 10000;

	private static final long serialVersionUID = 1L;
		
	private GestionForme gestionForme;
	
	private Communication communication;
	
	private ButtonGroup groupeOrdre;
	
	private enum Ordre {
						NOSEQASC, NOSEQDESC, AIREASC, AIREDESC, TYPEFORME, TYPEFORMEINV, DISTANCE, ORIGINAL, 
						HAUTEURASC, HAUTEURDESC, LARGEURASC, LARGEURDESC
						};
	
	/**
	 * Traiter les items du menu "Ordre".
	 */
	class OrdreAction extends AbstractAction{
		private static final long serialVersionUID = 1L;
		
		private Ordre ordre;
		
		public OrdreAction(String menuItemTitle, Ordre ordreTri){
			super(menuItemTitle);
			ordre = ordreTri;
		}
		
		public void actionPerformed(ActionEvent arg0){
			if(!(gestionForme == null)){
				
				try{
					switch(ordre){
						case NOSEQASC:
							//On trie par num�ro de s�quence ascendant
							gestionForme.tri(new CompareNoSequence(true));
							break;
						case NOSEQDESC:
							//On trie par num�ro de s�quence descendant
							gestionForme.tri(new CompareNoSequence(false));
							break;
						case AIREASC:
							//On trie par aire ascendant
							gestionForme.tri(new CompareAire(true));
							break;
						case AIREDESC:
							//On trie par aire descendant
							gestionForme.tri(new CompareAire(false));
							break;
						case TYPEFORME:
							//On trie par type de forme
							gestionForme.tri(new CompareForme(true));
							break;
						case TYPEFORMEINV:
							//On trie par type de forme invers�
							gestionForme.tri(new CompareForme(false));
							break;
						case DISTANCE:
							//On trie par distance
							gestionForme.tri(new CompareDistance(true));
							break;
						case ORIGINAL:
							//On trie avec l'ordre original
							gestionForme.setListeOriginal();
							break;
						case HAUTEURASC:
							//On trie par hauteur croissante
							System.out.println("HAUTEURASC");
							gestionForme.tri(new CompareHauteur(true));
							break;
						case HAUTEURDESC:
							//On trie par hauteur d�croissante
							gestionForme.tri(new CompareHauteur(false));
							break;
						case LARGEURASC:
							//On trie par largeur croissante
							gestionForme.tri(new CompareLargeur(true));
							break;
						case LARGEURDESC:
							//On trie par largeur d�croisstante
							gestionForme.tri(new CompareLargeur(false));
							break;
					}
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Erreur",JOptionPane.ERROR_MESSAGE);
				}
			}
			
			//On rafraichit l'�cran
			repaint();
			validate();
		}
	}
	
	/**
	 *  Traiter l'item "Obtenir formes".
	 */
	class ObtenirFormesAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public ObtenirFormesAction() {
			super(ApplicationSupport.getResource(FICHIER_FORME));
		}
		
		public void actionPerformed(ActionEvent arg0) {
			String commandeForme = null;
			communication = Communication.getInstance();
			
			groupeOrdre.clearSelection();
			
			try {
				/* Initialisation de la connexion. */
				communication.initialiserConnexion(NOM_SERVER, PORT_SERVER);
			
				/* Initialisation du gestionnaire de formes. */
				gestionForme = new GestionForme();
				
				/* On r�cup�re les formes. */
				for(int nbFormes = 0; nbFormes < gestionForme.getMaxTaille(); nbFormes++){
					commandeForme = communication.commandeGET();
					
					if (!commandeForme.isEmpty()){
						AbstractForme forme = FabriqueForme.creerForme(commandeForme);
						gestionForme.ajouterForme(forme);
						
					}
				}

				/* On ferme la connexion avec le serveur de formes. */
				communication.commandeEND();
				
				repaint();
				validate();
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
		private static final long serialVersionUID = 1L;
		
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
		private static final long serialVersionUID = 1L;

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
				ListeForme listeFormes = gestionForme.getListeFormeTrier();
				ListeIterateur iterateur = new ListeIterateur(listeFormes);
				int compteur = 0;
				while(iterateur.possedeSuivant()){
					/*
					 * TODO: Ajouter les positions selon le nombre de forme en param�tre
					 * 			Ex: listeFormes[i].dessiner(g2d, i*40, i*40);
					 */
					iterateur.suivant().getNoeud().dessiner(g2d, compteur * 40, compteur * 40);
					++compteur;
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
		menu.setMnemonic(ORDRE_RACC);
		
		groupeOrdre = new ButtonGroup();
		
		/* Cr�ation de JRadtioButtonMenuItem. */
		JRadioButtonMenuItem ordreNoSeqCst = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_NOSEQASC), Ordre.NOSEQASC));
		JRadioButtonMenuItem ordreNoSeqDst = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_NOSEQDESC), Ordre.NOSEQDESC));
		JRadioButtonMenuItem ordreAireCst = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_AIREASC), Ordre.AIREASC));
		JRadioButtonMenuItem ordreAireDst = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_AIREDESC), Ordre.AIREDESC));
		JRadioButtonMenuItem ordreTForme = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_TFORME), Ordre.TYPEFORME));
		JRadioButtonMenuItem ordreTFormeInv = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_TFORMEINV), Ordre.TYPEFORMEINV));
		JRadioButtonMenuItem ordreDistance = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_DISTANCE), Ordre.DISTANCE));
		JRadioButtonMenuItem ordreOriginal = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_ORIGINAL), Ordre.ORIGINAL));
		JRadioButtonMenuItem ordreHauteurAsc = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_HAUTEURASC), Ordre.HAUTEURASC));
		JRadioButtonMenuItem ordreHauteurDesc = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_HAUTEURDESC), Ordre.HAUTEURDESC));
		JRadioButtonMenuItem ordreLargeurAsc = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_LARGEURASC), Ordre.LARGEURASC));
		JRadioButtonMenuItem ordreLargeurDesc = new JRadioButtonMenuItem(new OrdreAction(ApplicationSupport.getResource(ORDRE_LARGEURDESC), Ordre.LARGEURDESC));
		
		
		/* Ajout des raccourcis sp�cifiques � chaque bouton radio. */
		ordreNoSeqCst.setAccelerator(KeyStroke.getKeyStroke(NOSEQASC_RACC, ORDRE_MASK));
		ordreNoSeqCst.setMnemonic(NOSEQASC_RACC);
		ordreNoSeqDst.setAccelerator(KeyStroke.getKeyStroke(NOSEQDESC_RACC, ORDRE_MASK));
		ordreNoSeqDst.setMnemonic(NOSEQDESC_RACC);
		ordreAireCst.setAccelerator(KeyStroke.getKeyStroke(AIREASC_RACC, ORDRE_MASK));
		ordreAireCst.setMnemonic(AIREASC_RACC);
		ordreAireDst.setAccelerator(KeyStroke.getKeyStroke(AIREDESC_RACC, ORDRE_MASK));
		ordreAireDst.setMnemonic(AIREDESC_RACC);
		ordreTForme.setAccelerator(KeyStroke.getKeyStroke(TYPEFORME_RACC, ORDRE_MASK));
		ordreTForme.setMnemonic(TYPEFORME_RACC);
		ordreTFormeInv.setAccelerator(KeyStroke.getKeyStroke(TYPEFORMEINV_RACC, ORDRE_MASK));
		ordreTFormeInv.setMnemonic(TYPEFORMEINV_RACC);
		ordreDistance.setAccelerator(KeyStroke.getKeyStroke(DISTANCE_RACC, ORDRE_MASK));
		ordreDistance.setMnemonic(DISTANCE_RACC);
		ordreOriginal.setAccelerator(KeyStroke.getKeyStroke(ORIGINAL_RACC, ORDRE_MASK));
		ordreOriginal.setMnemonic(ORIGINAL_RACC);
		ordreHauteurAsc.setAccelerator(KeyStroke.getKeyStroke(HAUTEURASC_RACC, ORDRE_MASK));
		ordreHauteurAsc.setMnemonic(HAUTEURASC_RACC);
		ordreHauteurDesc.setAccelerator(KeyStroke.getKeyStroke(HAUTEURDESC_RACC, ORDRE_MASK));
		ordreHauteurDesc.setMnemonic(HAUTEURDESC_RACC);
		ordreLargeurAsc.setAccelerator(KeyStroke.getKeyStroke(LARGEURASC_RACC, ORDRE_MASK));
		ordreLargeurAsc.setMnemonic(LARGEURASC_RACC);
		ordreLargeurDesc.setAccelerator(KeyStroke.getKeyStroke(LARGEURDESC_RACC, ORDRE_MASK));
		ordreLargeurDesc.setMnemonic(LARGEURDESC_RACC);

		/* Ajout des boutons radio au groupe de radio bouton. */
		groupeOrdre.add(ordreNoSeqCst);
		groupeOrdre.add(ordreNoSeqDst);
		groupeOrdre.add(ordreAireCst);
		groupeOrdre.add(ordreAireDst);
		groupeOrdre.add(ordreTForme);
		groupeOrdre.add(ordreTFormeInv);
		groupeOrdre.add(ordreDistance);
		groupeOrdre.add(ordreOriginal);
		groupeOrdre.add(ordreHauteurAsc);
		groupeOrdre.add(ordreHauteurDesc);
		groupeOrdre.add(ordreLargeurAsc);
		groupeOrdre.add(ordreLargeurDesc);
		
		/* Ajout des boutons radio au menu. */
		menu.add(ordreNoSeqCst);
		menu.add(ordreNoSeqDst);
		menu.add(ordreAireCst);
		menu.add(ordreAireDst);
		menu.add(ordreTForme);
		menu.add(ordreTFormeInv);
		menu.add(ordreDistance);
		menu.add(ordreOriginal);
		menu.add(ordreHauteurAsc);
		menu.add(ordreHauteurDesc);
		menu.add(ordreLargeurAsc);
		menu.add(ordreLargeurDesc);

		return menu;
	}

	/* Cr�er le menu "Fichier". */
	private JMenu creerMenuFichier() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(FICHIER_TITRE));
		menu.setMnemonic(FICHIER_RACC);
		
		menu.add(new ObtenirFormesAction());
		menu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(FORME_RACC, FORME_MASK));
		menu.getItem(0).setMnemonic(FORME_RACC);
		
		menu.add(new QuitterAction());
		menu.getItem(1).setAccelerator(KeyStroke.getKeyStroke(QUITTER_RACC, QUITTER_MASK));
		menu.getItem(1).setMnemonic(QUITTER_RACC);

		return menu;
	}

	/* Cr�er le menu "Aide". */
	private JMenu creerMenuAide() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(AIDE_TITRE));
		menu.setMnemonic(AIDE_RACC);

		menu.add(new AProposDeAction());
		menu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(PROPOS_RACC, PROPOS_MASK));
		menu.getItem(0).setMnemonic(PROPOS_RACC);

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
