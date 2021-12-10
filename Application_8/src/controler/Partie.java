package controler;


/**
 * Classe représentant une partie et son déroulement
 * @author Alexandra Denos, Hassane Lamine
 *
 */
public class Partie {
	
	private int id;
	
	Status status;
	Difficulty difficulty;
	
	private PlayArea playArea;
	
	/**
	 * Constructeur de la partie, initie une nouvelle partie
	 */
	public Partie() {
		createNewGame();
		
	}
	
	/**
	 * change l'id de la partie par l'id passé en paramètre
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return l'id de la partie
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * change le statut de la partie en 'Launch'
	 */
	public void play() {
		status = Status.LAUNCHE;
	}
	public void sauvegarde() {
		
	}
	
	/**
	 * créé une nouvelle partie
	 */
	public void createNewGame() {
		status = Status.LAUNCHE;
		setDifficulty();
	}

	/**
	 * 
	 * @return le statut de la partie
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * change le statut par le statut passé en paramètre
	 * @param status
	 */
	public void changeStatus(Status status) {
		this.status = status;	
	}
	
	/**
	 * change la difficulté en la remplaçant par une difficulté basse
	 */
	public void setDifficulty() {
		difficulty = Difficulty.LOW;
	}
	
	/**
	 * Augmente la difficulté de la partie d'un cran à chaque appel de fonction
	 */
	public void changeDifficulty() {
		
		int rank= difficulty.ordinal();
		difficulty = Difficulty.values()[rank+1];
		
	}
	
}