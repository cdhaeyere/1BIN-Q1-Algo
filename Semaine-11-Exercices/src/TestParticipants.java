/*
	@Author : Corentin D'haeyere
 */
public class TestParticipants {

	public static java.util.Scanner scanner = new java.util.Scanner(System.in);

	/**
	 * Cette methode verifie qu'un resultat attendu est bien un resultat obtenu.
	 * 
	 * @param messageErreur
	 *            message a afficher en cas de probleme
	 * @param attendu
	 *            la valeur qu'on s'attendait a recevoir
	 * @param recu
	 *            la valeur qu'on a recu en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu == null) {
			if (recu != null) {
				System.out.println();
				System.out.println(messageErreur);
				System.out.println("\nAttendu : " + attendu);
				System.out.println("\nRecu : " + recu);
				System.exit(0);
			}
		} else {
			if (attendu instanceof Character && recu instanceof String) {
				attendu = "" + attendu;
			}
			if (attendu instanceof String && recu instanceof Character) {
				recu = "" + recu;
			}
			if (!attendu.equals(recu)) {
				System.out.println();
				System.out.println(messageErreur);
				System.out.println("\nAttendu : " + attendu);
				System.out.println("\nRecu : " + recu);
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {

		int choix;
		System.out.println("Exercices d'algorithmique et Java");
		System.out.println("1ere Informatique IPL");
		System.out.println("********************************************");
		System.out.println("Programme Test pour la classe Participants :");
		System.out.println("********************************************");
		System.out.println();
		do {
			System.out.println("1 -> Tester la methode 'ajouterParticipant(String participant, int index)'");
			System.out.println("2 -> Tester la methode 'ajouterParticipant(String participant)'");
			System.out.println("3 -> Tester la methode 'getIndex(int index)'");
			System.out.println("4 -> Tester la methode 'donnerIndex(String participant)'");
			System.out.println("5 -> Tester la methode 'contient(String participant)'");
			System.out.println("6 -> Tester la methode 'supprimerParticipant(int index)'");
			System.out.println("7 -> Tester la methode 'supprimerParticipant(String participant)'");
			System.out.println("8 -> Tester la methode 'supprimerTousLesParticipants(String participant)'");

			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
				case 1:
					testerAjouterViaIndex();
					break;
				case 2:
					testerAjouterViaNom();
					break;
				case 3:
					testerGetIndex();
					break;
				case 4:
					testerDonnerIndex();
					break;
				case 5:
					testerContient();
					break;
				case 6 :
					testerSupprimerViaIndex();
					break;
				case 7:
					testerSupprimerViaNom();
					break;
				case 8:
					testerSupprimerTous();
					break;
			}
		} while (choix >= 1 && choix <= 8);
		System.out.println("Merci pour votre visite.");
	}




	private static void testerAjouterViaIndex() {
		// test 1 : ajout dans une table vide
		try {
			Participants tP = new Participants(4);
			String[] tSol = {"p1"};
			assertEquals("test 1 a echoue (booleen renvoye)", true, tP.ajouterParticipant(0,"p1"));
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 1 a echoue (nombre inscrits)", tPSol.getNombreInscrits(), tP.getNombreInscrits());
			assertEquals("test 1 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : on peut ajouter un participant a l'index 0 dans une table vide");
			System.out.println("test 1 a echoue : il ne fallait pas lancer d'exception");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 2 : ajout dans une table pleine
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			assertEquals("test 2 a echoue (booleen renvoye)", false, tP.ajouterParticipant(1,"pNv"));
			assertEquals("test 2 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : on peut ajouter un participant a l'index 1 dans une table qui contient au moins 1 participant");
			System.out.println("test 2 a echoue : il ne fallait pas lancer d'exception");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 3 : ajout a l'indice 1 dans une table de taille physique 4 qui contient 1 participant
		try {
			String[] t = { "p1"};
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1","pNv" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 3 a echoue (booleen renvoye)", true, tP.ajouterParticipant(1,"pNv"));
			assertEquals("test 3 a echoue (nombre inscrits)", 2, tP.getNombreInscrits());
			assertEquals("test 3 a echoue (contenu)", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : on peut ajouter un participant a l'indice 1 dans une table qui contient au moins 1 participant");
			System.out.println("test 3 a echoue : il ne fallait pas lancer d'exception");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 4 : ajout a l'indice 0 dans une table de taille physique 4 qui contient 2 participants
		try {
			String[] t = { "p1","p2" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "pNv","p1","p2" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 4 a echoue (booleen renvoye)", true, tP.ajouterParticipant(0,"pNv"));
			assertEquals("test 4 a echoue (nombre inscrits)", 3, tP.getNombreInscrits());
			assertEquals("test 4 a echoue (contenu)", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : on peut ajouter un participant a l'indice 0 dans une table qui contient 2 participants");
			System.out.println("test 4 a echoue : il ne fallait pas lancer d'exception");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 5 : ajout a l'indice 1 dans une table de taille physique 4 qui contient 2 participants
		try {
			String[] t = { "p1","p2" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1","pNv","p2" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 5 a echoue (booleen renvoye)", true, tP.ajouterParticipant(1,"pNv"));
			assertEquals("test 5 a echoue (nombre inscrits)", 3, tP.getNombreInscrits());
			assertEquals("test 5 a echoue (contenu)", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : on peut ajouter un participant a l'indice 1 dans une table qui contient 2 participants");
			System.out.println("test 5 a echoue : il ne fallait pas lancer d'exception");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 6 : ajout a l'indice 2 dans une table de taille physique 8 qui contient 6 participants
		try {
			String[] t = { "p1","p2","p3","p4","p5","p6" };
			Participants tP = new Participants(8, t);
			String[] tSol = { "p1","p2","pNv","p3","p4","p5","p6" };
			Participants tPSol = new Participants(8, tSol);
			assertEquals("test 6 a echoue (booleen renvoye)", true, tP.ajouterParticipant(2,"pNv"));
			assertEquals("test 6 a echoue (nombre inscrits)", 7, tP.getNombreInscrits());
			assertEquals("test 6 a echoue (contenu)", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : on peut ajouter un participant a l'indice 2 dans une table qui contient 6 participants");
			System.out.println("test 6 a echoue : il ne fallait pas lancer d'exception");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		//test 7 : ajout a l'indice 3 dans une table de taille physique 8 qui contient 7 participants
		try {
			String[] t = { "p1","p2","p3","p4","p5","p6","p7" };
			Participants tP = new Participants(8, t);
			String[] tSol = { "p1","p2","p3","pNv","p4","p5","p6","p7" };
			Participants tPSol = new Participants(8, tSol);
			assertEquals("test 7 a echoue (booleen renvoye)", true, tP.ajouterParticipant(3,"pNv"));
			assertEquals("test 7 a echoue (nombre inscrits)", 8, tP.getNombreInscrits());
			assertEquals("test 7 a echoue (contenu)", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("test 7 a echoue : on peut ajouter un participant a l'indice 2 dans une table qui contient 7 participants et prevue pour 8");
			System.out.println("test 7 a echoue : il ne fallait pas lancer d'exception");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 7 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		//test 8 : ajout a l'indice 4 dans une table de taille physique 8 qui contient 3 participants
		try {
			String[] t = { "p1","p2","p3"};
			Participants tP = new Participants(8, t);
			tP.ajouterParticipant(4,"pNv");
			System.out.println("test 8 a echoue : on ne peut pas avoir de trou dans la table");
			System.out.println("Il fallait lancer une IllegalArgumentException");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 8 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}catch (IllegalArgumentException e) {
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 8 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		//test 9 : ajout a l'indice -1 dans une table de taille physique 8 qui contient 3 participants
		try {
			String[] t = { "p1","p2","p3"};
			Participants tP = new Participants(8, t);
			tP.ajouterParticipant(-1,"pNv");
			System.out.println("test 9 a echoue : il n'y a pas d'indice negatif dans une table");
			System.out.println("Il fallait lancer une IllegalArgumentException");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 9 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 9 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi !");
		System.out.println();
	}


	private static void testerAjouterViaNom() {

		// test 1 : ajout dans une table vide
		try {
			Participants tP = new Participants(4);
			String[] tSol = { "p1" };
			assertEquals("test 1 a echoue (booleen renvoye)", true, tP.ajouterParticipant("p1"));
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 1 a echoue (nombre inscrits)", tPSol.getNombreInscrits(), tP.getNombreInscrits());
			assertEquals("test 1 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 2 : ajout dans une table pleine
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			assertEquals("test 2 a echoue (booleen renvoye)", false, tP.ajouterParticipant("p5"));
			assertEquals("test 2 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 3 : ajout dans une table non pleine
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3", "p4" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 3 a echoue (boolean renvoye)", true, tP.ajouterParticipant("p4"));
			assertEquals("test 3 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
			assertEquals("test 3 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (Exception e) {
		    e.printStackTrace();
			System.out.println("test 3 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 4 : ajout dans une table qui contient deja le participant
		// (homonyme accepte!)
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 4 a echoue", true, tP.ajouterParticipant("p3"));
			assertEquals("test 4 a echoue", tPSol.toString(), tP.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : exception inattendue");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}





	private static void testerGetIndex() {
		// test 1 : donner via indice dans une table vide
		try {
			Participants tP = new Participants(4);
			tP.getIndex(0);
			System.out.println("test 1 a echoue : il n'y a pas de participant a l'indice 0 dans une table vide");
			System.out.println("il fallait lancer une IllegalArgumentException");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 2 : recherche participant a l'indice -1 dans une table non pleine qui contient 3 participants
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			tP.getIndex(-1);
			System.out.println("test 2 a echoue : il n'y a pas de participant a l'indice -1");
			System.out.println("il fallait lancer une IllegalArgumentException");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 3 : recherche participant a l'indice 3 dans une table non pleine qui contient 3 participants
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			tP.getIndex(3);
			System.out.println("test 3 a echoue : il n'y a pas de participant a l'indice 3 dans une table qui contient 3 participants");
			System.out.println("il fallait lancer une IllegalArgumentException");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 4 : recherche participant a l'indice 1 dans une table non pleine qui contient 3 participants
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			assertEquals("test 4 a echoue","p2", tP.getIndex(1));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (IllegalArgumentException e) {
			System.out.println("test 4 a echoue : il y a un participant a l'indice 1 dans une table qui contient 3 participants");
			System.out.println("il ne fallait pas lancer une IllegalArgumentException");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 5 : recherche participant a l'indice 2 dans une table non pleine qui contient 3 participants
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			assertEquals("test 5 a echoue","p3", tP.getIndex(2));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (IllegalArgumentException e) {
			System.out.println("test 5 a echoue : il y a un participant a l'indice 2 dans une table qui contient 3 participants");
			System.out.println("il ne fallait pas lancer une IllegalArgumentException");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 6 : recherche participant a l'indice 0 dans une table pleine qui contient 4 participants
		try {
			String[] t = { "p1", "p2", "p3","p4" };
			Participants tP = new Participants(4,t);
			assertEquals("test 6 a echoue","p1", tP.getIndex(0));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (IllegalArgumentException e) {
			System.out.println("test 6 a echoue : il y a un participant a l'indice 0 dans une table qui contient 4 participants");
			System.out.println("il ne fallait pas lancer une IllegalArgumentException");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : exception inattendue!!!");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testerDonnerIndex() {

		// test 1 : donner index d'un participant dans une table vide
		try {
			Participants tP = new Participants(4);
			assertEquals("test 1 a echoue",-1,tP.donnerIndex("pX"));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 2 : donner index d'un participant qui n'appartient pas a la table qui contient 3 participants
		// La table a une taille physique de 4
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			assertEquals("test 2 a echoue",-1,tP.donnerIndex("pX"));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 3 : donner index d'un participant qui n'appartient pas a la table pleine qui contient 3 participants
		// La table a une taille physique de 3
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(3,t);
			assertEquals("test 3 a echoue",-1,tP.donnerIndex("pX"));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 4 : donner index d'un participant qui appartient a la table qui contient 3 participants
		// La table a une taille physique de 4, le participant est le 2eme (indice 1)
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			assertEquals("test 4 a echoue",1,tP.donnerIndex("p2"));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 5 : donner index d'un participant qui appartient a la table pleine qui contient 4 participants
		// La table a une taille physique de 4, le participant est le dernier (indice 3)
		try {
			String[] t = { "p1", "p2", "p3","p4" };
			Participants tP = new Participants(4,t);
			assertEquals("test 5 a echoue",3,tP.donnerIndex("p4"));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 6 : donner index d'un participant qui appartient a la table qui contient 3 participants
		// La table a une taille physique de 6, le participant est le 1er (indice 0)
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(6,t);
			assertEquals("test 6 a echoue",0,tP.donnerIndex("p1"));
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testerContient() {
		// test 1 : contient participant dans une table vide
		try {
			Participants tP = new Participants(4);
			assertEquals("test 1 a echoue",false,tP.contient("pX"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 2 : contient participant qui n'appartient pas a la table qui contient 3 participants
		// La table a une taille physique de 4
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			assertEquals("test 2 a echoue",false,tP.contient("pX"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 3 : contient participant qui n'appartient pas a la table pleine qui contient 3 participants
		// La table a une taille physique de 3
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(3,t);
			assertEquals("test 3 a echoue",false,tP.contient("pX"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 4 : contient un participant qui appartient a la table qui contient 3 participants
		// La table a une taille physique de 4, le participant est le 2eme (indice 1)
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			assertEquals("test 4 a echoue",true,tP.contient("p2"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 5 : contient un participant qui appartient a la table pleine qui contient 5 participants
		// La table a une taille physique de 5, le participant est le dernier
		try {
			String[] t = { "p1", "p2", "p3", "p4", "p5" };
			Participants tP = new Participants(5,t);
			assertEquals("test 5 a echoue",true,tP.contient("p5"));
		}  catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 6 : contient un participant qui appartient a la table qui contient 3 participants
		// La table a une taille physique de 6, le participant est le 1er (indice 0)
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(6,t);
			assertEquals("test 6 a echoue",true,tP.contient("p1"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testerSupprimerViaNom() {
		// test 1 : suppression dans une table vide
		try {
			Participants tP = new Participants(4);
			Participants tPSol = new Participants(4);
			assertEquals("test 1 a echoue (booleen renvoye)", false, tP.supprimerParticipant("p1"));
			assertEquals("test 1 a echoue (nombre inscrits)", 0, tP.getNombreInscrits());
			assertEquals("test 1 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 2 : suppression dans une table non vide et non pleine qui ne
		// contient pas le participant
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 2 a echoue (booleen renoye)", false, tP.supprimerParticipant("p4"));
			assertEquals("test 2 a echoue (nombre inscrits)", 3, tP.getNombreInscrits());
			assertEquals("test 2 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 3 : suppression dans une table non vide et non pleine qui
		// contient le participant
		try {
			String[] t = { "p1", "p2", "p3", "p4", "p5" };
			Participants tP = new Participants(6, t);
			String[] tSol = { "p1", "p3", "p4", "p5" };
			Participants tPSol = new Participants(6, tSol);
			assertEquals("test 3 a echoue (booleen renvoye)", true, tP.supprimerParticipant("p2"));
			assertEquals("test 3 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
			assertEquals("test 3 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 4 : suppression dans une table pleine qui ne contient pas le
		// participant
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3", "p4" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 4 a echoue (booleen renvoye)", false, tP.supprimerParticipant("p5"));
			assertEquals("test 4 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
			assertEquals("test 4 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 5 : suppression dans une table pleine qui contient le
		// participant
		try {
			String[] t = { "p1", "p2", "p3", "p4", "p5" };
			Participants tP = new Participants(5, t);
			String[] tSol = { "p1", "p3", "p4","p5" };
			Participants tPSol = new Participants(5, tSol);
			assertEquals("test 5 a echoue (booleen renvoye)", true, tP.supprimerParticipant("p2"));
			assertEquals("test 5 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
			assertEquals("test 5 a echoue", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 6 : suppression dans une table pleine qui contient le
		// participant en premier lieu
		try {
			String[] t = { "p1", "p2", "p3", "p4","p5" };
			Participants tP = new Participants(5, t);
			String[] tSol = { "p2", "p3", "p4","p5" };
			Participants tPSol = new Participants(5, tSol);
			assertEquals("test 6 a echoue", true, tP.supprimerParticipant("p1"));
			assertEquals("test 6 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
			assertEquals("test 6 a echoue", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 7 : suppression dans une table pleine qui contient le
		// participant en dernier lieu
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 7 a echoue", true, tP.supprimerParticipant("p4"));
			assertEquals("test 7 a echoue (nombre inscrits)", 3, tP.getNombreInscrits());
			assertEquals("test 7 a echoue", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 7 a echoue : exception inattendue");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}


	private static void testerSupprimerTous() {
		// test 1 : suppression dans une table vide
		try {
			Participants tP = new Participants(4);
			Participants tPSol = new Participants(4);
			assertEquals("test 1 a echoue (nombreSupp)", 0, tP.supprimerTousLesParticipants("p1"));
			assertEquals("test 1 a echoue (nombre inscrits)", 0, tP.getNombreInscrits());
			assertEquals("test 1 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 2 : suppression dans une table non vide et non pleine qui ne
		// contient pas le participant
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 2 a echoue (nombreSupp)",0, tP.supprimerTousLesParticipants("p4"));
			assertEquals("test 2 a echoue (nombre inscrits)", 3, tP.getNombreInscrits());
			assertEquals("test 2 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 3 : suppression dans une table non vide et non pleine qui
		// contient 1 x le participant
		try {
			String[] t = { "p1", "p2", "p3", "p4", "p5" };
			Participants tP = new Participants(6, t);
			String[] tSol = { "p1", "p3", "p4", "p5" };
			Participants tPSol = new Participants(6, tSol);
			assertEquals("test 3 a echoue (nombreSupp)", 1, tP.supprimerTousLesParticipants("p2"));
			assertEquals("test 3 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
			assertEquals("test 3 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 4 : suppression dans une table non vide et non pleine qui
		// contient 3 x le participant
		try {
			String[] t = { "p1", "p2", "p1", "p4", "p1" };
			Participants tP = new Participants(6, t);
			String[] tSol = { "p2", "p4"};
			Participants tPSol = new Participants(6, tSol);
			assertEquals("test 4 a echoue (nombre supp renvoye)", 3, tP.supprimerTousLesParticipants("p1"));
			assertEquals("test 4 a echoue (nombre inscrits)", 2, tP.getNombreInscrits());
			assertEquals("test 4 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 5 : suppression dans une table pleine qui
		// contient 2 x le participant
		try {
			String[] t = { "p1", "p2", "p4", "p1" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p2", "p4"};
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 5 a echoue (nombre supp renvoye)", 2, tP.supprimerTousLesParticipants("p1"));
			assertEquals("test 5 a echoue (nombre inscrits)", 2, tP.getNombreInscrits());
			assertEquals("test 5 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 6 : suppression dans une table pleine de 5 participants qui
		// contient 4 x le participant
		try {
			String[] t = { "p1", "p1", "p3", "p1", "p1" };
			Participants tP = new Participants(5, t);
			String[] tSol = { "p3"};
			Participants tPSol = new Participants(5, tSol);
			assertEquals("test 6 a echoue (nombre supp renvoye)", 4, tP.supprimerTousLesParticipants("p1"));
			assertEquals("test 6 a echoue (nombre inscrits)", 1, tP.getNombreInscrits());
			assertEquals("test 6 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : exception inattendue");
			System.exit(0);
		}

		// test 7 : suppression dans une table pleine de 5 participants qui
		// contient 5 x le participant
		try {
			String[] t = { "p1", "p1", "p1", "p1", "p1" };
			Participants tP = new Participants(5, t);
			String[] tSol = { };
			Participants tPSol = new Participants(5, tSol);
			assertEquals("test 7 a echoue (nombre supp renvoye)", 5, tP.supprimerTousLesParticipants("p1"));
			assertEquals("test 7 a echoue (nombre inscrits)", 0, tP.getNombreInscrits());
			assertEquals("test 7 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 7 a echoue : exception inattendue");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void testerSupprimerViaIndex() {
		// test 1 : supprimer via indice dans une table vide
		try {
			Participants tP = new Participants(4);
			tP.supprimerParticipant(0);
			System.out.println("test 1 a echoue : il n'y a pas de participant a l'indice 0 dans une table vide");
			System.out.println("il fallait lancer une IllegalArgumentException");
			System.exit(0);
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 2 : supprime participant a l'indice -1 dans une table non pleine qui contient 3 participants
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			tP.supprimerParticipant(-1);
			System.out.println("test 2 a echoue : il n'y a pas de participant a l'indice -1");
			System.out.println("il fallait lancer une IllegalArgumentException");
			System.exit(0);
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 3 : supprime participant a l'indice 3 dans une table non pleine qui contient 3 participants
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			tP.supprimerParticipant(3);
			System.out.println("test 3 a echoue : il n'y a pas de participant a l'indice 3 dans une table qui contient 3 participants");
			System.out.println("il fallait lancer une IllegalArgumentException");
			System.exit(0);
		} catch (IllegalArgumentException e) {

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 4 : supprime participant a l'indice 1 dans une table non pleine qui contient 5 participants
		try {
			String[] t = { "p1", "p2", "p3", "p4", "p5" };
			Participants tP = new Participants(6,t);
			String[] tSol = { "p1", "p3", "p4", "p5" };
			Participants tPSol = new Participants(6,tSol);
			tP.supprimerParticipant(1);
			assertEquals("test 4 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
			assertEquals("test 4 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (IllegalArgumentException e) {
			System.out.println("test 4 a echoue : il y a un participant a l'indice 1 dans une table qui contient 5 participants");
			System.out.println("il ne fallait pas lancer une IllegalArgumentException");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 5 : supprime participant a l'indice 2 dans une table non pleine qui contient 3 participants
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4,t);
			String[] tSol = { "p1", "p2" };
			Participants tPSol = new Participants(4,tSol);
			tP.supprimerParticipant(2);
			assertEquals("test 5 a echoue (nombre inscrits)", 2, tP.getNombreInscrits());
			assertEquals("test 5 a echoue (contenu table)", tPSol.toString(), tP.toString());
		}  catch (IllegalArgumentException e) {
			System.out.println("test 5 a echoue : il y a un participant a l'indice 2 dans une table qui contient 3 participants");
			System.out.println("il ne fallait pas lancer une IllegalArgumentException");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : exception inattendue!!!");
			System.exit(0);
		}

		// test 6 : supprime participant a l'indice 0 dans une table pleine qui contient 4 participants
		try {
			String[] t = { "p1", "p2", "p3","p4" };
			Participants tP = new Participants(4,t);
			String[] tSol = { "p2", "p3","p4" };
			Participants tPSol = new Participants(4,tSol);
			tP.supprimerParticipant(0);
			assertEquals("test 6 a echoue (nombre inscrits)", 3, tP.getNombreInscrits());
			assertEquals("test 6 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (IllegalArgumentException e) {
			System.out.println("test 6 a echoue : il y a un participant a l'indice 0 dans une table qui contient 4 participants");
			System.out.println("il ne fallait pas lancer une IllegalArgumentException");
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : exception inattendue!!!");
			System.exit(0);
		}
		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

}
