import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class SpecialCards extends Card {

	public SpecialCards(int value, int suit) {
		super(value, suit);
		// TODO Auto-generated constructor stub
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
}
