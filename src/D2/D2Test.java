package D2;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D2Test {
    D2 d2 = new D2();

    @Test
    void solve1() throws FileNotFoundException {
        Submarine submarine = new Submarine();
        assertEquals(1714950, d2.Solve(submarine));
    }

    @Test
    void solve2() throws FileNotFoundException {
        Submarine2 submarine = new Submarine2();
        assertEquals(1281977850, d2.Solve(submarine));
    }
}