
public class Card {
    int number; // A,K,Q,J,10,9,8,7,6,5,4,3,2
    String type; // 
    double chip;
    double mult;
    String enhanced;
    String seal;
    boolean face;

    public Card (String card, String enhanced, String seal) {
    	String[] str = card.split("");
    	setNumber(str[0]);
    	this.mult = 0;
    	setType(str[1], false);
    	this.enhanced = enhanced;
    	this.seal = seal;
    } 
    
    public void setNumber(String number) {
		if (number.equals("A")) 		{this.number = 14; this.chip = 11; this.face = false;}
		else if (number.equals("K")) 	{this.number = 13; this.chip = 10; this.face = true;}
		else if (number.equals("Q")) 	{this.number = 12; this.chip = 10; this.face = true;}
		else if (number.equals("J")) 	{this.number = 11; this.chip = 10; this.face = true;}
		else 							{this.number = Integer.parseInt(number);  this.chip = this.number; this.face = false;}
    }
    
    public void setChip(double chip) {
    	this.chip += chip;
    }
    
    public void setMult(double mult) {
    	this.mult += mult;
    }
    
    public double getChip() {
    	return this.chip;
    }
    
    public double[] getMult() {
    	double[] mults = new double[2];
    	mults[0] = this.mult;
    	mults[1] = 0;
    	return mults;
    }
    
    public void setType(String type, boolean wild) {
    	if (!wild) this.type = type;
    	else this.type = "wild";
    }
    
    public void setEnchanced(String enhanced) {
        this.enhanced = enhanced;
    }

    public void setSeal(String seal) {
        this.seal = seal;
    }
    
    
    

    

}