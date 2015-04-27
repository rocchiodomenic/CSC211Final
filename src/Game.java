import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	private Card handOne1, handOne2, handTwo1, handTwo2, burnCard1, burnCard2,
			burnCard3, burnCard4, burnCard5;
	
	private Deck deck = new Deck();

	private Abutton playButton, resetButton, quitButton;

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

	/**
	 * a test to see whether the button is up or down.
	 */
	private boolean up;

	public Game() {

		setTitle("Texas Holdem"); // The title of the program frame
		setSize(550, 500); // Size of the program frame
		setLocation(300, 300); // Location where the frame will appear
		setBackground(Color.GREEN);// Set the background color to be green

		Window myWindow = new Window();// to allow for window closing
		addWindowListener(myWindow);// A must for AWT to close the window

		setVisible(true);

		addMouseListener(this);// so you can handle the mouse clicks

		deck.printDeck();
		
		
		
		// I create my three buttons of different colors
		playButton = new Abutton("Play", Color.green, 125, 400, 100, 50);
		resetButton = new Abutton("Reset", Color.yellow, 250, 400, 100, 50);
		quitButton = new Abutton("Quit", Color.red, 375, 400, 100, 50);
		System.out.println("buttons");
		
		handOne1 = new Card(100,75,false);
		System.out.println("card information");
		
		handOne1.setSuit();
		System.out.println("card suit: " + handOne1.getSuit());
		handOne1.setValue();
		System.out.println("card value: " + handOne1.getValue());
		
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
			//handOne1 = new Card(100, 75, false);
			// handOne2 = new Card(176, 75, false);
			// handTwo1 = new Card(300, 75, false);
			// handTwo2 = new Card(376, 75, false);
		}

		else if (resetButton.isInside(xValue, yValue)) {

			// Makes it so that my cards disappear
			// When the reset button is pressed.
			handOne1 = new Card(true);
			handOne2 = new Card(true);
			handTwo1 = new Card(true);
			handTwo2 = new Card(true);

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
	 * The game rules method which begins the comparison between both cards And
	 * takes their rank as a parameter
	 */
	/*public void gameRules(int cardOneNumber, int cardTwoNumber,
			int cardThreeNumber, int cardFourNumber) {
		// If their values are equal
		if (cardOneNumber == cardTwoNumber) {
			tie++;// increment counter
		}

		// Otherwise it takes the score and adds
		// To it the value of tie to the second power
		// Because is the rule when it comes to ties.
		else if (tie > 1) {
			gameScore += tie ^ 2;
			tie = 0;
		} else {
			if (cardOneNumber > cardTwoNumber) {
				// Still figuring out the score based on
				// The comparison of the cards
				gameScore += 1 + tie;
				tie = 0;

				// Mutator method to change the score
				score.changeScore(gameScore);
			}

			else if (cardOneNumber < cardTwoNumber) {
				// Still figuring out the score based on
				// The comparison of the cards
				gameScore -= 1 + tie;
				tie = 0;

				// Mutator method to change the score
				score.changeScore(gameScore);
			}
		}
	}*/

	/**
	 * This is my entire paint method that paints everything That is going to be
	 * in the frame
	 */
	public void paint(Graphics pane) {
		if (complete) {

			Graphics2D pane2 = (Graphics2D) pane;

			// This is where the color will change showing
			// when a button is pressed
			pane2.setColor(up ? highColor : lowColor);

			handOne1.paint(pane);
			//handOne2.paint(pane);
			//handTwo1.paint(pane);
			//handTwo2.paint(pane);
			playButton.paint(pane);
			resetButton.paint(pane);
			quitButton.paint(pane);
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
