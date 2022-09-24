/*
    @Author Corentin D'haeyere
 */
public class calculBMIV2 {

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Entrez votre poids : ");
        double poids= scanner.nextDouble();
        System.out.print(("Entrez votre taille : "));
        double taille = scanner.nextDouble();
        double bmi = calculerBmi(poids,taille);
        System.out.println("Votre bmi : "+ bmi);
        String etat = donnerEtat(bmi);
        System.out.println("Votre etat : "+etat);
    }

    /**
     * calcule le bmi
     * @param poids le poids exprime en kg
     * @param taille la taille exprimee en m
     * @return le bmi
     */
    public static double calculerBmi(double poids, double taille){
        return poids/(taille*taille);
    }

    /**
     * renvoie sous forme d'une string, l'etat du patient
     * bmi < 20 : mince
     * [20,25] : normal
     * ]25,30] : en embonpoint
     * bmi > 30 : obese
     * @return l'etat du patient
     */
    public static String donnerEtat(double bmi){
        if(bmi<20)
            return "mince";
        // bmi >= 20
        if(bmi<=25)
            return "normal";
        // bmi > 25
        if(bmi<=30)
            return "en embonpoint";
        return "obese";
    }

}
