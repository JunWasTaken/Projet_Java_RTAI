package controler;

import java.util.Arrays;

public class Ship extends Objet {
	private int HP;
	private Munitions[] chargeur;
	
	public Ship() {
		super();
		this.HP = 3;
		this.chargeur = new Munitions[10];
		for(Munitions ammo : chargeur) {
			ammo = new Munitions();
		}
	}

	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public Munitions[] getChargeur() {
		return chargeur;
	}
	public void setChargeur(Munitions[] chargeur) {
		this.chargeur = chargeur;
	}
	@Override
	public String toString() {
		return "Ship [HP=" + HP + ", chargeur=" + Arrays.toString(chargeur) + "]";
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
	
	public void tirer() {
		
	}
}
