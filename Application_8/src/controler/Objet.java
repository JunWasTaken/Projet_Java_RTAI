package controler;

public abstract class Objet {
	private int posX, posY;

	public Objet() {
		this.posX = 0; 
		this.posY = 0;
	}
	
	public Objet(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	@Override
	public String toString() {
		return "Objet [posX=" + posX + ", posY=" + posY + "]";
	}

	public abstract void moving(int posX, int posY);
	public abstract void onImpact(Ship joueur);
}
