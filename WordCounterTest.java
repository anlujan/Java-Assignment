package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class WordCounterTest {
    private WordCounter wordCounter;

    @BeforeEach
    public void setup() {
        wordCounter = new WordCounter();
    }

    @Test
    public void testCountWords() {
        String text = "Once upon a midnight dreary, while. I pondered, weak and weary,";
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("once", 1);
        expectedMap.put("upon", 1);
        expectedMap.put("a", 1);
        expectedMap.put("midnight", 1);
        expectedMap.put("dreary", 1);
        expectedMap.put("while", 1);
        expectedMap.put("i", 1);
        expectedMap.put("pondered", 1);
        expectedMap.put("weak", 1);
        expectedMap.put("and", 1);
        expectedMap.put("weary", 1);

        Map<String, Integer> actualMap = wordCounter.countWords(text);

        Assertions.assertEquals(expectedMap, actualMap);
    }

    @Test
    public void testRemoveHtmlTags() {
        String text = "Once upon a <br /> midnight dreary";
        String expectedText = "Once upon a  midnight dreary";

        String actualText = wordCounter.removeHtmlTags(text);

        Assertions.assertEquals(expectedText, actualText);
    }
}
