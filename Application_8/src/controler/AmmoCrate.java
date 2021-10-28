package controler;

public class AmmoCrate extends Objet {

	public AmmoCrate() {
		super();
	}
	
	public AmmoCrate(int posX, int posY) {
		super(posX, posY);
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
		// TODO Auto-generated method stub

	}

}
