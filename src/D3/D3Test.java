package D3;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D3Test {
    D3 d3 = new D3();

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(1540244, d3.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(4203981, d3.Solve2());
    }
}