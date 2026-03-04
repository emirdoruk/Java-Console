import java.util.*;

public class Move {

	String name;
	String type;
	String category;
	int pp;
	int power;
	int accuracy;
	List<String> pokemon;
	
	Move(String name, String type, String category, int pp, String power, String accuracy, List<String> pokemon){
		this.name = name;
		this.type = type;
		this.category = category(category, pp);
		this.pp = pp;
		this.power = power(power);
		this.accuracy = accuracy(accuracy);
		this.pokemon = pokemon;
	}
	
	public static int power(String power) {
	    if (power.equals("—")) return 0;
	    else if (power.equals("∞")) return Integer.MAX_VALUE;
	    else return Integer.parseInt(power);
	}

	public static int accuracy(String accuracy) {
	    if (accuracy.equals("—")) return Integer.MIN_VALUE;
	    else if (accuracy.equals("∞")) return Integer.MAX_VALUE;
	    else return Integer.parseInt(accuracy);
	}
	
	public static String category(String category, int pp) {
		if (category.equals("???")) {
			if (pp == 1) return "Z-Move";
			else return "Max-Move";
		}
		else return category;
	}
	
}
