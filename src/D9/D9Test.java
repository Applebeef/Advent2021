package D9;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D9Test {
    D9 d9;

    @BeforeEach
    void setUp() {
        d9 = new D9();
    }

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(631, d9.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(821560, d9.Solve2());
    }
}