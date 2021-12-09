package controler;
/**
 * Classe représentant une caisse de munitions. Sert à recharger les munitions du joueur
 * @author Alexandra Denos, Hassane Lamine
 *
 */
public class AmmoBox extends Objet {
	private Munitions[] reload;
	
	/**
	 * Constructeur de la classe en utilisant lle constructeur de la classe mère et initialise un tableau de munitions représentant la caisse de munitions
	 * @see Objet#Objet()
	 */
	public AmmoBox() {
		super();
		createAmmoBox();
	}
	/**
	 * Créer un nouveau débris en utilisant le constructeur de la classe mère et en utilisant deux variables en paramètres pour remplacer les coordonnées x et y de l'objet créé,  initialise un tableau de munitions représentant la caisse de munitions
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
	/**
	 * Fonction de déplacement de l'objet. On utilise les coordonnées passées en paramètres pour remplacer celle de l'objet
	 * @see Objet#setPosX(double)
	 * @see Objet#setPosY(double)
	 * @param posX
	 * @param posY
	 */
	public void moving(double posX, double posY) {
		this.setPosX(this.getPosX()+posX);
		this.setPosY(this.getPosY()+posY);
	}
	/**
	 * Fonction de déplacement de l'objet. Utilise l'attribut velocity de l'objet pour gérer le déplacement
	 * @see Objet#setPosX(double)
	 * @see Objet#setPosY(double)
	 */
	public void moving() {
		this.setPosX(this.getPosX() + velocity.getX());
		this.setPosY(this.getPosY() + velocity.getY());
	}
	/**
	 * Fonction gérant l'impact de l'objet avec le joueur. on utilise la fonction setChargeur du vaisseau avec l'attribut reload de cette classe
	 * @see Ship#setChargeur(Munitions[])
	 * @param Ship
	 */
	@Override
	public void onImpact(Ship joueur) {
		joueur.setChargeur(this.reload);
	}

	/**
	 * remplit le tableau reload de cette classe avec 10 objets de type Munitions
	 */
	private void createAmmoBox() {
		this.reload = new Munitions[10];
		for (int i=0; i<10; i++) {
			this.reload[i] = new Munitions();
		}
	}
}
