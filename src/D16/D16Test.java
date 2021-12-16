package D16;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D16Test {
    D16 d16;

    @BeforeEach
    void setUp() throws FileNotFoundException {
        d16 = new D16();
    }

    @Test
    void solve1() {
        assertEquals(901, d16.Solve1());
    }

    @Test
    void solve2() {
        assertEquals(110434737925L, d16.Solve2());
    }
}