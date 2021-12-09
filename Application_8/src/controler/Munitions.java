package controler;

public class Munitions extends Objet {

	public Munitions() {
		super();
	}

	public Munitions(double posX, double posY) {
		super(posX, posY);
	}
		
	@Override

	public void moving(double posX, double posY) {
		this.setPosX(this.getPosX()+posX);
		this.setPosY(this.getPosY()+posY);
	}
	public void moving() {
		this.setPosX(this.getPosX() + velocity.getX());
		this.setPosY(this.getPosY() + velocity.getY());
	}
	@Override
	public void onImpact(Ship joueur) {
		//Nothing to do here
	}
	
	public void onImpact(Debris debris) {
		
	}
	public boolean impact(Debris debris) {
		return getView().getBoundsInParent().intersects(debris.getView().getBoundsInParent());
	}

}
