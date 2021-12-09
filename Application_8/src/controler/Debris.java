package controler;
/**
 * 
 * @author Alexandra Denos, Hassane Lamine
 * 
 * Classe héritant de la classe mère Objet et correspondant aux obstacles à éviter ou détruire pour le joueur au cours de la partie.
 *
 */
public class Debris extends Objet {
	
	/**
	 * Créer un nouveau débris en utilisant le constructeur de la classe mère
	 * @see Objet#Objet()
	 */
	public Debris() {
		super();

	}
	/**
	 * Créer un nouveau débris en utilisant le constructeur de la classe mère et en utilisant deux variables en paramètres pour remplacer les coordonnées x et y de l'objet créé
	 * @see Objet#Objet(double, double)
	 * @param posX
	 * @param posY
	 */
	public Debris(double posX, double posY) {
		super(posX, posY);
	}
	
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
	/**
	 * Fonction gérant l'impact entre le débris et le vaisseau du joueur. L'impact entre les deux objets fait perdre 1 HP au vaisseau
	 */
	@Override
	public void onImpact(Ship joueur) {
		joueur.setHP(joueur.getHP()-1);
	}

}
