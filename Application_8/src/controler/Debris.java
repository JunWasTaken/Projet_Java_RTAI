package controler;

public class Debris extends Objet {
	
	public Debris() {
		super();
	}
	public Debris(int posX, int posY) {
		super(posX, posY);
	}
	
	@Override
	public void moving(int posX, int posY) {
		this.setPosX(this.getPosX()+posX);
		this.setPosY(this.getPosY()+posY);
	public void moving(double posX, double posY) {
	}

	@Override
	public void onImpact(Ship joueur) {
		joueur.setHP(joueur.getHP()-1);
	}

}
