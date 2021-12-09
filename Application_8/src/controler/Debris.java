package controler;

public class Debris extends Objet {
	
	public Debris() {
		super();

	}
	public Debris(double posX, double posY) {
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
		joueur.setHP(joueur.getHP()-1);
	}

}
