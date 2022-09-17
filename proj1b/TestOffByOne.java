import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void TestEqualChars() {
        assertTrue(OffByOne.equalChars('a', 'b'));
        assertTrue(OffByOne.equalChars('r', 'q'));
        assertTrue(OffByOne.equalChars('&', '%'));

        assertFalse(OffByOne.equalChars('a', 'e'));
        assertFalse(OffByOne.equalChars('z', 'a'));
        assertFalse(OffByOne.equalChars('a', 'a'));
        assertFalse(OffByOne.equalChars('a', 'A'));
    }
}
