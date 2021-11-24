package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import controler.Munitions;
import controler.Partie;
import controler.Player;
import controler.Ship;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author Hassane_lm
 * 
 */
public class MainController {

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
	Pane spaceBackgroundPane;
	@FXML
	Pane gamePane;

	@FXML
	ImageView logo;

	List<String> themePane; //liste des themes.
	int count; //Cet attribut nous permet de  selectionner le theme suivant.

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

	
	int hpSize;
	ImageView hpTable[]; //Tableau permettant l'affichage des images de points d'hp.

	
	
	
	Label munitionLabel;
	Label scoreLabel;
	Player playerScore;
	
	Partie partie;

	ImageView shipImg;
	public Ship ship;
	
	private AnimationTimer gameTimer;
	
	private double rayonShip;//	Le rayon par rapport à la position du vaisseau.

	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private boolean isUpKeyPressed;
	private boolean isDownKeyPressed;
	private int angle;

	private boolean hasExceededLeft;
	private boolean hasExceededRight;
	private boolean hasExceededUp;
	private boolean hasExceededDown;

	private int distance;

	
	

	/******************************************
	 *********  I. INTERFACE MENU  ************
	 */
	
	
	
	/*
	 * 	Affichage des fenêtres (Pane) souhaitées en fonction du menu :
	 */

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
	 * Mise en place du bouton radio :
	 * 
	 * @param event button radio
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

