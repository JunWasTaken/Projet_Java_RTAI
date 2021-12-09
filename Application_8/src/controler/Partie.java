package controler;


/**
 * @author Hassane_lm
 *
 */
public class Partie {
	
	private int id;
	
	Status status;
	Difficulty difficulty;
	
	private PlayArea playArea;
	
	public Partie() {
		createNewGame();
		
	}
	
	//ID
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	public void play() {
		status = Status.LAUNCHE;
	}
	public void sauvegarde() {
		
	}
	
	public void createNewGame() {
		status = Status.LAUNCHE;
		setDifficulty();
	}

	//Status
	public Status getStatus() {
		return status;
	}
	
	public void changeStatus(Status status) {
		this.status = status;	
	}
	
	//DIFFICULTY
	public void setDifficulty() {
		difficulty = Difficulty.LOW;
	}
	
	//Augmente la difficulté d'un cran à chaque appel de fonction
	public void changeDifficulty() {
		
		int rank= difficulty.ordinal();
		difficulty = Difficulty.values()[rank+1];
		
	}
	
}