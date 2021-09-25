package ch23_generating_english_words_for_numbers;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberToWord {

    private Deque<Integer> weightsOf(int number) {

        Deque<Integer> weights = new ArrayDeque<>();
        while (number > 0) {
            weights.push(number % 1000);
            number /= 1000;
        }
        return weights;
    }

    public String namesOf(int number) {
        var weights = weightsOf(number);

        String text = "";
        int index = weights.size() - 1;
        while (!weights.isEmpty()) {
            Integer currentWeight = weights.pop();
            text += nameOfDigit(currentWeight);
            text += currentWeight == 0 ? "and " : nameOfWeight(index);
            index--;
        }
        return text;
    }

    public String nameOfDigit(Integer number) {
        final String[] lessThan20 = new String[]{"", "one", "two", "three", "four", "five", "six", "seven",
                "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"};
        final String[] times10 = new String[]{"", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        int hundreds = number / 100;
        int rest = number % 100;
        int tens = rest / 10;
        int ones = rest % 10;

        String words = "";

        //TODO: refactor this ugly nested if
        if (hundreds > 0)
            words += lessThan20[hundreds] + " " + "hundred ";
        if (hundreds > 0 && rest > 0)
            words += "and ";
        if (rest < 20)
            words += lessThan20[rest] + " ";
        else {
            if (tens > 0)
                words += times10[tens];
            if (tens > 0 && ones > 0)
                words += "-";
            if (ones > 0)
                words += lessThan20[ones] + " ";
        }
        return words;
    }

    public String nameOfWeight(int index) {
        final String[] weights = new String[]{"", "thousand", "million", "billion", "trillion"};
        return weights[index] + " ";
    }

}
