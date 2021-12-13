package D11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D11Test {
    D11 d11;

    @BeforeEach
    void setUp() {
        d11 = new D11();
    }

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(1632, d11.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(303, d11.Solve2());
    }
}