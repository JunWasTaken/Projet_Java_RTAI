package controler;

/**
 * @author Hassane_lm
 *
 */
public enum Difficulty {
	LOW(1.0) , MEDIUM(1.2) , HIGH(1.4) , SUPERHIGH(1.6);
	
	private double coeff;
	
	private Difficulty(double coeff) {
		this.coeff = coeff;
	}
	
	private double getCoeff() {
		return this.coeff;
	}
}
