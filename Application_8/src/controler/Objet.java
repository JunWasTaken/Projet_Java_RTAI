package controler;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * @author Alexandra Denos, Hassane Lamine
 * 
 * Classe abstraite et coeur du programme. Tous les objets du programme héritent de cette classe, c'est à partir de cette classe que l'on va gérer tout ce qui concerne les déplacements des objets.
 * 
 * */
public abstract class Objet {
	private ImageView view;
	private double posX, posY;
	public Point2D velocity = new Point2D(0, 0);

	/**
	 * Constructeur par défaut de la classe Objet, initie la position de l'objet aux coordonnées centrales 0, 0
	 */
	public Objet() {
		this.posX = 0; 
		this.posY = 0;
	}
	
	/**
	 * Constructeur de la classe prenant en charge deux paramètres définissant les coordonnées auxquels l'objet apparaîtra
	 * @param posX
	 * @param posY
	 */
	public Objet(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * 
	 * @return la coordonnées x de l'objet
	 */
	public double getPosX() {
		return posX;
	}
	/**
	 * change la position x de l'objet par celle passée en paramètre
	 * @param posX
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}
	/**
	 * 
	 * @return la coordonnée y de l'objet
	 */
	public double getPosY() {
		return posY;
	}
	/**
	 * change la position y de l'objet par celle passée en paramètre
	 * @param posY
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}
	/**
	 * fonction utilisée à des fins de débuggage pour avoir des informations sur la position de l'objet
	 * @return les coordonnées de l'objet sous forme de chaîne de caractère
	 */
	@Override
	public String toString() {
		return "Objet [posX=" + posX + ", posY=" + posY + "]";
	}

	/**
	 * fonction utilisée par les classes filles pour gérer le déplacement de l'objet
	 * @param posX
	 * @param posY
	 */
	public abstract void moving(double posX, double posY);
	/**
	 * fonction utilisée par les classes filles pour gérer l'impact entre l'objet et l'objet vaisseau
	 * @param joueur
	 */
	public abstract void onImpact(Ship joueur);

	/**
	 * @return l'attribut velocity de l'objet (la vitesse de l'objet)
	 */
	public Point2D getVelocity() {
		return velocity;
	}

	/**
	 * change la vélocité de l'objet par la valeur passée en paramètre
	 * @param velocity
	 */
	public void setVelocity(Point2D velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return l'attribut view de l'objet (le noeud FX représentant l'objet)
	 */
	public Node getView() {
		return view;
	}

	/**
	 * change l'attribut view de l'objet par celui passé en paramètre
	 * @param view
	 */
	public void setView(ImageView view) {
		this.view = view;
	}
}
