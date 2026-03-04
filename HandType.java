public class HandType {
    private final String name;
    private double baseChip;
    private double baseMultiplier;
    private int level;

    public HandType(String name) {
        this.name = name; this.level = 1;
        if (name.equalsIgnoreCase("high card"))			{this.baseChip = 5 + 10 * (level-1); this.baseMultiplier = 1 + 1 * (level - 1);}
        if (name.equalsIgnoreCase("pair")) 				{this.baseChip = 10 + 15 * (level-1); this.baseMultiplier = 2 + 1 * (level-1);}
        if (name.equalsIgnoreCase("two pair")) 			{this.baseChip = 20 + 20 * (level-1); this.baseMultiplier = 2 + 1 * (level-1);}
        if (name.equalsIgnoreCase("three of a kind")) 	{this.baseChip = 30 + 20 * (level-1); this.baseMultiplier = 3 + 2 * (level-1);}
        if (name.equalsIgnoreCase("straight")) 			{this.baseChip = 30 + 30 * (level-1); this.baseMultiplier = 4 + 3 * (level-1);}
        if (name.equalsIgnoreCase("flush")) 			{this.baseChip = 35 + 15 * (level-1); this.baseMultiplier = 4 + 2 * (level-1);}
        if (name.equalsIgnoreCase("full house")) 		{this.baseChip = 40 + 25 * (level-1); this.baseMultiplier = 4 + 2 * (level-1);}
        if (name.equalsIgnoreCase("four of a kind")) 	{this.baseChip = 60 + 30 * (level-1); this.baseMultiplier = 7 + 3 * (level-1);}
        if (name.equalsIgnoreCase("straight flush")) 	{this.baseChip = 100 + 40 * (level-1); this.baseMultiplier = 8 + 4 * (level-1);}
        if (name.equalsIgnoreCase("royal flush")) 		{this.baseChip = 100 + 10; this.baseMultiplier = 8;}
        if (name.equalsIgnoreCase("five of a kind")) 	{this.baseChip = 120 + 35 * (level-1); this.baseMultiplier = 12 + 3 * (level-1);}
        if (name.equalsIgnoreCase("flush house")) 		{this.baseChip = 140 + 40 * (level-1); this.baseMultiplier = 14 + 4 * (level-1);}
        if (name.equalsIgnoreCase("flush five")) 		{this.baseChip = 160 + 50 * (level-1); this.baseMultiplier = 16 + 3 * (level-1);}
    }

    public void setChip(double chip) {
        this.baseChip = chip;
    }

    public void setMultiplier(double multiplier) {
        this.baseMultiplier = multiplier;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }

    public double getChip() {
        return baseChip;
    }

    public double getMultiplier() {
        return baseMultiplier;
    }
    
    public int getLevel() {
    	return level;
    }
    
    public String getName() {
    	return name;
    }
}
