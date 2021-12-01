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
import javafx.geometry.Point2D;
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
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
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
	AnchorPane gameAnchorPane;
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
	private List<RadioButton> buttonList;

	@FXML
	Button playButton;
	@FXML
	Button themeButton;


	int hpSize;
	ImageView hpTable[]; //Tableau permettant l'affichage des images de points d'hp.




	Label munitionLabel;
	Label scoreLabel;
	controler.Player playerScore;

	Partie partie;

	controler.Munitions munition;
	ImageView munitionImg;
	private double angleMunition;

	ImageView shipImg;
	public Ship ship;
	private double centerShipX;
	private double centerShipY;

	private AnimationTimer gameTimer;

	private double rayonShip;//	Le rayon par rapport à la position du vaisseau.
	private double rayonGame;
	private double rayonMunition;
	private double centreX;
	private double centreY;

	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private boolean isUpKeyPressed;
	private boolean isDownKeyPressed;
	private double angle;
	private double mouseCoordX;//Coordonnées par rapport au centre du vaisseau.
	private double mouseCoordY;//Idem.

	private double mouseX;//Coordonnées par rapport à la fenetre.
	private double mouseY;//Idem.

	private boolean hasExceededLeft;
	private boolean hasExceededRight;
	private boolean hasExceededUp;
	private boolean hasExceededDown;

	private int distance;

	private long lastTimeShot;

	private List<Munitions> munitions = new ArrayList<>();;





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
	 * Affichage du vaissau au centre de l'arène : 
	 */
	public void setShip() {
		ship = new Ship();

		shipImg.setFitWidth(99 / 1.4);
		shipImg.setFitHeight(75 / 1.4);
		centerShipX = shipImg.getFitWidth() / 2;
		centerShipY = shipImg.getFitHeight() / 2;

		ship.setPosX((gamePane.getWidth() / 2) - centerShipX);
		ship.setPosY((gamePane.getWidth() / 2) - centerShipY);

		shipImg.setLayoutX(ship.getPosX());
		shipImg.setLayoutY(ship.getPosY());
		gamePane.getChildren().add(shipImg);

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
		int compt=0;
		for(Munitions munition : ship.getChargeur()) {
			if(munition != null) {
				compt++;
			}
		}
		munitionLabel.setText(String.valueOf(compt));
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

			centreX = gamePane.getWidth() / 2; //Coordonnée x du point central
			centreY = gamePane.getHeight() / 2; //Coordonnée y
			rayonGame = centreY;	
			
			setShip();
			createGame();

			
		}

	}





	/**********************************************
	 *********  II. INTERFACE IN GAME  ************
	 */




	public void createGame() {
		createKeyListeners();
		createGameLoop();
	}

	public void createKeyListeners() {
		gameAnchorPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				System.out.println("KEY PRESSED : "+ arg0.getCode());
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
		gameAnchorPane.setOnKeyReleased(new EventHandler<KeyEvent>() {
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

		//Si rayon du vaisseau < à rayon du cercle on remet tout à "false" :		
		if(rayonShip < rayonGame) {
			hasExceededLeft = false;
			hasExceededRight = false;
			hasExceededUp = false;
			hasExceededDown = false;
		}

		//MOVING LEFT
		if(isLeftKeyPressed && !isRightKeyPressed) {


			/*	On verifie si la variable booléenne est false, ce qui veut dire que le vaisseau n'a pas atteint les limites du cercle,
			 *	S'il atteint la limite (en comparant son rayon par rapport à celui du cercle), on met la variable booléenne à true.
			 **/
			if(!hasExceededLeft) {
				ship.setPosX(ship.getPosX() -distance);
				shipImg.setLayoutX(ship.getPosX());
				//				shipImg.setLayoutX(shipImg.getLayoutX() -distance); //Je fais avancer le vaisseau.
				rayonShip = Math.sqrt(Math.pow(((shipImg.getLayoutX() + centerShipX) - centreX) , 2) + Math.pow(((shipImg.getLayoutY() + centerShipY) - centreY), 2));
				if(rayonShip > rayonGame) {
					distance = 6;
					hasExceededLeft = true;
				}else {distance = 3;}
			}

		}

		//MOVING RIGHT
		if(!isLeftKeyPressed && isRightKeyPressed) {

			if(!hasExceededRight) {
				ship.setPosX(ship.getPosX() +distance);
				shipImg.setLayoutX(ship.getPosX());
				rayonShip = Math.sqrt(Math.pow(((shipImg.getLayoutX() + centerShipX) - centreX) , 2) + Math.pow(((shipImg.getLayoutY() + centerShipY) - centreY), 2));
				if(rayonShip > rayonGame) {
					distance = 6;
					hasExceededRight = true;
				}else {distance = 3;}
			}
		}

		//MOVING UP
		if(isUpKeyPressed && !isDownKeyPressed) {
			if(!hasExceededUp) {
				ship.setPosY(ship.getPosY() -distance);
				shipImg.setLayoutY(ship.getPosY());
				rayonShip = Math.sqrt(Math.pow(((shipImg.getLayoutX() + centerShipX)- centreX) , 2) + Math.pow(((shipImg.getLayoutY() + centerShipY) - centreY), 2));
				if(rayonShip > rayonGame) {
					distance = 6;
					hasExceededUp = true;
				}else {distance = 3;}
			}
		}
		//MOVING DOWN
		if(isDownKeyPressed && !isUpKeyPressed) {
			if(!hasExceededDown) {
				ship.setPosY(ship.getPosY() +distance);
				shipImg.setLayoutY(ship.getPosY());
				rayonShip = Math.sqrt(Math.pow(((shipImg.getLayoutX() + centerShipX) - centreX) , 2) + Math.pow(((shipImg.getLayoutY() + centerShipY) - centreY), 2));
				if(rayonShip > rayonGame) {
					distance = 6;
					hasExceededDown = true;
				}else {distance = 3;}
			}	
		}
	}
	
	private void rotateShip() {
		//SET ROTATION
		gameAnchorPane.setOnMouseMoved(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub

				mouseCoordX = arg0.getX() - (shipImg.getLayoutX() + 333 + centerShipX); //Coordonne du curseur par rapport au vaisseau.
				mouseCoordY = arg0.getY() - (shipImg.getLayoutY() + 34 + centerShipY); 

				double rayonMouse = Math.sqrt(Math.pow(mouseCoordX,2) + Math.pow(- mouseCoordY, 2)); //Le moins devant le y c'est parceque l'axe des ordonnées sont inversées sur l'interface.
				double coteOppose = Math.sqrt(Math.pow(mouseCoordX, 2) + Math.pow(- mouseCoordY - rayonMouse, 2)) / 2;
				double coteHypotenuse = rayonMouse;
				angle = Math.asin(coteOppose / coteHypotenuse) / Math.PI * 180;

				if(mouseCoordX < 0) {
					shipImg.setRotate(- (angle * 2));
				}else {
					shipImg.setRotate(angle * 2);
				}

			}
		});
	}


	private void setMunition() {

		munition.setPosX(ship.getPosX());
		munition.setPosY(ship.getPosY());
		
		munition.setView(new ImageView("/img/laserBlue06.png"));
		munition.getView().setLayoutX(munition.getPosX() + (shipImg.getFitWidth() / 2));
		munition.getView().setLayoutY(munition.getPosY() + (shipImg.getFitHeight() / 2));
		munition.getView().setRotate(shipImg.getRotate());
		
		munition.setVelocity(new Point2D(Math.cos(Math.toRadians(shipImg.getRotate()-90)), Math.sin(Math.toRadians(shipImg.getRotate()-90)))
				.normalize().multiply(6));			
		
		gamePane.getChildren().add(munition.getView());
	}


	private void launchMunition() {
		gameAnchorPane.setOnMousePressed(new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent arg0) {
				munition = ship.tirer();
				
				if(munition != null) {
					setMunition();
					munitions.add(munition);
				}
			}
		});
		
		if(munition != null) {
			for(int i=0; i<munitions.size(); i++) {
				
				munitions.get(i).moving();
				
				munitions.get(i).getView().setLayoutX(munitions.get(i).getPosX());
				munitions.get(i).getView().setLayoutY(munitions.get(i).getPosY());
				
				rayonMunition = Math.sqrt(Math.pow((munitions.get(i).getPosX() - centreX) , 2) + Math.pow((munitions.get(i).getPosY() - centreY), 2));

				if(rayonMunition > 600) {
					munitions.remove(i);
				}
			}		
		}
	}


	private void createGameLoop() {
		gameTimer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				moveShip();
				rotateShip();
				launchMunition();

				changeMunitionLabel();
				changeScoreLabel();

			}
		};
		gameTimer.start();
	}



}
