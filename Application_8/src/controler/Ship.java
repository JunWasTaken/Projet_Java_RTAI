package controler;

import java.util.ArrayList;
import java.util.Arrays;

public class Ship extends Objet {
	private int HP;
	private ArrayList<Munitions> magazine;
	
	public Ship() {
		super();
		this.HP = 3;
		this.magazine = new ArrayList<>();
		this.magazine = new AmmoCrate().getReload();
	}

	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public ArrayList getChargeur() {
		return magazine;
	}
	public void setChargeur(ArrayList<Munitions> reload) {
		this.magazine = reload;
	}
	@Override
	public String toString() {
		return "Ship [HP=" + HP + ", chargeur=" + magazine.toString() + "]";
	}

	@Override
	public void moving(int posX, int posY) {
		super.setPosX(super.getPosX()+posX);
		super.setPosY(super.getPosY()+posY);
	}

	@Override
	public void onImpact(Ship joueur) {
		//rien � mettre dans cette fonction
	}
	
	public void onImpact(Debris debris) {
		this.setHP(this.getHP()-1);
	}
	
	public boolean estDetruit() {
		if (this.getHP() == 0)
			return true;
		return false;
	}
	
	public Munitions tirer() {
		try {
			return this.magazine.remove(this.magazine.size()-1);
		}catch (Exception e) {
			System.err.println(e.toString());
			return null;
		}
	}
}
