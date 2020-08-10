import java.awt.image.BufferedImage;

public class card {
	private BufferedImage cardImage;
	private String rank;
	private int value;
	private String suit;

	public static enum Suit{
		SPADES   ("Spades",  "s"),
		CLUBS    ("Clubs",   "c"),
		DIAMONDS ("Diamonds","d"),
		HEARTS   ("Hearts",  "h");
		private final String suit;
		private final String imgAbbr;

		//Suit constructor
		Suit(String suit, String imgAbbr){
			this.suit = suit;
			this.imgAbbr = imgAbbr;
		}

		//Returns type of card
		public String getSuit(){
			return this.suit;
		}
		//Returns assigned letter of card
		public String getImgAbbr(){
			return this.imgAbbr;
		}
	}

	public static enum Rank {
		ACE     ("Ace", 1, "a"),
		TWO     ("Two", 2, "2"),
		THREE   ("Three", 3, "3"),
		FOUR    ("Four", 4, "4"),
		FIVE    ("Five", 5, "5"),
		SIX     ("Six", 6, "6"),
		SEVEN   ("Seven", 7, "7"),
		EIGHT   ("Eight", 8, "8"),
		NINE    ("Nine", 9, "9"),
		TEN     ("Ten", 10, "t"),
		JACK    ("Jack", 11, "j"),
		QUEEN   ("Queen", 12, "q"),
		KING    ("King", 13, "k");

		private final String rank;
		private final int value;
		private final String imgAbbr;

		  //method constucts rank
		Rank(String rank, int value, String imgAbbr){
			this.rank = rank;
			this.value = value;
			this.imgAbbr = imgAbbr;
		}

		//Returns numeric value of Card object
		public int getRankValue(){
			return this.value;
		}
		
		//Returns the string rank of a card
		public String getRank(){
			return this.rank;
		}

		//Returns image abreviation 
		public String getImgAbbr(){
			return this.imgAbbr;
		}
	}

	//method that constructs cards
	public card(String rank, String suit, int value, BufferedImage cardImage) {
		this.suit = suit;
		this.rank = rank;
		this.value = value;
		this.cardImage = cardImage;
	}

	      //Returns appropriate string value
	          public String toString(){
		return rank + " of " + suit;
	}

	//Returns image for a card
	public BufferedImage getCardImage() {
		return cardImage;
	}
}
