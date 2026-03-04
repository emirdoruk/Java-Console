
public class Enhanced {
	static Card card;
	
	Enhanced(String type){
		switch(type) {
		case "bonus": bonus(); break;
		}
	}
	
	public static void bonus() {
		card.setChip(50);
	}
	
	public static void mult() {
		card.setMult(4);
	}
	
	public static void wild() {
		
	}
	
	public static void glass() {
		
	}
	
	public static void steel() {
		
	}
	
	public static void stone() {
		
	}
	
	public static void gold() {
		
	}
	
	public static void lucky() {
		
	}
}
