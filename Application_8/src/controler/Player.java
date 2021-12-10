package controler;

/**
 * Classe représentant un joueur, la classe n'est utilisée que lors de la sauvegarde et de la création de la partie
 * @author Alexandra Denos
 *
 */
public class Player {
	
	private String nom;
	private int score;
	/**
	 * Constructeur de la classe Joueur, le score est initialisé à 0
	 */
	public Player() {
		this.score = 0;
	}
	
	/**
	 * change le nom du joueur par la chaine de caractère passée en commentaire
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
	 * change le score par l'entier passé en paramètre
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
