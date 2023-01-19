package hotel;

// Les régles métiers du projet doivent garantir les fonctionnalités
//suivantes :
//- On veut pouvoir savoir qui occupe quelle chambre à quelle date.
//- Pour chaque jour de l'année, on veut pouvoir calculer le loyer de chaque chambre en fonction de son prix et de son occupation (le loyer est nul si la chambre est inoccupée).
// La somme de ces loyers permet de calculer le chiffre d'affaires de l'hôtel entre deux dates.

public class DemoGestionHotel {

	public static void main(String[] args) {
		
		
		Hotel hotel = new Hotel();
		Single chambre1 = new Single(2, false);
		
		hotel.ajouterChambre(chambre1);
		hotel.afficherListeChambres();
		
	}

}
