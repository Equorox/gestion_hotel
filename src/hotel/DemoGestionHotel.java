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

//		LocalDate date = LocalDate.now();
//		
//		Chambre chambre = new Chambre(2, 10);
//		h1.reservation(date, chambre);
//		
//		System.out.println(chambre.getReservations());

		
		Session admin = new Session("emile","pass");
		GestionSession.addSession(admin.getLogin(), admin.getPassword());
		
		
		// TODO fonction pour demander le mdp
//		 if (!GestionSession.tryToConnect()) return ;//tente de se connecter, termine
//		 l'action si la connexion a échoué.

//		System.out.println(h1.getListeReservations());

//		for (LocalDate date : h1.getListeReservations().keySet()) {
//			System.out.println(date);
//		}
		
		Menu menu = new Menu();
		
		while (true) {
			
			menu.processMenu(menu.afficheMenu(), h1);
		}

	}

}
