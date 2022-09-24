
public class Candidat {
	
	private int numeroCandidat;
	private String nom;
	private static int numeroDer = 0;
	
	public Candidat(String nom) {
		this.nom = nom;
		this.numeroDer++;
		this.numeroCandidat = numeroDer;
	}

	public int getNumeroCandidat() {
		return numeroCandidat;
	}

	public String getNom() {
		return nom;
	}

}
