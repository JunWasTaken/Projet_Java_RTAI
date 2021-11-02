package controler;

import java.util.Arrays;

public class AmmoCrate extends Objet {
	private Munitions[] reload;

	public AmmoCrate() {
		super();
		this.reload = new Munitions[10];
		for (int i=0; i<10; i++) {
			this.reload[i] = new Munitions();
		}
	}
	
	public AmmoCrate(int posX, int posY) {
		super(posX, posY);
		this.reload = new Munitions[10];
		for (int i=0; i<10; i++) {
			this.reload[i] = new Munitions();
		}
	}

	public Munitions[] getReload() {
		return reload;
	}
	public void setReload(Munitions[] reload) {
		this.reload = reload;
	}

	@Override
	public String toString() {
		return "AmmoCrate [reload=" + Arrays.toString(reload) + "]";
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
