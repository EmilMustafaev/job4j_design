package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class FoolTest {

    @Test
    void whenFizz() {
        assertThat("Fizz".equals(Fool.getExpectedAnswer(3))).isTrue();
    }

    @Test
    void whenBuzz() {
        assertThat("Buzz".equals(Fool.getExpectedAnswer(5))).isTrue();
    }

    @Test
    void whenFizzBuzz() {
        assertThat("FizzBuzz".equals(Fool.getExpectedAnswer(15))).isTrue();
    }

    @Test
    void whenNumder() {
        assertThat("2".equals(Fool.getExpectedAnswer(2))).isTrue();
    }

    @Test
    void whenCorrectAnswer() {
        assertTrue(Fool.isAnswerCorrect(3, "Fizz"));
        assertTrue(Fool.isAnswerCorrect(5, "Buzz"));
        assertTrue(Fool.isAnswerCorrect(15, "FizzBuzz"));
        assertTrue(Fool.isAnswerCorrect(4, "4"));
    }

    @Test
    void whenIncorrectAnswer() {
        assertFalse(Fool.isAnswerCorrect(3, "Buzz"));
        assertFalse(Fool.isAnswerCorrect(5, "Fizz"));
        assertFalse(Fool.isAnswerCorrect(15, "4"));
        assertFalse(Fool.isAnswerCorrect(4, "FizzBuzz"));
    }

}