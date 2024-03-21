import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testIsPalindrome() {
        String s = "appa";
        assertTrue(palindrome.isPalindrome(s));
        String s1 = "qwerttrewq";
        assertTrue(palindrome.isPalindrome(s1));
        String s2 = "wjodaiso";
        assertFalse(palindrome.isPalindrome(s2));
        String s3 = "";
        assertTrue(palindrome.isPalindrome(s3));
        String s4 = "e";
        assertTrue(palindrome.isPalindrome(s4));
        String s5 = "32";
        assertFalse(palindrome.isPalindrome(s5));
    }

    @Test
    public void testOverloadingIsPalindrome() {
        OffByOne a = new OffByOne();
        String s0 = "flake";
        assertTrue(palindrome.isPalindrome(s0, a));
        String s1 = "lllll";
        assertFalse(palindrome.isPalindrome(s1, a));
    }
}
