import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import java.util.Queue;

public class PlateauDeJeu extends JFrame implements ActionListener, WindowListener{ 

	private Grille grille;
	private int taille;
	private JPanel panneau,dPan, panneauJoueur, panneauJeton ;
	private JButton[] jBout ;
	private JLabel[][] grilleLabels ;
	private JLabel jeton, points ;
	private	JLabel infos ;
	private ImageIcon[] iconesJetons ;
	private ImageIcon[] iconesJetonsAlpha ;
	private ImageIcon iconeFleche,iconeCaseVide ;
	private Queue<Integer> coupQueue = new LinkedList<Integer>();
	private Thread listener ;

	private String path = "./Semaine 14-Projet/Images/";

	public PlateauDeJeu (Grille grille) {

		this.grille = grille;
		taille = grille.getTaille();
		this.taille = taille ;
		listener = Thread.currentThread();
		try {
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e) {
			System.out.println(e.getMessage()) ;
		}
		this.setTitle("Puissance 4");
		this.setSize(taille*70+20,taille*64+200);
		this.setLocation(10,10);

		panneau = new JPanel() ;
		panneau.setLayout(new BorderLayout()) ;
		panneauJoueur = new JPanel() ;
		panneauJoueur.setLayout(new GridLayout(1,1));
		panneauJeton = new JPanel() ;
		panneauJeton.setLayout(new GridLayout(1,taille-3));
		panneauJeton.add(new JLabel("Joueur suivant :"));
		jeton = new JLabel() ;
		jeton.setHorizontalAlignment(SwingConstants.LEFT);
		panneauJeton.add(jeton) ;
		for (int i=0 ; i<taille-5 ; i++) {
			panneauJeton.add(new JLabel()) ;
		}
		panneauJoueur.add(panneauJeton) ;

		panneau.add(panneauJoueur,BorderLayout.NORTH) ;
		dPan = new JPanel() ;
		dPan.setLayout(new GridLayout(taille+1,taille)) ;
		jBout = new JButton[taille] ;
		iconeFleche = new ImageIcon(path+"fleche.jpg");
		iconeCaseVide = new ImageIcon(path+"vide.jpg");
		iconesJetons = new ImageIcon[3];
		iconesJetons[0] = new ImageIcon(path+"jr.jpg");
		iconesJetons[1] = new ImageIcon(path+"jv.jpg");
		iconesJetons[2] = new ImageIcon(path+"bombe.jpg");
		iconesJetonsAlpha = new ImageIcon[3] ;
		iconesJetonsAlpha[0] = new ImageIcon(path+"jr.png");
		iconesJetonsAlpha[1] = new ImageIcon(path+"jv.png");
		iconesJetonsAlpha[2] = new ImageIcon(path+"bombe.png");
		for (int i=0 ; i<taille ; i=i+1) {
			jBout[i] = new JButton("",iconeFleche) ;
			jBout[i].addActionListener(this) ;
			dPan.add(jBout[i]) ;
		}
		grilleLabels = new JLabel[taille][taille] ;
		for (int i=0 ; i<taille ; i=i+1) {
			for (int j=0 ; j<taille ; j=j+1) {
				grilleLabels[i][j] = new JLabel(iconeCaseVide) ;
				grilleLabels[i][j].setOpaque(true);
				grilleLabels[i][j].setBackground(new Color(40,0,200));
				dPan.add(grilleLabels[i][j]) ;
			}
		}
		panneau.add(dPan,BorderLayout.CENTER) ;
		infos = new JLabel() ;
		Font font = new Font("Arial", Font.BOLD, 18) ;
		infos.setFont(font);
		infos.setForeground(Color.BLACK);
		infos.setHorizontalAlignment(SwingConstants.CENTER);
		infos.setVerticalAlignment(SwingConstants.CENTER);
		panneau.add(infos,BorderLayout.SOUTH) ;
		this.setContentPane(panneau);
		this.addWindowListener(this) ;
		this.setVisible(true);
	}

	public void afficherJetonSuivant(int couleur) {
		//System.out.println("Jeton à afficher : "+couleur) ;
		jeton.setIcon(iconesJetonsAlpha[couleur-1]) ;
		redessiner();
	}

	public void afficherInformations(String texte) {
		infos.setText(texte);
		redessiner() ;
	}
	
	public void actualiserGrille() {
		for (int i=0 ; i<taille ; i++) {
			for (int j=0 ; j<taille ; j++) {
				if (grille.table[i][j]==0)
					grilleLabels[taille-1-i][j].setIcon(iconeCaseVide) ;
				else
					grilleLabels[taille-1-i][j].setIcon(iconesJetons[grille.table[i][j]-1]);
			}
		}
		redessiner() ;
	}
	
	/**
	 * Renvoie la colonne choisie par le joueur
	 * @return le numero de colonne
	 */
	public int cliquerColonne() {
		return coupSuivant();
	}
	
	private void redessiner() {
		panneau.invalidate();
		panneau.repaint();
	}

	private int coupSuivant() {
		synchronized (coupQueue) {
			while (coupQueue.isEmpty())
				try {
					coupQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			return coupQueue.remove();
		}
	}

	private void addCoup(int coup) {
		synchronized (coupQueue) {
			coupQueue.add(coup);
			if (listener != null)
				coupQueue.notifyAll();
		}
	}

	private int getBout(JButton b) {
		int i=0 ;
		while ((i<taille)&&(jBout[i]!=b)) {
			i=i+1 ;
		}
		return i ;
	}

	private int getCouleur() {
		/*
		for (int i=0 ; i<boutonsChoix.length ; i++) {
			if (boutonsChoix[i].isSelected())
				return i+1 ;
		}*/
		return 0 ;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			JButton jb = (JButton) e.getSource() ;
			addCoup(getBout(jb)) ;
		}
	}

	public void windowActivated(WindowEvent e) {}

	public void windowClosed(WindowEvent e) {}

	public void windowClosing(WindowEvent e) {
		e.getWindow().dispose();
		System.exit(0);
	}

	public void windowDeactivated(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowOpened(WindowEvent e) {}

}