import java.util.*;

public class HandScore {
    private final HandType type;
    private List<Card> playedCards;
    private List<Card> heldCards;
    private List<Card> scoringCards;
    private List<Card> nonScoringCards;
    private double chip;
    private double mult;

    public HandScore(HandType type, List<Card> hand, List<Card> playedCards) {
        this.type = type;
        this.playedCards = playedCards;
        this.heldCards = new ArrayList<>();
        for (int i = 0; i < hand.size(); i++) if (!playedCards.contains(hand.get(i))) this.heldCards.add(hand.get(i)); 
        this.scoringCards = new ArrayList<>();
        this.nonScoringCards = new ArrayList<>();
    }

    public HandType getType() {
        return type;
    }

    public void setScoringCards(List<Card> cards) {
        this.scoringCards = cards;
    }

    public void setNonScoringCards(List<Card> cards) {
        this.nonScoringCards = cards;
    }
    
    public void setChip(double chip) {
    	this.chip = chip;
    }
    
    public void setMult(double mult) {
    	this.mult = mult;
    }

    public List<Card> getScoringCards() {
        return scoringCards;
    }

    public List<Card> getNonScoringCards() {
        return nonScoringCards;
    }
    
    public List<Card> getHeldCards() {
        return heldCards;
    }
    
    public List<Card> getPlayedCards(){
    	return playedCards;
    }

	public double getMult() {
		// TODO Auto-generated method stub
		return mult;
	}
}