
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Author: Domenic Rocchio
 * 
 */
public class Game extends Frame implements MouseListener {

	/**
	 * I am creating four card objects to be use throughout the program Two will
	 * be one persons and two more will be another players.
	 * 
	 * I then will have a display of river and a flop which consists of 5 cards
	 * total.
	 */
	private Card player1Card1, player1Card2, player2Card1, player2Card2, flop1, flop2, flop3, turn, river;
	/**
	 * deck to be used for the game
	 */
	private Deck deck = new Deck();

	private Abutton playButton, resetButton, quitButton, foldButton, checkButton, raiseButton, callButton;

	/**
	 * So the System doesn't try to paint the buttons before they are
	 * initialized
	 */
	private boolean complete = false;

	/**
	 * x and y coordinate of the mouse click
	 */
	private int xValue, yValue;

	/**
	 * lowColor is the color when the button is down, highColor when the button
	 * is up
	 */
	private Color lowColor, highColor;

	int clicks = 0;
	private boolean up;
	private boolean flopOccured = false;
	private boolean turnOccured = false;
	private boolean riverOccured = false;
	private boolean gameStarted = false;

	public Game() {

		setTitle("Texas Holdem"); // The title of the program frame
		setSize(600, 600); // Size of the program frame
		setLocation(300, 100); // Location where the frame will appear
		setBackground(Color.white);// Set the background color to be white

		Window myWindow = new Window();// to allow for window closing
		addWindowListener(myWindow);// A must for AWT to close the window

		setVisible(true);

		addMouseListener(this);// so you can handle the mouse clicks
		
		
		
		// I create my three buttons of different colors
		playButton = new Abutton("Play", Color.green, 125, 400, 100, 50);
		resetButton = new Abutton("Reset", Color.yellow, 250, 400, 100, 50);
		quitButton = new Abutton("Quit", Color.red, 375, 400, 100, 50);
		
		//creates the deck to be used in the game
		//pulls cards from the 
		deck = new Deck();
		
		//there is an initial shuffle in the deck constructor but this is just another shuffle
		deck.shuffle();
		
		// Showing that the program is ready to execute
		complete = true;

	}

	/**
	 * The mouseClicked method is where you collect any information you need for
	 * painting properly. If the mouse is clicked in either button you'll want
	 * to flip that button, and you'll want to get the coordinates so you can
	 * mark where the click has taken place.
	 */
	public void mouseClicked(MouseEvent event) {

		// The values of where the mouse is clicked
		// and sets them to the xValue and yValue
		xValue = event.getX();
		yValue = event.getY();

		// my test to see if the mouse click is
		// inside the boundries of the button
		// If it is, I create new cards that will be
		// The cards that are being compared in
		// the game of war.
		if (playButton.isInside(xValue, yValue)) {
			if( clicks == 0){
				gameStarted = true;
				player1Card1 = deck.drawCard();
				player1Card1.setLocation(100, 100);
				player1Card2 = deck.drawCard();
				player1Card2.setLocation(200, 100);
				player2Card1 = deck.drawCard();
				player2Card1.setLocation(325, 100);
				player2Card2 = deck.drawCard();
				player2Card2.setLocation(425, 100);
				raiseButton = new Abutton("Raise", Color.blue, 75, 475, 100, 50);
				foldButton = new Abutton("Fold", Color.red, 200, 475, 100, 50);
				checkButton = new Abutton("Check", Color.white, 325, 475, 100, 50);
				callButton = new Abutton("Call", Color.pink, 450, 475, 100, 50);
				clicks ++;
			}
			else{
					gameStarted = false;
					clicks = 0;
					repaint();
				}
		}

		else if (resetButton.isInside(xValue, yValue)) {
			// Makes it so that my cards disappear
			// When the reset button is pressed.
			gameStarted = false;
			repaint();
		}
		else if (raiseButton.isInside(xValue, yValue)) {
			//TODO
			if (clicks == 1){
				flopOccured = true;
				flop1 = deck.drawCard();
				flop1.setLocation(75, 250);
				flop2 = deck.drawCard();
				flop2.setLocation(150, 250);
				flop3 = deck.drawCard();
				flop3.setLocation(225, 250);
				clicks++;
				
			}
			else if(clicks == 2){
				turnOccured = true;
				turn = deck.drawCard();
				turn.setLocation(300,250);
				clicks++;
				}
			else if(clicks == 3){
				riverOccured = true;
				river = deck.drawCard();
				river.setLocation(375, 250);
				clicks++;
				}
			else if(clicks > 4){
				
				}
			}		
				
		
		else if (foldButton.isInside(xValue, yValue)) {
			gameStarted = false;
			flopOccured = true;
			riverOccured = true;
			turnOccured = true;
			System.out.println("You Give up!");
			repaint();
			
		}
		else if (checkButton.isInside(xValue, yValue)) {
			if (clicks == 1){
				flopOccured = true;
				flop1 = deck.drawCard();
				flop1.setLocation(75, 250);
				flop2 = deck.drawCard();
				flop2.setLocation(150, 250);
				flop3 = deck.drawCard();
				flop3.setLocation(225, 250);
				clicks++;
				
			}
			else if(clicks == 2){
				turnOccured = true;
				turn = deck.drawCard();
				turn.setLocation(300,250);
				clicks++;
				}
			else if(clicks == 3){
				riverOccured = true;
				river = deck.drawCard();
				river.setLocation(375, 250);
				clicks++;
				}
			else if(clicks > 4){
				
				}
			}		
		else if (callButton.isInside(xValue, yValue)) {
			if (clicks == 1){
				flopOccured = true;
				flop1 = deck.drawCard();
				flop1.setLocation(75, 250);
				flop2 = deck.drawCard();
				flop2.setLocation(150, 250);
				flop3 = deck.drawCard();
				flop3.setLocation(225, 250);
				clicks++;
				
			}
			else if(clicks == 2){
				turnOccured = true;
				turn = deck.drawCard();
				turn.setLocation(300,250);
				clicks++;
				}
			else if(clicks == 3){
				riverOccured = true;
				river = deck.drawCard();
				river.setLocation(375, 250);
				clicks++;
				}
			else if(clicks > 4){
				}
			}		
		repaint();
	}

