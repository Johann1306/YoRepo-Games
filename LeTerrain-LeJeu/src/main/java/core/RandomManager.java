package core;

import java.util.Random;

public class RandomManager {

	public static int random(int min, int max) {
		Random rand = new Random(); 
		int nbAleatoire = rand.nextInt(max - min + 1) + min;
		System.out.println("Random (" + min + "," + max + ") = " + nbAleatoire);
		return nbAleatoire;
	}
	
	public static int random1_100() {
		Random rand = new Random(); 
		int nbAleatoire = rand.nextInt(100)+1;
		return nbAleatoire;
	}

	public static int random0_100() {
		Random rand = new Random(); 
		int nbAleatoire = rand.nextInt(101);
		return nbAleatoire;
	}
	
//	public static Jeu getRandomJeu(List<NomJeu> jeux) {
//		JeuManager jeuManager = MenuPrincipal.getMainFrame().getCoreManager().getJeuManager();
//		Jeu jeu = null;
//		int nombreJeu = jeux.size();
//		if (nombreJeu>1) {
//			//random
//			int random = RandomManager.random(0, nombreJeu-1);
//			jeu = jeuManager.getJeu(jeux.get(random));
//		} else {
//			jeu = jeuManager.getJeu(jeux.get(0));
//		}
//		return jeu;
//	}


}
