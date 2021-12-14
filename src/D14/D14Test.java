package D14;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D14Test {
    D14 d14;

    @BeforeEach
    void setUp() {
        d14 = new D14();
    }

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(3411, d14.Solve1());
    }

    @Test
    void solve1_2() throws FileNotFoundException {
        assertEquals(3411, d14.Solve2(10));
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(7477815755570L, d14.Solve2(40));
    }
}