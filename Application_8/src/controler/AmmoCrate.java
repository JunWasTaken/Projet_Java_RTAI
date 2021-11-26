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

	@Override
	public void onImpact(Ship joueur) {
		joueur.setChargeur(this.reload);
	}

}
