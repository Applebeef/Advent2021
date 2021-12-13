package D13;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D13Test {
    D13 d13;

    @BeforeEach
    void setUp() {
        d13 = new D13();
    }

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(661, d13.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
        String str = d13.Solve2();
        assertEquals(str, str);
    }
}