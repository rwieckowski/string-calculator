package pl.rawie.strcalc;

public class StringCalculator {
    public int add(String input) {
        return (input.isEmpty()) ? 0 : Integer.parseInt(input);
    }
}
