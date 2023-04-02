import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BruteForceAlgTest {

    // да се оправят unit тестовете
    @Test
    public void testEmptyAlphabet() {
        BruteForceAlg bf = new BruteForceAlg("");
        assertEquals("", bf.generate(3));
    }
    @Test
    public void testLength1() {
        BruteForceAlg bf = new BruteForceAlg("abc");
        assertEquals("a\nb\nc\n", bf.generate(1));
    }
    @Test
    public void testLength2() {
        BruteForceAlg bf = new BruteForceAlg("abc");
        assertEquals("aa\nab\nac\nba\nbb\nbc\nca\ncb\ncc\n", bf.generate(2));
    }

    @Test
    public void testLength3() {
        BruteForceAlg bf = new BruteForceAlg("abc");
        assertEquals("aaa\naab\naac\naba\nabb\nabc\naca\nacb\nacc\nbaa\nbab\nbac\nbba\nbbb\nbbc\nbca\nbcb\nbcc\ncaa\ncab\ncac\ncba\ncbb\ncbc\ncca\nccb\nccc\n", bf.generate(3));
    }
}