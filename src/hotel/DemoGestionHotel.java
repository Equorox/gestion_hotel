package hotel;

// Les régles métiers du projet doivent garantir les fonctionnalités
//suivantes :
//- On veut pouvoir savoir qui occupe quelle chambre à quelle date.
//- Pour chaque jour de l'année, on veut pouvoir calculer le loyer de chaque chambre en fonction de son prix et de son occupation (le loyer est nul si la chambre est inoccupée).
// La somme de ces loyers permet de calculer le chiffre d'affaires de l'hôtel entre deux dates.

public class DemoGestionHotel {

//	private String[] listeTypes = { "single", "twin", "double", "suite" };
//	private static int nbreChambres = 20;

	public static void main(String[] args) {
		Hotel h1 = new Hotel();
		h1.generateurHotel();
//		h1.afficherListeChambres();
//		
//		h1.affichePremiereLibre();
//		h1.afficheDerniereLibre();
		
		h1.reservation();
		
		
		
//		System.out.println(h1.getListeReservations());
		
//		for (LocalDate date : h1.getListeReservations().keySet()) {
//			System.out.println(date);
//		}
	}
	
	
	

}
