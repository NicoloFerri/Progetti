package Utils;

public class FindHandValueUtil {
    
    public static int fromStringToInt(String s) {
        return switch (s) {
            case "2" -> 2;
            case "3" -> 3;
            case "4" -> 4;
            case "5" -> 5;
            case "6" -> 6;
            case "7" -> 7;
            case "8" -> 8;
            case "9" -> 9;
            case "T" -> 10;
            case "J" -> 11;
            case "Q" -> 12;
            case "K" -> 13;
            case "A" -> 14;
            default -> throw new IllegalArgumentException("Invalid card value: " + s);
        };
    }

}
