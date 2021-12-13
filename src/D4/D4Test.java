package D4;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D4Test {
    D4 d4 = new D4();

    @Test
    void solve1() throws FileNotFoundException {
            assertEquals(82440, d4.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
            assertEquals(20774, d4.Solve2());
    }
}