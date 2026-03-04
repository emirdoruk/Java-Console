import java.util.*;

void main() {
    Scanner sc = new Scanner(System.in);
    String phrase = sc.nextLine();
    String[] words = phrase.trim().split("\\s{3,}");
    for (String word : words) {
        String[] letters = word.split("\\s+");
        for (String letter : letters) {
            switch (letter) {
                case ".-" -> System.out.print("A");
                case "-..." -> System.out.print("B");
                case "-.-." -> System.out.print("C");
                case "-.." -> System.out.print("D");
                case "." -> System.out.print("E");
                case "..-." -> System.out.print("F");
                case "--." -> System.out.print("G");
                case "...." -> System.out.print("H");
                case ".." -> System.out.print("I");
                case ".---" -> System.out.print("J");
                case "-.-" -> System.out.print("K");
                case ".-.." -> System.out.print("L");
                case "--" -> System.out.print("M");
                case "-." -> System.out.print("N");
                case "---" -> System.out.print("O");
                case ".--." -> System.out.print("P");
                case "--.-" -> System.out.print("Q");
                case ".-." -> System.out.print("R");
                case "..." -> System.out.print("S");
                case "-" -> System.out.print("T");
                case "..-" -> System.out.print("U");
                case "...-" -> System.out.print("V");
                case ".--" -> System.out.print("W");
                case "-..-" -> System.out.print("X");
                case "-.--" -> System.out.print("Y");
                case "--.." -> System.out.print("Z");
            }
        }
        System.out.print(" ");
    }
    sc.close();
}
