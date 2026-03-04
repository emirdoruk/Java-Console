
public class Test {

    public static void main(String[] args) {
        Move move1 = new Move("Flamethrower", "Fire", "Special", 15, "90", "100");
        Move move2 = new Move("Splash", "Normal", "Status", 40, "—", "—");
        Move move3 = new Move("Guillotine", "Normal", "???", 5, "∞", "30");
        Move move4 = new Move("Swift", "Normal", "???", 1, "60", "∞");

        printMove(move1);
        printMove(move2);
        printMove(move3);
        printMove(move4);
    }

    public static void printMove(Move move) {
        System.out.println("Name: " + move.name);
        System.out.println("Type: " + move.type);
        System.out.println("Category: " + move.category);
        System.out.println("PP: " + move.pp);
        System.out.println("Power: " + move.power);
        System.out.println("Accuracy: " + move.accuracy);
        System.out.println("------------------------------");
    }

}
