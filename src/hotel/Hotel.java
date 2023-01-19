package hotel;

import java.util.ArrayList;

public class Hotel {
	
	private static ArrayList<Chambre> listeChambres = new ArrayList<>();
	private static int nbreChambres = 20;

	
	// Décompte le nombre de chambres libres dans la liste des chambres
	public int nbreChambresLibres() {
		int somme=0;
		for (Chambre chambre : listeChambres) {
			if (chambre.reservee) {
				somme++;
			}
		}
		return somme;
	}
	
	// Décompte le nombre de chambres réservée dans la liste des chambres
	public int nbreChambresReservee() {
		int somme = 0;
		somme = listeChambres.size()-nbreChambresLibres();
		return somme;
	}
	
	// Ajoute une chambre dans l'hotel
	public static void ajouterChambre(Chambre chambre) {
		listeChambres.add(chambre);
	}
	
	// Affiche la liste des chambres
	public void afficherListeChambres() {
		int rang=1;
		for (Chambre chambre : listeChambres) {
			System.out.printf("Chambre n°%d | Type : %s | Places : %d | Lits : %d |Tarif : %f Reservee : %s%n--------------------%n", rang, chambre.getClass().getName(), chambre.getPlaces(),chambre.getLits(),chambre.getTarif(), chambre.getReservee());
			rang++;
		}
	}
	
	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	public void generateurHotel() {
		for (int i = 0; i < nbreChambres; i++) {
			
			Chambre chambre = null;
			int reserve = getRandomNumber(0, 2);
			
			boolean estReservee=false;
			if (reserve==1) {
				estReservee=true;
			}
			
			int rand = getRandomNumber(0, 4);
			
			switch (rand) {
			case 0:
				chambre = new Single(1, estReservee);
				break;
			case 1:
				chambre = new Twin(estReservee);
				break;
			case 2:
				chambre = new Double(estReservee);
				break;
			case 3:
				chambre = new Suite(2, 1, estReservee);
				break;
			default:
				break;
			}
			
			ajouterChambre(chambre);
		}
	}
	
	
	
	
}
