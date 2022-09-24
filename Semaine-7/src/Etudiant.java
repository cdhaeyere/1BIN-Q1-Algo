/*
	@author Corentin D'haeyere
 */
public class Etudiant{

	private double[] tableCotes;
	private int matricule;

	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	/**
	 * constructeur par recopie
	 * @param matricule
	 * @param tableARecopier
	 * @throws IllegalArgumentException si la table est null ou si la table ne contient aucune cote ou si le contenu ne correspond pas a des cotes
	 */
	public Etudiant(int matricule, double[] tableARecopier){	
		if( tableARecopier==null)
			throw new IllegalArgumentException("table null");
		if(tableARecopier.length == 0)
			throw new IllegalArgumentException("aucune cote");
		this.matricule = matricule;
		this.tableCotes = new double[tableARecopier.length];
		for(int i = 0; i < tableCotes.length; i++) {
			if(tableARecopier[i]<0||tableARecopier[i]>20)
				throw new IllegalArgumentException("cote non comprise entre 0 et 20");
			tableCotes[i] = tableARecopier[i];
		}			
	}

	// A NE PAS MODIFIER! VA SERVIR POUR LES TESTS
	public String toString(){
		String aRenvoyer = "\nMatricule : "+matricule+"\nCotes : ";
		for(int i = 0; i < tableCotes.length; i++) 
			aRenvoyer = aRenvoyer + "  " + tableCotes[i];
		return aRenvoyer;
	}

	
	/**
	 * 						
	 * @param coteMin
	 * @param coteMax
	 * @return
	 * @throws IllegalArgumentException 
	 */
	public int nombreDeCotesEntre(int coteMin, int coteMax){
		if(coteMin<0||coteMin>20)
			throw new IllegalArgumentException("coteMin non comprise entre 0 et 20");
		if(coteMax<0||coteMax>20)
			throw new IllegalArgumentException("coteMax non comprise entre 0 et 20");
		if(coteMin > coteMax)
			throw new IllegalArgumentException("coteMin > coteMax");
		int compteur = 0;
		for (int i = 0; i < tableCotes.length; i++) {
			if(tableCotes[i]>=coteMin && tableCotes[i]<=coteMax)
				compteur++;
		}
		return compteur;
	}
	
	
	/**
	 * compte le nombre d'occurrence de la cote passee en parametre
	 * @param coteRecherchee
	 * @return le nombre de cotes egales a la cote passee en parametre
	 * @throws IllegalArgumentException si la cote recherchee n'est pas comprise entre 0 et 20 
	 */
	public int nombreCotesEgalesA(double coteRecherchee){
		if(coteRecherchee<0||coteRecherchee>20)
			throw new IllegalArgumentException("cote non comprise entre 0 et 20");
		int compteur = 0;
		for (int i = 0; i < tableCotes.length; i++) {
			if(tableCotes[i]==coteRecherchee)
				compteur++;
		}
		return compteur;
	}
	
	/**
	 * calcule la moyenne des cotes
	 * @return la moyenne
	 */
	public double moyenne(){
		double moyenne = 0;
		for (double cote : tableCotes) {
			moyenne += cote;
		}
		return moyenne/tableCotes.length;
	}
	

	/**
	 * calcule le nombre de cotes < 10
	 * @return le nombre de cotes < 10
	 */
	public int nombreEchecs(){
		int echecs = 0;
		for (double cote : tableCotes) {
			if (cote < 10) {
				echecs++;
			}
		}
		return echecs;
	}


	/**
	 * recherche la plus petite cote
	 * @return la plus petite cote
	 */
	public double min(){
		double min = Double.MAX_VALUE;
		for (double cote : tableCotes) {
			if (cote < min) {
				min = cote;
			}
		}
		return min;
	}


	/**
	 * recherche la plus grande cote
	 * @return la plus grande cote
	 */
	public double max(){
		double max = -Double.MAX_VALUE;
		for (double cote : tableCotes) {
			if (cote > max) {
				max = cote;
			}
		}
		return max;
	}

	public int nombreUEValidees() {
		int UE = 0;
		for (double cote : tableCotes) {
			if (cote >= 10) {
				UE++;
			}
		}
		return UE;
	}

	// N'oubliez pas d'ajouter la methode nombreUEValidees() - cfr enonce
}