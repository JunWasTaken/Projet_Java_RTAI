package controler;
/**
 * 
 * @author Alexandra Denos, Hassane Lamine
 * 
 * Classe h�ritant de la classe m�re Objet et correspondant aux obstacles � �viter ou d�truire pour le joueur au cours de la partie.
 *
 */
public class Debris extends Objet {
	
	/**
	 * Cr�er un nouveau d�bris en utilisant le constructeur de la classe m�re
	 * @see Objet#Objet()
	 */
	public Debris() {
		super();

	}
	/**
	 * Cr�er un nouveau d�bris en utilisant le constructeur de la classe m�re et en utilisant deux variables en param�tres pour remplacer les coordonn�es x et y de l'objet cr��
	 * @see Objet#Objet(double, double)
	 * @param posX
	 * @param posY
	 */
	public Debris(double posX, double posY) {
		super(posX, posY);
	}
	
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
	/**
	 * Fonction g�rant l'impact entre le d�bris et le vaisseau du joueur. L'impact entre les deux objets fait perdre 1 HP au vaisseau
	 */
	@Override
	public void onImpact(Ship joueur) {
		joueur.setHP(joueur.getHP()-1);
	}

}
