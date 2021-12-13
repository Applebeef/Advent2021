package D12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D12Test {
    D12 d12;

    @BeforeEach
    void setUp() {
        d12 = new D12();
    }

    @Test
    void solve1() throws FileNotFoundException {
        assertEquals(4186, d12.Solve1());
    }

    @Test
    void solve2() throws FileNotFoundException {
        assertEquals(92111, d12.Solve2());
    }
}