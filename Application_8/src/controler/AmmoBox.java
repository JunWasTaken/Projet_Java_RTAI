package controler;
/**
 * Classe repr�sentant une caisse de munitions. Sert � recharger les munitions du joueur
 * @author Alexandra Denos, Hassane Lamine
 *
 */
public class AmmoBox extends Objet {
	private Munitions[] reload;
	
	/**
	 * Constructeur de la classe en utilisant lle constructeur de la classe m�re et initialise un tableau de munitions repr�sentant la caisse de munitions
	 * @see Objet#Objet()
	 */
	public AmmoBox() {
		super();
		createAmmoBox();
	}
	/**
	 * Cr�er un nouveau d�bris en utilisant le constructeur de la classe m�re et en utilisant deux variables en param�tres pour remplacer les coordonn�es x et y de l'objet cr��,  initialise un tableau de munitions repr�sentant la caisse de munitions
	 * @see Objet#Objet(double, double)
	 * @param posX
	 * @param posY
	 */
	public AmmoBox(double posX, double posY) {
		super(posX, posY);
		createAmmoBox();
	}
	
	public Munitions[] getReload() {
		return this.reload;
	}
//	@Override
//	public void moving(int posX, int posY) {
//		this.setPosX(this.getPosX()+posX);
//		this.setPosY(this.getPosY()+posY);
//	}
	public void moving(double posX, double posY) {
		this.setPosX(this.getPosX()+posX);
		this.setPosY(this.getPosY()+posY);
	}
	public void moving() {
		this.setPosX(this.getPosX() + velocity.getX());
		this.setPosY(this.getPosY() + velocity.getY());
	}
	@Override
	public void onImpact(Ship joueur) {
		joueur.setChargeur(this.reload);
	}

	private void createAmmoBox() {
		this.reload = new Munitions[10];
		for (int i=0; i<10; i++) {
			this.reload[i] = new Munitions();
		}
	}
}
