package controler;

public class Munitions extends Objet {

	public Munitions() {
		super();
	}
	public Munitions(int posX, int posY) {
		super(posX, posY);
	}

	@Override
	public void onImpact(Ship joueur) {
		//Nothing to do here
	}
	
	public void onImpact(Debris debris) {
		debris = null;
		System.gc();
	}

}
