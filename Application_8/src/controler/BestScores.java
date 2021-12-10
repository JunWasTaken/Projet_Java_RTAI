package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
/**
 * Gestion des scores de la partie, de leur sauvegarde et de leur chargement. Les scores sont stockées dans une hashmap avec pour clé le nom du joueur
 * @author Alexandra
 *
 */
public class BestScores implements Serializable {
	private HashMap<String, Integer> TableauScores;

	/**
	 * Constructeur de la classe, initialise une nouvelle HashMap;
	 */
	public BestScores() {
		this.TableauScores = new HashMap<>();	
	}
	
	/**
	 * Ajoute un nouveau score à la liste
	 * @param nomJoueur
	 * @param score
	 */
	public void add(String nomJoueur, int score) {
		this.TableauScores.put(nomJoueur, (Integer) score);
	}
	
	/**
	 * Sauvegarde la hashmap de la classe. Les scores sont dans le fichier high_scores.data
	 */
	public void save() {
		try {
			FileOutputStream savefile = new FileOutputStream(new File("high_scores.data"));
			ObjectOutputStream obj = new ObjectOutputStream(savefile);
			obj.writeObject(this);
			obj.close();
		}catch (Exception e) {
			System.err.println(e.toString());
		}
	}
	
	/**
	 * charge les scores depuis le fichier high_scores.data
	 * @return un objet de type BestScores avec une hashmap contenant les scores et les clés
	 */
	public static BestScores load() {
		BestScores o = new BestScores();
		try {
			FileInputStream savefile = new FileInputStream(new File("high_scores.data"));
			ObjectInputStream obj = new ObjectInputStream(savefile);
			o = (BestScores) obj.readObject();
			obj.close();
		}catch (Exception e) {
			System.err.println(e.toString());
		}
		return o;
	}
}
