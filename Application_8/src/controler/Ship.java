package controler;

import java.util.Arrays;
/**
 * Classe h�ritant de la classe m�re Objet. Repr�sente le vaisseau que le joueur contr�le
 * @author Alexandra Denos, Hassane Lamine
 *
 */
public class Ship extends Objet {
	private int HP;
	private Munitions[] magazine;
	/**
	 * Constructeur de l'objet. Ne prends pas de coordonn�es en param�tre car le vaisseau appara�tra toujours au centre de la zone de jeu. Initialise la valeur des HP � 3 et remplis le chargeur du vaisseau avec 10 munitions.
	 */
	public Ship() {
		super();
		this.HP = 3;
		this.magazine = new Munitions[10];
		this.magazine = new AmmoCrate().getReload();
	}


	/**
	 * 
	 * @return le nombre de HP restant du vaisseau
	 */
	public double getHP() {
		return HP;
	}
	/**
	 * change le nombre de HP du vaisseau par celui pass� en param�tre
	 * @param hP
	 */
	public void setHP(double hP) {
		HP = (int) hP;
	}
	/**
	 * 
	 * @return un tableau de munitions repr�sentant le chargeur du vaisseau
	 */
	public Munitions[] getChargeur() {
		return magazine;
	}
	/**
	 * remplace le chargeur du vaisseau par celui pass� en param�tre
	 * @param chargeur (tableau de munitions)
	 */
	public void setChargeur(Munitions[] chargeur) {
		this.magazine = chargeur;
	}
	/**
	 * Fonction utilis�e � des fins de d�buggage pour afficher les attributs du vaisseau
	 * @return une cha�ne de caract�res repr�sentant les HP et le chargeur du vaisseau
	 */
	@Override
	public String toString() {
		return "Ship [HP=" + HP + ", chargeur=" + Arrays.toString(magazine) + "]";
	}

	/**
	 * Fonction de d�placement de l'objet. Utilise les coordon�es pass�es en param�tres pour remplacer celle de l'objet
	 * @see Objet#setPosX(double)
	 * @see Objet#setPosY(double)
	 * @param posX
	 * @param posY
	 */
	@Override
	public void moving(double posX, double posY) {
		super.setPosX(super.getPosX()+posX);
		super.setPosY(super.getPosY()+posY);
	}
	
	/**
	 * Fonction g�rant l'impact entre un d�bris et le vaisseau, r�duit les HP du vaisseau de 1.
	 * @param debris
	 */
	public void onImpact(Debris debris) {
		this.setHP(this.getHP()-1);
	}
	
	/**
	 * Fonction g�rant l'impact entre le vaisseau et une ammoBox. change le chargeur du vaisseau par le chargeur de l'AmmoBox
	 * @param ammoBox
	 */
	public void onImpact(AmmoBox ammoBox) {
		this.setChargeur(ammoBox.getReload());
	}
	
	/**
	 * @return <code>true</code> si HP du vaisseau est �gal � 0, sinon <code>false</code>
	 */
	public boolean estDetruit() {
		if (this.getHP() == 0)
			return true;
		return false;
	}
	
	/**
	 * Fonction utilis�e lorsque le joueur d�cide de tirer un missile pour d�truire un d�bris 
	 * @return une munition qui a �t� retir� du chargeur du vaisseau si le chargeur n'est pas vide, sinon retourne <code>null</code>
	 */
	public Munitions tirer() {
		Munitions ammo_tmp;
		for (int i=9; i>=0; i--) {

			if (this.magazine[i] != null) {
				ammo_tmp = this.magazine[i];
				this.magazine[i] = null;
				return ammo_tmp;
			}			
		}
		return null;
	}
	/**
	 * 
	 * @param unDebris
	 * @return
	 */
	public boolean impact(Debris unDebris) {
		return getView().getBoundsInParent().intersects(unDebris.getView().getBoundsInParent());
	}

	/**
	 * 
	 * @param uneAmmoBox
	 * @return
	 */
	public boolean impact(AmmoBox uneAmmoBox) {
		// TODO Auto-generated method stub
		return getView().getBoundsInParent().intersects(uneAmmoBox.getView().getBoundsInParent());
	}

	@Override
	public void onImpact(Ship joueur) {
		// TODO Auto-generated method stub
	}
	public boolean impact(AmmoCrate ammocrate) {
		return getView().getBoundsInParent().intersects(ammocrate.getView().getBoundsInParent());
	}
}
