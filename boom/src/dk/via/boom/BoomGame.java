package dk.via.boom;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class BoomGame {
    int booms(int number) {
        String numberString = String.valueOf(number);
        long threes = numberString.chars().filter(c -> c == '3').count();
        if (threes > 0)
            return (int) threes;
        if (number % 3 == 0)
            return 1;
        return 0;
    }

    String answer(int number) {
        int booms = booms(number);
        if (booms > 0)
            return "Boom".repeat(booms);
        return String.valueOf(number);
    }

    List<String> boomSequence(int first, int last) {
        return IntStream.range(first, last + 1).mapToObj(this::answer).collect(toList());
    }

    public List<String> play(int last) {
        return boomSequence(1, last);
    }
}
