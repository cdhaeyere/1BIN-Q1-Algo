
public class QuestionCM {
	private String question;
	private String choix1;
	private String choix2;
	private String choix3;
	private int numeroChoixCorrect; // 1, 2 ou 3

	public QuestionCM(String question, String choix1, String choix2, String choix3,int numeroChoixCorrect) {
		this.question = question;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.numeroChoixCorrect = numeroChoixCorrect;
	}

	public String getQuestion() {
		return question;
	}

	public String getChoix1() {
		return choix1;
	}

	public String getChoix2() {
		return choix2;
	}

	public String getChoix3() {
		return choix3;
	}

	public int getNumeroChoixCorrect() {
		return numeroChoixCorrect;
	}

	@Override
	public String toString() {
		return "QCM [question=" + question + ", choix1=" + choix1 + ", choix2="
				+ choix2 + ", choix3=" + choix3 + ", numeroChoixCorrect="
				+ numeroChoixCorrect + "]";
	}

}
