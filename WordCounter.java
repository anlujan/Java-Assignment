package org.example;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        String[] words = text.split(" ");

        for (String word : words) {
            word = word.replace(',', ' ').replace('.', ' ').toLowerCase().trim();

            if (word.length() > 0 && !(word.contains("<") || word.contains(">"))) {
                if (wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
        }

        return wordCountMap;
    }

    public String removeHtmlTags(String text) {
        String htmlTag = text.substring(text.indexOf("<"), text.indexOf(">") + 1);
        return text.replace(htmlTag, "");
    }
}