	/**
	 * mousePressed is triggered on the downstroke of a mouse click (or if the
	 * user holds the button down)
	 */
	public void mousePressed(MouseEvent event) {

		// The values of where the mouse is clicked
		// and sets them to the xValue and yValue
		xValue = event.getX();
		yValue = event.getY();

		// Just like before, tests if the click is inside
		// And if it is it updates the frame
		// by showing that the button is pressed
		// using flip()
		if (playButton.isInside(xValue, yValue)) {
			playButton.flip();
			gameStarted = true;
			repaint();// updates the frame
		}

		// Same thing, shows the button flipped if inside the boundaries
		else if (resetButton.isInside(xValue, yValue)) {
			resetButton.flip();
			repaint();
		}

		// Same thing, shows the button flipped if inside the boundaries
		else if (quitButton.isInside(xValue, yValue)) {
			quitButton.flip();
			repaint();
		}

	}

	/**
	 * mouseReleased is triggered on the release of the mouse button, (the
	 * upstroke of a click or when it's released after being held down).
	 * 
	 */
	public void mouseReleased(MouseEvent event) {

		// The values of where the mouse is clicked
		// and sets them to the xValue and yValue
		xValue = event.getX();
		yValue = event.getY();

		// Same thing, shows the button flipped if inside the boundaries
		if (playButton.isInside(xValue, yValue)) {
			playButton.flip();
			repaint();
		}

		// Same thing, shows the button flipped if inside the boundaries
		else if (resetButton.isInside(xValue, yValue)) {
			resetButton.flip();
			repaint();
		}

		// Same thing, shows the button flipped if inside the boundaries
		else if (quitButton.isInside(xValue, yValue)) {
			quitButton.flip();
			repaint();
			System.exit(1);
		}
	}
	
	 /**
	  * what is thegamescore
	  */
     
	 public boolean winner1 = false;
	 public boolean winner2 = false; 
	 public boolean winnerDealer = false;



	/**
	 * The game rules method which begins the comparison between both cards And
	 * takes their rank as a parameter
	 * @return 
	 */
	public void gameRules() {
		// If their values are equal
		if(((player1Card1.getValue() + player1Card2.getValue())/2 > (flop1.getValue() + flop2.getValue() + flop3.getValue() + river.getValue() + turn.getValue())/5 && (player1Card1.getValue() + player1Card2.getValue())/2 > (player2Card1.getValue() + player2Card2.getValue())/2))
		{
			winner1 = true;
			
		}
		else if ((player2Card1.getValue() + player2Card2.getValue())/2 > (flop1.getValue() + flop2.getValue() + flop3.getValue() + river.getValue() + turn.getValue()/5) && (player2Card1.getValue() + player2Card2.getValue())/2 > (player1Card1.getValue() + player1Card2.getValue())/2){
			winner2 = true;
		}
		else {
			winnerDealer = true;
		}
		}

		// Otherwise it takes the score and adds
		// To it the value of tie to the second power
		// Because is the rule when it comes to ties.
		

	/**
	 * This is my entire paint method that paints everything That is going to be
	 * in the frame
	 */
	public void paint(Graphics pane) {
		if (complete) {
			Graphics2D pane2 = (Graphics2D) pane;
			pane.drawString("You", 180, 90);
			pane.drawString("Computer", 380, 90);
			pane.drawString("Flop", 170, 240);
			pane.drawString("Turn", 320, 240);
			pane.drawString("River", 400, 240);
			pane.drawString("The Winner is:", 270, 65);
			
			// This is where the color will change showing
			// when a button is pressed
			pane2.setColor(up ? highColor : lowColor);
			
			playButton.paint(pane);
			resetButton.paint(pane);
			quitButton.paint(pane);
			
			if(gameStarted){
				player1Card1.paint(pane);
				player1Card2.paint(pane);
				player2Card1.paint(pane);
				player2Card2.paint(pane);
				raiseButton.paint(pane);
				checkButton.paint(pane);
				foldButton.paint(pane);
				callButton.paint(pane);
		}
			
			if(flopOccured){
				flop1.paint(pane);
				flop2.paint(pane);
				flop3.paint(pane);
			}
			if(turnOccured){
				turn.paint(pane);
			}
			if(riverOccured){
				river.paint(pane);
				if(winner1 = true){
					pane.drawString("YOU!!",270, 85);
				}
				else if(winner2 = true){
					pane.drawString("THE COMPUTER!!",270, 85);
				}
		
				else{
					pane.drawString("THE DEALER!!",270, 85);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
