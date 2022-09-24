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
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class FenetrePendu extends JFrame implements ActionListener{
	
	private JPanel cadrePrincipal, cadreInfo, cadreMot, saisieLettre, lesLettres, cadrePotence;
	private JLabel  information, imagePendu, mot, lettresLues;
	private JButton lire;
	private JTextField lettre;
	private ImageIcon[] iconesPendus;
	private ImageIcon enter;
	private Queue<Character> listeLettres = new LinkedList<Character>();
	private Thread listener;


	private String path = "./Semaine 9/Images/";
	
	public FenetrePendu(){
		
		listener = Thread.currentThread();
		
		this.setTitle("Jeu du pendu");
		this.setSize(400, 400);
		this.setLocation(30, 30);
		this.setLocationRelativeTo(null);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 		
		
		
		Font fontInfo = new Font("Arial", Font.BOLD, 14);
		Font fontLettre = new Font("Arial", Font.BOLD, 18);
		
		iconesPendus = new ImageIcon[7];
		iconesPendus[0]= new ImageIcon(path+"pendu0.png");
		iconesPendus[1]= new ImageIcon(path+"pendu1.png");
		iconesPendus[2]= new ImageIcon(path+"pendu2.png");
		iconesPendus[3]= new ImageIcon(path+"pendu3.png");
		iconesPendus[4]= new ImageIcon(path+"pendu4.png");
		iconesPendus[5]= new ImageIcon(path+"pendu5.png");
		iconesPendus[6]= new ImageIcon(path+"pendu6.png");
		
		enter = new ImageIcon(path+"enterP.png");
		
		
		
		cadrePrincipal = new JPanel(new BorderLayout());
		
		
		
		cadreInfo = new JPanel(new GridLayout(3,1));
		cadreInfo.add(new JLabel(" "));
		
		information = new JLabel(" ");
		information.setFont(fontInfo);
		information.setHorizontalAlignment(SwingConstants.CENTER);
		information.setVerticalAlignment(SwingConstants.CENTER);
		cadreInfo.add(information);
		cadreInfo.add(new JLabel(" "));
		cadrePrincipal.add(cadreInfo, BorderLayout.SOUTH);
		
		
		cadreMot = new JPanel(new GridLayout(3,1));
		cadreMot.add(new JLabel(""));
			
		// La lettre
		
		lesLettres = new JPanel();
		lesLettres.setLayout(new BorderLayout());
		saisieLettre = new JPanel();
		saisieLettre.setLayout(new FlowLayout());
		lettre = new JTextField();
		lettre.setColumns(1);
		lettre.setFont(fontLettre);
		saisieLettre.add(lettre);
		lire = new JButton(enter);	
		lire.addActionListener(this);
		saisieLettre.add(lire);
		lesLettres.add(saisieLettre, BorderLayout.NORTH);
		lettresLues = new JLabel("");
		lettresLues.setFont(fontInfo);
		lettresLues.setHorizontalAlignment(SwingConstants.CENTER);
		lettresLues.setVerticalAlignment(SwingConstants.CENTER);
		lesLettres.add(lettresLues, BorderLayout.CENTER);
		cadreMot.add(lesLettres);
			
		mot = new JLabel(" ");
		mot.setFont(fontLettre);
		
		cadreMot.add(mot);
		
		cadrePrincipal.add(cadreMot,BorderLayout.CENTER);
		
		
		// Le pendu
		
		cadrePotence = new JPanel();
		cadrePotence.setLayout(new BorderLayout());
		imagePendu = new JLabel(iconesPendus[0]);
		cadrePotence.add(imagePendu,BorderLayout.CENTER);
		
		cadrePrincipal.add(cadrePotence, BorderLayout.WEST);
		
		setContentPane(cadrePrincipal);
		this.setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String lettreRecue = lettre.getText();
		if(!lettreRecue.equals("")){
			ajouterListeLettres(lettreRecue.charAt(0));
		    lettre.setText("");
		    lettre.requestFocus();
		}
		cadrePrincipal.invalidate();
		cadrePrincipal.repaint();
		
	}
	

	private char lireLettreSuivante() {
		synchronized (listeLettres) {
			while (listeLettres.isEmpty()){
				
				try {
					listeLettres.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return listeLettres.remove();

		}
	}
	
	private void ajouterListeLettres(char lettre) {
		synchronized (listeLettres) {
			listeLettres.add(lettre);
			if (listener != null)
				listeLettres.notifyAll();
		}
	}
	
	
	
	public char lireLettre() {
		return lireLettreSuivante();
	}
		
	public void afficherPendu(int nombreMorceaux){
		imagePendu.setIcon(iconesPendus[nombreMorceaux]);
		cadrePrincipal.invalidate();
		cadrePrincipal.repaint();
	}	
	
	public void afficherInformation(String texte) {
		information.setText(" "+texte);
	}

	public void afficherMot(String texte) {
		mot.setText(" "+texte);
	}
	
	public void afficherLettresLues(String texte){
		lettresLues.setText(" "+texte);
	}

}
