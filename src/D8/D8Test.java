package D8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D8Test {
    D8 d8;

    @BeforeEach
    void setUp() {
        d8 = new D8();
    }

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(362, d8.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(1020159, d8.Solve2());
    }
}