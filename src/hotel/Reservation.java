package hotel;

import java.time.*;
import java.util.*;

public class Reservation {

	private LinkedHashMap<LocalDate, ArrayList<Chambre>> listeReservations = new LinkedHashMap<>();
	
	public Reservation() {
		remplisDates();
	}
		
	public LinkedHashMap<LocalDate, ArrayList<Chambre>> getListeReservations() {
		return this.listeReservations;
	}

	// Genere une liste de date à partir de la date courante (format date : yyyy-MM-dd)
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
    * @param chambre la chambre à réserver
    * @param dates <-- reservationMenu()
    * @return void, remplis la listeReservation aux dates entrées par l'utilisateur
    */
	public void reservation(Chambre chambre, LocalDate[] dates) {
		LocalDate dateDebut = dates[0];
		LocalDate dateFin = dates[1];
		while (dateDebut.compareTo(dateFin) <= 0) {
			if (listeReservations.get(dateDebut) != null) {
				ArrayList<Chambre> chambreAdded = listeReservations.get(dateDebut);
				chambreAdded.add(chambre);
				listeReservations.put(dateDebut, chambreAdded);
				chambre.setReservations(dateDebut, true);
			} else {
				ArrayList<Chambre> chambreAdded = new ArrayList<>();
				chambreAdded.add(chambre);
				listeReservations.put(dateDebut, chambreAdded);
				chambre.setReservations(dateDebut, true);
			}
			System.out.printf("Chambre réservée pour le %s%n", dateDebut);
			dateDebut = dateDebut.plusDays(1);
		}
	}
	
	
	public void libererChambre(Chambre chambre, LocalDate[] dates) {

		LocalDate dateDebut = dates[0];
		LocalDate dateFin = dates[1];
		while (dateDebut.compareTo(dateFin) <= 0) {
			for (int i=0;i<listeReservations.get(dateDebut).size();i++) {
				if (listeReservations.get(dateDebut).get(i).equals(chambre)) {
					listeReservations.get(dateDebut).remove(i);
					chambre.getReservations().put(dateDebut, false);
					chambre.getClients().put(dateDebut, null);
				}
			}
			dateDebut = dateDebut.plusDays(1);
		}
	}
	
	public float chiffreDAffaire(LocalDate[] dates) {
		int somme = 0;
		LocalDate dateDebut = dates[0];
		LocalDate dateFin = dates[1];
		while (dateDebut.compareTo(dateFin) <= 0) {
			for (Chambre chambre : listeReservations.get(dateDebut)) {
				somme += chambre.getTarif();
			}
			dateDebut = dateDebut.plusDays(1);
		}
		return somme;
	}
	
	
}
