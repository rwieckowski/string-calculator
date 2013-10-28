package pl.rawie.strcalc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.asList;

public class StringCalculator {
    public int add(String input) {
        List<String> strings = splitNumbers(input);
        List<Integer> numbers = parseNumbers(strings);
        rejectNegatives(numbers);
        return sum(numbers);
    }

    private List<String> splitNumbers(String input) {
        DelimiterWithNumbers dn = extractDelimiterWithNumbers(input);
        return split(dn);
    }

    private List<String> split(DelimiterWithNumbers input) {
        return asList(input.numbers.split(input.delimiter));
    }

    private DelimiterWithNumbers extractDelimiterWithNumbers(String input) {
        if (hasDefinedDelimiter(input)) {
            int i = input.indexOf('\n');
            String delimiter = input.substring(2, i);
            String numbers = input.substring(i + 1);
            return new DelimiterWithNumbers(delimiter, numbers);
        } else
            return new DelimiterWithNumbers(",|\n", input);
    }

    private boolean hasDefinedDelimiter(String input) {
        return input.startsWith("//");
    }

    private List<Integer> parseNumbers(List<String> strings) {
        List<Integer> numbers = new ArrayList<Integer>();
        for (String string : strings)
            numbers.add(parseInt(string));
        return numbers;
    }

    private void rejectNegatives(List<Integer> numbers) {
        List<Integer> negatives = new ArrayList<Integer>();
        for (int number : numbers)
            if (number < 0)
                negatives.add(number);

        if (!negatives.isEmpty())
            throw new IllegalArgumentException(formatMessage(negatives));
    }

    private String formatMessage(List<Integer> numbers) {
        String message = "";
        Iterator<Integer> it = numbers.iterator();
        message += it.next();
        while (it.hasNext())
            message += "," + it.next();
        return message;
    }

    private int sum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers)
            sum += number;
        return sum;
    }

    private class DelimiterWithNumbers {
        private String delimiter;
        private String numbers;

        private DelimiterWithNumbers(String delimiter, String numbers) {
            this.delimiter = delimiter;
            this.numbers = (numbers.isEmpty()) ? "0" : numbers;
        }
    }
}
