package controler;

public class Debris extends Objet {
	
	public Debris() {
		super();
	}
	public Debris(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public void onImpact(Ship joueur) {
		joueur.setHP(joueur.getHP()-1);
	}

}
