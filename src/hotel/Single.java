package hotel;

// deux lits ou un grand lit, réservée pour une personne

public class Single extends Chambre{
	
	public Single(boolean reservee) {
		super(1, 10, reservee);
	}
	
}
