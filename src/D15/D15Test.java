package D15;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D15Test {
    D15 d15;

    @BeforeEach
    void setUp() {
        d15 = new D15();
    }

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(748, d15.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(3045, d15.Solve2());
    }
}