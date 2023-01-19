package hotel;

import java.util.ArrayList;

public class Hotel {
	
	private ArrayList<Chambre> listeChambres = new ArrayList<>();

	
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
	public void ajouterChambre(Chambre chambre) {
		listeChambres.add(chambre);
	}
	
	// Affiche la liste des chambres
	public void afficherListeChambres() {
		int rang=1;
		for (Chambre chambre : listeChambres) {
			System.out.printf("Chambre n°%d%nType de chambre : %s%nNombre de places : %d%nNombre de lits : %d%nReservee : %s", rang, chambre.getClass().getName(), chambre.getPlaces(),chambre.getLits(), chambre.getReservee());
		}
	}
	
	
	
	
}
