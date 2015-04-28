import java.util.Random;

public class Deck {
	private Card[] deck = new Card[52];
	private int currentIndex;
	/**
	 * creates a deck of 52 cards
	 */
	public Deck() {
		int i = 0;
		for (int j = 1; j <= 4; j++) {
			for (int k = 1; k <= 13; k++) {
				deck[i++] = new Card(k, j);
			}
		}
		shuffle();
		currentIndex = 0;
		//printDeck();
	}
	
	public Card drawCard(){
		return deck[currentIndex++];
	}

	/**
	 * for testing purposes...delete when you are going to submit for grading
	 */
	protected void printDeck() {
		for (int i = 0; i < deck.length; i++) {
			System.out.println("Value: " + deck[i].getValue());
			System.out.println("Suit: " + deck[i].getSuit());
		}
	}

	/**
	 * gets the card from the deck
	 * @param cardNum
	 * @return
	 */
	protected Card getCard(int cardNum) {
		return deck[cardNum];
	}

	public void shuffle() {
		// length of the deck so it can shuffle the entire deck
		int deckLength = deck.length;
		Random random = new Random();
		currentIndex = 0;

		for (int i = 0; i < deckLength; i++) {
			int swap = i + random.nextInt(deckLength - i);
			Card temp = deck[i];
			deck[i] = deck[swap];
			deck[swap] = temp;
		}
	}
}

