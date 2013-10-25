package pl.rawie.strcalc;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty())
            return 0;
        int i = input.indexOf(',');
        if (i < 0)
            return Integer.parseInt(input);
        else
            return Integer.parseInt(input.substring(0, i))
                + Integer.parseInt(input.substring(i + 1));
    }
}
