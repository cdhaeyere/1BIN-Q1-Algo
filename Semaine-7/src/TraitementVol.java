/*
	@author Corentin D'haeyere
 */
public class TraitementVol {
	
	private static Vol vol;

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("\nTraitement d'un vol\n*******************");
		vol = chargerVol();
		if(vol==null){
			System.out.println("vol non charge car inexistant");
			return;
		}
		int choix;
		do{
			System.out.println("\n"
					+ "1) afficher le lieu d arrivee\n"
					+ "2) verifier si le lieu de depart correspond au lieu d arrivee\n"
					+ "3) afficher le lieu survole apres n intervalles de temps\n"
					+ "4) afficher le lieu survole le plus au sud\n"
					+ "5) afficher le lieu survole le plus eloigne du lieu de depart\n"			
					+ "6) verifier si le parapentiste a atteint une cible donnee\n"
					+ "7) afficher le nombre de cibles atteintes\n"
					+ "8) afficher la distance parcourue\n"
					+ "9) verifier si le parapentiste a croise son propre parcours\n"
					+ "10) verifier si le parapentiste a suivi un parcours impose\n");
					
			System.out.print("Votre choix : ");
			choix = scanner.nextInt();

			switch (choix) {
			case 1:
				System.out.println("le lieu d'arrivee : \n"+vol.lieuArrivee());
				break;
			case 2:
				if(vol.estUnTour()){
					System.out.println("le parapentiste est revenu a son point de depart");
				}else{
					System.out.println("le parapentiste n'est pas revenu a son point de depart");
				}
				break;
			case 3:
				afficherNiemeLieu();
				break;
			case 4:
				System.out.println("le lieu le plus au sud : \n"+vol.lieuLePlusAuSud());
				break;
			case 5:
				System.out.println("le lieu le plus eloigne : \n"+vol.lieuLePlusEloigne());
				break;
			case 6:
				verifierCibleAtteinte();
				break;
			case 7:
				afficherNombreCiblesAtteintes();
				break;
			case 8:
				System.out.println("la distance du vol : "+ Math.round(vol.distance()*100)/100.0);
				break;
			case 9:
				if(vol.aSurvoleUnMemeLieu()){
					System.out.println("le parapentiste a croise son propre parcours");
				}else{
					System.out.println("le parapentiste n'a jamais croise son propre parcours");
				}
				break;
			case 10:			
				verifierParcoursSuivi();
				break;
			}

		}while(choix>0&&choix<=10);
	}

	private static void afficherNiemeLieu() {
		System.out.print("Entrez n : ");
		int n = scanner.nextInt();
		Coordonnees niemeCoordonnee = vol.niemeLieu(n);
		if(niemeCoordonnee==null){
			System.out.println("vol trop court");
		}else{
			System.out.println("Apres "+n+ " unites de temps, le lieu survole : \n" + niemeCoordonnee);
		}
	}

	private static void verifierCibleAtteinte() {
		System.out.println("Entrez la cible : ");
		Coordonnees cible = lireCoordonnees();
		if(vol.cibleAtteinte(cible)){
			System.out.println("la cible a ete atteinte");
		}else{
			System.out.println("la cible n'a pas ete atteinte");
		}
	}
	

	private static void afficherNombreCiblesAtteintes() {
		Coordonnees[] cibles = lireTableCoordonnees();
		System.out.println("nombre de cibles atteintes : "+vol.nombreCiblesAtteintes(cibles));	
	}
	
	private static void verifierParcoursSuivi() {
		Coordonnees[] cibles = lireTableCoordonnees();
		if(vol.parcoursSuivi(cibles))
			System.out.println("le parcours a ete suivi");
		else
			System.out.println("le parcours n'a pas ete suivi");
	}
	
	private static Coordonnees[] lireTableCoordonnees(){
		System.out.print("Entrez le nombre de lieux : ");
		int nbrCoordonnees = scanner.nextInt();
		Coordonnees[] tableCoordonnees = new Coordonnees[nbrCoordonnees];
		for (int i = 0; i < tableCoordonnees.length; i++) {
			System.out.println("Coordonnees num "+(i+1));
			tableCoordonnees[i]= lireCoordonnees();
		}
		return tableCoordonnees;
	}
	
	private static Coordonnees lireCoordonnees(){
		System.out.print("Entrez la latitude : ");
		Long latitude = scanner.nextLong();
		System.out.print("Entrez la longitude : ");
		Long longitude = scanner.nextLong();
		return new Coordonnees(latitude, longitude);
	}

	private static Vol chargerVol() {
		System.out.print("Entrez le num du vol : ");
		int numVol = scanner.nextInt();
		Coordonnees[] tableCoordonnees;
		switch (numVol) {
		case 1:
			tableCoordonnees = new Coordonnees[6];
			tableCoordonnees[0]= new Coordonnees(1,1);
			tableCoordonnees[1]= new Coordonnees(2,2);
			tableCoordonnees[2]= new Coordonnees(3,3);
			tableCoordonnees[3]= new Coordonnees(4,4);
			tableCoordonnees[4]= new Coordonnees(5,5);
			tableCoordonnees[5]= new Coordonnees(4,6);	
			return new Vol(tableCoordonnees);
		case 2:
			tableCoordonnees = new Coordonnees[5];
			tableCoordonnees[0]= new Coordonnees(1,1);
			tableCoordonnees[1]= new Coordonnees(2,2);
			tableCoordonnees[2]= new Coordonnees(-1,2);
			tableCoordonnees[3]= new Coordonnees(-2,1);
			tableCoordonnees[4]= new Coordonnees(1,1);	
			return new Vol(tableCoordonnees);
		case 3:	
			tableCoordonnees = new Coordonnees[7];
			tableCoordonnees[0]= new Coordonnees(0,-1);
			tableCoordonnees[1]= new Coordonnees(0,0);
			tableCoordonnees[2]= new Coordonnees(0,1);
			tableCoordonnees[3]= new Coordonnees(-1,0);
			tableCoordonnees[4]= new Coordonnees(-1,1);
			tableCoordonnees[5]= new Coordonnees(0,1);
			tableCoordonnees[6]= new Coordonnees(1,1);
			return new Vol(tableCoordonnees);
		}
		return null;
	
	}
} 
