/*
	@Author: Corentin D'haeyere
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
	 *            la valeur qu'on a re�u en realite
	 */
	private static void assertEquals(String messageErreur, Object attendu, Object recu) {
		if (attendu == null) {
			if (recu != null) {
				System.out.println();
				System.out.println(messageErreur);
				System.out.println("\nAttendu : " + attendu);
				System.out.println("\nRe�u : " + recu);
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
				System.out.println("\nRe�u : " + recu);
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
			System.out.println("1 -> Tester la methode 'ajouterUnParticipant()'");
			System.out.println("2 -> Tester la methode 'supprimerUnParticipant()'");

			System.out.print("\nEntrez votre choix : ");
			choix = scanner.nextInt();
			switch (choix) {
			case 1:
				ajouter();
				break;
			case 2:
				supprimer();
				break;

			}
		} while (choix >= 1 && choix <= 2);
		System.out.println("Merci pour votre visite.");
	}

	private static void ajouter() {

		// test 1 : ajout dans une table vide
		try {
			Participants tP = new Participants(4);
			String[] tSol = { "p1" };
			assertEquals("test 1 a echoue (booleen renvoye)", true, tP.ajouterUnParticipant("p1"));
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 1 a echoue (nombre inscrits)", tPSol.getNombreInscrits(), tP.getNombreInscrits());
			assertEquals("test 1 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		// test 2 : ajout dans une table pleine
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			assertEquals("test 2 a echoue (booleen renvoye)", false, tP.ajouterUnParticipant("p5"));
			assertEquals("test 2 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		// test 3 : ajout dans une table non pleine
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3", "p4" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 3 a echoue (boolean renvoye)", true, tP.ajouterUnParticipant("p4"));
			assertEquals("test 3 a echoue (nombre inscrits)", 4, tP.getNombreInscrits());
			assertEquals("test 3 a echoue (contenu table)", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
		    e.printStackTrace();
			System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		// test 4 : ajout dans une table qui contient deja le participant
		// (homonyme accepte!)
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 4 a echoue", true, tP.ajouterUnParticipant("p3"));
			assertEquals("test 4 a echoue", tPSol.toString(), tP.toString());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}

	private static void supprimer() {
		// test 1 : suppression dans une table vide
		try {
			Participants tP = new Participants(4);
			Participants tPSol = new Participants(4);
			assertEquals("test 1 a echoue (booleen renvoye)", false, tP.supprimerUnParticipant("p1"));
			assertEquals("test 1 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : NullPointerException!!!");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 1 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);

		}

		// test 2 : suppression dans une table non vide et non pleine qui ne
		// contient pas le participant
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 2 a echoue (booleen renoye)", false, tP.supprimerUnParticipant("p4"));
			assertEquals("test 2 a echoue (nombre inscrits)", 3, tP.getNombreInscrits());
			assertEquals("test 2 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : NullPointerException!!!");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 2 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		// test 3 : suppression dans une table non vide et non pleine qui
		// contient le participant
		try {
			String[] t = { "p1", "p2", "p3" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 3 a echoue (booleen renvoye)", true, tP.supprimerUnParticipant("p2"));
			assertEquals("test 3 a echoue (nombre inscrits)", 2, tP.getNombreInscrits());
			assertEquals("test 3 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : NullPointerException!!!");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 3 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		// test 4 : suppression dans une table pleine qui ne contient pas le
		// participant
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3", "p4" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 4 a echoue (booleen renvoye)", false, tP.supprimerUnParticipant("p5"));
			assertEquals("test 4 a echoue (contenu table)", tPSol.toString(), tP.toString());

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : NullPointerException!!!");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 4 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		// test 5 : suppression dans une table pleine qui contient le
		// participant
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			String[] tSol1 = { "p1", "p3", "p4" };
			Participants tPSol1 = new Participants(4, tSol1);
			String[] tSol = { "p1", "p4", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 5 a echoue (booleen renvoye)", true, tP.supprimerUnParticipant("p2"));
			if (tP.toString().equals(tPSol1.toString())) {
				System.out.println("ATTENTION! Le test 5 a reussi, mais votre methode n'est pas performante!!!");
				System.out.println("Avez-vous suivi les conseils de la fiche?");
				System.out.println("Vous devez revoir votre methode!");
				System.exit(0);
			}
			assertEquals("test 5 a echoue", tPSol.toString(), tP.toString());

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : NullPointerException!!!");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 5 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		// test 6 : suppression dans une table pleine qui contient le
		// participant en premier lieu
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p4", "p2", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 6 a echoue", true, tP.supprimerUnParticipant("p1"));
			assertEquals("test 6 a echoue", tPSol.toString(), tP.toString());

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : NullPointerException!!!");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 6 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		// test 7 : suppression dans une table pleine qui contient le
		// participant en dernier lieu
		try {
			String[] t = { "p1", "p2", "p3", "p4" };
			Participants tP = new Participants(4, t);
			String[] tSol = { "p1", "p2", "p3" };
			Participants tPSol = new Participants(4, tSol);
			assertEquals("test 7 a echoue", true, tP.supprimerUnParticipant("p4"));
			assertEquals("test 7 a echoue", tPSol.toString(), tP.toString());

		} catch (NullPointerException e) {
			e.printStackTrace();
			System.out.println("test 7 a echoue : NullPointerException!!!");
			System.exit(0);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("test 7 a echoue : ArrayIndexOutOfBoundsException!!!");
			System.exit(0);
		}

		System.out.println("Tous les tests ont reussi!");
		System.out.println();
	}
}
