package controler;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Objet {
	private ImageView view;
	private double posX, posY;
	public Point2D velocity = new Point2D(0, 0);

	public Objet() {
		this.posX = 0; 
		this.posY = 0;
	}
	
	public Objet(double posX, double posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public double getPosX() {
		return posX;
	}
	public void setPosX(double posX) {
		this.posX = posX;
	}
	public double getPosY() {
		return posY;
	}
	public void setPosY(double posY) {
		this.posY = posY;
	}
	@Override
	public String toString() {
		return "Objet [posX=" + posX + ", posY=" + posY + "]";
	}

	public abstract void moving(double posX, double posY);
	public abstract void onImpact(Ship joueur);

	public Point2D getVelocity() {
		return velocity;
	}

	public void setVelocity(Point2D velocity) {
		this.velocity = velocity;
	}

	public Node getView() {
		return view;
	}

	public void setView(ImageView view) {
		this.view = view;
	}
}
