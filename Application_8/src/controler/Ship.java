package controler;

import java.util.Arrays;

public class Ship extends Objet {
	private int HP;
	private double HP;
	private Munitions[] magazine;
	
	public Ship() {
		super();
		this.HP = 3;
		this.magazine = new Munitions[10];
		this.magazine = new AmmoCrate().getReload();
	}

	public double getHP() {
		return HP;
	}
	public void setHP(double hP) {
		HP = hP;
	}
	public Munitions[] getChargeur() {
		return magazine;
	}
	public void setChargeur(Munitions[] chargeur) {
		this.magazine = chargeur;
	}
	@Override
	public String toString() {
		return "Ship [HP=" + HP + ", chargeur=" + Arrays.toString(magazine) + "]";
	}

	@Override
	public void moving(double posX, double posY) {
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
		Munitions ammo_tmp;
		for (int i=9; i>=0; i++) {
		for (int i=9; i>=0; i--) {
			if (this.magazine[i] != null) {
				ammo_tmp = this.magazine[i];
				this.magazine[i] = null;
				return ammo_tmp;
			}
		}
		return null;
	}
}
