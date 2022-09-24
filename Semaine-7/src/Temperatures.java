import java.util.Arrays;
/*
	@author Corentin D'haeyere
 */
public class Temperatures {

	private String mois;
	private double[] tableDesTemperatures;
	
	// A NE PAS MODIFIER
	public Temperatures(String mois, double [] tableARecopier) {
		if(tableARecopier == null)
			throw new IllegalArgumentException();
		if(tableARecopier.length == 0)
			throw new IllegalArgumentException();
		this.mois = mois;
		this.tableDesTemperatures = new double[tableARecopier.length];
		for (int i = 0; i < tableARecopier.length; i++) {
			this.tableDesTemperatures[i]=tableARecopier[i];
		}
	}

	// A NE PAS MODIFIER
	public String toString(){
		String aRenvoyer = "temperatures du mois de " + this.mois + " : \n";
		return aRenvoyer + Arrays.toString(tableDesTemperatures);
	}


	/**
	 * calcule la moyenne des temperatures
	 * @return la moyenne
	 */
	public double moyenne(){
		double moyenne = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			moyenne += tableDesTemperatures[i];
		}
		return moyenne/tableDesTemperatures.length;
	}


	/**
	 * recherche la temperature la plus basse
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus basse
	 */
	public double temperatureMin(){
		double temperatureMin = Double.MAX_VALUE;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] < temperatureMin) {
				temperatureMin = tableDesTemperatures[i];
			}
		}
		return temperatureMin;
	}


	/**
	 * calcule le nombre de temperatures negatives (< 0)
	 * @return le nombre de jours de gel
	 */
	public int nombreJoursDeGel(){
		int nbrJoursDeGel = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] < 0) {
				nbrJoursDeGel++;
			}
		}
		return nbrJoursDeGel;
	}


	/**
	 * remplit une table avec les numeros des jours de gel
	 * @return une table avec les jours de gel, la dimension de cette table correspond a ce nombre de jours
	 */
	public int[] joursDeGel(){
		int[] joursDeGel = new int[nombreJoursDeGel()];
		int nbr = 0;
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] < 0) {
				joursDeGel[nbr] = i+1;
				nbr++;
			}
		}
		return joursDeGel;
	}


	/**
	 * verifie si toutes les temperatures sont positives
	 * @return true si toutes les temperatures sont positives, false sinon
	 */
	public boolean toutesPositives(){
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i] < 0) {
				return false;
			}
		}
		return true;
	}


	/**
	 * verifie la presence d'au moins une temperature negative (<0)
	 * @return true si la table contient au moins une temperature negative, false sinon
	 */
	public boolean contientAuMoinsUnJourDeGel(){
		return !toutesPositives();
	}


	/**
	 * verifie la presence d'au moins une temperature superieure a la temperature passee en parametre
	 * @param temperature la temperature qui sert a cette recherche
	 * @return true si la table contient au moins une temperature superieure a temperature, false sinon
	 */
	public boolean contientAuMoinsUneTemperatureSuperieureA(double temperature){
		for (int i = 0; i < tableDesTemperatures.length; i++) {
			if (tableDesTemperatures[i]> temperature) {
				return true;
			}
		}
		return false;
	}


	/**
	 * recherche la temperature la plus elevee
	 * precondition (a ne pas verifier) la table des temperatures est non vide
	 * @return la temperature la plus elevee
	 */
	public double temperatureMax(){
		double temperatureMax = -Double.MAX_VALUE;
		for (double tableDesTemperature : tableDesTemperatures) {
			if (tableDesTemperature > temperatureMax) {
				temperatureMax = tableDesTemperature;
			}
		}
		return temperatureMax;
	}


	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus elevee
	 * @return une table avec les jours de haute temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMax(){
		int[] joursMax = new int[nombreJours(temperatureMax())];
		int i = 0;
		for (int j = 0; j < tableDesTemperatures.length; j++) {
			if (tableDesTemperatures[j] == temperatureMax()) {
				joursMax[i] = j+1;
				i++;
			}
		}
		return joursMax;
	}





	/**
	 * remplit une table avec les numeros des jours correspondant a la temperature la plus basse
	 * @return une table avec les jours de basse temperature, la dimension de cette table correspond à ce nombre de jours
	 */
	public int[] joursMin(){
		int[] joursMin = new int[nombreJours(temperatureMin())];
		int i = 0;
		for (int j = 0; j < tableDesTemperatures.length; j++) {
			if (tableDesTemperatures[j] == temperatureMin()) {
				joursMin[i] = j+1;
				i++;
			}
		}
		return joursMin;
	}

	public int nombreJours(double temperature) {
		int nbr = 0;
		for (double temp : tableDesTemperatures) {
			if (temp == temperature) {
				nbr++;
			}
		}
		return nbr;
	}
}
