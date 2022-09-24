
public class TestQuestionnaire {
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
		QuestionCM[] questions = new QuestionCM[4];
		for (int i = 0; i < questions.length; i++) {
			questions[i]= new QuestionCM("Q"+(i+1),"P1","P2","P3",1);
		}	
		Questionnaire questionnaire = new Questionnaire(questions);

		System.out.println("Il y a 4 questions : \tQ1 \tQ2 \tQ3 \tQ4");
		System.out.println("Voici la succession attendue des questions : \tQ1 \tQ2 \tQ3 \tQ4 \tQ1 \tQ2 \tQ3 \tQ4    ... ");
		System.out.println();
		QuestionCM question;
		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("1er appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("1er appel fournirQuestion() ko","Q1", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("1er appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.exit(0);
		}

		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("2eme appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("2eme appel fournirQuestion() ko","Q2", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("2eme appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.exit(0);
		}

		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("3eme appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("3eme appel fournirQuestion() ko","Q3", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("3eme appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.exit(0);
		}

		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("4eme appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("4eme appel fournirQuestion() ko","Q4", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("4eme appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.exit(0);
		}

		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("5eme appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("5eme appel fournirQuestion() ko","Q1", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("5eme appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.out.println("Avez-vous pense a revenir au debut de la table ?");
			System.exit(0);
		}

		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("6eme appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("6eme appel fournirQuestion() ko","Q2", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("6eme appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.exit(0);
		}

		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("7eme appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("7eme appel fournirQuestion() ko","Q3", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("7eme appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.exit(0);
		}

		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("8eme appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("8eme appel fournirQuestion() ko","Q4", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("8eme appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.exit(0);
		}
		try{
			question = questionnaire.fournirQuestion();
			if(question == null){
				System.out.println("9eme appel fournirQuestion() ko : la question renvoyee est null");
				System.exit(0);
			}
			assertEquals("9eme appel fournirQuestion() ko","Q1", question.getQuestion());
			System.out.println(question.getQuestion());
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("9eme appel fournirQuestion() ko : il y a eu une exception inattendue");
			System.exit(0);
		}

		System.out.println("Bravo, la succession des questions est bien respectee!");

	}
}
