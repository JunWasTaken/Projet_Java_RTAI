package controler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

public class BestScores implements Serializable {
	private HashMap<String, Integer> TableauScores;

	public BestScores() {
		this.TableauScores = new HashMap<>();	
	}
	
	public void add(String nomJoueur, int score) {
		this.TableauScores.put(nomJoueur, (Integer) score);
	}
	
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
