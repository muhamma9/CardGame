package ca.sheridancollege.project;

public class Card {

    private Rank cardRank;
    private Suit cardSuit;

    /**
     *
     * @param rank
     * @param suit
     */
    public Card(Rank rank, Suit suit) {
        this.cardRank = rank;
        this.cardSuit = suit;

    }

    /**
     * @return the cardRank
     */
    public Rank getCardRank() {
        return cardRank;
    }

    /**
     * @param cardRank the cardRank to set
     */
    public void setCardRank(Rank cardRank) {
        this.cardRank = cardRank;
    }

    /**
     * @return the cardSuit
     */
    public Suit getCardSuit() {
        return cardSuit;
    }

    /**
     * @param cardSuit the cardSuit to set
     */
    public void setCardSuit(Suit cardSuit) {
        this.cardSuit = cardSuit;
    }

    @Override
    public String toString() {

        return getCardRank() + "of " + getCardSuit();

    }

}
