package controler;
/**
 * 
 * @author Alexandra Denos, Hassane Lamine
 * 
 * Classe h�ritant de la classe m�re Objet et correspondant aux munitions tir�es par le joueur au cours de la partie
 *
 */
public class Munitions extends Objet {

	/**
	 * constructeur par d�faut de la classe
	 */
	public Munitions() {
		super();
	}

	/**
	 * constructeur de la classe prenant en param�tres les coordonn�es de l'objet
	 * @see Objet#Objet(double, double)
	 * @param posX
	 * @param posY
	 */
	public Munitions(double posX, double posY) {
		super(posX, posY);
	}
		
	@Override
	/**
	 * Fonction de d�placement de l'objet. On utilise les coordonn�es pass�es en param�tres pour remplacer celle de l'objet
	 * @see Objet#setPosX(double)
	 * @see Objet#setPosY(double)
	 * @param posX
	 * @param posY
	 */
	public void moving(double posX, double posY) {
		this.setPosX(this.getPosX()+posX);
		this.setPosY(this.getPosY()+posY);
	}
	/**
	 * Fonction de d�placement de l'objet. Utilise l'attribut velocity de l'objet pour g�rer le d�placement
	 * @see Objet#setPosX(double)
	 * @see Objet#setPosY(double)
	 */
	public void moving() {
		this.setPosX(this.getPosX() + velocity.getX());
		this.setPosY(this.getPosY() + velocity.getY());
	}
	@Override
	public void onImpact(Ship joueur) {
		//Nothing to do here
	}
	/**
	 * Fonction g�rant l'impact entre le d�bris et la munition
	 */
	public void onImpact(Debris debris) {
		
	}
	public boolean impact(Debris debris) {
		return getView().getBoundsInParent().intersects(debris.getView().getBoundsInParent());
	}

}
