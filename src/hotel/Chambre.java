package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Chambre {
	
	protected int places;
	protected LinkedHashMap<LocalDate, Boolean> reservations = new LinkedHashMap<LocalDate,Boolean>();
	protected LinkedHashMap<LocalDate, Client> clients = new LinkedHashMap<LocalDate, Client>();
	protected float tarif;
	
	
	
	public Chambre(int places, float tarif) {
		this.places=places;
		this.tarif=tarif;
		remplisDates(reservations);
		for (LocalDate date : reservations.keySet()) {
			reservations.put(date, false);
		}
		remplisDatesClients(clients);
//		for (LocalDate date : genereDates()) {
//			int num = getRandomNumber(0, 2);
//			switch (num) {
//			case 0:
//				this.reservations.put(date, false);
//				break;
//			case 1:
//				this.reservations.put(date, true);
//				break;
//			default:
//				break;
//			}
//		}
	}
	
	public LinkedHashMap<LocalDate,Boolean> getReservations() {
		return this.reservations;
	}
	
	public int getPlaces(){
		return this.places;
	}
	
	public float getTarif() {
		return this.tarif;
	}
	
	public LinkedHashMap<LocalDate,Client> getClients(){
		return this.clients;
	}
	
	
	
	public void setReservations(LocalDate date, boolean reservation) {
		this.reservations.put(date, reservation);
	}
	
	public void setPlaces(int places) {
		this.places=places;
	}
	
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
	public void remplisDates(LinkedHashMap<LocalDate, Boolean> liste) {
		for (LocalDate date : genereDates()) {
			liste.put(date, null);
		}
	}
	
	public void remplisDatesClients(LinkedHashMap<LocalDate, Client> liste) {
		for (LocalDate date : genereDates()) {
			liste.put(date, null);
		}
	}
	
	
	// ______
	// Renvoie un nombre entier aléatoire entre les bornes min max (max exclusif)
	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
}
