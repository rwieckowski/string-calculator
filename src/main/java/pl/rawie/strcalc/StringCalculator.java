package pl.rawie.strcalc;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty())
            return 0;

        String[] numbers = input.split(",");

        int sum = 0;
        for (String number : numbers)
            sum += parseInt(number);
        return sum;
    }
}
