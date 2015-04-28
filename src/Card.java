/**
 * Author: Domenic Rocchio
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Card extends JPanel {
	private int suit;
	private int value;
	private BufferedImage image;
	private int width = 75;
	private int height = 125;
	private int xValue;
	private int yValue;
	private boolean isUpsideDown = false;
	private String imagePath = "images/";
	private String heartsPath = "Hearts.png";
	private String spadesPath = "Spades.png";
	private String clubsPath = "Clubs.png";
	private String diamondsPath = "Diamonds.png";
	private boolean isVisible = true;
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int HEARTS = 1;
	public static final int CLUBS = 2;
	public static final int SPADES = 3;
	public static final int DIAMONDS = 4;

	public Card(int value, int suit) {
		this.value = value;
		this.suit = suit;
	}

	public Card(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public void setLocation(int xValue, int yValue){
		this.xValue = xValue;
		this.yValue = yValue;
	}

	
	public void setIfUpsideDown(boolean isUpsideDown){
		this.isUpsideDown = isUpsideDown;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void paint(Graphics pane) {
		if (isVisible == true) {
			// Sets the color of the face down cards
			pane.setColor(Color.darkGray);

			// Draws the outline for the cards that are visible
			pane.drawRoundRect(xValue, yValue, width, height, 16, 16);

			// Draws the rank of the card on the face of the card on the
			// Top left of the card
			String valueToString = "" + value;
			switch (value) {
			case ACE:
				valueToString = "A";
				break;
			case KING:
				valueToString = "K";
				break;
			case QUEEN:
				valueToString = "Q";
				break;
			case JACK:
				valueToString = "J";
				break;
			}
			pane.drawString("" + valueToString, xValue + 5, yValue + 15);

			try {
				String imageFile = "";
				switch (suit) {
				case HEARTS:
					imageFile = heartsPath;
					break;
				case CLUBS:
					imageFile = clubsPath;
					break;
				case DIAMONDS:
					imageFile = diamondsPath;
					break;
				case SPADES:
					imageFile = spadesPath;
					break;
				}
				//In order for this to work, put images in source folder called images
				image = ImageIO.read(new File(imagePath + imageFile));
				JLabel picLabel = new JLabel(new ImageIcon(image));
				add(picLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}

			pane.drawImage(image, xValue + (width / 3) - 22, yValue + (height / 3) - 15, null);

			if (isUpsideDown) {
				pane.fillRoundRect(xValue + 1, yValue + 1, width - 1,
						height - 1, 16, 16);
			}
		}
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getSuit() {
		return suit;
	}
}
