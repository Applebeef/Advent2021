package D1;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D1Test {
    D1 d1 = new D1();

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(1446, d1.Solve1());
    }

    @Test
    void solve1_2() throws FileNotFoundException {
        assertEquals(1446, d1.Solve1_2());
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(1486, d1.Solve2());
    }
}