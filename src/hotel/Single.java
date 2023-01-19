package hotel;

// deux lits ou un grand lit, réservée pour une personne

public class Single extends Chambre{
	
	public Single(int nbreLits, boolean reservee) {
		super(1, nbreLits, reservee);
	}
	
}
