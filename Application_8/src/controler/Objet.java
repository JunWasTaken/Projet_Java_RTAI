package controler;

public abstract class Objet {

	public Objet() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract void moving(int posX, int posY);
	public abstract void onImpact(Ship joueur);
}
