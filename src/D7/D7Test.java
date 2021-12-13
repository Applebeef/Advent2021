package D7;

import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

class D7Test {

    D7 d7 = new D7();

    @Test
    void solve1() throws FileNotFoundException {
            assertEquals(355150, d7.Solve1());
    }

    @Test
    void solve1_2() throws FileNotFoundException {
        assertEquals(355150, d7.Solve1_2());
    }

    @Test
    void solve2() throws FileNotFoundException {
            assertEquals(98368490, d7.Solve2());
    }

    @Test
    void solve2_2() throws FileNotFoundException {
        assertEquals(98368490, d7.Solve2_2());
    }
}