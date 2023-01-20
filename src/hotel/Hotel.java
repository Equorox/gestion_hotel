package hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class Hotel {

	private ArrayList<Chambre> listeChambres = new ArrayList<>();
	private int nbreChambres = 20;
	private Reservation reservations = new Reservation();

	public Reservation getReservations() {
		return this.reservations;
	}
	
	public ArrayList<Chambre> getListeChambres(){
		return this.listeChambres;
	}

	
	
	// ______
	// Décompte le nombre de chambres libres dans la liste des chambres
	public int nbreChambresLibres(LocalDate date) {
		int somme = 0;
		for (Chambre chambre : listeChambres) {
			if (chambre.getReservations().get(date)) {
				somme++;
			}
		}
		return somme;
	}
	
	// ______
	// Décompte le nombre de chambres réservée dans la liste des chambres
	public int nbreChambresReservee(LocalDate date) {
		int somme = 0;
		somme = listeChambres.size() - nbreChambresLibres(date);
		return somme;
	}
	
	// ______
	// Ajoute une chambre dans l'hotel
	public void ajouterChambre(Chambre chambre) {
		this.listeChambres.add(chambre);
	}
	
	// ______
	// Affiche la liste des chambres
	public void afficherListeChambres(LocalDate date) {
		int rang = 1;
		for (Chambre chambre : listeChambres) {
			System.out.printf("Chambre n°%d | Type : %s | Places : %d | Tarif : %f | Réservée : %s%n", rang,
					chambre.getClass().getName(), chambre.getPlaces(), chambre.getTarif(), chambre.getReservations().get(date)
					);
			rang++;
		}
	}
	
	// ______
	// Renvoie un nombre entier aléatoire entre les bornes min max (max exclusif)
	public static int getRandomNumber(int min, int max) {
		return (int) ((Math.random() * (max - min)) + min);
	}
	
	// ______
	// Génère aléatoirement les chambres de l'hotel
	public void generateurHotel() {
		for (int i = 0; i < nbreChambres; i++) {

			Chambre chambre = null;
			
			int rand = getRandomNumber(0, 4);
			
			switch (rand) {
			case 0:
				chambre = new Single();
				break;
			case 1:
				chambre = new Twin();
				break;
			case 2:
				chambre = new Double();
				break;
			case 3:
				chambre = new Suite(2);
				break;
			default:
				break;
			}

			ajouterChambre(chambre);
		}
	}
	
	// ______
	// Renvoie le numéro de la première chambre vide de chaque type
	public int[] premiereLibre(LocalDate date) {
		int rang[] = { 0, 0, 0, 0 };
		for (int i = 0; i < listeChambres.size(); i++) {
			if (listeChambres.get(i) instanceof Single && listeChambres.get(i).getReservations().get(date) == false && rang[0] == 0) {
				rang[0] = i;
			} else if (listeChambres.get(i) instanceof Twin && listeChambres.get(i).getReservations().get(date) == false
					&& rang[1] == 0) {
				rang[1] = i;
			} else if (listeChambres.get(i) instanceof Double && listeChambres.get(i).getReservations().get(date) == false
					&& rang[2] == 0) {
				rang[2] = i;
			} else if (listeChambres.get(i) instanceof Suite && listeChambres.get(i).getReservations().get(date) == false
					&& rang[3] == 0) {
				rang[3] = i;
			}
		}
		return rang;
	}
	
	// ______
	// Affiche le numéro de la première chambre vide de chaque type
	public void affichePremiereLibre(LocalDate date) {
		System.out.printf(
				"Date : %s%nPremière single libre : n°%d%nPremière twin libre : n°%d%nPremière double libre : n°%d%nPremière suite libre : n°%d%n",
				date,premiereLibre(date)[0] + 1, premiereLibre(date)[1] + 1, premiereLibre(date)[2] + 1, premiereLibre(date)[3] + 1);
	}
	
	// ______
	// Renvoie le numéro de la dernière chambre vide de chaque type
	public int[] derniereLibre(LocalDate date) {
		int rang[] = { listeChambres.size(), listeChambres.size(), listeChambres.size(), listeChambres.size() };
		for (int i = listeChambres.size() - 1; i > 0; i--) {
			if (listeChambres.get(i) instanceof Single && listeChambres.get(i).getReservations().get(date) == false
					&& rang[0] == listeChambres.size()) {
				rang[0] = i;
			} else if (listeChambres.get(i) instanceof Twin && listeChambres.get(i).getReservations().get(date) == false
					&& rang[1] == listeChambres.size()) {
				rang[1] = i;
			} else if (listeChambres.get(i) instanceof Double && listeChambres.get(i).getReservations().get(date) == false
					&& rang[2] == listeChambres.size()) {
				rang[2] = i;
			} else if (listeChambres.get(i) instanceof Suite && listeChambres.get(i).getReservations().get(date) == false
					&& rang[3] == listeChambres.size()) {
				rang[3] = i;
			}
		}
		return rang;
	}
	
	// ______
	// Affiche le numéro de la dernière chambre vide de chaque type
	public void afficheDerniereLibre(LocalDate date) {
		System.out.printf(
				"Date : %s%nDernière single libre : n°%d%nDernière twin libre : n°%d%nDernière double libre : n°%d%nDernière suite libre : n°%d%n",
				date, derniereLibre(date)[0] + 1, derniereLibre(date)[1] + 1, derniereLibre(date)[2] + 1, derniereLibre(date)[3] + 1);
	}
	
	// ______
	// Reserve une chambre entre des dates données par l'utilisateur (bornes inclusives)
	public void reservation(Chambre chambre, LocalDate[] dates) {
		reservations.reservation(chambre, dates);
	}
	
	
	
}
