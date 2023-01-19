package hotel;

public class Chambre {
	
	protected int places;
	protected boolean reservee;
	protected int nbreLits;
	protected float tarif;
	

	
	public Chambre(int places, int nbreLits, float tarif, boolean reservee) {
		this.places=places;
		this.reservee=reservee;
		this.nbreLits=nbreLits;
		this.tarif=tarif;
	}
	
	public boolean getReservee() {
		return this.reservee;
	}
	
	public int getPlaces(){
		return this.places;
	}
	
	public float getTarif() {
		return this.tarif;
	}
	
	public int getLits() {
		return this.nbreLits;
	}
	
	public void setReservee(boolean reservee) {
		this.reservee=reservee;
	}
	
	public void setPlaces(int places) {
		this.places=places;
	}
	
	
}
