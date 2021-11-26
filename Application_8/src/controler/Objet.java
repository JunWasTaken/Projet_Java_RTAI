package controler;

public abstract class Objet {
	private double posX, posY;

	public Objet() {
		this.posX = 0; 
		this.posY = 0;
	}
	
	public Objet(int posX, int posY) {
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
	
	public void moving(int posX, int posY) {
		this.setPosX(this.getPosX()+posX);
		this.setPosY(this.getPosY()+posY);
	};
	public abstract void onImpact(Ship joueur);
}
