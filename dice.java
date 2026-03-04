import java.util.*;

public class dice {
	static Random random = new Random();
	
	public static void main(String[] args) {
		tmntCharacterDice();

	}
	
	public static int roll (int number, int side) {
		int x = 0;
		for (int i = 0; i < number; i++)
			x = x+diceNoMOD(side);
		if (x < 10) roll(number, side);
		return x;
	}
	
	public static int diceNoMOD(int side) {
		return random.nextInt(side) + 1;
	}
	
	public static int diceWithMOD(int roll, int stat) {
		if (stat%2 != 0) stat = stat-1;
		return roll + stat/2;
	}

	public static void tmntCharacterDice (){
		for (int j = 0; j < 6; j++) {
			int x = 0;
			x = roll(3,6);
			if (x >= 15) x = x + roll(1, 6);
			System.out.println(x);	
		}
	}
}
