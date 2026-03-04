import java.util.*;

public class PokerHands {
    List<Card> hand;
    List<Card> playedCards;
    
    HandType highCard;
    HandType onePair;
    HandType twoPair;
    HandType threeOfAKind;
    HandType straight;
    HandType flush;
    HandType fullHouse;
    HandType fourOfAKind;
    HandType straightFlush;
    HandType royalFlush;
    HandType fiveOfAKind;
    HandType flushHouse;
    HandType flushFive;

    public PokerHands(List<Card> hand, List<Card> playedCards) {
        this.hand = hand;
        this.playedCards = playedCards;
        this.highCard = new HandType("high card");
        this.onePair = new HandType("one pair");
        this.twoPair = new HandType("two pair");
        this.threeOfAKind = new HandType("three of a kind");
        this.straight = new HandType("straight");
        this.flush = new HandType("flush");
        this.fullHouse = new HandType("full house");
        this.fourOfAKind = new HandType("four of a kind");
        this.straightFlush = new HandType("straight flush");
        this.royalFlush = new HandType("royal flush");
        this.fiveOfAKind = new HandType("five of a kind");
        this.flushHouse = new HandType("flush house");
        this.flushFive = new HandType("flush five");
    }

    public HandScore evaluate() {
        List<Card> filtered = new ArrayList<Card>();
        List<Card> scoring = new ArrayList<Card>();
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        String suit = null;
        boolean isFlush = true;
        boolean isStraight = false;
        boolean glassDoubled = false;
        List<Card> toRemove = new ArrayList<Card>();
        double chipBonus = 0;
        Random rand = new Random();

        // 1. Filtrele: stone olmayanlar sadece burada poker mantığına katılır
        for (int i = 0; i < playedCards.size(); i++) {
            Card c = playedCards.get(i);
            if (!"stone".equalsIgnoreCase(c.enhanced)) {
                filtered.add(c);
                freq.put(c.number, freq.getOrDefault(c.number, 0) + 1);
                if (suit == null) suit = c.type;
                else if (!c.type.equals(suit)) isFlush = false;
            }
        }

        // 2. Straight kontrolü
        List<Integer> values = new ArrayList<Integer>(freq.keySet());
        Collections.sort(values);
        isStraight = values.size() == 5;
        if (isStraight) {
            for (int i = 0; i < 4; i++) {
                if (values.get(i + 1) - values.get(i) != 1) {
                    isStraight = false;
                    break;
                }
            }
            if (!isStraight) {
                isStraight = values.contains(14) && values.contains(2) &&
                             values.contains(3) && values.contains(4) &&
                             values.contains(5);
            }
        }

        // 3. Kaçlılar var?
        List<Integer> fives = new ArrayList<Integer>();
        List<Integer> fours = new ArrayList<Integer>();
        List<Integer> threes = new ArrayList<Integer>();
        List<Integer> pairs = new ArrayList<Integer>();

        for (int n : freq.keySet()) {
            int count = freq.get(n);
            if (count == 5) fives.add(n);
            else if (count == 4) fours.add(n);
            else if (count == 3) threes.add(n);
            else if (count == 2) pairs.add(n);
        }

        // 4. El Tipi Seçimi
        HandType type;

        if (fives.size() == 1)                     type = new HandType("five of a kind");
        else if (isFlush && isRoyal(values))       type = new HandType("royal flush");
        else if (isFlush && isStraight)            type = new HandType("straight flush");
        else if (fours.size() == 1)                type = new HandType("four of a kind");
        else if (threes.size() == 1 && pairs.size() >= 1) type = new HandType("full house");
        else if (isFlush)                          type = new HandType("flush");
        else if (isStraight)                       type = new HandType("straight");
        else if (threes.size() == 1)               type = new HandType("three of a kind");
        else if (pairs.size() == 2)                type = new HandType("two pair");
        else if (pairs.size() == 1)                type = new HandType("pair");
        else                                       type = new HandType("high card");

        // 5. Skora katkı yapan kartları belirle
        for (int i = 0; i < playedCards.size(); i++) {
            Card c = playedCards.get(i);
            if (!"stone".equalsIgnoreCase(c.enhanced)) {
                if (type.getName().equalsIgnoreCase("flush") && c.type.equals(suit)) {
                    scoring.add(c);
                } else if (type.getName().equalsIgnoreCase("straight") ||
                           type.getName().equalsIgnoreCase("straight flush") ||
                           type.getName().equalsIgnoreCase("royal flush")) {
                    scoring.add(c);
                } else if (fives.contains(c.number) ||
                           fours.contains(c.number) ||
                           threes.contains(c.number) ||
                           pairs.contains(c.number)) {
                    scoring.add(c);
                }
            }
        }

        // 6. HandScore oluştur
        HandScore score = new HandScore(type, hand, playedCards);
        score.setScoringCards(new ArrayList<Card>(scoring));

        // 7. Enhanced etkilerini uygula
        for (int i = 0; i < playedCards.size(); i++) {
            Card c = playedCards.get(i);
            chipBonus += c.chip;
            score.setMult(score.getMult() + c.mult);

            if ("stone".equalsIgnoreCase(c.enhanced))
                chipBonus += 50;
            if ("bonus".equalsIgnoreCase(c.enhanced) && scoring.contains(c))
                chipBonus += 30;
            if ("glass".equalsIgnoreCase(c.enhanced) && scoring.contains(c)) {
                score.setMult(score.getMult() * 2);
                if (rand.nextInt(4) == 0) // 1/4
                    toRemove.add(c);
            }
            if ("lucky".equalsIgnoreCase(c.enhanced) && scoring.contains(c)) {
                if (rand.nextInt(5) == 0) // 1/5
                    score.setMult(score.getMult() * 2);
                if (rand.nextInt(15) == 0) // 1/15
                {}// +20 para
            }
        }
        
        List<Card> heldCards = score.getHeldCards();
        for (int i = 0; i < heldCards.size(); i++) {
        	Card c = heldCards.get(i);
        	
        	if ("stell".equalsIgnoreCase(c.enhanced)) 
                type.setMultiplier(type.getMultiplier() * 1.5);
        	if ("gold".equalsIgnoreCase(c.enhanced)) {} // +3 para
        }

        if (!toRemove.isEmpty()) {
            List<Card> updated = new ArrayList<Card>();
            for (int i = 0; i < scoring.size(); i++)
                if (!toRemove.contains(scoring.get(i)))
                    updated.add(scoring.get(i));
            score.setScoringCards(updated);
        }

        // 8. Puanı ekle
        score.setChip(type.getChip() + chipBonus);

        // 9. Non-scoring kartları ata
        List<Card> nonScoring = new ArrayList<Card>();
        for (int i = 0; i < playedCards.size(); i++) {
            Card c = playedCards.get(i);
            if (!scoring.contains(c) && !"stone".equalsIgnoreCase(c.enhanced))
                nonScoring.add(c);
        }
        score.setNonScoringCards(nonScoring);

        // 10. Jokerler 
        
        return score;
    }

    private boolean isRoyal(List<Integer> values) {
        if (values.size() != 5) return false;
        int[] royal = {10, 11, 12, 13, 14};
        for (int i = 0; i < 5; i++)
            if (!values.contains(royal[i])) return false;
        return true;
    }
}
