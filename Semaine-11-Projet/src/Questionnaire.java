
public class Questionnaire {
	
	private QuestionCM[] tableQuestions;
	private int indiceDer = -1; // l'indice de la derniere question fournie
	
	
	public Questionnaire(QuestionCM[] tableARecopier) {
		if(tableARecopier==null)
			throw new IllegalArgumentException();
		if(tableARecopier.length==0)
			throw new IllegalArgumentException();
		this.tableQuestions = new QuestionCM[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			if(tableARecopier[i]==null)
				throw new IllegalArgumentException();
			this.tableQuestions[i]=tableARecopier[i];
		}
	}
	
	/**
	 * renvoie la question suivante
	 * La question qui "suit" la derniere question est la premiere
	 * precondition (a ne pas verifier) : la table est non vide
	 * @return une question QuestionCM
	 */
	public QuestionCM fournirQuestion(){
		indiceDer++;
		if (indiceDer == tableQuestions.length) {
			indiceDer = 0;
		}
		QuestionCM newQuestion = tableQuestions[indiceDer];
		return newQuestion;
	}
}
