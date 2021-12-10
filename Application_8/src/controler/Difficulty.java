package controler;

/**
 * Enumération correspondant à la difficulté du jeu, la difficulté augmente avec le temps
 * @author Hassane_lm
 *
 */
public enum Difficulty {
	LOW(1.0) , MEDIUM(1.2) , HIGH(1.4) , SUPERHIGH(1.6);
	
	private double coeff;
	
	/**
	 * Constructeur des valeurs de l'énumération, prends un double en paramètre pour définir le coeff
	 * @param coeff
	 */
	private Difficulty(double coeff) {
		this.coeff = coeff;
	}
	
	/**
	 * @return le coefficient de la valeur
	 */
	private double getCoeff() {
		return this.coeff;
	}
}
