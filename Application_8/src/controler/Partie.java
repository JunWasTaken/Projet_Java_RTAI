package controler;


/**
 * @author Hassane_lm
 *
 */
public class Partie {
	
	private int id;
	
	Status status;
	Difficulty difficulty;
	
	public Partie(int id) {
		this.id = id;
		setDifficulty();
		
	}
	
	//ID
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	
	public void sauvegarde() {
		
	}
	

	public void createNewGame() {
		status = Status.LAUNCHE;
		
	}

	//Status

	public void changeStatus(Status status) {
		this.status = status;	
	}
	
	
	
	//DIFFICULTY
	public void setDifficulty() {
		difficulty = Difficulty.LOW;
	}
	
	//Augmente la difficult� d'un cran � chaque appel de fonction
	public void changeDifficulty() {
		
		int rank= difficulty.ordinal();
		difficulty = Difficulty.values()[rank+1];
		
	}
	
}