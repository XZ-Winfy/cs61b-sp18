public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> lld = new LinkedListDeque<>();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            lld.addLast(word.charAt(i));
        }
        return lld;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> lld = wordToDeque(word);
        if (lld.size() == 0 || lld.size() == 1) {
            return true;
        }
        while (lld.size() > 1) {
            if (lld.removeFirst() != lld.removeLast()) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        while (d.size() > 1) {
            if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
                return false;
            }
        }
        return true;
    }
}
