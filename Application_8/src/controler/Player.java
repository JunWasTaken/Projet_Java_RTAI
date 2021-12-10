package controler;

/**
 * Classe repr�sentant un joueur, la classe n'est utilis�e que lors de la sauvegarde et de la cr�ation de la partie
 * @author Alexandra Denos
 *
 */
public class Player {
	
	private String nom;
	private int score;
	/**
	 * Constructeur de la classe Joueur, le score est initialis� � 0
	 */
	public Player() {
		this.score = 0;
	}
	
	/**
	 * change le nom du joueur par la chaine de caract�re pass�e en commentaire
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return le nom du joueur
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * change le score par l'entier pass� en param�tre
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	/**
	 * 
	 * @return le score du joueur
	 */
	public int getScore() {
		return this.score;
	}
	
}
