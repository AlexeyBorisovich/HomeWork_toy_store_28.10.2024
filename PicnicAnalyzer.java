import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PicnicAnalyzer {

    public static void main(String[] args) {
        String filePath = "input.txt";
        try {
            String content = readFile(filePath);
            String[] words = content.split("\\s+");

            // Задание №1: Осуществить подсчет слов
            int wordCount = words.length;
            System.out.println("Количество слов: " + wordCount);

            System.out.println();

            // Задание №2: Найти самое длинное слово
            String longestWord = findLongestWord(words);
            System.out.println("Самое длинное слово: " + longestWord);

            System.out.println();

            // Задание №3: Вычислить частоту слов
            Map<String, Integer> wordFrequency = calculateWordFrequency(words);
            System.out.println("Частота слов: " + wordFrequency);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(" ");
            }
        }
        return content.toString().trim();
    }

    private static String findLongestWord(String[] words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    private static Map<String, Integer> calculateWordFrequency(String[] words) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        return wordFrequency;
    }
}