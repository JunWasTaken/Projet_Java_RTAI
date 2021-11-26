package controler;

public class Player {
	
	private String nom;
	private static int score = 0;
	
	public Player() {
		score = 0;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return this.score;
	}
	
	public static void increaseScore() {
		score += 100;
	}
	
}
