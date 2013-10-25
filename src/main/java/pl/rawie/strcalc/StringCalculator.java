package pl.rawie.strcalc;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public int add(String input) {
        if (input.isEmpty())
            return 0;
        Parser parser = new Parser(input);
        int[] numbers = parser.numbers();
        requireNonNegative(numbers);
        return sum(numbers);
    }

    private void requireNonNegative(int[] numbers) {
        for (int number : numbers)
            if (number < 0)
                throw new IllegalArgumentException(Integer.toString(number));
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers)
            sum += number;
        return sum;
    }

    private class Parser {
        private String delimiter;
        private String input;

        private Parser(String input) {
            init(input);
        }

        private void init(String input) {
            if (hasDefinedDelimiter(input)) {
                int i = input.indexOf('\n');
                delimiter = input.substring(2, i);
                this.input = input.substring(i + 1);
            } else {
                delimiter = ",|\n";
                this.input = input;
            }
        }

        private boolean hasDefinedDelimiter(String input) {
            return input.startsWith("//");
        }

        public int[] numbers() {
            return parseNumbers(split());
        }

        private String[] split() {
            return input.split(delimiter);
        }

        private int[] parseNumbers(String[] strings) {
            int[] numbers = new int[strings.length];
            for (int i = 0; i < strings.length; i++)
                numbers[i] = parseInt(strings[i]);
            return numbers;
        }
    }
}
