package hotel;

import java.time.LocalDate;
import java.util.*;

public class Menu {

	private static Scanner sc = new Scanner(System.in);

	public static int choix() {
		System.out.print("Choix : ");
		int choix = sc.nextInt();
		System.out.println();
		return choix;
	}

	// Fais entrer une date à l'utilisateur
	public static LocalDate dateInput() {
		System.out.printf("Aujourd'hui ?%n1. Oui%n2. Non%n");
		int choix = choix();

		switch (choix) {
		case 1:
			return LocalDate.now();
		default:
			boolean goodDate = false;
			LocalDate date = LocalDate.now();
			while (date.compareTo(LocalDate.now()) < 0) {
				System.out.print("Jour : ");
				String jour = sc.next();
				System.out.printf("Mois : ");
				String mois = sc.next();
				System.out.printf("Année : ");
				String annee = sc.next();
				date = LocalDate.parse(String.format("%d-%d-%d", annee, mois, jour));
				if (date.compareTo(LocalDate.now())<0) {
					System.out.println("Veuillez entrer une date future.");
				}
			}
			return date;
		}
	}

	public Client clientInput() {
		System.out.print("Entrez le nom du client : ");
		String nom = sc.next();
		System.out.printf("Entrez le nombre de personnes : ");
		int nbre = sc.nextInt();
		Client client = new Client(nbre, nom);
		return client;
	}

	public int afficheMenu() {
		System.out.println("-------MENU-------");
		System.out.println("1. Etat de l'hotel");
		System.out.println("2. Nombre de chambres réservées");
		System.out.println("3. Nombre de chambres libres");
		System.out.println("4. Numéro de la première chambre vide");
		System.out.println("5. Numéro de la dernière chambre vide");
		System.out.println("6. Réserver une chambre");
		System.out.println("7. Libérer une chambre");
		System.out.println("8. Chiffre d'affaire");
		System.out.println("9. Quitter");
		int choix = choix();
		return choix;
	}

	public void processMenu(int choix, Hotel h) {
		LocalDate date = LocalDate.now();
		switch (choix) {
		case 1:
			date = dateInput();
			h.afficherListeChambres(date);
			break;
		case 2:
			date = dateInput();
			System.out.println(h.nbreChambresReservee(date));
			break;
		case 3:
			date = dateInput();
			System.out.println(h.nbreChambresLibres(date));
			break;
		case 4:
			date = dateInput();
			h.affichePremiereLibre(date);
			break;
		case 5:
			date = dateInput();
			h.afficheDerniereLibre(date);
			break;
		case 6:
			if (!GestionSession.tryToConnect())
				return;
			date = dateInput();
			menuReservation(h, date);
			break;
		case 7:
			if (!GestionSession.tryToConnect())
				return;
			date = dateInput();
			menuLiberer(h, date);
			break;
		case 8:
			date = dateInput();
			h.getReservations().chiffreDAffaire(dateIntervalleInput());
			break;
		case 9:
			System.out.println("A bientôt !");
			System.exit(0);
			break;
		default:
			break;
		}
	}

	public void menuReservation(Hotel h, LocalDate date) {
		System.out.printf("Quel type de chambre voulez vous réserver ?%n1. Single%n2. Twin%n3. Double%n4. Suite%n");
		int choixChambre = choix() - 1;
		Chambre chambre = h.getListeChambres().get(h.premiereLibre(date)[choixChambre]);
		Client client = clientInput();

		int nbre = client.getNbre();
		LocalDate[] dates = dateIntervalleInput();
		while (nbre > 0 && h.getListeChambres().get(h.premiereLibre(date)[choixChambre])!=null) {
			h.reservation(chambre, dates);
			nbre -= chambre.getPlaces();
			chambre = h.getListeChambres().get(h.premiereLibre(date)[choixChambre]);
			chambre.setClients(date, client);
			client.setNbre(nbre);
			return;
		}
		System.out.printf("Plus de chambre disponible, il reste %d clients à loger.", client.getNbre());
		
		

	}

	public void menuLiberer(Hotel h, LocalDate date) {
		h.afficherListeChambres(date);
		System.out.println("Quelle chambre voulez vous vider ?");
		int choixChambreAVider = choix() - 1;
		h.getReservations().libererChambre(h.getListeChambres().get(choixChambreAVider), dateIntervalleInput());

	}

	/**
	 * Affiche le menu et demande à l'utilisateur d'entrer un intervalle de dates
	 * 
	 * @return un tableau qui comprend les deux bornes de l'intervalle
	 */
	public static LocalDate[] dateIntervalleInput() {
		System.out.printf("Entrez la date de début : ");
		LocalDate dateDebut = dateInput();
		System.out.printf("%nEntrez la date de fin : ");
		LocalDate dateFin = dateInput();
		LocalDate[] dates = { dateDebut, dateFin };
		return dates;
	}
}
