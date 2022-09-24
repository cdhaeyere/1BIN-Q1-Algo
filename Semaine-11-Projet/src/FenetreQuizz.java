import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class FenetreQuizz extends JFrame implements ActionListener{
	
	private JPanel principal, zoneJeu, bordHaut, bordBas, zoneJoueur, cadreMilieu, buzzer, zoneClassement, cadreEnter;
	
	private JLabel information, question, imageJoueur, resultatJoueur;
	
	JLabel[] zonesF, zonesH;

	private ImageIcon[] imagesS;
	private ImageIcon[] imagesL;
	private ImageIcon imageP , pouceOK , pouceKO, pointInterrogation, go;

	private String path = "./Semaine 11-Projet/images/";
	

	
	private JButton choix1, choix2, choix3, suivant;	
	private Queue<Integer> listeChoix = new LinkedList<Integer>();
	private Queue<Boolean> listeEnter = new LinkedList<Boolean>();
	private Thread listener;

	
	
	public FenetreQuizz(String titre){
		
		listener = Thread.currentThread();
		
		this.setTitle(titre);
		this.setSize(800, 700);
		this.setLocation(30, 30);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		Font font14 = new Font("Arial", Font.BOLD, 14);
	
		Font font20 = new Font("Arial", Font.BOLD, 20);
		
		
		imagesS = new ImageIcon[12];
		
		for (int i = 0; i < 6; i++) {
			imagesS[i] = new ImageIcon(path+"F"+(i+1)+"S.png");
			
		}
		for (int i = 6; i < 12; i++) {
			imagesS[i] = new ImageIcon(path+"M"+(i+1-6)+"S.png");
		
		}

		imagesL = new ImageIcon[12];

		for (int i = 0; i < 6; i++) {
			imagesL[i] = new ImageIcon(path+"F"+(i+1)+"L.png");
			
		}
		for (int i = 6; i < 12; i++) {
			imagesL[i] = new ImageIcon(path+"M"+(i+1-6)+"L.png");
			
		}
		
		imageP = new ImageIcon(path+"P.png");
		
		pouceOK = new ImageIcon(path+"pouceLeve.png");
		pouceKO = new ImageIcon(path+"pouceBaisse.png");
		pointInterrogation = new ImageIcon(path+"pointInterrogation.png");
		go = new ImageIcon(path+"go.png");
		
		
		bordHaut = new JPanel(new GridLayout(5,1));
		bordHaut.add(new JLabel(" "));
		bordHaut.add(new JLabel(" "));
			
		
		bordBas = new JPanel(new GridLayout(8,1));
		bordBas.add(new JLabel(" "));
		bordBas.add(new JLabel(" "));
		
		information = new JLabel(" ");
		information.setFont(font14);
		information.setHorizontalAlignment(SwingConstants.CENTER);
		information.setVerticalAlignment(SwingConstants.CENTER);
		bordBas.add(information);
		bordBas.add(new JLabel(" "));
		bordBas.add(new JLabel(" "));
		
		
		// zoneJoueur - image du joueur + resultatQuestion + joueur suivant
		
		zoneJoueur = new JPanel();
		zoneJoueur.setLayout(new BorderLayout());
		
		// zoneJoueur - image du joueur
		
	    imageJoueur = new JLabel(imageP);
		zoneJoueur.add(imageJoueur,BorderLayout.NORTH);
		
		// zoneJoueur - resultatQuestion
		
		resultatJoueur = new JLabel(go);
		zoneJoueur.add(resultatJoueur,BorderLayout.CENTER);
		
		// zoneJoueur - joueur suivant
		
		cadreEnter = new JPanel(new GridLayout(1,5));
		cadreEnter.add(new JLabel(" "));
		cadreEnter.add(new JLabel(" "));
		suivant = new JButton(new ImageIcon(path+"enterP.png"));
		suivant.addActionListener(this);
		cadreEnter.add(suivant);
		cadreEnter.add(new JLabel(" "));
		cadreEnter.add(new JLabel(" "));
		
		zoneJoueur.add(cadreEnter,BorderLayout.SOUTH);
		
		
		// zoneJeu la question + les choix
		
		zoneJeu = new JPanel(new BorderLayout());
		
		zoneJeu.add(new JLabel(" "));
		
		cadreMilieu = new JPanel(new GridLayout(5,1));
		
		// La question
		
		question = new JLabel("Question");
		question.setFont(font20);
		question.setHorizontalAlignment(SwingConstants.CENTER);
		question.setVerticalAlignment(SwingConstants.CENTER);
		cadreMilieu.add(question);
		
		
		// Les choix
		
		buzzer = new JPanel();
		buzzer.setLayout(new GridLayout(5,1));

		choix1 = new JButton("Proposition1");
		choix1.addActionListener(this);
		buzzer.add(choix1);
		choix2 = new JButton("Proposition2");
		choix2.addActionListener(this);
		buzzer.add(choix2);
		choix3 = new JButton("Proposition3");
		choix3.addActionListener(this);
		buzzer.add(choix3);
		cadreMilieu.add(buzzer);
		
		zoneJeu.add(new JLabel(" "),BorderLayout.NORTH);
		zoneJeu.add(cadreMilieu,BorderLayout.CENTER);	
	
		
		
		zoneClassement = new JPanel();
		zoneClassement = new JPanel(new GridLayout(6,5));
		
		
		zonesF = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			zonesF[i] = new JLabel(" ");
		}
		
		zonesH = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			zonesH[i] = new JLabel(" ");
		}
				
		for (int i = 0; i <6; i++) {
			zoneClassement.add(new JLabel(" "));			
			zoneClassement.add(zonesF[i]);	
			//	zoneClassement.add(new JLabel(" "));	
			zoneClassement.add(zonesH[i]);
			//zoneClassement.add(new JLabel(" "));	
		
		}
		
		
		principal = new JPanel();
		principal.setLayout((new BorderLayout()));
		
		
		principal.add(bordHaut,BorderLayout.NORTH);
		principal.add(bordBas,BorderLayout.SOUTH);
		principal.add(zoneJoueur,BorderLayout.WEST);
		principal.add(zoneJeu,BorderLayout.CENTER);
		
		principal.add(zoneClassement,BorderLayout.EAST);

		setContentPane(principal);
		this.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==choix1){
			ajouterListeChoix(1);
			zoneJeu.invalidate();
			zoneJeu.repaint();
		}else{
			if(e.getSource()==choix2){
				ajouterListeChoix(2);
				zoneJeu.invalidate();
				zoneJeu.repaint();
			}else{
				if(e.getSource()==choix3){
					ajouterListeChoix(3);
					zoneJeu.invalidate();
					zoneJeu.repaint();
				}else{

					ajouterListeEnter();
				}
			}
		}


	}

	private int donnerChoixSuivant() {
		synchronized (listeChoix) {
			while (listeChoix.isEmpty()){

				try {
					listeChoix.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return listeChoix.remove();

		}
	}

	private void ajouterListeChoix(int choix) {
		synchronized (listeChoix) {

			listeChoix.add(choix);

			if (listener != null){
				listeChoix.notifyAll();
			}
		}
	}


	private void continuerSuivant() {
		synchronized (listeEnter) {
			while (listeEnter.isEmpty()){
				try {
					listeEnter.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			listeEnter.remove();
		}
	}

	private void ajouterListeEnter() {
		synchronized (listeEnter) {

			listeEnter.add(true);

			if (listener != null){
				listeEnter.notifyAll();
			}

		}
	}




	public int cliquerChoix() {
		int choix = donnerChoixSuivant();
		listeEnter = new LinkedList<Boolean>();
		return choix;
	}

	public void cliquerSuivant() {
		continuerSuivant();
		listeChoix = new LinkedList<Integer>();
	}
	
	
	public void afficherCandidat(Candidat candidat){	
		if(candidat==null)
			throw new IllegalArgumentException();
		imageJoueur.setIcon(imagesL[candidat.getNumeroCandidat()-1]);
		resultatJoueur.setIcon(pointInterrogation);	
		zoneJeu.invalidate();
		zoneJeu.repaint();	
	}
	
	public void afficherQuestion(QuestionCM qcm){
		this.question.setText(qcm.getQuestion());
		this.choix1.setText(qcm.getChoix1());
		this.choix2.setText(qcm.getChoix2());
		this.choix3.setText(qcm.getChoix3());
		zoneJeu.invalidate();
		zoneJeu.repaint();	
	}
	
	
//	public void afficherEquipes(Candidat[] candidatsF, Candidat[] candidatsM){
//		
//		if(candidatsF==null)
//			throw new IllegalArgumentException();
//		if(candidatsM==null)
//			throw new IllegalArgumentException();
//		if(candidatsF.length>6)
//			throw new IllegalArgumentException();
//		if(candidatsM.length>6)
//			throw new IllegalArgumentException();
//		
//		for (int i = 0; i < candidatsF.length; i++) {
//			zonesF[i].setIcon(imagesS[candidatsF[i].getNumeroCandidat()-1]);
//		}
//		
//		for (int i = candidatsF.length; i < 6; i++) {
//			zonesF[i].setIcon(new ImageIcon());
//		}
//	
//		for (int i = 0; i < candidatsM.length; i++) {
//			zonesH[i].setIcon(imagesS[candidatsM[i].getNumeroCandidat()-1]);
//		}
//		
//		for (int i = candidatsM.length; i < 6; i++) {
//			zonesH[i].setIcon(new ImageIcon());
//		}
//		
//		zoneClassement.invalidate();
//		zoneClassement.repaint();
//			
//	}
	
	public void afficherEquipe(Equipe equipe){
	
		if(equipe==null)
			return;
		
		Candidat[] candidats = equipe.candidatsEnjeu();

		if(candidats.length>6)
			throw new IllegalArgumentException();

		if(equipe.getNumero()==1){

			for (int i = 0; i < candidats.length; i++) {
				zonesF[i].setIcon(imagesS[candidats[i].getNumeroCandidat()-1]);
			}

			for (int i = candidats.length; i < 6; i++) {
				zonesF[i].setIcon(new ImageIcon());
			}
		}else{


			for (int i = 0; i < candidats.length; i++) {
				zonesH[i].setIcon(imagesS[candidats[i].getNumeroCandidat()-1]);
			}

			for (int i = candidats.length; i < 6; i++) {
				zonesH[i].setIcon(new ImageIcon());
			}
		}
		zoneClassement.invalidate();
		zoneClassement.repaint();

	}

	public void afficherInformation(String texte) {
		information.setText(" "+texte);
	}
	
	public void afficherPouceOK(){
		resultatJoueur.setIcon(pouceOK);
		zoneJoueur.invalidate();
		zoneJoueur.repaint();
	}
	
	public void afficherPouceKO(){
		resultatJoueur.setIcon(pouceKO);
		zoneJoueur.invalidate();
		zoneJoueur.repaint();
	}
	
	/*public void retirerPouce(){
		resultatJoueur.setIcon(pointInterrogation); 
		zoneJoueur.invalidate();
		zoneJoueur.repaint();
	}*/

}
