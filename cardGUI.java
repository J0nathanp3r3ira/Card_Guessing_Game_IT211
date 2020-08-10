import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class cardGUI implements ItemListener, ActionListener {
  private ImageIcon cardBack;
  private ImageIcon cardImg;
  private JTextArea dropDownText;
  private JFrame window;
  private JPanel gameContainer;
  private JPanel dropDownContainer;
  private JTextArea gameInfo;
  private JComboBox suits;
  private JComboBox ranks;
  private JButton buttonGo;
  private String suitGuess;
  private String rankGuess;
  private String combinedGuess;
  private JLabel imgHolder;
  private card currentCard;

  public int wins = 0;
  public int count = 0;
  public int cardsLeft = 52;


  public cardGUI() throws IOException {
    
    // Creates frame
    window = new JFrame("Card Game");

    // creates game container
    gameContainer = new JPanel(new GridLayout(5, 5, 10, 10));

    // score board for players
    gameInfo = new JTextArea("Correct Guesses: " + wins + "\nTotal Attempts: " + count + "\nCards Left: " + cardsLeft);
    gameInfo.setEditable(false);

    // dropdown lists creation of cards
    suits = new JComboBox<>(card.Suit.values());
    ranks = new JComboBox<>(card.Rank.values());  

    // dropdown listener box
    suits.addItemListener(this);
    ranks.addItemListener(this);

    //sets variables to null
    suitGuess = suits.getSelectedItem().toString();
    rankGuess = ranks.getSelectedItem().toString();
    combinedGuess = rankGuess + " of " + suitGuess;

    // introduction to game
    dropDownText = new JTextArea("Guess the next card from the suit and rank selection");
    dropDownText.setEditable(false);

    //keeps grid and dropdown
    dropDownContainer = new JPanel(new GridLayout(4, 8));
    dropDownContainer.add(ranks);
    dropDownContainer.add(new JLabel("of", JLabel.CENTER));
    dropDownContainer.add(suits);

    // sets images for card
    cardBack = new ImageIcon(ImageIO.read(new File("cards/b.gif")));
    cardImg = new ImageIcon();
    imgHolder = new JLabel(cardImg);
    
    // guesses card
    buttonGo = new JButton("Click to guess card");
    buttonGo.addActionListener(this);

    // closes operation and opens game container
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.add(gameContainer);

    //makes container for cards
    gameContainer.setBorder(BorderFactory.createEmptyBorder(55, 55, 55, 55));
    gameContainer.add(new JLabel(cardBack));
    gameContainer.add(imgHolder);
    gameContainer.add(dropDownText);
    gameContainer.add(gameInfo);
    gameContainer.add(buttonGo);
    gameContainer.add(dropDownContainer);

    //changes window size
    window.pack();
    window.setVisible(true);
  }

  // insure all cards work
  private void printEntireDeck() {
    int n = 0;
    for (card c : deckOfCards.deck) {
      cardImg = new ImageIcon(deckOfCards.deck[n].getCardImage());
      gameContainer.add(new JLabel(cardImg));
      deckOfCards.deck[n] = c;
      n++;
    }
  }

  //When button is pressed method is activated
  @Override
  public void actionPerformed(ActionEvent e) {
    currentCard = cardGame.deck.deal();

    if (currentCard == null)
      return;
   //Displays current card
    if (cardsLeft > 0)
      cardImg.setImage(currentCard.getCardImage());

    //checks to see progress
    System.out.println(currentCard.toString());
    System.out.println(combinedGuess);

    //double checks current card
    if (combinedGuess.equalsIgnoreCase(currentCard.toString()))
      wins++;

    // Changes label and image
    imgHolder.repaint();

    cardsLeft--;
    count++;
    gameInfo.setText("Correct Guesses: " + wins + "\nTotal Attempts: " + count + "\nCards Left: " + cardsLeft);
  }

  //called for dropdown
  @Override
  public void itemStateChanged(ItemEvent e) {
    Object source = e.getItemSelectable();
    //change if dropdown is used
    if(source == suits)
      suitGuess = suits.getSelectedItem().toString();
    //change if dropdown is used
    if(source == ranks)
      rankGuess = ranks.getSelectedItem().toString();
    //make combinedguess equal to new variables
    combinedGuess = rankGuess + " of " + suitGuess;
  }
}
