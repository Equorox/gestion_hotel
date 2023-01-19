package hotel;

public class Chambre {
	
	protected int places;
	protected boolean reservee;
	protected int nbreLits;
	
	public Chambre(int places,int nbreLits, boolean reservee) {
		this.places=places;
		this.reservee=reservee;
		this.nbreLits=nbreLits;
	}
	
	public boolean getReservee() {
		return this.reservee;
	}
	
	public int getPlaces(){
		return this.places;
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
