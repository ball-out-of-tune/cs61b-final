public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        ArrayDeque<Character> characterArrayDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            characterArrayDeque.addLast(word.charAt(i));
        }
        return characterArrayDeque;
    }

    public boolean isPalindrome(String word) {
        if (word.isEmpty() || word.length() == 1) {
            return true;
        } else {
            if (word.charAt(0) != word.charAt(word.length() - 1))
                return false;
            return isPalindrome(word.substring(1, word.length() - 1));
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.isEmpty() || word.length() == 1) {
            return true;
        }
        else {
            if (!cc.equalChars(word.charAt(0), word.charAt(word.length() - 1))) {
                return false;
            }
            return isPalindrome(word.substring(1, word.length() - 1), cc);
        }
    }
}
