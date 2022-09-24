
public class Quizz1 {

	public static FenetreQuizz fenetreQuizz;
	
	public static void main(String[] args){
		
		// creation de  l equipe
		
		Candidat[] candidats = new Candidat[6];
		for (int i = 0; i < candidats.length; i++) {
			candidats[i] = new Candidat("nom"+(i+1));
		}
		Equipe equipe = new Equipe(1, candidats);

		// creation du questionnaire
		
		Questionnaire questionnaire = chargerQuestions();

		// creation de la fenetre de depart
		
		fenetreQuizz = new FenetreQuizz("Quizz - Capitales des pays de l'union europeenne");
		fenetreQuizz.afficherEquipe(equipe);

		/*
			Boucle du jeu
		 */
		while (equipe.getNombreCandidats() > 0) {

			//On récupère la question posée + affichage
			QuestionCM question = questionnaire.fournirQuestion();
			fenetreQuizz.afficherQuestion(question);

			//On récupère le choix du joueur ainsi que le candidat
			int choix = fenetreQuizz.cliquerChoix();
			Candidat candidat = equipe.selectionnerCandidat();
			fenetreQuizz.afficherCandidat(candidat);

			//On vérifie si il a bien répondu
			if (choix == question.getNumeroChoixCorrect()) {

				//Si oui on remet le candidat
				fenetreQuizz.afficherPouceOK();
				equipe.remettreEnJeu(candidat);
			} else {

				//Si non on retire le candidat
				fenetreQuizz.afficherPouceKO();
			}

			//On est reparti pour un tour
			fenetreQuizz.afficherEquipe(equipe);
			fenetreQuizz.cliquerSuivant();
		}

		//Fin du jeu
		fenetreQuizz.afficherInformation("Vous avez perdu !");
	}
	
	
	public static Questionnaire chargerQuestions(){

		QuestionCM[] questions = new QuestionCM[5];
		questions[0]= new QuestionCM("Allemagne","Amsterdam","Dublin","Berlin",3);
		questions[1]= new QuestionCM("Autriche","Vienne","Prague", "Vilnius",1);
		questions[2]= new QuestionCM("Belgique","Amsterdam", "Bruxelles","Paris",2);
		questions[3]= new QuestionCM("Bulgarie"	,"Sofia","Budapest","Bucarest",1);
		questions[4]= new QuestionCM("Italie",	"Nicosie","Riga","Rome",3);
		

//		Croatie		Zagreb
//		Danemark	Copenhague
//		Espagne		Madrid
//		Estonie		Tallinn
//		Finlande	Helsinki
//		France		Paris
//		Grece		Athenes
//		Hongrie		Budapest
//		Irlande		Dublin
//		Italie		Rome
//		Lettonie	Riga
//		Lituanie	Vilnius
//		Luxembourg	Luxembourg
//		Malte		La Valette
//		Pays-Bas	Amsterdam
//		Pologne		Varsovie
//		Portugal	Lisbonne
//		Republiquetcheque	Prague
//		Roumanie	Bucarest
//		Royaume-Uni	Londres
//		Slovaquie	Bratislava
//		Slovenie	Ljubljana
//		Suede		Stockholm

		return new Questionnaire(questions);
		
	}

}
