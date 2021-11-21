package application;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * @author Hassane_lm
 * 
 */
public class MainController {
	/* Déclaration des éléments graphiques */
	
	private static final String FONT_PATH ="/font/SpaceRaveItalic.ttf";
	
	@FXML
	Label startLabel;
	@FXML
	Label optionsLabel;
	@FXML
	Label creditsLabel;
	@FXML
	ImageView arrawBack;
	
	@FXML
	Pane mainPane;
	@FXML
	Pane homePane;
	@FXML
	Pane startPane;
	@FXML
	Pane optionsPane;
	@FXML
	Pane scoresPane;
	@FXML
	Pane creditsPane;
	@FXML
	Pane inGamePane;
	@FXML 
	Pane spaceBackgroundPane;
	
	@FXML
	ImageView logo;
	
	List<String> themePane; //liste des themes
	int count; //Cet attribut nous permet de  selectionner le theme suivant
	
	@FXML
	RadioButton redRadioButton;
	@FXML
	RadioButton orangeRadioButton;
	@FXML
	RadioButton greenRadioButton;
	@FXML
	RadioButton blueRadioButton;
	
	RadioButton radioButton;
	List<RadioButton> buttonList;
	
	@FXML
	Button playButton;
	@FXML
	Button themeButton;
	
	
	
	public void setHome(Event event) {
		System.out.println(startLabel.getFont());
//		startLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 40));
		homePane.setVisible(true);
		startPane.setVisible(false);
		optionsPane.setVisible(false);
		scoresPane.setVisible(false);
		creditsPane.setVisible(false);
		
	}
	public void setStartPane() {
		homePane.setVisible(false);
		startPane.setVisible(true);
	}
	
	public void setOptionsPane() {
		homePane.setVisible(false);
		optionsPane.setVisible(true);
	}
	
	public void setScorePane() {
		homePane.setVisible(false);
		scoresPane.setVisible(true);
	}
	public void setCreditsPane() {
		homePane.setVisible(false);
		creditsPane.setVisible(true);
	}
	
	/* 
	 * Mise en place du fonctionement du bouton radio.
	 * 
	 * @param event
	 */
	public void chooseRadioButton(Event event) {
		System.out.println(event.getSource());
		radioButton = (RadioButton) event.getSource();
		
		buttonList = new ArrayList<>();
		
		buttonList.add(orangeRadioButton);
		buttonList.add(redRadioButton);
		buttonList.add(greenRadioButton);
		buttonList.add(blueRadioButton);
		

		for(int i=0; i<buttonList.size(); i++) {
			buttonList.get(i).setSelected(false);
		}radioButton.setSelected(true);
	}
	
	public void play() {
//		inGamePane.setVisible(true);
//		spaceBackgroundPane.setVisible(false);
		startPane.setVisible(false);
		TranslateTransition transition = new TranslateTransition();
		transition.setDuration(Duration.seconds(0.3));
		transition.setNode(logo);
		transition.setByX(-1000);
		transition.play();
		Label scoreLabel = new Label();
		
		/**********************
		ICIIIIIIII à voir ce qu'est les methodes static
		***********************/
		int score=1;// à supprimer.
		scoreLabel.setText("Score : "+score);
	}
	
//	Cette fonction permet de changer le theme (couleur) et d'appliquer ce theme aux boutons.
	public void changeTheme(Event event) {
		themePane = new ArrayList<>();
		themePane.add("pink");
		themePane.add("orange");
		themePane.add("green");
		themePane.add("blue");
		
		count++;
		if(count > 3) {
			count = 0;
		}
		
		mainPane.setStyle("-fx-background-image: url('/img/theme_"+ themePane.get(count) +".png'); -fx-background-size: cover;");
		
		playButton.setId(themePane.get(count)+"Button");
		themeButton.setId(themePane.get(count)+"Button");
		
	}
	
	
}
