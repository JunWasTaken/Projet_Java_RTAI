package controler;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 * @author Alexandra Denos, Hassane Lamine
 * 
 * Classe abstraite et coeur du programme. Tous les objets du programme h�ritent de cette classe, c'est � partir de cette classe que l'on va g�rer tout ce qui concerne les d�placements des objets.
 * 
 * */
public abstract class Objet {
	private ImageView view;
	private double posX, posY;
	public Point2D velocity = new Point2D(0, 0);

	/**
	 * Constructeur par d�faut de la classe Objet, initie la position de l'objet aux coordonn�es centrales 0, 0
	 */
	public Objet() {
		this.posX = 0; 
		this.posY = 0;
	}
	
	/**
	 * Constructeur de la classe prenant en charge deux param�tres d�finissant les coordonn�es auxquels l'objet appara�tra
	 * @param posX
	 * @param posY
	 */
	public Objet(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	/**
	 * 
	 * @return la coordonn�es x de l'objet
	 */
	public double getPosX() {
		return posX;
	}
	/**
	 * change la position x de l'objet par celle pass�e en param�tre
	 * @param posX
	 */
	public void setPosX(double posX) {
		this.posX = posX;
	}
	/**
	 * 
	 * @return la coordonn�e y de l'objet
	 */
	public double getPosY() {
		return posY;
	}
	/**
	 * change la position y de l'objet par celle pass�e en param�tre
	 * @param posY
	 */
	public void setPosY(double posY) {
		this.posY = posY;
	}
	/**
	 * fonction utilis�e � des fins de d�buggage pour avoir des informations sur la position de l'objet
	 * @return les coordonn�es de l'objet sous forme de cha�ne de caract�re
	 */
	@Override
	public String toString() {
		return "Objet [posX=" + posX + ", posY=" + posY + "]";
	}

	/**
	 * fonction utilis�e par les classes filles pour g�rer le d�placement de l'objet
	 * @param posX
	 * @param posY
	 */
	public abstract void moving(double posX, double posY);
	/**
	 * fonction utilis�e par les classes filles pour g�rer l'impact entre l'objet et l'objet vaisseau
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
	 * change la v�locit� de l'objet par la valeur pass�e en param�tre
	 * @param velocity
	 */
	public void setVelocity(Point2D velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return l'attribut view de l'objet (le noeud FX repr�sentant l'objet)
	 */
	public Node getView() {
		return view;
	}

	/**
	 * change l'attribut view de l'objet par celui pass� en param�tre
	 * @param view
	 */
	public void setView(ImageView view) {
		this.view = view;
	}
}
