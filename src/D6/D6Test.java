package D6;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class D6Test {

    D6 d6 = new D6();

    @Test
    void solve1() throws FileNotFoundException {
            assertEquals(359999, d6.Solve2(80));
    }

    @Test
    void solve2() throws FileNotFoundException {
            assertEquals(1631647919273L, d6.Solve2(256));
    }
}