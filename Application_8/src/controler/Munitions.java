package controler;

public class Munitions extends Objet {

	public Munitions() {
		super();
	}
	public Munitions(int posX, int posY) {
		super(posX, posY);
	}
		
	@Override
	public void moving(int posX, int posY) {
		this.setPosX(this.getPosX()+posX);
		this.setPosY(this.getPosY()+posY);
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
