/**
 * Author: Domenic Rocchio
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;


public class Card {
	private int suit;

	private int cardValue;
	private String value;
	private Image image;
	private int width = 75;
	private int height = 125;
	private int xValue;
	private int yValue;
	private boolean isUpsideDown;
	private String imagePath = "";
	private boolean isVisible = true;

	public Card(int cardValue, int suit) {
		this.cardValue = cardValue;
		this.suit = suit;

	}

	public Card(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public Card(int someX, int someY, boolean isUpsideDown) {
		xValue = someX;
		yValue = someY;

		// If the card is face down or right side up
		this.isUpsideDown = isUpsideDown;

		// When its facing up, it will be the cards being compared
		// And I call the accessor and mutator methods to get the info
		// For the card
		/**if (!isUpsideDown) {
			System.out.println("got here");
			setSuit();
			System.out.println(suit);
			setValue();
			System.out.println(value);
		}*/
	}

	public void setValue() {
		// Int to go through the switch
		cardValue = (int) (Math.random() * 13) + 1;

		switch (cardValue) {
		case 1:
			value = "2";
			break;
		case 2:
			value = "3";
			break;
		case 3:
			value = "4";
			break;
		case 4:
			value = "5";
			break;
		case 5:
			value = "6";
			break;
		case 6:
			value = "7";
			break;
		case 7:
			value = "8";
			break;
		case 8:
			value = "9";
			break;
		case 9:
			value = "10";
			break;
		case 10:
			value = "J";
			break;
		case 11:
			value = "Q";
			break;
		case 12:
			value = "K";
			break;
		case 13:
			value = "A";
			break;
		default:
			break;
		}
	}

	public int getValue() {
		return cardValue;
	}

	public void paint(Graphics pane) {
		if (isVisible == true) {
			//Sets the color of the face down cards 
			pane.setColor(Color.darkGray);
			
			//Draws the outline for the cards that are visible
			pane.drawRoundRect(xValue, yValue, width, height, 16, 16);
			
			//Draws the rank of the card on the face of the card on the 
			//Top left of the card
			pane.drawString(""+ value, xValue + 5 , yValue + 15);

			image = new ImageIcon(imagePath).getImage();
			pane.drawImage(image, xValue + width/3 - 17, yValue + height/3, null);
			//fills the rectangle
			if(isUpsideDown){
				pane.fillRoundRect(xValue + 1, yValue + 1, width - 1, height - 1, 16, 16);
			}
			else{
				//This is where I am importing the image file which
				// is a .png  I call getImage to get the image and 
				//I draw it on the face up cards
				
			}
		}
	}

	public void setSuit() {
		// Random number between 1 and 4 for the switch
		suit = ((int) (Math.random() * 4) + 1);

		switch (suit) {
		case 1:
			imagePath = "Hearts.png";
			break;
		case 2:
			imagePath = "Spades.png";
			break;
		case 3:
			imagePath = "Clubs.png";
			break;
		case 4:
			imagePath = "Diamonds.png";
			break;
		}
	}

	public int getSuit() {
		return suit;
	}
}
