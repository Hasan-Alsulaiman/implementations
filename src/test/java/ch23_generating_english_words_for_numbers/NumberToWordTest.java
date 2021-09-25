package ch23_generating_english_words_for_numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberToWordTest {

    NumberToWord underTest = new NumberToWord();

    @Test
    void canConvertNumberToWord() {
        // given
        int number = 1999;

        // when
        String actual = underTest.namesOf(number);

        //then
        String expected = "one thousand nine hundred and ninety-nine";
        assertEquals(expected, actual.strip());
    }

    @Test
    void canFormatHundreds() {
        // given
        int number = 100;

        // when
        String actual = underTest.formatHundreds(number).strip();

        // then
        assertEquals("one hundred", actual);
    }

    @Test
    void canFormatTensAndOnesLessThan20() {
        // given
        int number = 111;

        // when
        String actual = underTest.formatLessThan20(number).strip();

        // then
        assertEquals("eleven", actual);
    }

    @Test
    void canFormatTensAndOnesMoreThan19() {
        // given
        int number = 123;

        // when
        String actual = underTest.formatMoreThan19(number).strip();

        // then
        assertEquals("twenty-three", actual);
    }



}