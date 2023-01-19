package hotel;

import java.util.Iterator;

// Les régles métiers du projet doivent garantir les fonctionnalités
//suivantes :
//- On veut pouvoir savoir qui occupe quelle chambre à quelle date.
//- Pour chaque jour de l'année, on veut pouvoir calculer le loyer de chaque chambre en fonction de son prix et de son occupation (le loyer est nul si la chambre est inoccupée).
// La somme de ces loyers permet de calculer le chiffre d'affaires de l'hôtel entre deux dates.

public class DemoGestionHotel {

	private String[] listeTypes = { "single", "twin", "double", "suite" };
	private static int nbreChambres = 20;

	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}

	
	
	
	
	public static void main(String[] args) {

		Hotel h1 = new Hotel();
		h1.generateurHotel();
		h1.afficherListeChambres();
		
	}

}
