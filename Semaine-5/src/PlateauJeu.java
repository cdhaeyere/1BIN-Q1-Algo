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


public class PlateauJeu  extends JFrame implements ActionListener{
		
		private JPanel principal, cadreHaut, cadreBas, cadreMilieu, de, cadreEnter;
		private JPanel[] num;
		private JLabel[] cases;
		private JLabel informationEnHaut, faceDe;
		private JButton jouerDe,enter;	
		private ImageIcon[] fDe;
		private ImageIcon[] numCase;
		private ImageIcon indi, lara, bombe, cobra, poison;
		private Queue<Boolean> listeEnter = new LinkedList<Boolean>();
		private Queue<Integer> listeLancersDes = new LinkedList<Integer>();
		private Thread listener;
		private int numeroCaseLara=-1, numeroCaseIndi=-1, numeroCaseCobra=-1, numeroCasePoison=-1;

		private String path = "./Semaine5-Projet/Images/";
		
		public PlateauJeu(){
			
			listener = Thread.currentThread();
			
			this.setTitle("Chasse au trésor");
			this.setSize(600, 700);
			this.setLocation(30, 30);
			this.setLocationRelativeTo(null);

			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
			
			principal = new JPanel();
			
			principal = new JPanel();
			principal.setLayout(new BorderLayout());
			
			Font font = new Font("Arial", Font.BOLD, 16);
		
			
			fDe = new ImageIcon[6];
			fDe[0]= new ImageIcon(path +"un.png");
			fDe[1]= new ImageIcon(path+"deux.png");
			fDe[2]= new ImageIcon(path+"trois.png");
			fDe[3]= new ImageIcon(path+"quatre.png");
			fDe[4]= new ImageIcon(path+"cinq.png");
			fDe[5]= new ImageIcon(path+"six.png");
			
			
			numCase = new ImageIcon[16];
			numCase[0] = new ImageIcon(path+"tresor.png");
			numCase[1] = new ImageIcon(path+"num1.png");
			numCase[2] = new ImageIcon(path+"num2.png");
			numCase[3] = new ImageIcon(path+"num3.png");
			numCase[4] = new ImageIcon(path+"num4.png");
			numCase[5] = new ImageIcon(path+"num5.png");
			numCase[6] = new ImageIcon(path+"num6.png");
			numCase[7] = new ImageIcon(path+"num7.png");
			numCase[8] = new ImageIcon(path+"num8.png");
			numCase[9] = new ImageIcon(path+"num9.png");
			numCase[10] = new ImageIcon(path+"num10.png");
			numCase[11] = new ImageIcon(path+"num11.png");
			numCase[12] = new ImageIcon(path+"num12.png");
			numCase[13] = new ImageIcon(path+"num13.png");
			numCase[14] = new ImageIcon(path+"num14.png");
			numCase[15] = new ImageIcon(path+"num15.png");
			
			indi = new ImageIcon(path+"indi.png");
			lara = new ImageIcon(path+"lara.png");
			bombe = new ImageIcon(path+"bombe.png");
			cobra = new ImageIcon(path+"cobra.png");
			poison = new ImageIcon(path+"poison.png");
			
			//cadreHaut (information)
			
			cadreHaut = new JPanel(new GridLayout(3,1));
			cadreHaut.add(new JLabel(" "));
			informationEnHaut = new JLabel(" ");
			informationEnHaut.setFont(font);
			informationEnHaut.setHorizontalAlignment(SwingConstants.CENTER);
			informationEnHaut.setVerticalAlignment(SwingConstants.CENTER);
			cadreHaut.add(informationEnHaut);
			cadreHaut.add(new JLabel(" "));
			principal.add(cadreHaut, BorderLayout.NORTH);
			
			
			
			
			//cadreBas (bouton suivant)
			
			cadreBas = new JPanel(new GridLayout(3,1));
			cadreBas.add(new JLabel(" "));
			
			// Le enter
			
			
			cadreEnter = new JPanel(new GridLayout(1,3));
			
			cadreEnter.add(new JLabel(" "));
			enter = new JButton("suivant");
			enter.addActionListener(this);
			cadreEnter.add(enter);
			cadreEnter.add(new JLabel(" "));			
		//	cadreBas.add(cadreEnter);		
			
			cadreBas.add(new JLabel(" "));
			principal.add(cadreBas, BorderLayout.SOUTH);
			
			
			//cadreMilieu (damier + de)			
			cadreMilieu = new JPanel(new GridLayout(5,5));
			
			
			// Les cases
			
			cases = new JLabel[16];
			for (int i = 0; i < cases.length; i++) {
				cases[i]=new JLabel();
				cases[i].setIcon(numCase[i]);
			}
			
			
			// Le de
			
			de = new JPanel();
			de.setLayout(new FlowLayout());
			faceDe = new JLabel(""); 
			faceDe.setIcon(fDe[0]);
			de.add(faceDe);
			jouerDe = new JButton("lancer");
			jouerDe.addActionListener(this);
			de.add(jouerDe);
		
		
			for (int i = 0; i < 5; i++) {
				cadreMilieu.add(cases[i]);
			}
			
			cadreMilieu.add(cases[15]);
			for (int i = 0; i < 3; i++) {
				cadreMilieu.add(new JLabel(" "));
			}
			cadreMilieu.add(cases[5]);
			
			cadreMilieu.add(cases[14]);

			cadreMilieu.add(new JLabel(" "));
			cadreMilieu.add(de);
			cadreMilieu.add(new JLabel(" "));

			cadreMilieu.add(cases[6]);
			cadreMilieu.add(cases[13]);
			for (int i = 0; i < 3; i++) {
				cadreMilieu.add(new JLabel(" "));
			}
			cadreMilieu.add(cases[7]);
			for (int i = 0; i < 5; i++) {
				cadreMilieu.add(cases[12-i]);
			}
			
					
			principal.add(cadreMilieu, BorderLayout.CENTER);
			
			
			setContentPane(principal);
			this.setVisible(true);		
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==jouerDe){
				int resultatDe = unEntierAuHasardEntre(1,6);
				faceDe.setIcon(fDe[resultatDe-1]);	
				ajouterListeLancerDe(resultatDe);
				principal.invalidate();
				principal.repaint();
			}else{
				ajouterListeEnter();
			}
		
		}
		
		private static int unEntierAuHasardEntre (int valeurMinimale, int valeurMaximale){
			double nombreReel;
			int resultat;

			nombreReel = Math.random();
			resultat = (int) (nombreReel * (valeurMaximale - valeurMinimale + 1)) + valeurMinimale;
			return resultat;
		}
		
		private int lancerDeSuivant() {
			synchronized (listeLancersDes) {
				while (listeLancersDes.isEmpty()){
					
					try {
						listeLancersDes.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//System.out.println("ici cccc");
				return listeLancersDes.remove();

			}
		}
		
		private void ajouterListeLancerDe(int resultatDe) {
			synchronized (listeLancersDes) {

				listeLancersDes.add(resultatDe);
				if (listener != null)
					listeLancersDes.notifyAll();
			}
		}
		
		
		
		public int lancerDe() {
			int de = lancerDeSuivant();
			listeEnter = new LinkedList<Boolean>();
			return de;
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
		
		public void suivant() {
			continuerSuivant();
			listeLancersDes = new LinkedList<Integer>();
		}
				
		private void afficherBug(){
			for (int i = 0; i < cases.length; i++) {
				cases[i].setIcon(bombe);			
			}
			informationEnHaut.setText("!!!!!!!!!!!BUG!!!!!!!!!!!");
			principal.invalidate();
			principal.repaint();		
		}
		
		public void placerIndi(int numeroCase){
			
			if(numeroCase<=0||numeroCase>16){
				afficherBug();
			}else{
				if(numeroCase==16)
					numeroCase = 0;
				cases[numeroCase].setIcon(indi);
				numeroCaseIndi=numeroCase;
				principal.invalidate();
				principal.repaint();
			}
		}
		
		public void supprimerIndi(){
			if(numeroCaseIndi!=-1){
				cases[numeroCaseIndi].setIcon(numCase[numeroCaseIndi]);
				numeroCaseIndi=-1;
			}
			principal.invalidate();
			principal.repaint();
		}
		
		public void deplacerIndi(int numeroCase){
			supprimerIndi();
			placerIndi(numeroCase);
		}

	
		public void placerLara(int numeroCase){
			if(numeroCase<=0||numeroCase>16){
				afficherBug();
			}else{
				if(numeroCase==16)
					numeroCase = 0;
				cases[numeroCase].setIcon(lara);
				numeroCaseLara=numeroCase;
				principal.invalidate();
				principal.repaint();
			}
		}
		
		public void supprimerLara(){
			if(numeroCaseLara!=-1){
				cases[numeroCaseLara].setIcon(numCase[numeroCaseLara]);
				numeroCaseLara=-1;
			}
			principal.invalidate();
			principal.repaint();
		}
		
		public void deplacerLara(int numeroCase){
			supprimerLara();
			placerLara(numeroCase);
		}
		
		public void placerCobra(int numeroCase){
			if(numeroCase<=0||numeroCase>16){
				afficherBug();
			}else{
				if(numeroCase==16)
					numeroCase = 0;
				cases[numeroCase].setIcon(cobra);
				numeroCaseCobra=numeroCase;
				principal.invalidate();
				principal.repaint();
			}
		}
		
		public void supprimerCobra(){
			if(numeroCaseCobra!=-1){
				cases[numeroCaseCobra].setIcon(numCase[numeroCaseCobra]);
				numeroCaseCobra=-1;
			}
			principal.invalidate();
			principal.repaint();
		}

		public void placerElixir(int numeroCase){
			if(numeroCase<=0||numeroCase>16){
				afficherBug();
			}else{
				if(numeroCase==16)
					numeroCase = 0;
				cases[numeroCase].setIcon(poison);
				numeroCasePoison=numeroCase;
				principal.invalidate();
				principal.repaint();
			}
		}
		
		public void supprimerElixir(){
			if(numeroCasePoison!=-1){
				cases[numeroCasePoison].setIcon(numCase[numeroCasePoison]);
				numeroCasePoison=-1;
			}
			principal.invalidate();
			principal.repaint();
		}

		public void afficherInformation(String texte) {
			informationEnHaut.setText(texte);
		}
}
