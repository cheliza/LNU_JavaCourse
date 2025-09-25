package services;

public class WordProcessor {
    public static String processWords(String input) {
        String[] words = input.split("[ ,]+" );
        if (words.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (String word : words) {
            StringBuilder newWord = new StringBuilder();
            char firstChar = word.charAt(0);

            newWord.append(firstChar);
            for (int i = 1; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (currentChar != firstChar) {
                    newWord.append(currentChar);
                }
            }
            result.append(newWord).append(",");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1); 
        }

        return result.toString();
    }
}