package controler;

import java.util.Arrays;
/**
 * Ancienne classe gérant les déplacements des boîtes de munitions
 * @see AmmoBox
 * @deprecated
 * @author Alexandra Denos
 *
 */

public class AmmoCrate extends Objet {
	private Munitions[] reload;

	public AmmoCrate() {
		super();
		this.reload = new Munitions[10];
		for (int i=0; i<10; i++) {
			this.reload[i] = new Munitions();
		}
	}
	
	public AmmoCrate(double posX, double posY) {
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
	 * posX reste le mÃªme car déplacement uniquement horizontal
	 * posY est une addition cf grille dans OtherStuff*/
	@Override
	public void moving(double posX, double posY) {
		super.setPosX(posX);
		super.setPosY(super.getPosY()+posY);
	}

	/**
	 * remplit le tableau reload de cette classe avec 10 objets de type Munitions
	 */
	@Override
	public void onImpact(Ship joueur) {
		joueur.setChargeur(this.reload);
	}

}
