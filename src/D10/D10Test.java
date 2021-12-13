package D10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D10Test {
    D10 d10;

    @BeforeEach
    void setUp() {
        d10 = new D10();
    }

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(341823, d10.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(2801302861L, d10.Solve2());
    }
}