package application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import controler.AmmoBox;
import controler.Debris;
import controler.Munitions;
import controler.Partie;
import controler.Player;
import controler.Ship;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	@FXML
	Pane gameOverPane;
	@FXML
	TextField textFieldPseudo;
	@FXML
	TableView tableScoreOver;
	@FXML
	Label labelRestart;
	@FXML
	Label labelMainMenu;


	int hpSize;
	ImageView hpTable[]; //Tableau permettant l'affichage des images de points d'hp.




	Label munitionLabel;
	Label scoreLabel;
	controler.Player player;

	Partie partie;

	controler.Munitions munition;
	ImageView munitionImg;
	private double angleMunition;

	ImageView shipImg;
	public Ship ship;
	private double centerShipX;
	private double centerShipY;

	private AnimationTimer gameTimer;

	private double rayonShip;//	Le rayon par rapport � la position du vaisseau.
	private double rayonGame;
	private double rayonMunition;
	private double centreX;
	private double centreY;

	private boolean isLeftKeyPressed;
	private boolean isRightKeyPressed;
	private boolean isUpKeyPressed;
	private boolean isDownKeyPressed;
	private boolean isLeftRotateKeyPressed;
	private boolean isRightRotateKeyPressed;
	private double angle;
	private double mouseCoordX;//Coordonn�es par rapport au centre du vaisseau.
	private double mouseCoordY;//Idem.

	private double mouseX;//Coordonn�es par rapport � la fenetre.
	private double mouseY;//Idem.

	private boolean hasExceededLeft;
	private boolean hasExceededRight;
	private boolean hasExceededUp;
	private boolean hasExceededDown;

	private int distance;

	private long lastTimeShot;

	private List<Munitions> munitions = new ArrayList<>();
	private List<Debris> debris = new ArrayList<>();
	private List<AmmoBox> ammoBox = new ArrayList<>();
	
	private double hp;
	private int countScore;




	/******************************************
	 *********  I. INTERFACE MENU  ************
	 */



	/*
	 * 	Affichage des fen�tres (Pane) souhait�es en fonction du menu :
	 */

	public void setHome(Event event) {
		System.out.println(startLabel.getFont());
		//		startLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 40));
		homePane.setVisible(true);
		startPane.setVisible(false);
		optionsPane.setVisible(false);
		scoresPane.setVisible(false);
		creditsPane.setVisible(false);
		gameOverPane.setVisible(false);

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
	public void setGameOverPane() {
		homePane.setVisible(false);
		gameOverPane.setVisible(true);
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
	 * Affichage du vaissau au centre de l'ar�ne : 
	 */
	public void setShip() {
		ship = new Ship();

		ship.setView(shipImg);
		((ImageView) ship.getView()).setFitWidth(99 / 1.4);
		((ImageView) ship.getView()).setFitHeight(75 / 1.4);
		
		centerShipX = ((ImageView) ship.getView()).getFitWidth() / 2;
		centerShipY = ((ImageView) ship.getView()).getFitHeight() / 2;

		ship.setPosX((gamePane.getWidth() / 2) - centerShipX);
		ship.setPosY((gamePane.getWidth() / 2) - centerShipY);

		ship.getView().setLayoutX(ship.getPosX());
		ship.getView().setLayoutY(ship.getPosY());
		
		gamePane.getChildren().add(ship.getView());

	}
	
	public void deleteShip() {
		
		gamePane.getChildren().clear();

	}


	/**
	 * Affichage du label "score" :
	 */
	public void setScoreLabel() {
		scoreLabel = new Label();
		scoreLabel.setText("Score : "+player.getScore());
		scoreLabel.setLayoutX(1100);
		scoreLabel.setLayoutY(40);
		scoreLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 40));
		mainPane.getChildren().add(scoreLabel);	
	}
	
	public void deleteScoreLabel() {
		mainPane.getChildren().clear();	
	}
	
	/**
	 * Affichage du label "temp" :
	 */
	private static int m2, m1, s2, s1;
	private static String tempScore;
	public void setTempLabel() {		
	       
		Label timeLabel = new Label();
		timeLabel.setText("00:00");
		timeLabel.setLayoutX(1125);
		timeLabel.setLayoutY(650);
		timeLabel.setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 50));
		mainPane.getChildren().add(timeLabel); //A finir
		m2 = 0; m1 = 0; s2 = 0; s1 = 0;	
		
		Timer chrono = new Timer();
		chrono.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				s1++;
				if(s1 == 10) {
					s1 = 0;
					s2++;	
				}
				if(s2 == 6) {
					s2 = 0;
					m1++;
				}
				if(m1 == 10) {
					m1 = 0;
					m2++;	
				}

				Platform.runLater (() -> timeLabel.setText(m2 + "" + m1 + ":" + s2 + "" + s1));
				tempScore = timeLabel.getText();
				
			}
			
		}, 1000, 1000);
		
	}
	
	public void deleteTempLabel() {		
	       
		mainPane.getChildren().clear();
		
	}
	
	private static String tempScoreDef;
	public void stopTempLabel() {		
	       
		tempScoreDef = tempScore;
		
	}

	/**
	 * Affichage des points de vie (hp) :
	 */
	public void setHpLabel() {
		hpTable = new ImageView[3];
		int xCoordonnees=0;

		//J'affiche les points d'hp:	
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
	public void changeHpLabel() {
		if(hpSize>0) {
			hpSize--;
			hpTable[hpSize].setVisible(false);
		}
		if(hpSize==0) {
			gameOver();
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
	
	public void deleteMunitionsLabel() {

		mainPane.getChildren().clear();	
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
		scoreLabel.setText("Score : "+String.valueOf(player.getScore()));
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
	private static TranslateTransition transition = new TranslateTransition();
	public void play() {
		if(shipImg != null) {
			//		spaceBackgroundPane.setVisible(false);
			partie = new controler.Partie();
			player = new controler.Player();

			startPane.setVisible(false);
			transition.setDuration(Duration.seconds(0.4));
			transition.setNode(logo);
			transition.setByX(-1000);
			transition.play();
			setScoreLabel();
			setHpLabel();		
			setMunitionsLabel();
			setTimeLabel();
			setTempLabel();
			
			centreX = gamePane.getWidth() / 2; //Coordonn�e x du point central
			centreY = gamePane.getHeight() / 2; //Coordonn�e y
			rayonGame = centreY;	
			
			setShip();
//			setDebris();
			createGame();

			
		}

	}
	
	public void gameOver() {
		gameOverPane.setVisible(true);
		
		deleteScoreLabel();		
		deleteMunitionsLabel();
		deleteTempLabel();
		stopTempLabel();	
		gameTimer.stop();
		deleteShip();
		deleteMunition();
		deleteDebris();
		deleteLaunchMunition();

	}






	/**********************************************
	 *********  II. INTERFACE IN GAME  ************
	 */

	private void setAmmoBox() {
		if(Math.random()<0.03) {
			double x = Math.random() * 1000;
			double y = Math.random() * 1000;
			double rayonRandom = Math.sqrt(Math.pow((x - centreX) , 2) + Math.pow((y - centreY), 2));
			if(rayonRandom > rayonGame+30) {
				
				AmmoBox uneAmmoBox = new AmmoBox(x, y);
				uneAmmoBox.setView(new ImageView("/img/ammunition_box.png"));
				uneAmmoBox.getView().setLayoutX(uneAmmoBox.getPosX());
				uneAmmoBox.getView().setLayoutY(uneAmmoBox.getPosY());	
				
				uneAmmoBox.setVelocity(new Point2D(Math.cos(Math.toRadians(Math.random() * 360)), Math.sin(Math.toRadians(Math.random()*360)))
						.normalize().multiply(4));	
				
				ammoBox.add(uneAmmoBox);
				gamePane.getChildren().add(uneAmmoBox.getView());
			}	
		}
		for(int i=0; i<ammoBox.size(); i++) {
			ammoBox.get(i).moving();
			ammoBox.get(i).getView().setLayoutX(ammoBox.get(i).getPosX());
			ammoBox.get(i).getView().setLayoutY(ammoBox.get(i).getPosY());
		}
		if(ammoBox.size()>15) {
			ammoBox.remove(1);
			System.out.println(ammoBox.size());
		}
	}	
	
	private void setDebris() {
		if(Math.random()<0.09) {
			double x = Math.random() * 1000;
			double y = Math.random() * 1000;
			double rayonRandom = Math.sqrt(Math.pow((x - centreX) , 2) + Math.pow((y - centreY), 2));
			if(rayonRandom > rayonGame+30) {
				
				Debris unDebri = new Debris(x, y);
				unDebri.setView(new ImageView("/img/meteorBrown_med1.png"));
				unDebri.getView().setLayoutX(unDebri.getPosX());
				unDebri.getView().setLayoutY(unDebri.getPosY());	
				
				unDebri.setVelocity(new Point2D(Math.cos(Math.toRadians(Math.random() * 360)), Math.sin(Math.toRadians(Math.random()*360)))
						.normalize().multiply(4));	
				
				debris.add(unDebri);
				gamePane.getChildren().add(unDebri.getView());
			}	
		}
		for(int i=0; i<debris.size(); i++) {
			debris.get(i).moving();
			debris.get(i).getView().setLayoutX(debris.get(i).getPosX());
			debris.get(i).getView().setLayoutY(debris.get(i).getPosY());
		}
		if(debris.size()>15) {
			debris.remove(1);
			System.out.println(debris.size());
		}
	}
	
	private void deleteDebris() {
				
		gamePane.getChildren().clear();
		
	}

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
				}else if(arg0.getCode() == KeyCode.O) {
					isLeftRotateKeyPressed = true;
				}else if(arg0.getCode() == KeyCode.P) {
					isRightRotateKeyPressed = true;
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
				}else if(arg0.getCode() == KeyCode.O) {
					isLeftRotateKeyPressed =false;
				}else if(arg0.getCode() == KeyCode.P) {
					isRightRotateKeyPressed = false;
				}

			}
		});
	}


	public void moveShip() {	
		//Si rayon du vaisseau < � rayon du cercle on remet tout � "false" :		
		if(rayonShip < rayonGame) {
			hasExceededLeft = false;
			hasExceededRight = false;
			hasExceededUp = false;
			hasExceededDown = false;
		}

		//MOVING LEFT
		if(isLeftKeyPressed && !isRightKeyPressed) {


			/*	On verifie si la variable bool�enne est false, ce qui veut dire que le vaisseau n'a pas atteint les limites du cercle,
			 *	S'il atteint la limite (en comparant son rayon par rapport � celui du cercle), on met la variable bool�enne � true.
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

				double rayonMouse = Math.sqrt(Math.pow(mouseCoordX,2) + Math.pow(- mouseCoordY, 2)); //Le moins devant le y c'est parceque l'axe des ordonn�es sont invers�es sur l'interface.
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
	
	private void deleteMunition() {

		gamePane.getChildren().clear();
		munitions.clear();
		
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
	
	private void deleteLaunchMunition() {
	
		munitions.clear();
		
	}

	private void checkIfColision() {
		for	(Debris unDebris : debris){
			if(ship.impact(unDebris)){
				gamePane.getChildren().remove(unDebris.getView());
				
        		ship.onImpact(unDebris);
        		changeHpLabel();
        		
        		debris.remove(unDebris);
        	}
		}
		for (Munitions munition : munitions) {
            for (Debris unDebris : debris) {
            	
                if(munition.impact(unDebris)) {
                	gamePane.getChildren().removeAll(munition.getView(), unDebris.getView());
                	
                	unDebris.onImpact(ship);
                	
                	countScore++;
                	player.setScore(countScore);
                	changeScoreLabel();
                	
                	munitions.remove(munition);
                    debris.remove(unDebris);
                    
                }
            }
        }
		for	(AmmoBox uneAmmoBox : ammoBox){
			if(ship.impact(uneAmmoBox)){
				gamePane.getChildren().remove(uneAmmoBox.getView());
				
        		ship.onImpact(uneAmmoBox);
        		ship.getChargeur();
        		
        		ammoBox.remove(uneAmmoBox);
        	}
		}
	}
	
	
	private void createGameLoop() {
		gameTimer = new AnimationTimer() {
			@Override
			public void handle(long arg0) {
				moveShip();
				rotateShip();
				setDebris();
				launchMunition();
				checkIfColision();
				setAmmoBox();
				changeMunitionLabel();
				changeScoreLabel();
				
				

			}

		};
		gameTimer.start();
	}



}
