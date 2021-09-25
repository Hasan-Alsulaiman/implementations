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
        String resutl = underTest.namesOf(number);

        //then
        String expected = "one thousand nine hundred and ninety-nine";
        assertEquals(expected, resutl.strip());
    }

}