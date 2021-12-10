package controler;
/**
 * 
 * @author Alexandra Denos, Hassane Lamine
 * 
 * Classe héritant de la classe mère Objet et correspondant aux munitions tirées par le joueur au cours de la partie
 *
 */
public class Munitions extends Objet {

	/**
	 * constructeur par défaut de la classe
	 */
	public Munitions() {
		super();
	}

	/**
	 * constructeur de la classe prenant en paramètres les coordonnées de l'objet
	 * @see Objet#Objet(double, double)
	 * @param posX
	 * @param posY
	 */
	public Munitions(double posX, double posY) {
		super(posX, posY);
	}
		
	@Override
	/**
	 * Fonction de déplacement de l'objet. On utilise les coordonnées passées en paramètres pour remplacer celle de l'objet
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
	 * Fonction de déplacement de l'objet. Utilise l'attribut velocity de l'objet pour gérer le déplacement
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
	 * Fonction gérant l'impact entre le débris et la munition
	 */
	public void onImpact(Debris debris) {
		
	}
	public boolean impact(Debris debris) {
		return getView().getBoundsInParent().intersects(debris.getView().getBoundsInParent());
	}

}
