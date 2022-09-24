
public class TestEquipe {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur message a afficher en cas de probleme
	 * @param attendu la valeur qu'on s'attendait a recevoir
	 * @param recu la valeur qu'on a recu en realite
	 */
	
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu==null) {
			if (recu!=null) {
				System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
				System.exit(0);
				
			}
		} else if (!attendu.equals(recu)) {
			System.out.println(messageErreur+". Attendu="+attendu+" recu="+recu);
			System.exit(0);		
		}
	}
	
	public static void main(String[] args) {
		int choix;
		System.out.println("**************************************");
		System.out.println("Programme Test pour la classe Equipe :");
		System.out.println("**************************************");
		System.out.println();
		do {
			System.out.println("1 -> Tester la methode 'selectionnerCandidat()'");
			System.out.println("2 -> Tester la methode 'remettreEnJeu(Candidat candidat)'");
			System.out.println("3 -> Tester la methode 'candidatsEnjeu()'");
			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					testerSelectionnerCandidat();
					break;
				case 2:
					testerRemettreEnJeu();
					break;
				case 3:
					testerCandidatsEnJeu();
					break;
			}
		} while (choix >= 1 && choix <= 3);
		System.out.println("Fin des tests");
	}

	private static void testerSelectionnerCandidat() {
		//Test1
		System.out.println("Test1");
		System.out.println("Au depart, les 6 candidats en jeu sont : nom1 \tnom2 \tnom3 \tnom4 \tnom5 \tnom6");
		System.out.println("Le candidat a selectionner est nom1");
		System.out.println("Apres selection, Il reste 5 candidats en jeu : nom2 \tnom3 \tnom4 \tnom5 \tnom6");
		try{
			Candidat[] candidats = new Candidat[6];
			for (int i = 0; i < candidats.length; i++) {
				candidats[i] = new Candidat("nom"+(i+1));
			}
			Equipe equipe = new Equipe(1, candidats);
			assertEquals("Test1 ko, candidat ko","nom1",equipe.selectionnerCandidat().getNom());
			assertEquals("Test1 ko, apres selection, le nombre de candidats est ko",5, equipe.getNombreCandidats());
			assertEquals("Test1 ko, apres selection, les candidats en jeu sont ko"," nom2 nom3 nom4 nom5 nom6", equipe.toString());
			System.out.println("Test1 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test1 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test2
		System.out.println("Test2");
		System.out.println("En cours de jeu, le nombre de candidats diminue ");
		System.out.println("Pour le test2, il reste 3 candidats en jeu : nom5 nom1 nom2 ");
		System.out.println("Le candidat a selectionner est nom5");
		System.out.println("Apres selection, Il reste 2 candidats en jeu : nom1 nom2");
		try{
			Candidat[] candidats = new Candidat[6];
			candidats[0] = new Candidat("nom5");
			candidats[1] = new Candidat("nom1");
			candidats[2] = new Candidat("nom2");
			for (int i = 3; i < 6; i++) {
				candidats[i] = new Candidat("nomBidon");
			}
			Equipe equipe = new Equipe(1, candidats,3);
			assertEquals("Test2 ko, candidat ko","nom5",equipe.selectionnerCandidat().getNom());
			assertEquals("Test2 ko, apres selection, le nombre de candidats est ko",2, equipe.getNombreCandidats());
			assertEquals("Test2 ko, apres selection, les candidats restants sont ko"," nom1 nom2", equipe.toString());
			System.out.println("Test2 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test2 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test3
		System.out.println("Test3");
		System.out.println("Il n'y a plus de candidat en jeu");
		System.out.println("On ne peut donc plus en selectionner");

		try{
			Candidat[] candidats = new Candidat[6];
			for (int i = 0; i < 6; i++) {
				candidats[i] = new Candidat("nomBidon");
			}
			Equipe equipe = new Equipe(1, candidats,0);
			assertEquals("Test1 ko, candidat ko",null,equipe.selectionnerCandidat());
			assertEquals("Test3 ko, apres selection, le nombre de candidats est ko",0, equipe.getNombreCandidats());
			System.out.println("Test3 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test3 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi");
		System.out.println();
	}

	private static void testerRemettreEnJeu() {
		//Test3
		System.out.println("Test1");
		System.out.println("Au depart, les 6 candidats en jeu sont : nom1 \tnom2 \tnom3 \tnom4 \tnom5 \tnom6");
		System.out.println("Il est donc impossible de remettre en jeu un candidat !");
		try{
			Candidat[] candidats = new Candidat[6];
			for (int i = 0; i < candidats.length; i++) {
				candidats[i] = new Candidat("nom"+(i+1));
			}
			Equipe equipe = new Equipe(1, candidats);
			assertEquals("Test1 ko, booleen renvoye est ko" ,false,equipe.remettreEnJeu(new Candidat("nom7")) );
			assertEquals("Test1 ko, apres remise en jeu, le nombre de candidats est ko",6, equipe.getNombreCandidats());
			System.out.println("Test1 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test1 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test2
		System.out.println("Test2");
		System.out.println("En cours de jeu, le nombre de candidats diminue ");
		System.out.println("Pour le test2, il reste 3 candidats en jeu : nom5 \tnom1 \tnom2 ");
		System.out.println("On peut remettre le candidat nom4 en jeu !");
		System.out.println("Apres remise en jeu, Il y aura 4 candidats en jeu : nom5 \tnom1 \tnom2 \tnom4");
		try{
			Candidat[] candidats = new Candidat[6];
			candidats[0] = new Candidat("nom5");
			candidats[1] = new Candidat( "nom1");
			candidats[2] = new Candidat( "nom2");
			for (int i = 3; i < 6; i++) {
				candidats[i] = new Candidat("nomBidon");
			}
			Equipe equipe = new Equipe(1, candidats,3);
			assertEquals("Test2 ko, booleen renvoye est ko" ,true,equipe.remettreEnJeu(new Candidat("nom4")) );
			assertEquals("Test2 ko, apres remise en jeu, le nombre de candidats est ko",4, equipe.getNombreCandidats());
			assertEquals("Test2 ko, apres remise en jeu, les candidats en jeu sont ko"," nom5 nom1 nom2 nom4", equipe.toString());
			System.out.println("Test2 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test2 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test3
		System.out.println("Test3");
		System.out.println("Il n'y a plus de candidat en jeu");
		System.out.println("On peut remettre le candidat nom2 en jeu !");
		System.out.println("Apres remise en jeu, Il y aura 1 candidat en jeu : nom2");
		try{
			Candidat[] candidats = new Candidat[6];
			for (int i = 0; i < 6; i++) {
				candidats[i] = new Candidat("nomBidon");
			}
			Equipe equipe = new Equipe(1, candidats,0);
			assertEquals("Test3 ko, booleen renvoye est ko" ,true,equipe.remettreEnJeu(new Candidat("nom3")) );
			assertEquals("Test3 ko, apres remise en jeu, le nombre de candidats est ko",1, equipe.getNombreCandidats());
			assertEquals("Test3 ko, apres remise en jeu, le candidat en jeu est ko"," nom3", equipe.toString());
			System.out.println("Test3 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test3 ko : il y a eu une exception non prevue");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi");
		System.out.println();

	}

	private static void testerCandidatsEnJeu() {
		//Test1
		System.out.println("Test1");
		System.out.println("Au depart, les 6 candidats en jeu sont : nom1 \tnom2 \tnom3 \tnom4 \tnom5 \tnom6");
		try{
			Candidat[] candidats = new Candidat[6];
			for (int i = 0; i < candidats.length; i++) {
				candidats[i] = new Candidat("nom"+(i+1));
			}
			Equipe equipe = new Equipe(1, candidats);
			Candidat[] tableCandidatsEnJeu = equipe.candidatsEnjeu();
			if(tableCandidatsEnJeu==null){
				System.out.println("Test1 ko, table renvoyee est null");
				System.exit(0);
			}
			assertEquals("Test1 ko, taille table renvoyee ko" ,6, tableCandidatsEnJeu.length);
			assertEquals("Test1 ko, contenu table renvoyee ko, a l'indice 0" ,"nom1", tableCandidatsEnJeu[0].getNom());
			assertEquals("Test1 ko, contenu table renvoyee ko, a l'indice 1" ,"nom2", tableCandidatsEnJeu[1].getNom());
			assertEquals("Test1 ko, contenu table renvoyee ko, a l'indice 2" ,"nom3", tableCandidatsEnJeu[2].getNom());
			assertEquals("Test1 ko, contenu table renvoyee ko, a l'indice 3" ,"nom4", tableCandidatsEnJeu[3].getNom());
			assertEquals("Test1 ko, contenu table renvoyee ko, a l'indice 4" ,"nom5", tableCandidatsEnJeu[4].getNom());
			assertEquals("Test1 ko, contenu table renvoyee ko, a l'indice 5" ,"nom6", tableCandidatsEnJeu[5].getNom());
			System.out.println("Test1 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test1 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test2
		System.out.println("Test2");
		System.out.println("En cours de jeu, le nombre de candidats diminue ");
		System.out.println("Pour le test2, il reste 3 candidats en jeu : nom5 \tnom1 \tnom2 ");
		try{
			Candidat[] candidats = new Candidat[6];
			candidats[0] = new Candidat("nom5");
			candidats[1] = new Candidat("nom1");
			candidats[2] = new Candidat("nom2");
			for (int i = 3; i < 6; i++) {
				candidats[i] = new Candidat("nomBidon");
			}
			Equipe equipe = new Equipe(1, candidats,3);
			Candidat[] tableCandidatsEnJeu = equipe.candidatsEnjeu();
			if(tableCandidatsEnJeu==null){
				System.out.println("Test2 ko, table renvoyee est null");
				System.exit(0);
			}
			assertEquals("Test2 ko, taille table renvoyee ko" ,3, tableCandidatsEnJeu.length);
			assertEquals("Test2 ko, contenu table renvoyee ko, a l'indice 0" ,"nom5", tableCandidatsEnJeu[0].getNom());
			assertEquals("Test2 ko, contenu table renvoyee ko, a l'indice 1" ,"nom1", tableCandidatsEnJeu[1].getNom());
			assertEquals("Test2 ko, contenu table renvoyee ko, a l'indice 2" ,"nom2", tableCandidatsEnJeu[2].getNom());
			System.out.println("Test2 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test2 ko : il y a eu une exception non prevue");
			System.exit(0);
		}

		//Test3
		System.out.println("Test3");
		System.out.println("Il n'y a plus de candidat en jeu");
		try{
			Candidat[] candidats = new Candidat[6];
			for (int i = 0; i < 6; i++) {
				candidats[i] = new Candidat("nomBidon");
			}
			Equipe equipe = new Equipe(1, candidats,0);
			Candidat[] tableCandidatsEnJeu = equipe.candidatsEnjeu();
			if(tableCandidatsEnJeu==null){
				System.out.println("Test3 ko, table renvoyee est null");
				System.exit(0);
			}
			assertEquals("Test3 ko, taille table renvoyee ko" ,0, tableCandidatsEnJeu.length);
			System.out.println("Test3 ok");
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Test3 ko : il y a eu une exception non prevue");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi");
		System.out.println();

	}

}
