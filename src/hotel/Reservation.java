package hotel;

import java.time.*;
import java.util.*;

public class Reservation {

	private LinkedHashMap<LocalDate, ArrayList<Chambre>> listeReservations = new LinkedHashMap<>();
	private static Scanner sc = new Scanner(System.in);
	
	public Reservation() {
		remplisDates();
	}
	
	
	public LinkedHashMap<LocalDate, ArrayList<Chambre>> getListeReservations() {
		return this.listeReservations;
	}
	
	// Genere une liste de date à partir de la date courante (format date :
	// yyyy-MM-dd)
	public ArrayList<LocalDate> genereDates() {
		LocalDate start = LocalDate.now();
		LocalDate end = LocalDate.now().plusYears(1);
		ArrayList<LocalDate> totalDates = new ArrayList<>();
		while (!start.isAfter(end)) {
			totalDates.add(start);
			start = start.plusDays(1);
		}
		return totalDates;
	}

	// Remplis les dates de la liste de réservations
	public void remplisDates() {
		for (LocalDate date : genereDates()) {
			listeReservations.put(date, null);
		}
	}
	
	/**
	 * Menu Reservation --> Affiche le menu et demande à l'utilisateur d'entrer un intervalle de dates
	 * @return un tableau qui comprend les deux bornes de l'intervalle
	 */
	public String[] reservationMenu() {
		System.out.println("----RESERVATION----");
		System.out.printf("Entrez la date de début(format yyyy-MM-dd) : ");
		String dateDebut = sc.next();
		System.out.printf("%nEntrez la date de fin (format yyyy-MM-dd) : ");
		String dateFin = sc.next();
		String[] dates = { dateDebut, dateFin };
		return dates;
	}

	 /**
    * @param chambre la chambre à réserver
    * @param dates <-- reservationMenu()
    * @return void, remplis la listeReservation aux dates entrées par l'utilisateur
    */
	public void reservation(Chambre chambre, String[] dates) {
		LocalDate dateDebut = LocalDate.parse(dates[0]);
		LocalDate dateFin = LocalDate.parse(dates[1]);

		while (dateDebut.compareTo(dateFin) <= 0) {
			if (listeReservations.get(dateDebut) != null) {
				ArrayList<Chambre> chambreAdded = listeReservations.get(dateDebut);
				chambreAdded.add(chambre);
				listeReservations.put(dateDebut, chambreAdded);
			} else {
				ArrayList<Chambre> chambreAdded = new ArrayList<>();
				chambreAdded.add(chambre);
				listeReservations.put(dateDebut, chambreAdded);
			}
			System.out.printf("Chambre réservée pour le %s%n", dateDebut);
			dateDebut = dateDebut.plusDays(1);
		}
	}
	
	
}