		shipImgChoosen(); //Selection du vaisseau.
	}

	/**
	 * Selection du vaisseau correspondant au bouton radio :
	 */
	public void shipImgChoosen() {
		switch (radioButton.getId()) {
		case "redRadioButton" :
			shipImg = new ImageView("/img/playerShip1_red.png");
			break;
		case "orangeRadioButton" :
			shipImg = new ImageView("/img/playerShip1_orange.png");
			break;
		case "greenRadioButton" :
			shipImg = new ImageView("/img/playerShip1_green.png");
			break;
		case "blueRadioButton" :
			shipImg = new ImageView("/img/playerShip1_blue.png");
			break;
		}
	}

	/**
	 * 
	 */
	public void play() {
		if(shipImg != null) {
			//		spaceBackgroundPane.setVisible(false);
			partie = new controler.Partie();
			playerScore = new controler.Player();
			
			startPane.setVisible(false);
			TranslateTransition transition = new TranslateTransition();
			transition.setDuration(Duration.seconds(0.4));
			transition.setNode(logo);
			transition.setByX(-1000);
			transition.play();
			setScoreLabel();
			setHpLabel();		
			setMunitionsLabel();
			setTimeLabel();		
			setShip(); 			
			createGame();

		}

	}

	/**
	 * Affichage du vaissau au centre de l'arène : 
	 */
	public void setShip() {
		shipImg.setFitWidth(99 / 1.4);
		shipImg.setFitHeight(75 / 1.4);
		shipImg.setLayoutX((gamePane.getWidth() / 2));
		shipImg.setLayoutY((gamePane.getHeight() / 2));
		gamePane.getChildren().add(shipImg);

		ship = new Ship();
	}


	/**
	 * Affichage du label "score" :
	 */
	public void setScoreLabel() {
		scoreLabel = new Label();
		int score=1;// à supprimer...
		scoreLabel.setText("Score : "+score);
		scoreLabel.setLayoutX(1100);
		scoreLabel.setLayoutY(40);
		scoreLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 40));
		mainPane.getChildren().add(scoreLabel);	
		
		
	}

	/**
	 * Affichage des points de vie (hp) :
	 */
	public void setHpLabel() {
		hpTable = new ImageView[3];
		int xCoordonnees=0;

		//J'affiche les points d'hp		
		for(int i=0; i<hpTable.length; i++) {
			hpTable[i] = new ImageView("img/hp.png");
			hpTable[i].setFitWidth(80);
			hpTable[i].setFitHeight(80);
			hpTable[i].setLayoutX(xCoordonnees+=90);
			hpTable[i].setLayoutY(40);
			mainPane.getChildren().add(hpTable[i]);
		}
		hpSize = hpTable.length;//J'instancie la variable hpSize.		
	}

	/**
	 * Suppression d'un point de vie :
	 */
	public void removeHpLabel() {
		if(hpSize>0) {
			hpSize--;
			hpTable[hpSize].setVisible(false);
		}
	}

	/**
	 *	Affichage des munitions : 
	 */
	public void setMunitionsLabel() {
		munitionLabel = new Label();

		ImageView munitionImg = new ImageView("img/munitions.png"); 
		munitionImg.setFitWidth(80);
		munitionImg.setFitHeight(80);
		munitionImg.setLayoutX(90);
		munitionImg.setLayoutY(640);
		mainPane.getChildren().add(munitionImg);

		munitionLabel.setText("0");
		munitionLabel.setLayoutX(170);
		munitionLabel.setLayoutY(674);
		munitionLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 40));
		mainPane.getChildren().add(munitionLabel);	
	}

	public void setTimeLabel() {

	}
	
	/**
	 * @param munitions
	 */
	public void changeMunitionLabel() {
//À REVOIR...
//		String munition;

//		for (int i=0; i<ship.getChargeur().length; i++) {
//			if(ship.getChargeur()[i] != null) {
//				munition = 
//			}
//		}
//		munitionLabel.setText((ship.getChargeur().length).toString());
	}

	public void changeScoreLabel() {
		scoreLabel.setText("Score : "+String.valueOf(playerScore.getScore()));
	}
	

	/**
	 * @param event
	 * Cette fonction permet de changer le theme (couleur) et d'appliquer ce theme aux boutons :
	 */
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







	/**********************************************
	 *********  II. INTERFACE IN GAME  ************
	 */

	

	
	public void createGame() {
		createKeyListeners();
		createGameLoop();
	}

	public void createKeyListeners() {
		mainPane.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent arg0) {
				if(arg0.getCode() == KeyCode.Q) {
					isLeftKeyPressed = true;
				}else if(arg0.getCode() == KeyCode.D) {
					isRightKeyPressed = true;
				}else if(arg0.getCode() == KeyCode.Z) {
					isUpKeyPressed = true;
				}else if(arg0.getCode() == KeyCode.S) {
					isDownKeyPressed = true;
				}
			}

		});
		mainPane.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				if(arg0.getCode() == KeyCode.Q) {
					isLeftKeyPressed = false;
				}else if(arg0.getCode() == KeyCode.D) {
					isRightKeyPressed = false;
				}else if(arg0.getCode() == KeyCode.Z) {
					isUpKeyPressed = false;
				}else if(arg0.getCode() == KeyCode.S) {
					isDownKeyPressed = false;
				}

			}
		});
	}

	public void moveShip() {
		//On determine les coodronées du centre de notre cercle :		
		final double centreX = gamePane.getWidth() / 2; //Coordonnée x
		final double centreY = gamePane.getHeight() / 2; //Coordonnée y
		double rayonGame = centreY;	


		//test :
//		System.out.println(rayonShip);
//		System.out.println(rayonGame);
//		System.out.println("LEFT "+hasExceededLeft);
//		System.out.println("RIGHT "+hasExceededRight);
//		System.out.println("UP "+hasExceededUp);
//		System.out.println("DOWN "+hasExceededDown);
		
		
		//Si rayon du vaisseau < à rayon du cercle on remet tout à "false" :		
		if(rayonShip < rayonGame) {
			hasExceededLeft = false;
			hasExceededRight = false;
			hasExceededUp = false;
			hasExceededDown = false;
		}

		//MOVING LEFT
		if(isLeftKeyPressed && !isRightKeyPressed) {
			//Rotation pour test :
			if (angle > -30) {
				angle -= 5;
			}
			shipImg.setRotate(angle);

			/*	On verifie si la variable booléenne est false, ce qui veut dire que le vaisseau n'a pas atteint les limites du cercle,
			*	S'il atteint la limite (en comparant son rayon par rapport à celui du cercle), on met la variable booléenne à true.
			**/
			if(!hasExceededLeft) {
				shipImg.setLayoutX(shipImg.getLayoutX() -distance); //Je fais avancer le vaisseau.
				rayonShip = Math.sqrt(Math.pow((shipImg.getLayoutX() - centreX) , 2) + Math.pow((shipImg.getLayoutY() - centreY), 2));
				if(rayonShip > rayonGame) {
					distance = 6;
					hasExceededLeft = true;
				}else {distance = 3;}
			}

		}
		
		//MOVING RIGHT
		if(!isLeftKeyPressed && isRightKeyPressed) {
			if (angle < 30) {
				angle += 5;
			}
			shipImg.setRotate(angle);

			if(!hasExceededRight) {
				shipImg.setLayoutX(shipImg.getLayoutX() + distance);
				rayonShip = Math.sqrt(Math.pow((shipImg.getLayoutX() - centreX) , 2) + Math.pow((shipImg.getLayoutY() - centreY), 2));
				if(rayonShip > rayonGame) {
					distance = 6;
					hasExceededRight = true;
				}else {distance = 3;}
			}
		}
//		Les deux fonctions suivantes sont à supprimer surrement, car la rotation sera génerée par la souris :
		if(!isLeftKeyPressed && !isRightKeyPressed) {
			if(angle > 0) {
				angle -= 5;
			}else if(angle < 0) {
				angle += 5;
			}
			shipImg.setRotate(angle);
		}
		if(isLeftKeyPressed && isRightKeyPressed) {
			if(angle > 0) {
				angle -= 5;
			}else if(angle < 0) {
				angle += 5;
			}
			shipImg.setRotate(angle);
		}

		//MOVING UP
		if(isUpKeyPressed && !isDownKeyPressed) {
			if(!hasExceededUp) {
				shipImg.setLayoutY(shipImg.getLayoutY() -distance);
				rayonShip = Math.sqrt(Math.pow((shipImg.getLayoutX() - centreX) , 2) + Math.pow((shipImg.getLayoutY() - centreY), 2));
				if(rayonShip > rayonGame) {
					distance = 6;
					hasExceededUp = true;
				}else {distance = 3;}
			}
		}
		//MOVING DOWN
		if(isDownKeyPressed && !isUpKeyPressed) {
			if(!hasExceededDown) {
				shipImg.setLayoutY(shipImg.getLayoutY() +distance);
				rayonShip = Math.sqrt(Math.pow((shipImg.getLayoutX() - centreX) , 2) + Math.pow((shipImg.getLayoutY() - centreY), 2));
				if(rayonShip > rayonGame) {
					distance = 6;
					hasExceededDown = true;
				}else {distance = 3;}
			}	
		}
		
		gamePane.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
			
				System.out.println(arg0.getX());
				System.out.println(arg0.getY());
			}
		});
	}

	private void createGameLoop() {
		gameTimer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				moveShip();
				changeMunitionLabel();
				changeScoreLabel();
			}
		};
		gameTimer.start();
	}



}
