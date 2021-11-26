package controler;

import java.util.ArrayList;
import java.util.Arrays;

public class AmmoCrate extends Objet {
	private ArrayList<Munitions> reload;

	public AmmoCrate() {
		super();
		this.reload = new ArrayList<>();
		for (int i=0; i<10; i++) {
			this.reload.add(new Munitions());
		}
	}
	
	public AmmoCrate(int posX, int posY) {
		super(posX, posY);
		this.reload = new ArrayList<>();
		for (int i=0; i<10; i++) {
			this.reload.add(new Munitions());
		}
	}

	public ArrayList<Munitions> getReload() {
		return reload;
	}
	public void setReload(ArrayList<Munitions> reload) {
		this.reload = reload;
	}

	@Override
	public String toString() {
		return "AmmoCrate [reload=" + reload.toString() + "]";
	}

	/*
	 * fonction de déplacement des ammoCrates
	 * posX reste le même car déplacement uniquement horizontal
	 * posY est une addition cf grille dans OtherStuff*/
	@Override
	public void moving(int posX, int posY) {
		super.setPosX(posX);
		super.setPosY(super.getPosY()+posY);
	}

	@Override
	public void onImpact(Ship joueur) {
		joueur.setChargeur(this.reload);
	}

}
