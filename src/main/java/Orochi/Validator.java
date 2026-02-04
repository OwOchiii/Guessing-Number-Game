package Orochi;

public class Validator {
    public int validateInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1; // Indicate invalid input
        }
    }
}
