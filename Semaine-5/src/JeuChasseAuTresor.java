public class JeuChasseAuTresor {
	
	public static void main(String[] args){

		//Initialisation du jeu
		int positionIndi = 1;
		int positionLara = 4;
		int de = 0;
		int positionCobra = 10;
		int positionElixir = 12;
		PlateauJeu jeu = new PlateauJeu();

		//Placement de base des joueurs
		jeu.placerIndi(positionIndi);
		jeu.placerLara(positionLara);
		jeu.placerCobra(positionCobra);
		jeu.placerElixir(positionElixir);

		//Boucle de jeu
		while(positionLara < 16 && positionIndi < 16) {
			jeu.afficherInformation("A Indi");
			de = jeu.lancerDe();
			positionIndi = positionIndi + de;

			if (positionElixir == positionIndi) {
				positionIndi = 14;
				jeu.deplacerIndi(positionIndi);
			} else {
				//Cas meme position
				if (positionIndi == positionLara) {
					positionIndi--;
					jeu.deplacerIndi(positionIndi);
				} else {
					//Vérification victoire Indi
					if (positionIndi >= 16) {
						jeu.deplacerIndi(16);
						jeu.afficherInformation("Victoire de Indi");
					} else {
						//Verification Cobra au meme endroit que Indi
						if (positionCobra <= positionIndi) {
							jeu.supprimerCobra();
							jeu.deplacerIndi(positionCobra);
							positionCobra = positionCobra + 100;
						} else {
							jeu.deplacerIndi(positionIndi);
						}
						jeu.afficherInformation("A Lara");
						de = jeu.lancerDe();
						positionLara = positionLara + de;
						if (positionElixir == positionLara) {
							positionLara = 14;
							jeu.deplacerLara(positionLara);
						} else {
							//Cas meme position
							if (positionIndi == positionLara) {
								positionLara--;
								jeu.deplacerLara(positionLara);
							} else if (positionLara == positionElixir) {
								positionLara = 17;
							} else {
								//Verification victoire Lara
								if (positionLara >= 16) {
									jeu.deplacerLara(16);
									jeu.afficherInformation("Victoire de Lara");
								} else {
									if (positionCobra <= positionLara) {
										jeu.supprimerCobra();
										jeu.deplacerLara(positionCobra);
										positionCobra = positionCobra + 100;
									} else {
										jeu.deplacerLara(positionLara);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
