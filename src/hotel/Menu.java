package hotel;

import java.util.*;

public class Menu {
	
	private static Scanner sc = new Scanner(System.in);
	
	
	public int choix() {
		System.out.print("Choix : ");
		int choix = sc.nextInt();
		System.out.println();
		return choix;
	}
}
