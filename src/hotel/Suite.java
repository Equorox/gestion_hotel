package hotel;

import java.util.ArrayList;

//  accommodation composée de plusieurs pièces (p. ex. chambre et salon), de meubles supplémentaires, . . .

public class Suite extends Chambre {
	
	private ArrayList<String> pieces = new ArrayList<>();
	private ArrayList<String> meubles = new ArrayList<>();
 	
	public Suite(int places,int nbreLits, boolean reservee) {
		super(places,nbreLits, reservee);
	}
	
}
