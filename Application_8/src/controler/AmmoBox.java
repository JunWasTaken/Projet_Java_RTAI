package controler;

public class AmmoBox extends Objet {
	
	public AmmoBox() {
		super();

	}
	public AmmoBox(double posX, double posY) {
		super(posX, posY);
	}
	
//	@Override
//	public void moving(int posX, int posY) {
//		this.setPosX(this.getPosX()+posX);
//		this.setPosY(this.getPosY()+posY);
//	}
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
		joueur.getChargeur();
	}

}
