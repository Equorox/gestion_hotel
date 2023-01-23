package hotel;
//commentaire sarah
public class Client {

	protected int nbrePersonnes;
	private String nom;
	
	public Client(int nbrePersonnes, String nom) {
		this.nbrePersonnes=nbrePersonnes;
		this.nom=nom;
	}
	
	public int getNbre(){
		return this.nbrePersonnes;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setNbre(int nbrePersonnes) {
		this.nbrePersonnes=nbrePersonnes;
	}
	
	public void setNom(String nom) {
		this.nom=nom;
	}
}
